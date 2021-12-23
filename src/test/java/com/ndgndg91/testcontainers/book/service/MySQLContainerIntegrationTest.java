package com.ndgndg91.testcontainers.book.service;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

public interface MySQLContainerIntegrationTest {
    @Container
    MySQLContainer mysql = new MySQLContainer<>("mysql:5.7")
            .withReuse(true)
            .withCommand("mysqld", "--character-set-server=utf8mb4")
            .withInitScript("init.sql");

    @DynamicPropertySource
    static void overrideProperties(@NotNull DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.driver-class-name", mysql::getDriverClassName);
    }

    // withReuse 를 사용하기 위해서는 ~/.testcontainers.properties 의 testcontainers.reuse.enable=true 로 설정해야한다.
    @BeforeAll
    static void setup() {
        mysql.start();
    }
}
