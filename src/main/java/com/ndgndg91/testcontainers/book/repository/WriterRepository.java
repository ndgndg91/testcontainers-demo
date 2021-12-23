package com.ndgndg91.testcontainers.book.repository;

import com.ndgndg91.testcontainers.book.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer, Long> {
}
