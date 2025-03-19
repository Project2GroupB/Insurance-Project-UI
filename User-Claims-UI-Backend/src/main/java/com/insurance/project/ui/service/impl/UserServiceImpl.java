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
    
	@Override
	public User getUserById(Long userId) {
		logger.info("User deatails fetching...");
		return userRepository.findById(userId)
				.orElseThrow(() -> {
					logger.warn("User not found with ID : " + userId);
					return new ResourceNotFoundException("");
				});
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("All user deatils fetching...");
		List<User> users = userRepository.findAll();
		if(users.isEmpty()) {
			logger.warn("No user found !!");
		}else {
			logger.info("Users fetched user count is : " + users.size());
		}
		
		return users;
	}

}
