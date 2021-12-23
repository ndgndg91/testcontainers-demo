package com.ndgndg91.testcontainers.book.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SingletonContainerAbstractPatternTest extends AbstractContainerTest {

    @Autowired
    private BookService bookService;

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
