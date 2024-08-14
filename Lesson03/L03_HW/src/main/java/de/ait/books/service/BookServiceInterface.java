package de.ait.app.service;

import de.ait.app.entity.Book;

import java.util.List;

public interface BookServiceInterface {
    List<Book> getAllBooks();
    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);
    List<Book> findByGenre(String genre);
    Book save(Book book);
}
