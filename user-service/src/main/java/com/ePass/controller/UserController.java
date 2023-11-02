package com.ePass.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ePass.entity.AddressDetails;
import com.ePass.entity.ApplicantDetails;
import com.ePass.entity.ReferenceDetails;
import com.ePass.entity.User;
import com.ePass.feign.Office;
import com.ePass.feign.OfficeProxy;
import com.ePass.repository.UserRepository;

@RestController
@RequestMapping({"users", "admin"})
public class UserController {
	
	@Autowired
	private OfficeProxy officeProxy;
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping
	public String hello() {
		return "<h1> Hello World </h1>";
	}
	
	
	public User loadByUserName(@PathVariable String userName) {
		User user = userRepo.findByEmailId(userName).orElseThrow(
				() -> new RuntimeException("User is not found with the given user name: "+ userName));
		System.out.println(user);
		return user;
	}
	
	@GetMapping("welcome")
	public ModelAndView demoWelcome() {
		return new ModelAndView("welcome");
	}
	
///////////////////////// User Management /////////////////////////
	
	@GetMapping("{id}")
	public User getUserById(@PathVariable Integer id) {
		return userRepo.findById(id).orElseThrow(
				() -> new RuntimeException("User doesn't exists with the Id: "+ id));
	}
	
	@PostMapping("registerUser")
	public ResponseEntity<?> userRegistration(@RequestBody User user){
		user.setRole("ROLE_USER");
		return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
	}
	
	//Action by User
	public ResponseEntity<?> saveApplicantDetailsByUser(@RequestBody ApplicantDetails applicantDetails){
		Integer id = 1;	//need to fetch id of the current user
		return saveApplicantDetails(id, applicantDetails);
	}
	


///////////////////////// Admin Section /////////////////////////
	
	@GetMapping("{id}/getApplicantDetails")
	public ResponseEntity<?> getApplicantDetails(@PathVariable Integer id){
		return new ResponseEntity<>(getUserById(id).getApplicantDetails(), HttpStatus.OK);
	}
	
	@PostMapping("{id}/saveApplicantDetails")
	public ResponseEntity<?> saveApplicantDetails(@PathVariable Integer id, @RequestBody ApplicantDetails applicantDetails) {
		User user = getUserById(id);
		applicantDetails.setFirstName(user.getFirstName());
		
		if(user.getApplicantDetails() != null)
			updateApplicantDetails(id, applicantDetails);
		
		user.setApplicantDetails(applicantDetails);
		userRepo.save(user);
		return new ResponseEntity<>(user.getApplicantDetails(), HttpStatus.OK);
	}
	
	
	@PostMapping("{id}/updateApplicantDetails")
	public ResponseEntity<?> updateApplicantDetails(@PathVariable Integer id, @RequestBody ApplicantDetails applicantDetails) {
		User user = getUserById(id);
		ApplicantDetails currentApplicantDetails = user.getApplicantDetails();
		
		if(!user.getFirstName().equals(applicantDetails.getFirstName()))
			return new ResponseEntity<>("Application Info Doesn't matches with the user", HttpStatus.BAD_REQUEST);
		else {
			AddressDetails addressDetails = currentApplicantDetails.getAddressDetails();
			ReferenceDetails referenceDetails = currentApplicantDetails.getReferenceDetails();
			if(addressDetails != null) 
				applicantDetails.setAddressDetails(addressDetails);
			if(referenceDetails != null)
				applicantDetails.setReferenceDetails(referenceDetails);
		}
		
		user.setApplicantDetails(applicantDetails);
		userRepo.save(user);
		return new ResponseEntity<>(applicantDetails, HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("{id}/saveAddressDetails")
	public ResponseEntity<?> savaAddressDetails(@PathVariable Integer id, @RequestBody AddressDetails addressDetails){
		User user = getUserById(id);
		user.getApplicantDetails().setAddressDetails(addressDetails);
		return new ResponseEntity<>(userRepo.save(user).getApplicantDetails(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("{id}/saveReferenceDetails")
	public ResponseEntity<?> saveReferenceDetails(@PathVariable Integer id, @RequestBody ReferenceDetails referenceDetails){
		User user = getUserById(id);
		user.getApplicantDetails().setReferenceDetails(referenceDetails);
		return new ResponseEntity<>(userRepo.save(user).getApplicantDetails(), HttpStatus.ACCEPTED);
	}


	//Need to hide password, etc while printing the form
	@GetMapping("{id}/printApplicantDetails")
	public List<?> printApplicantDetails(@PathVariable Integer id){
		List<Object> l = new ArrayList<>();
		User user = getUserById(id);
		l.add(user);
		l.add(user.getApplicantDetails());
		return l;
	}
	
	


///////////////////////// Office Management By Admin /////////////////////////
	
	
	@GetMapping("offices")
	public List<Office> getAllOffices(){
		return officeProxy.getAll();
	} 
	
	@GetMapping("offices/{juridiction}")
	public Office getByJuridiction(@PathVariable String juridiction) {
		return officeProxy.getByJuridiction(juridiction);
	}
	
	@PostMapping("offices/addOffice")
	public Office addOffice(@RequestBody Office office) {
		return officeProxy.addOffice(office);
	}
	
	
}
