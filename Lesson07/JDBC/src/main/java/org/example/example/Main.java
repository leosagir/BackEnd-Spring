package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        JDBCDemo.loadDriver();
        List<User> users=JDBCDemo.getAll();
        System.out.println(users);

    }
}