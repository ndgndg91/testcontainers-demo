DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS writer;
CREATE TABLE writer
(
    id       bigint auto_increment primary key,
    full_name VARCHAR(50),
    birthday datetime
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE book
(
    id        bigint auto_increment primary key,
    writer_id bigint,
    title     varchar(255),
    FOREIGN KEY (writer_id) REFERENCES writer (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO writer VALUE (1, '남동길', DATE('1991-11-07'));
INSERT INTO book VALUE (1, 1, 'Java');
