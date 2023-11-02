package com.ePass.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Office {

	@Id @GeneratedValue
	private Integer id;
	
	@NotNull
	private String officeName, address;
	
	@Column(unique = true) @NotNull
	private String juridiction;
	
	@Column(unique = true) @Min(10000)
	private Long phoneNumber;
	
	
	
	
}
