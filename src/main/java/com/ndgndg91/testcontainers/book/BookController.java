package com.ndgndg91.testcontainers.book;

import com.ndgndg91.testcontainers.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/apis/writers/{id}/books")
    public ResponseEntity<List<Book>> findByWId(@PathVariable final long id) {
        return ResponseEntity.ok(bookService.findAllByWriterId(id));
    }

}
