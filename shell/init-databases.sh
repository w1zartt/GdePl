#!/bin/bash
set -e
set -u

function create_user_and_databases() {
	local database=$1
	local dbUser=$2
	local dbPassword=$3
	echo "  Creating user and database '$database'"
	psql -v ON_ERROR_STOP=1 --username "$dbUser" <<-EOSQL
      DO
      \$do\$
      BEGIN
         IF EXISTS (SELECT FROM pg_catalog.pg_roles WHERE  rolname = '$dbUser') THEN
            RAISE NOTICE 'Role already exists. Skipping.';
         ELSE
            BEGIN
               CREATE ROLE $dbUser LOGIN PASSWORD '$dbPassword';
            EXCEPTION
               WHEN duplicate_object THEN RAISE NOTICE 'Role was just created by a concurrent transaction. Skipping.';
            END;
         END IF;
         CREATE EXTENSION IF NOT EXISTS dblink;
         IF EXISTS (SELECT FROM pg_database WHERE datname = '$database') THEN RAISE NOTICE 'Database already exists';
            ELSE
               PERFORM dblink_exec('dbname=' || current_database()
                                 , 'CREATE DATABASE $database WITH OWNER $dbUser ENCODING ''UTF-8''');
               PERFORM dblink_exec('dbname=' || current_database()
                                , 'GRANT ALL PRIVILEGES ON DATABASE $database TO $dbUser');
            END IF;
      END
      \$do\$;
EOSQL
}

if [ -n "$POSTGRES_MULTIPLE_DATABASES" ]; then
	echo "Multiple database creation requested: $POSTGRES_MULTIPLE_DATABASES"
	for db in $(echo $POSTGRES_MULTIPLE_DATABASES | tr ',' ' '); do
		create_user_and_databases $db $POSTGRES_USER $POSTGRES_PASSWORD
	done
	echo "Multiple databases created"
fi
