package com.insurance.project.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.insurance.project.ui.model.User;
import com.insurance.project.ui.service.UserService;
import com.insurance.project.ui.exception.UserNotFoundException;

/*
 * REST Controller for handling user-related requests.
 */
@CrossOrigin(origins = "http://localhost:4200") // Allows frontend to access API
@RestController
@RequestMapping("/api/users") // Base URL for user-related API endpoints
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /*
     * Adds a new user.
     *
     * @param user The user object to be added
     * @return ResponseEntity with the added user or an error message
     */
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            logger.info("Adding a new user: {}", user.getName());
            User savedUser = userService.addUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.error("Error while adding user: {} - {}", user.getName(), ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while adding the user. Please try again.");
        }
    }

    /*
     * Retrieves user details by ID (including claims).
     *
     * @param userId The ID of the user
     * @return ResponseEntity with the user details or an error message
     */
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        try {
            logger.info("Fetching user details for ID: {}", userId);
            User user = userService.getUserById(userId);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException ex) {
            logger.warn("User not found with ID: {} - {}", userId, ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: User not found with ID " + userId);
        } catch (Exception ex) {
            logger.error("Error while fetching user details for ID: {} - {}", userId, ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred while fetching user details.");
        }
    }

    /*
     * Retrieves all users.
     *
     * @return ResponseEntity with the list of users or an error message
     */
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            logger.info("Fetching all users...");
            List<User> users = userService.getAllUsers();
            if (users.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No users found.");
            }
            return ResponseEntity.ok(users);
        } catch (Exception ex) {
            logger.error("Error while fetching users: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred while fetching users.");
        }
    }
}
