package de.ait.books.service;

import de.ait.books.entity.Book;

import java.util.List;

public interface BookServiceInterface {
    List<Book> getAllBooks();
    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);
    List<Book> findByGenre(String genre);
    Book save(Book book);
}
