package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String DB = "app_43";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "qwerty007";

    public static void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Load driver error: " + DRIVER, e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL + DB, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Create connection error: " + e.getMessage(), e);
        }
    }

    public static List<User> getAll() {
        String query = "SELECT * FROM t_user";
        try (Connection connection = getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<User> result = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                result.add(new User(id, name, email, password));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException("Read data fail: " + e.getMessage(), e);
        }
    }

    public static User create(User user) {
        String query = "INSERT INTO t_user(name, email, password) VALUES(?, ?, ?)";
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Insert failed: " + user);
            }

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getLong(1));
                return user;
            } else {
                throw new SQLException("Insert failed, no ID obtained.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Create user error: " + e.getMessage(), e);
        }
    }

    public static User update(User user) {
        String query = "UPDATE t_user SET name=?, email=?, password=? WHERE id=?";
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setLong(4, user.getId());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Update failed: " + user);
            }

            if (affectedRows > 1) {
                throw new SQLException("Error! Updated " + affectedRows + " users. Duplicate keys in DB.");
            }

            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Update user error: " + e.getMessage(), e);
        }
    }

    public static User findById(Long id) {
        String query = "SELECT * FROM t_user WHERE id = ?";
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long userId = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                return new User(userId, name, email, password);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Read data fail: " + e.getMessage(), e);
        }
    }

    public static User save(User user) {
        if(user.getId() != null) {
            return update(user);
        }else{
            return create(user);
        }
    }

}

