package com.ePass.entity;

import java.time.Month;

import com.ePass.entity.timeSlot.SlotId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AppointmentDetails {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private Integer monthId;
	
	@NotNull
	private Month monthName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "slot_id", referencedColumnName = "slotId")
	private SlotId slotId; 	//format: Map<LocalDate, Map<FromTo, Boolean>> 
	
	@JsonIgnore
	@OneToOne(mappedBy = "appointmentDetails")
	private User user;
	
	
	
	
	
}
