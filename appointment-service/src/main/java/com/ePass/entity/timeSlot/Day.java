package com.ePass.entity.timeSlot;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import lombok.ToString;

@ToString
public class Day {

	static Map<LocalDate, Map<FromTo, Boolean>> slots = new LinkedHashMap<>();
	static Map<LocalDate, Map<FromTo, Boolean>> availableSlots = new LinkedHashMap<>();
	
	static {
		for(int i=0; i<31; i++) {
			TimeSlot timeSlot = new TimeSlot();
			Map<FromTo, Boolean> timeSlots = new LinkedHashMap<>();
			timeSlots.put(timeSlot.getFirstSlot(), true);
			timeSlots.put(timeSlot.getSecondSlot(), true);
			timeSlots.put(timeSlot.getThirdSlot(), true);
			
			slots.put(LocalDate.now().plusDays(i), timeSlots);
		}
		setter(new LinkedHashMap<>(slots));
		LocalDate now = LocalDate.now();
		Booking.bookSlot(LocalDate.of(
				now.getYear(), now.getMonth().getValue(), now.getDayOfMonth()+2), 2);
		Booking.bookSlot(LocalDate.of(
				now.getYear(), now.getMonth().getValue(), now.getDayOfMonth()+2), 3);				
	}

	private static void setter(Map<LocalDate, Map<FromTo, Boolean>> slotsCopy) {
		availableSlots = new LinkedHashMap<>();
		for(Entry<LocalDate, Map<FromTo, Boolean>> entry : slotsCopy.entrySet())
			availableSlots.put(entry.getKey(), new LinkedHashMap<>(entry.getValue()));
	}

	
	
	public static Map<LocalDate, Map<FromTo, Boolean>> getSlots() {
		return slots;
	}

	public static Map<LocalDate, Map<FromTo, Boolean>> getAvailableSlots() {
		return availableSlots;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
