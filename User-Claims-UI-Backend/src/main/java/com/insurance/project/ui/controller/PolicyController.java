package com.insurance.project.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.insurance.project.ui.model.Policy;
import com.insurance.project.ui.service.PolicyService;
import com.insurance.project.ui.exception.PolicyNotFoundException;

/*
 * REST Controller for handling claim-related requests.
 */
@RestController
@RequestMapping("/policies") // Base URL for policy-related API endpoints
public class PolicyController {

    private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);

    @Autowired
    private PolicyService policyService;

    public ResponseEntity<?> getPolicyByUserId(@PathVariable Long userId){
    	try {
    		logger.info("Fetching policy details for User ID {} ", userId);
    		List<Policy> policies = policyService.getPolicyByUserId(userId);
    		return ResponseEntity.ok().body(policies);
    	}catch(PolicyNotFoundException ex) {
    		logger.warn("Policy not found for User ID {} ", userId, ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Policy not found.");
    	}catch(Exception ex) {
    		logger.error("Error occured while fetching policy details for User ID {} ", userId, ex.getMessage());
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    				.body("Error while fetching policy details try again later.");
    	}
    }
}
