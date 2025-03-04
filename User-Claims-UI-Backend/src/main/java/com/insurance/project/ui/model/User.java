package com.insurance.project.ui.model;

import java.util.List;
import jakarta.persistence.*;

/*
 * Entity class representing a user in the insurance system.
 */
@Entity // Marks this class as a JPA entity for ORM (Object-Relational Mapping)
@Table(name = "users") // Specifies the table name in the database
public class User {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Automatically generates unique values for user ID
    private Long id;

    @Column(nullable = false) // Ensures name cannot be null
    private String name;

    @Column(unique = true, nullable = false) // Ensures email is unique and cannot be null
    private String email;

    private String phone; // Stores the user's phone number
    private String address; // Stores the user's address

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) 
    /*
     * Establishes a one-to-many relationship with the Claim entity.
     * "mappedBy = 'user'" indicates that the 'user' field in the Claim entity owns the relationship.
     * "cascade = CascadeType.ALL" ensures that any operation (persist, remove, update) on the User 
     * will be cascaded to its associated Claims.
     */
    private List<Claim> claims;

    /*
     * Default Constructor - Required for JPA
     */
    public User() {}

    /*
     * Parameterized Constructor - Used to create a User instance with specific values.
     *
     * @param name    User's full name.
     * @param email   User's email address (must be unique).
     * @param phone   User's phone number.
     * @param address User's residential address.
     * @param claims  List of claims associated with the user.
     */
    public User(String name, String email, String phone, String address, List<Claim> claims) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.claims = claims;
    }

    // Getters and Setters

    /*
     * Gets the ID of the user.
     * @return user ID
     */
    public Long getId() { return id; }

    /*
     * Sets the ID of the user.
     * @param id user ID
     */
    public void setId(Long id) { this.id = id; }

    /*
     * Gets the user's name.
     * @return user name
     */
    public String getName() { return name; }

    /*
     * Sets the user's name.
     * @param name user name
     */
    public void setName(String name) { this.name = name; }

    /*
     * Gets the user's email.
     * @return user email
     */
    public String getEmail() { return email; }

    /*
     * Sets the user's email.
     * @param email user email
     */
    public void setEmail(String email) { this.email = email; }

    /*
     * Gets the user's phone number.
     * @return user phone number
     */
    public String getPhone() { return phone; }

    /*
     * Sets the user's phone number.
     * @param phone user phone number
     */
    public void setPhone(String phone) { this.phone = phone; }

    /*
     * Gets the user's address.
     * @return user address
     */
    public String getAddress() { return address; }

    /*
     * Sets the user's address.
     * @param address user address
     */
    public void setAddress(String address) { this.address = address; }

    /*
     * Gets the list of claims associated with the user.
     * @return list of claims
     */
    public List<Claim> getClaims() { return claims; }

    /*
     * Sets the list of claims associated with the user.
     * @param claims list of claims
     */
    public void setClaims(List<Claim> claims) { this.claims = claims; }
}
