--liquibase formatted sql

--changeset polina.petrushina:create-users-table runOnChange:false runAlways:false dbms:postgresql
CREATE TABLE users
(
    id           int GENERATED BY DEFAULT AS IDENTITY         NOT NULL,
    first_name   varchar(150) NOT NULL,
    last_name    varchar(150) NOT NULL,
    phone_number varchar(150) NOT NULL,
    address      varchar(150) NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
);

COMMENT ON TABLE users IS 'Таблица пользователей';
COMMENT ON COLUMN users.id IS 'Идентификатор пользователя';
COMMENT ON COLUMN users.first_name IS 'Имя пользователя';
COMMENT ON COLUMN users.last_name IS 'Фамилия подьзователя';
COMMENT ON COLUMN users.phone_number IS 'Номер телефона пользователя';
COMMENT ON COLUMN users.address IS 'Адрес пользователя';