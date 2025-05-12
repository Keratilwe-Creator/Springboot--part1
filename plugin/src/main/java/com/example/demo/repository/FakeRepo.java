package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeRepo implements FakeRepoInterface {
    private List<User> users = new ArrayList<>();

    @Override
    public void insertUser(User user) {
        users.add(user);
    }

    @Override
    public User findUserById(Long userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}