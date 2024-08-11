package de.ait.app.repository;

import de.ait.app.entity.Book;

import java.util.List;

public interface BookRepositoryInterface {
    List<Book> findAll();
    Book save(Book book);
    Book delete(Book book);
}
