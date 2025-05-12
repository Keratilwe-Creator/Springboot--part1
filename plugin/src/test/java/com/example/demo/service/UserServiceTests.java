package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.FakeRepoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTests {
    @Mock
    private FakeRepoInterface fakeRepo;

    @InjectMocks
    private UserServiceImpl userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = new User(1L, "John", "Doe");
    }

    @Test
    void testAddUser_ShouldCallInsertUser() {
        // Arrange
        doNothing().when(fakeRepo).insertUser(any(User.class));

        // Act
        userService.addUser(testUser);

        // Assert
        verify(fakeRepo, times(1)).insertUser(testUser);
    }

    @Test
    void testGetUser_WithValidId_ShouldReturnUser() {
        // Arrange
        when(fakeRepo.findUserById(1L)).thenReturn(testUser);

        // Act
        User result = userService.getUser(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        verify(fakeRepo, times(1)).findUserById(1L);
    }

    @Test
    void testGetUser_WithInvalidId_ShouldReturnNull() {
        // Arrange
        when(fakeRepo.findUserById(99L)).thenReturn(null);

        // Act
        User result = userService.getUser(99L);

        // Assert
        assertNull(result);
        verify(fakeRepo, times(1)).findUserById(99L);
    }

    @Test
    void testRemoveUser_ShouldCallDeleteUser() {
        // Arrange
        doNothing().when(fakeRepo).deleteUser(anyLong());

        // Act
        userService.removeUser(1L);

        // Assert
        verify(fakeRepo, times(1)).deleteUser(1L);
    }
}