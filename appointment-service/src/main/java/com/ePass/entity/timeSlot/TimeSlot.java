package com.ePass.entity.timeSlot;

import java.time.LocalTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimeSlot {
	
	private final FromTo firstSlot = 
			new FromTo(LocalTime.of(10, 00), LocalTime.of(12, 00));
	private final FromTo secondSlot = 
			new FromTo(LocalTime.of(1, 30), LocalTime.of(03, 30));
	private final FromTo thirdSlot = 
			new FromTo(LocalTime.of(04, 00), LocalTime.of(06, 00));
}
