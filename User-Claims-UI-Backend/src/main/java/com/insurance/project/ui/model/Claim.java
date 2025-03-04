package com.insurance.project.ui.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/*
 * Represents a Claim entity in the insurance system.
 */
@Entity // Marks this class as a JPA entity for ORM (Object-Relational Mapping)
@Table(name = "claims") // Specifies the table name in the database
public class Claim {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "claims_seq") // Uses a sequence generator for ID generation
    @SequenceGenerator(name = "claims_seq", sequenceName = "CLAIMS_SEQ", allocationSize = 1) // Defines the sequence name in the database
    private Long id;

    @Column(nullable = false, unique = true) // Ensures claimNumber is unique and cannot be null
    private String claimNumber;

    @Column(nullable = false) // Ensures claimStatus cannot be null
    private String claimStatus;

    @Column(nullable = false) // Ensures claimAmount cannot be null
    private double claimAmount;

    @Temporal(TemporalType.DATE) // Specifies that only the DATE part should be stored
    @Column(nullable = false) // Ensures claimDate cannot be null
    private Date claimDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE) // Defines many-to-one relationship with User entity
    @JoinColumn(name = "user_id", nullable = false) // Specifies the foreign key column in the database
    @JsonIgnore // Prevents serialization to avoid infinite recursion
    private User user;

    /*
     * Default Constructor - Required for JPA
     */
    public Claim() {}

    /*
     * Parameterized Constructor - Used to create a Claim instance with specific values.
     * 
     * @param claimNumber  Unique claim number.
     * @param claimStatus  Status of the claim (e.g., "Pending", "Approved", "Rejected").
     * @param claimAmount  Amount of the claim.
     * @param claimDate    Date of the claim.
     * @param user         Associated User who filed the claim.
     */
    public Claim(String claimNumber, String claimStatus, double claimAmount, Date claimDate, User user) {
        this.claimNumber = claimNumber;
        this.claimStatus = claimStatus;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.user = user;
    }

    // Getters and Setters

    /*
     * Gets the ID of the claim.
     * @return claim ID
     */
    public Long getId() { return id; }

    /*
     * Sets the ID of the claim.
     * @param id claim ID
     */
    public void setId(Long id) { this.id = id; }

    /*
     * Gets the claim number.
     * @return claim number
     */
    public String getClaimNumber() { return claimNumber; }

    /*
     * Sets the claim number.
     * @param claimNumber unique claim number
     */
    public void setClaimNumber(String claimNumber) { this.claimNumber = claimNumber; }

    /*
     * Gets the claim status.
     * @return claim status
     */
    public String getClaimStatus() { return claimStatus; }

    /*
     * Sets the claim status.
     * @param claimStatus status of the claim
     */
    public void setClaimStatus(String claimStatus) { this.claimStatus = claimStatus; }

    /*
     * Gets the claim amount.
     * @return claim amount
     */
    public double getClaimAmount() { return claimAmount; }

    /*
     * Sets the claim amount.
     * @param claimAmount amount of the claim
     */
    public void setClaimAmount(double claimAmount) { this.claimAmount = claimAmount; }

    /*
     * Gets the claim date.
     * @return claim date
     */
    public Date getClaimDate() { return claimDate; }

    /*
     * Sets the claim date.
     * @param claimDate date when the claim was filed
     */
    public void setClaimDate(Date claimDate) { this.claimDate = claimDate; }

    /*
     * Gets the user associated with the claim.
     * @return user who filed the claim
     */
    public User getUser() { return user; }

    /*
     * Sets the user associated with the claim.
     * @param user user who filed the claim
     */
    public void setUser(User user) { this.user = user; }
}
