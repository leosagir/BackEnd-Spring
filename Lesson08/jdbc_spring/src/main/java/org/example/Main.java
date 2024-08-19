package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        JDBCDemo.loadDriver();
        List<User> users=JDBCDemo.getAll();
        System.out.println(users);

        User u1= new User("Georg","georg@mail.com","12345");
        User createdUser=JDBCDemo.create(u1);

        users=JDBCDemo.getAll();
        System.out.println(users);

        createdUser.setId(1L);
        createdUser.setName("Vika");
        createdUser.setEmail("vika@mail.com");

        System.out.println("------------update------------------");
        JDBCDemo.update(createdUser);
        users=JDBCDemo.getAll();
        User user= users.get(0);
        user.setPassword("54321");
        JDBCDemo.update(user);
        users=JDBCDemo.getAll();
        System.out.println(users);

        System.out.println("------------");
        System.out.println(JDBCDemo.findById(2L));
    }
}