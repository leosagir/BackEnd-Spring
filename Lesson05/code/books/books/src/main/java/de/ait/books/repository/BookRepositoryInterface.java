package de.ait.books.repository;

import de.ait.books.entity.Book;

import java.util.List;

public interface BookRepositoryInterface {
    List<Book> findAll();
    Book save(Book book);
    Book delete(Book book);
}
