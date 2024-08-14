package de.ait.books.service;

import de.ait.books.entity.Book;
import de.ait.books.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookServiceInterface {

    private BookRepositoryImpl bookRepository;
    @Autowired
    public BookServiceImpl(BookRepositoryImpl bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookRepository.books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }


    @Override
    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookRepository.books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> findByGenre(String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookRepository.books) {
            if (book.getGenre().equals(genre)) {
                result.add(book);
            }
        }
        return result;
    }


    public Book findById(int id) {
        for (Book book : bookRepository.books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }



    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public Book delete(Book book) {
        return bookRepository.delete(book);
    }
}
