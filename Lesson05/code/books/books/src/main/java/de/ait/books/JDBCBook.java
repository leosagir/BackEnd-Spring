package de.ait.books;

import de.ait.books.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCBook {



        private static final String DRIVER = "org.postgresql.Driver";
        private static final String URL ="jdbc:postgresql://localhost:5432/";
        private static final String DB = "books";
        private static final String USERNAME = "postgres";
        private static final String PASSWORD = "qwerty007";

        public static void loadDriver() {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Load driver error: " + DRIVER);
            }
        }
        public static Connection getConnection() {
            try {
                Connection connection = DriverManager.getConnection(URL+DB,USERNAME,PASSWORD);
                return connection;
            } catch (SQLException e) {
                throw new RuntimeException("create connection error: " + e.getMessage());
            }
        }
        public static List<Book> getAll() {
            String query = "select * from books";
            try (Connection connection = getConnection()) {

                if(connection==null){
                    throw new SQLException("connection is fail");
                }
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                List<Book> result = new ArrayList<Book>();
                while ((resultSet.next())) {
                    Long id = resultSet.getLong("id");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String genre = resultSet.getString("genre");
                    String description = resultSet.getString("description");


                    result.add(new Book(id, title, author, genre, description));
                }
                return result;

            } catch (SQLException e) {
                throw new RuntimeException("Read data fail: " + e.getMessage());
            }
        }
    }


