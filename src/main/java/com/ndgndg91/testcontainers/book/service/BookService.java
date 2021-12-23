package com.ndgndg91.testcontainers.book.service;

import com.ndgndg91.testcontainers.book.Book;
import com.ndgndg91.testcontainers.book.repository.BookRepository;
import com.ndgndg91.testcontainers.book.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final WriterRepository writerRepository;
    private final BookRepository bookRepository;

    @Transactional
    public Book register(final long writerId, final String title) {
        final var writer = writerRepository.findById(writerId).orElseThrow();
        final var book = new Book(title, writer);
        return bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public List<Book> findAllByWriterId(final long writerId) {
        return bookRepository.findAllByWriterId(writerId);
    }
}
