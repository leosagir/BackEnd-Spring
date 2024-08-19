package de.ait.books.controller;

import de.ait.books.entity.Book;
import de.ait.books.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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

    @GetMapping("/books/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return bookService.findByTitle(title);
    }

    @GetMapping("/books/genre/{genre}")
    public List<Book> getBookByGenre(@PathVariable String genre){
        return bookService.findByGenre(genre);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
        return bookService.findByAuthor(author);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){

        return bookService.save(book);
    }

    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable Long id) {
        Book bookToDelete = new Book();
        bookToDelete.setId(id);
        return bookService.delete(bookToDelete);
    }
}
