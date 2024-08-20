package lern.spring.users.service;

import lern.spring.users.entity.User;

import java.util.List;

public interface UserService {
    public interface UserServiceInterface {
        List<User> findAll();
        User createNew(User user);
        User findById(Long id);
        List<User> findByName(String name);
        List <User> getUsers(String name, String email);
    }
}
