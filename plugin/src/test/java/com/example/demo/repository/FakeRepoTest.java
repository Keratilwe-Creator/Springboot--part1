package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import com.example.demo.model.User;

public class FakeRepoTest {
    @Test
    public void testDeleteUser_ValidId() {
        FakeRepo repo = new FakeRepo();
        User user = new User(1L, "John", "Doe");
        repo.insertUser(user);
        repo.deleteUser(1L);
        assertNull(repo.findUserById(1L));
    }

    @Test
    public void testDeleteUser_InvalidId() {
        FakeRepo repo = new FakeRepo();
        User user = new User(1L, "John", "Doe");
        repo.insertUser(user);
        repo.deleteUser(2L);
        assertNotNull(repo.findUserById(1L));
    }

    @Test
    public void testDeleteUser_EmptyList() {
        FakeRepo repo = new FakeRepo();
        repo.deleteUser(1L);
        assertNull(repo.findUserById(1L));
    }

    @Test
    public void testDeleteUser_MultipleUsersSameId() {
        FakeRepo repo = new FakeRepo();
        User user1 = new User(1L, "John", "Doe");
        User user2 = new User(1L, "Jane", "Doe");
        repo.insertUser(user1);
        repo.insertUser(user2);
        repo.deleteUser(1L);
        assertNull(repo.findUserById(1L));
    }
}