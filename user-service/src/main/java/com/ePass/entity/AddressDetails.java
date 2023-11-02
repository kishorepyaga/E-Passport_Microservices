package com.ePass.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressDetails {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String houseNo, streetName, city, state, district;
	
	@Min(10000)
	private Long pinCode;
	
	@Min(1000000000)
	private Long telephoneNumber;
	
	@Email
	private String emailId;
	
	@JsonIgnore
	@OneToOne(mappedBy = "addressDetails")
	private ApplicantDetails applicant;
	
	
	
	
	
}
