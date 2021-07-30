drop table if exists contract cascade;

create table contract
(
    id        varchar(255) not null,
    client    varchar(255),
    end_date  DATE,
    contract_number    varchar(255),
    price     int4,
    sign_date DATE,
    type      varchar(255),
    updated   TIMESTAMP,
    primary key (id)
);

alter table if exists contract
    add constraint unique_contract_id unique (contract_number);
