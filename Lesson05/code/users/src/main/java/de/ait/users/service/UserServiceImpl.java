package de.ait.users.service;

import de.ait.users.entity.User;
import de.ait.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServiceInterface {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User createNew(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return findAll()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<User> findByName(String name) {
        return findAll()
                .stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase())) // ignore case-sensitive search
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getUsers(String name, String email) {

        Predicate<User> predicateByName = (name.equals("")) ? user ->true :user-> user.getName().equalsIgnoreCase(name);
        Predicate<User> predicateEmail = (email.equals("")) ? user ->true :user-> user.getEmail().equalsIgnoreCase(email);

        Predicate<User> allCondition = predicateByName.and(predicateEmail);

        return userRepository.findAll()
                .stream()
                .filter(allCondition)
                .toList();

    }
}
