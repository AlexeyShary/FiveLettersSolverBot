-- liquibase formatted sql
-- changeset alexsh:001

CREATE TABLE words
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    letter_0 CHAR(1) NOT NULL,
    letter_1 CHAR(1) NOT NULL,
    letter_2 CHAR(1) NOT NULL,
    letter_3 CHAR(1) NOT NULL,
    letter_4 CHAR(1) NOT NULL
);

CREATE INDEX idx_letter_0 ON words (letter_0);
CREATE INDEX idx_letter_1 ON words (letter_1);
CREATE INDEX idx_letter_2 ON words (letter_2);
CREATE INDEX idx_letter_3 ON words (letter_3);
CREATE INDEX idx_letter_4 ON words (letter_4);