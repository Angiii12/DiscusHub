create table topicos (
                         id bigint not null,
                         titulo varchar(100) not null,
                         mensaje varchar(6000) not null,
                         fecha timestamp not null,
                         status varchar(100) not null,
                         primary key(id)
);