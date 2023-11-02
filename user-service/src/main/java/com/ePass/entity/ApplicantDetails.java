package com.ePass.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ApplicantDetails {
	
	@Id
	private String firstName;
	
	@NotNull @Column(unique = true)
	private String pan;
	
	@NotNull
	private String fatherName, motherName, placeOfBirth, gender, state, district, maritalStatus, employmentType, educationalQualification;
	
	@JsonIgnore
	@OneToOne(mappedBy = "applicantDetails")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_details_id")//, referencedColumnName = "id") 
	private AddressDetails addressDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reference_details", referencedColumnName = "referenceName")
	private ReferenceDetails referenceDetails;
	
}
