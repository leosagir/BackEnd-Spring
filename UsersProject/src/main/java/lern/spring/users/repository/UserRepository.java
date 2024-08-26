package lern.spring.users.repository;

import lern.spring.users.entity.User;

import java.util.List;

public interface UserRepository {
    public User save(User user);
    public List<User> findAll();

    User updateUser(User user);

    public User deleteUser(User user);

}
