package com.example.demo.repository;

import com.example.demo.model.User;
import java.util.List;

public interface FakeRepoInterface {
    void insertUser(User user);
    User findUserById(Long userId);
    void deleteUser(Long id);
    List<User> getUsers();
}