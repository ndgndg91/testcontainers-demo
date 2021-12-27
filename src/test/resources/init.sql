DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS writer;
CREATE TABLE writer
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(50),
    birthday  DATETIME
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE book
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    writer_id BIGINT,
    title     VARCHAR(255),
    FOREIGN KEY (writer_id) REFERENCES writer (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO writer VALUE (1, '남동길', DATE('1991-11-07'));
INSERT INTO book VALUE (1, 1, 'Java');