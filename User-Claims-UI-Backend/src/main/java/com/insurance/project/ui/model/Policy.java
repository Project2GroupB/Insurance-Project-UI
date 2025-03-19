package com.insurance.project.ui.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

/*
 * Represents a Claim entity in the insurance system.
 */
@Entity // Marks this class as a JPA entity for ORM (Object-Relational Mapping)
@Table(name = "policies") // Specifies the table name in the database
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	@Column(nullable = false)
	private Long policySerialNo;
	
	@Column(nullable = false)
	private String policyName;
	@Column(nullable = false)
	private String policyStatus;
	private String policyTerm
	;
	private String policyCoverage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "user_id", nullable = false)
	@JsonIgnore
	private User user;
	
	public Policy() {}

	public Policy(Long policyId, Long policySerialNo, String policyName, String policyStatus, String policyTerm,
			String policyCoverage, User user) {
		super();
		this.policyId = policyId;
		this.policySerialNo = policySerialNo;
		this.policyName = policyName;
		this.policyStatus = policyStatus;
		this.policyTerm = policyTerm;
		this.policyCoverage = policyCoverage;
		this.user = user;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public Long getPolicySerialNo() {
		return policySerialNo;
	}

	public void setPolicySerialNo(Long policySerialNo) {
		this.policySerialNo = policySerialNo;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public String getPolicyTerm() {
		return policyTerm;
	}

	public void setPolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}

	public String getPolicyCoverage() {
		return policyCoverage;
	}

	public void setPolicyCoverage(String policyCoverage) {
		this.policyCoverage = policyCoverage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policySerialNo=" + policySerialNo + ", policyName=" + policyName
				+ ", policyStatus=" + policyStatus + ", policyTerm=" + policyTerm + ", policyCoverage=" + policyCoverage
				+ "]";
	}

	
	
	

}
