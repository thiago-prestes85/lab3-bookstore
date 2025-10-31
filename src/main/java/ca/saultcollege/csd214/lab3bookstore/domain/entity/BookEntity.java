package ca.saultcollege.csd214.lab3bookstore.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Concrete publication representing a book.
 * Extends PublicationEntity to inherit publisher and product details.
 */
@Entity
@Table(name = "books")
public class BookEntity extends PublicationEntity {

    /** Author of the book. */
    @Column(name = "author")
    private String author;

    /** International Standard Book Number (unique). */
    @Column(name = "isbn", unique = true)
    private String isbn;

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}