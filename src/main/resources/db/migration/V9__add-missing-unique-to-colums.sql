-- Flyway migration script to add UNIQUE constraint to existing table
ALTER TABLE topicos
    ADD CONSTRAINT uk_msj UNIQUE (mensaje(255));
