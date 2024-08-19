package de.ait.users.service;

import de.ait.users.entity.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> findAll();
    User createNew(User user);
    User findById(Long id);
    List<User> findByName(String name);
    List <User> getUsers(String name, String email);
}
