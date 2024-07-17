-- V2__add_missing_columns_to_usuarios.sql

ALTER TABLE usuarios
    ADD COLUMN correo VARCHAR(255),
ADD COLUMN password VARCHAR(255);
