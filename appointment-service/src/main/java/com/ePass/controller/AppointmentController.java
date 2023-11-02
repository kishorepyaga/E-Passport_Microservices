package com.ePass.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ePass.entity.User;
import com.ePass.entity.timeSlot.Booking;
import com.ePass.entity.timeSlot.Day;
import com.ePass.entity.timeSlot.FromTo;
import com.ePass.feign.UserProxy;
import com.ePass.repository.UserRepository;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserProxy proxy;
	
	
	@GetMapping({"/", "hello"})
	public ResponseEntity<Object> hello(){
		return new ResponseEntity<Object>("<h1>Hello World</h1>", HttpStatus.OK);
	}
	
	@Autowired
	private Environment env;

	//Need to make it to fetch the current user Id
	@GetMapping("test")
	public User getUserByEmailId() {
		
//		System.out.println(env.getProperty("userN"));;
//		return proxy.findByEmailId("");
		return null;
	}
	
	@GetMapping("users")
	public List<User> getAllAppointedUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("availableSlots")
	public Map<LocalDate, Map<FromTo, Boolean>> getAvailableSlots(){
		return Day.getAvailableSlots();
	}
	
	@GetMapping("allSlots")
	public Map<LocalDate, Map<FromTo, Boolean>> getAllSlots(){
		return Day.getSlots();
	}
	
	
	/////////////////// Local Date & Slots /////////////////////
	
	@PostMapping("bookSlot")
	public ResponseEntity<Object> bookSlot(@RequestBody Map<String, Object> map){
		if(map.size() < 2 || !map.containsKey("date") || !map.containsKey("slot"))
			return new ResponseEntity<Object>("Please Reselt the date & time properly", HttpStatus.BAD_REQUEST);
		
		LocalDate date = LocalDate.parse((String) map.get("date"), DateTimeFormatter.ISO_LOCAL_DATE);
		Integer slot = (Integer) map.get("slot");
		
		if(date.equals(null) || slot.equals(null))
			return new ResponseEntity<Object>("Please Reselt the date & time properly", HttpStatus.BAD_REQUEST);

		Object bookedSlot = Booking.bookSlot(date, slot).getBody();
		return new ResponseEntity<Object>(bookedSlot, HttpStatus.CREATED);
	}
	
	
}
