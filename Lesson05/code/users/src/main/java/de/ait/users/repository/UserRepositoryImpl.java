package de.ait.users.repository;

import de.ait.users.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {
    private List<User> database = new ArrayList<>(List.of(
            new User(1L, "Jack", "jack@mail.com", "12345"),
            new User(2L, "Ann", "ann@mail.com", "12345"),
            new User(3L, "Jack", "jack@mail.com", "12345"),
            new User(4L, "Lena", "lena@mail.com", "12345")
    ));


    @Override
    public List<User> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            database.add(user);
        } else {
            for (int i = 0; i < database.size(); i++) {
                if (database.get(i).getId().equals(user.getId())) {
                    database.set(i, user);
                    return user;
                }
            }
            database.add(user);
            return user;
        }
        return user;
    }
}