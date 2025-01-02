-- liquibase formatted sql
-- changeset alexsh:002

CREATE TABLE logs
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    timestamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    query     TEXT     NOT NULL
);