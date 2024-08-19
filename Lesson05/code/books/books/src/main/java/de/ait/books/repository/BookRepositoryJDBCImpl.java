package de.ait.books.repository;

import de.ait.books.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookRepositoryJDBCImpl implements BookRepositoryInterface{

   private final DataSource dataSource;
   private final JdbcTemplate jdbcTemplate;

   @Autowired
    public BookRepositoryJDBCImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<Book> BOOK_ROW_MAPPER = ((row, rowNumber) -> {
        Long id = row.getLong("id");
        String title = row.getString("title");
        String author = row.getString("author");
        String genre = row.getString("genre");
        String description = row.getString("description");
        return new Book(id, title, author, genre,description);
    });

    @Override
    public List<Book> findAll() {
        String query = "SELECT * FROM books";
        return jdbcTemplate.query(query, BOOK_ROW_MAPPER);
    }

    @Override
    public Book save(Book book) {
        String updateQuery = "UPDATE books SET title = ?, author = ?, genre = ?, description = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(updateQuery,
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getDescription(),
                book.getId());

        if (rowsAffected == 0) {
            String insertQuery = "INSERT INTO books (id, title, author, genre, description) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(insertQuery,
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getDescription());
        }

        return book;
    }

    @Override
    public Book delete(Book book) {
        String deleteQuery = "DELETE FROM books WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(deleteQuery, book.getId());

        if (rowsAffected > 0) {
            return book;
        } else {
            return null;
        }
    }

}
