package com.ePass.entity.timeSlot;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ePass.entity.AppointmentDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SlotId {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer slotId;
	
	@NotNull
	private LocalDate date;
	
	@NotNull
	private LocalTime _from, _to;
	
	@JsonIgnore
	@OneToOne(mappedBy = "slotId")
	private AppointmentDetails appointmentDetails;
	
	
	
	
	
	
}
