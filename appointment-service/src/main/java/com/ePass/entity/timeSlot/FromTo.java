package com.ePass.entity.timeSlot;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FromTo {
	
	private final LocalTime from;
	private final LocalTime to;

}
