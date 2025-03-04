package com.insurance.project.ui.service;

import java.util.List;
import com.insurance.project.ui.model.Claim;

/*
 * Service interface for managing claims.
 * Defines methods for retrieving and adding claims related to users.
 */
public interface ClaimService {

    /*
     * Retrieves a list of claims associated with a specific user.
     * 
     * @param userId The ID of the user whose claims need to be fetched.
     * @return A list of Claim objects belonging to the user.
     */
    List<Claim> getClaimsByUserId(Long userId);

    /*
     * Adds multiple claims for a specific user.
     * 
     * @param userId The ID of the user for whom claims are being added.
     * @param claims The list of claims to be added.
     * @return A list of newly added Claim objects.
     */
    List<Claim> addClaims(Long userId, List<Claim> claims);
}
