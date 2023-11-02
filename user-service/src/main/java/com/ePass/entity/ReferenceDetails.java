package com.ePass.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ReferenceDetails {
	
	@Id
	private String referenceName;
	
	@NotNull
	private String address;
	
	@Min(1000000000)
	private Long telephoneNumber;
	
	@JsonIgnore
	@OneToOne(mappedBy = "referenceDetails")
	private ApplicantDetails applicant;
	
	
	
	
	
}
