package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.FakeRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final FakeRepoInterface fakeRepo;

    @Autowired
    public UserServiceImpl(FakeRepoInterface fakeRepo) {
        this.fakeRepo = fakeRepo;
    }

    @Override
    public void addUser(User user) {
        fakeRepo.insertUser(user);
    }

    @Override
    public User getUser(Long id) {
        return fakeRepo.findUserById(id);
    }

    @Override
    public void removeUser(Long id) {
        fakeRepo.deleteUser(id);
    }
}