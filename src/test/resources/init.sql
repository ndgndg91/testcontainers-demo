DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS writer;
DROP TABLE IF EXISTS product;
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

CREATE TABLE product
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    title           VARCHAR(255) NOT NULL,
    description     VARCHAR(255) NOT NULL,
    seo_title       VARCHAR(255) NOT NULL,
    seo_description VARCHAR(255) NOT NULL,
    media           JSON         DEFAULT NULL,
    option_names    JSON         DEFAULT NULL,
    status          VARCHAR(100) DEFAULT 'DRAFT'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE product_variant
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id    BIGINT         NOT NULL,
    sku           VARCHAR(255)   NOT NULL,
    price         DECIMAL(19, 2) NOT NULL,
    option_values JSON DEFAULT NULL,
    FOREIGN KEY (product_id) REFERENCES product (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE product_inventory
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_variant_id BIGINT NOT NULL,
    available_quantity BIGINT DEFAULT 0,
    tracked            BIT(1) DEFAULT 0,
    FOREIGN KEY (product_variant_id) REFERENCES product_variant (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;