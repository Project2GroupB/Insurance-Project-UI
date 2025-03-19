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
    
    @GetMapping("getUser/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
    	try {
    		logger.info("Fetching User details");
    		User user = userService.getUserById(userId);
    		logger.info("User details fetched successfully UserID {}", userId);
    		System.out.println(user);
    		return ResponseEntity.ok().body(user);
    	}catch(UserNotFoundException ex) {
    		logger.warn("User not found with User Id {}" + userId, ex.getMessage());
    		return ResponseEntity.status(HttpStatus.NOT_FOUND)
    				.body("Error: User not found with User Id {} " + userId);
    	}catch(Exception ex) {
    		logger.error("Error while fetching user details for ID: {} - {}", userId, ex.getMessage());
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    				.body("Error occurred while fetching user details.");
    	}
    }
    
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers(){
    	try {
    		logger.info("In Controller Fetching users details");
    		List<User> users = userService.getAllUsers();
    		if(users.isEmpty()) {
    			return ResponseEntity.status(HttpStatus.NOT_FOUND)
    					.body("No user found");
    		}
    		return ResponseEntity.ok(users);
    	}catch(Exception ex) {
    		logger.error("Error occured while fetching user details", ex.getMessage());
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    				.body("Error occured while fetching user details try again later");
    	}
    }
    	
}