package de.ait.books.service;

import de.ait.books.entity.Book;
import de.ait.books.repository.BookRepository;
import de.ait.books.repository.BookRepositoryJDBCImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookServiceInterface {

    private BookRepository bookRepository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return getAllBooks()
                .stream()
                .filter(user -> user.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }


    @Override
    public List<Book> findByTitle(String title) {
        return getAllBooks()
                .stream()
                .filter(user -> user.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByGenre(String genre) {
        return getAllBooks()
                .stream()
                .filter(user -> user.getGenre().toLowerCase().contains(genre.toLowerCase()))
                .collect(Collectors.toList());
    }


    public Book findById(int id) {
        return getAllBooks()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findAny().get();
    }



    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public Book delete(Book book) {
        return bookRepository.delete(book);
    }
}
