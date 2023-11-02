package com.ePass.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class User {
	
	@Id @GeneratedValue
	private Integer id;
	
	@NotNull
	private String firstName, lastName, gender, role, password;
	
	@NotNull @Past
	private LocalDate dob;
	
	@Email @Column(unique = true)
	private String emailId;
	
	@NotNull @Column(unique = true)
	private Long phoneNumber;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "applicant_details", referencedColumnName = "firstName")
	private ApplicantDetails applicantDetails;
	
}
