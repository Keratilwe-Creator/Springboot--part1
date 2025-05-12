package com.example.demo.repository;

import com.example.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FakeRepoInterfaceTest {
    
    private FakeRepo repo;

    @BeforeEach
    void setUp() {
        repo = new FakeRepo();
    }

    @Test
    void testDeleteUser_ValidId() {
        // Arrange
        User user = new User(1L, "John", "Doe");
        repo.insertUser(user);
        
        // Pre-deletion verification
        assertNotNull(repo.findUserById(1L), "User should exist before deletion");
        
        // Act
        repo.deleteUser(1L);
        
        // Assert
        assertNull(repo.findUserById(1L), "User should not exist after deletion");
        assertTrue(repo.getUsers().isEmpty(), "Repository should be empty after deletion");
    }

    @Test
    void testDeleteUser_InvalidId() {
        // Arrange
        User user = new User(1L, "John", "Doe");
        repo.insertUser(user);
        
        // Act
        repo.deleteUser(2L);
        
        // Assert
        assertNotNull(repo.findUserById(1L), "User should still exist");
        assertEquals(1, repo.getUsers().size(), "Repository should still contain one user");
    }

    @Test
    void testDeleteUser_EmptyRepo() {
        // Act
        repo.deleteUser(1L);
        
        // Assert
        assertTrue(repo.getUsers().isEmpty(), "Repository should remain empty");
    }

    @Test
    void testInsertUser() {
        // Arrange
        User user = new User(1L, "John", "Doe");
        
        // Act
        repo.insertUser(user);
        
        // Assert
        assertEquals(1, repo.getUsers().size(), "Repository should contain one user");
        assertEquals(user, repo.findUserById(1L), "Should find inserted user");
    }
}

// Removed UserController class from this file.