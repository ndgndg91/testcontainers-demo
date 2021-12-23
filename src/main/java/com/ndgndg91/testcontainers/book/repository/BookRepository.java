package com.ndgndg91.testcontainers.book.repository;

import com.ndgndg91.testcontainers.book.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @EntityGraph(value = "Book.Writer")
    List<Book> findAllByWriterId(final long writerId);
}
