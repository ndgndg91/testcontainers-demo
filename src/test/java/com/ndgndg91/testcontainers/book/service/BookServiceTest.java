package com.ndgndg91.testcontainers.book.service;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Container
    private static final MySQLContainer mysql = new MySQLContainer<>("mysql:5.7")
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


    @Test
    void register() {
        // given
        final var wId = 1L;
        final var title = "Rust";

        // when
        final var book = bookService.register(wId, title);

        // then
        assertNotNull(book.getId());
        assertEquals(title, book.getTitle());
        assertEquals(wId, book.getWriter().getId());
    }

    @Test
    void findAllByWriterId(){
        // given
        final var wId = 1L;

        // when
        final var books = bookService.findAllByWriterId(wId);

        // then
        assertEquals(1, books.size());
        assertEquals("Java", books.get(0).getTitle());
        assertEquals("남동길", books.get(0).getWriter().getFullName());
    }
}