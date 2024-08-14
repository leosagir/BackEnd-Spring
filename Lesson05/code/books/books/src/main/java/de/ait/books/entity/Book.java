package de.ait.books.entity;

public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private String description;

    public Book(int id, String title, String author, String genre, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

public String toString() {
    // ANSI escape-коды для цветов
    String reset = "\u001B[0m";
    String red = "\u001B[31m";
    String green = "\u001B[32m";
    String yellow = "\u001B[33m";
    String blue = "\u001B[34m";

    return "Book{" + "\n" +
            red + "id=" + id + reset + ",\n" +
            green + "title='" + title + '\'' + reset + ",\n" +
            yellow + "author='" + author + '\'' + reset + ",\n" +
            blue + "genre='" + genre + '\'' + reset + ",\n" +
            "description='" + description + '\'' +
            '}' + "\n";
}
}
