package com.insurance.project.ui.service;

import java.util.List;
import com.insurance.project.ui.model.User;

/**
 * Service interface for managing users.
 * Defines methods for user creation and retrieval.
 */
public interface UserService {

    /**
     * Adds a new user to the system.
     * 
     * @param user The User object containing user details.
     * @return The saved User object.
     */
    User addUser(User user);

    /**
     * Retrieves a user based on their unique ID.
     * 
     * @param userId The ID of the user to be retrieved.
     * @return The User object if found, otherwise null or an exception.
     */
    User getUserById(Long userId);

    /**
     * Retrieves all users in the system.
     * 
     * @return A list of all User objects.
     */
    List<User> getAllUsers();
}
