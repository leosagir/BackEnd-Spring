package de.ait.books;

import de.ait.books.entity.Book;

import javax.management.openmbean.CompositeData;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        JDBCBook.loadDriver();
        List<Book> books=JDBCBook.getAll();
        System.out.println(books);

    }
}