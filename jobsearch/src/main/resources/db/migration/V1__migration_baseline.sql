create schema public;
CREATE TABLE application_user(
    ID BIGSERIAL PRIMARY KEY NOT NULL
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);