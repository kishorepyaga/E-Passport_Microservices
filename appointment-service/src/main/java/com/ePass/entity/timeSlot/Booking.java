package com.ePass.entity.timeSlot;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Booking {
	
	public static ResponseEntity<Object> bookSlot(LocalDate date, Integer slot){
		FromTo timeSlot = findTimeSlot(slot);
//		Map<LocalDate, Map<FromTo, Boolean>> slots = Day.slots;
		
		if(Day.availableSlots.get(date).isEmpty()) 
			return new ResponseEntity<>("This Day is Not Available To Book", HttpStatus.BAD_REQUEST);
		if(!Day.availableSlots.get(date).containsKey(timeSlot))
			return new ResponseEntity<>("This Slot is already Booked", HttpStatus.ALREADY_REPORTED);
		
		Day.slots.get(date).put(timeSlot, false);
		
//		Map<FromTo, Boolean> slotMap = slots.get(date);
//		slotMap.put(timeSlot, false);
//		slots.put(date, slotMap);
//		Day.slots = slots;
		System.out.println("\n ------------- Your Booked Date & Slot Time is -----------------");
		
		Map<LocalDate, FromTo> bookedSlot = new HashMap<>();
		bookedSlot.put(date, timeSlot);
		System.out.println(bookedSlot);
		removeSlot(date, timeSlot);
		
		return new ResponseEntity<Object>(bookedSlot, HttpStatus.CREATED);
	}

	private static void removeSlot(LocalDate date, FromTo timeSlot) {
		Day.availableSlots.get(date).remove(timeSlot);
	}

	private static FromTo findTimeSlot(Integer slot) {
		return (slot == 1) ? new TimeSlot().getFirstSlot() : 
			( (slot == 2) ? new TimeSlot().getSecondSlot() : new TimeSlot().getThirdSlot() );
	}

}
