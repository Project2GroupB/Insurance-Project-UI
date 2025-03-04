package com.insurance.project.ui.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.project.ui.model.Claim;

/*
 * Repository interface for performing CRUD operations on the Claim entity.
 * Extends JpaRepository to provide built-in database operations.
 */
public interface ClaimRepository extends JpaRepository<Claim, Long> {

    /*
     * Retrieves all claims associated with a specific user ID.
     * 
     * @param userId The ID of the user whose claims are to be retrieved.
     * @return List of Claim objects belonging to the specified user.
     */
    List<Claim> findByUserId(Long userId);

    /*
     * Retrieves a specific claim by its unique claim number.
     * 
     * @param claimNumber The unique claim number.
     * @return An Optional containing the Claim object if found, or empty otherwise.
     */
    Optional<Claim> findByClaimNumber(String claimNumber);
}
