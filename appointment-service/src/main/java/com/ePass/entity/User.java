package com.ePass.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class User {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String firstName, lastName;
	
	@Email @Column(unique = true) @NotNull
	private String emailId;
	
	@Column(unique = true) @Min(10000)
	private Long phoneNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "appointment_id", referencedColumnName = "id")
	private AppointmentDetails appointmentDetails;
	
	
}
