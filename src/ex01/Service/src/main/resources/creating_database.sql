DROP SCHEMA IF EXISTS database cascade;
CREATE SCHEMA IF NOT EXISTS database;
CREATE TABLE database.Users
(
    id serial PRIMARY KEY,
    email varchar (40) UNIQUE
);


INSERT INTO database.Users (id, email) VALUES (1, '12345@mail.ru');
INSERT INTO database.Users (id, email) VALUES (2, 'qwerty@mail.ru');
INSERT INTO database.Users (id, email) VALUES (3, 'zxcvbn@mail.ru');
INSERT INTO database.Users (id, email) VALUES (4, 'wsgdvdb@mail.ru');
