create table shop_type(
                          id uuid primary key,
                          code varchar(100),
                          description varchar(255)
);

create table shop (
    id uuid primary key,
    name varchar(255),
    description text,
    address text,
    shop_type uuid references shop_type(id)
);
