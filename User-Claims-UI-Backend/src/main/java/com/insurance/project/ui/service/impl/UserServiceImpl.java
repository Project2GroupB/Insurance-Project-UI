package com.insurance.project.ui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.insurance.project.ui.exception.ResourceNotFoundException;
import com.insurance.project.ui.model.User;
import com.insurance.project.ui.repository.UserRepository;
import com.insurance.project.ui.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    /*
     *  Add new user.
     * @param user User object to save
     * @return Saved user
     */
    @Override
    public User addUser(User user) {
        logger.info("Adding new user: {}", user);
        User savedUser = userRepository.save(user);
        logger.info("User added successfully with ID: {}", savedUser.getId());
        return savedUser;
    }

    /*
     *  Get user details by ID.
     * @param userId The user ID
     * @return User details
     * @throws ResourceNotFoundException if user is not found
     */
    @Override
    public User getUserById(Long userId) {
        logger.info("Fetching user details for ID: {}", userId);

        return userRepository.findById(userId)
                .orElseThrow(() -> {
                    logger.warn("User not found with ID: {}", userId);
                    return new ResourceNotFoundException("User not found with ID: " + userId);
                });
    }

    /*
     *  Get all users.
     * @return List of users
     */
    @Override
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        List<User> users = userRepository.findAll();
        
        if (users.isEmpty()) {
            logger.warn("No users found in the database.");
        } else {
            logger.info("Total users found: {}", users.size());
        }

        return users;
    }
}
