create table users
(
    id         uuid primary key,
    login      varchar(255) not null,
    password   varchar(100) not null,
    first_name varchar(100) not null,
    last_name  varchar(150),
    country    varchar(100),
    roles      jsonb        not null
)