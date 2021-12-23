package com.ndgndg91.testcontainers.book;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NamedEntityGraph(
        name = "Book.Writer",
        attributeNodes = @NamedAttributeNode("writer")
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private Writer writer;

    public Book(final String title, final Writer writer) {
        this.writer = writer;
        this.title = title;
    }
}
