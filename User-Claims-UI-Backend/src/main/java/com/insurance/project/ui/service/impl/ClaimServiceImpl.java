package com.insurance.project.ui.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.insurance.project.ui.exception.ResourceNotFoundException;
import com.insurance.project.ui.model.Claim;
import com.insurance.project.ui.model.User;
import com.insurance.project.ui.repository.ClaimRepository;
import com.insurance.project.ui.repository.UserRepository;
import com.insurance.project.ui.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {

    private static final Logger logger = LoggerFactory.getLogger(ClaimServiceImpl.class);

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private UserRepository userRepository; // For validating user existence

    /*
     *  Add multiple claims for a user.
     * @param userId The user ID
     * @param claims List of claims to add
     * @return List of saved claims
     */
    @Override
    public List<Claim> addClaims(Long userId, List<Claim> claims) {
        logger.info("Adding claims for User ID: {}", userId);

        //  Validate if the user exists
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        for (Claim claim : claims) {
            //  Check if a claim with the same claimNumber already exists
            Optional<Claim> existingClaim = claimRepository.findByClaimNumber(claim.getClaimNumber());
            if (existingClaim.isPresent()) {
                throw new RuntimeException("Claim with number " + claim.getClaimNumber() + " already exists.");
            }

            claim.setUser(user); // Set user reference
        }

        //  Save all valid claims
        List<Claim> savedClaims = claimRepository.saveAll(claims);
        logger.info("Successfully added {} claims for User ID: {}", savedClaims.size(), userId);

        return savedClaims;
    }

    /*
     *  Get all claims for a specific user.
     * @param userId The user ID
     * @return List of claims for the user
     */
    @Override
    public List<Claim> getClaimsByUserId(Long userId) {
        logger.info("Fetching claims for User ID: {}", userId);

        // Fetch claims by user ID
        List<Claim> claims = claimRepository.findByUserId(userId);

        if (claims.isEmpty()) {
            logger.warn("No claims found for User ID: {}", userId);
            throw new ResourceNotFoundException("No claims found for User ID: " + userId);
        }

        return claims;
    }
}
