package com.insurance.project.ui.model;

import java.util.List;
import jakarta.persistence.*;

/*
 * Entity class representing a user in the insurance system.
 */
@Entity // Marks this class as a JPA entity for ORM (Object-Relational Mapping)
@Table(name = "users") // Specifies the table name in the database
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(nullable = false)
	private String firstName;
	
	private String lastName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String mobileNo;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Policy> policies;

	
	public User( ) {}

	public User(Long userId, String firstName, String lastName, String email, String mobileNo, List<Policy> policies) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.policies = policies;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<Policy> getPolicy() {
		return policies;
	}

	public void setPolicy(List<Policy> policies) {
		this.policies = policies;
	};
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", policies=" + policies + "]";
	}
	
}
