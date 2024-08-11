package de.ait.app.controller;

import de.ait.app.entity.Book;
import de.ait.app.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookController {

    private final BookServiceImpl bookService;
    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    public List<Book> getAllBook(){
        return bookService.getAllBooks();
    }
    public Book getBookById(int id){
        return bookService.findById(id);
    }
    public List<Book> getBookByTitle(String title){
        return bookService.findByTitle(title);
    }
    public List<Book> getBookByGenre(String genre){
        return bookService.findByGenre(genre);
    }
    public List<Book> getBookByAuthor(String author){
        return bookService.findByAuthor(author);
    }
    public Book addBook(Book book){
        return bookService.save(book);
    }
    public Book deleteBook(Book book){
        return bookService.delete(book);
    }

}
