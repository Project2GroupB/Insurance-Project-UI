package com.insurance.project.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.insurance.project.ui.model.Claim;
import com.insurance.project.ui.service.ClaimService;
import com.insurance.project.ui.exception.UserNotFoundException;
import com.insurance.project.ui.exception.ClaimsNotFoundException;

/*
 * REST Controller for handling claim-related requests.
 */
@RestController
@RequestMapping("/claims") // Base URL for claim-related API endpoints
public class ClaimController {

    private static final Logger logger = LoggerFactory.getLogger(ClaimController.class);

    @Autowired
    private ClaimService claimService;

    /*
     * Adds multiple claims for a specific user.
     * 
     * @param userId The ID of the user
     * @param claims List of claims to be added
     * @return ResponseEntity with list of added claims or error message
     */
    @PostMapping("/user/{userId}")
    public ResponseEntity<?> addClaims(@PathVariable Long userId, @RequestBody List<Claim> claims) {
        try {
            logger.info("Adding claims for User ID: {}", userId);
            List<Claim> addedClaims = claimService.addClaims(userId, claims);
            return new ResponseEntity<>(addedClaims, HttpStatus.CREATED);
        } catch (UserNotFoundException ex) {
            logger.error("User with ID {} not found: {}", userId, ex.getMessage());
            return new ResponseEntity<>("User not found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            logger.error("Error adding claims for User ID {}: {}", userId, ex.getMessage());
            return new ResponseEntity<>("An error occurred while adding claims", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * Retrieves claims associated with a specific user.
     * 
     * @param userId The ID of the user
     * @return ResponseEntity with list of claims or error message
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getClaimsByUserId(@PathVariable Long userId) {
        try {
            logger.info("Fetching claims for User ID: {}", userId);
            List<Claim> claims = claimService.getClaimsByUserId(userId);
            return new ResponseEntity<>(claims, HttpStatus.OK);
        } catch (ClaimsNotFoundException ex) {
            logger.error("No claims found for User ID {}: {}", userId, ex.getMessage());
            return new ResponseEntity<>("No claims found for user: " + ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            logger.error("Error fetching claims for User ID {}: {}", userId, ex.getMessage());
            return new ResponseEntity<>("An error occurred while fetching claims", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
