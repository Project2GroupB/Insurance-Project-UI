package com.insurance.project.ui.service;

import java.util.List;
import com.insurance.project.ui.model.User;

/**
 * Service interface for managing users.
 * Defines methods for user creation and retrieval.
 */
public interface UserService {
	
    User getUserById(Long userId);

    List<User> getAllUsers();
}
