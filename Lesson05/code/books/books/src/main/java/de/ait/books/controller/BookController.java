package de.ait.books.controller;

import de.ait.books.entity.Book;
import de.ait.books.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBook(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/title")
    public List<Book> getBookByTitle(@RequestParam String title){
        return bookService.findByTitle(title);
    }

    @GetMapping("/books/genre")
    public List<Book> getBookByGenre(@RequestParam String genre){
        return bookService.findByGenre(genre);
    }

    @GetMapping("/books/author")
    public List<Book> getBookByAuthor(@RequestParam String author){
        return bookService.findByAuthor(author);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return bookService.save(book);
    }

    @DeleteMapping("/books/{id}")
    public Book deleteBook(Book book){
    return bookService.delete(book);
   }
}



//package de.ait.books.controller;
//
//import de.ait.books.entity.Book;
//import de.ait.books.service.BookServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class BookController {
//
//    private final BookServiceImpl bookService;
//    @Autowired
//    public BookController(BookServiceImpl bookService) {
//        this.bookService = bookService;
//    }
//
//@GetMapping("/books")
//    public List<Book> getAllBook(){
//        return bookService.getAllBooks();
//    }
//
//
//    public Book getBookById(int id){
//        return bookService.findById(id);
//    }
//
//@GetMapping("/title")
//    public List<Book> getBookByTitle(String title){
//        return bookService.findByTitle(title);
//    }
//
//    @GetMapping("/genre")
//    public List<Book> getBookByGenre(String genre){
//        return bookService.findByGenre(genre);
//    }
//
//    @GetMapping("/author")
//    public List<Book> getBookByAuthor(String author){
//        return bookService.findByAuthor(author);
//    }
//
//
//    public Book addBook(Book book){
//        return bookService.save(book);
//    }
//
//
//    public Book deleteBook(Book book){
//        return bookService.delete(book);
//    }
//
//}
