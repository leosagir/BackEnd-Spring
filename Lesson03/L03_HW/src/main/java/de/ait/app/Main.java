package de.ait.app;

import de.ait.app.controller.BookController;

import de.ait.app.entity.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("de.ait.app");
        BookController bookController = context.getBean(BookController.class);


//        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean run = true;

        while (run) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Показать все книги");
            System.out.println("2. Найти книгу по автору");
            System.out.println("3. Найти книгу по названию");
            System.out.println("4. Найти книгу по жанру");
            System.out.println("5. Добавить новую книгу");
            System.out.println("6. Удалить книгу");
            System.out.println("7. Выйти");

            int choice;
            choice= Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    List<Book> books = bookController.getAllBook();
                    System.out.println("Список всех книг:");
                    for(Book book:books){
                        System.out.println(book);
                    }
                    break;

                case 2:
                        System.out.println("Введите имя автора:");
                        String author = reader.readLine();
                        books=bookController.getBookByAuthor(author);
                        System.out.println("Книги автора " + author + ":");
                        for (Book book:books){
                            System.out.println(book);
                        }
                        break;

                case 3:
                            System.out.println("Введите название книги:");
                            String title = reader.readLine();
                            books=bookController.getBookByTitle(title);
                            System.out.println("Книги с названием " + title + ":");
                            for (Book book:books){
                                System.out.println(book);
                            }
                            break;

                case 4:
                    System.out.println("Введите жанр книги:");
                    String genre = reader.readLine();
                    books=bookController.getBookByGenre(genre);
                    System.out.println("Книги жанра " + genre + ":");
                    for (Book book:books){
                        System.out.println(book);
                    }
                    break;

                case 5:
                                System.out.println("Введите id книги:");
                                int id = Integer.parseInt(reader.readLine());

                                System.out.println("Введите название книги:");
                                title=reader.readLine();

                                System.out.println("Введите автора книги:");
                                author = reader.readLine();

                                System.out.println("Введите жанр книги:");
                                genre = reader.readLine();

                                System.out.println("Введите описание книги:");
                                String description = reader.readLine();

                                Book book = new Book(id, title, author, genre, description);
                                bookController.addBook(book);
                                System.out.println("Книга добавлена.");
                                break;

                                case 6:
                                    System.out.println("Введите id книги для удаления:");
                                    id = Integer.parseInt(reader.readLine());
                                    Book bookDel=bookController.getBookById(id);
                                    if(bookDel!=null){
                                        bookController.deleteBook(bookDel);
                                        System.out.println("Книга удалена.");
                                    }else{
                                        System.out.println("Книга не найдена.");
                                    }
                                    break;

                                    case 7:

                                        run = false;
                                        System.out.println("Выход из приложения...");
                                        break;

                                        default:
                                            System.out.println("Неверный выбор. Попробуйте снова.");
                                            break;
            }
        }
        context.close();
        reader.close();
    }
}
