package com.ePass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ePass.entity.User;
import com.ePass.repository.UserRepository;

@RestController
@RequestMapping("admin/users")
public class AdminController {

	@Autowired
	private UserRepository userRepo;
	
//////////////////////////// User Management ////////////////////////////
	
	@GetMapping
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("u/{userName}")
	public User findByEmailId(@PathVariable String userName) {
		return userRepo.findByEmailId(userName).orElseThrow(
				() -> new RuntimeException("User is not found with the given user name: "+ userName));
	}
	
	@GetMapping("{id}")
	public User getUserById(@PathVariable Integer id) {
		return userRepo.findById(id).orElseThrow(
				() -> new RuntimeException());
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id){
		userRepo.deleteById(id);
		return new ResponseEntity<>("Deleted if Exists", HttpStatus.OK);
	}
	
	
//////////////////////////// Applicant Details Management ////////////////////////////
	
	
	
	
}


@RestController
class EasyController {
	
	@GetMapping
	public String nothing() {
		return "<h1>Hello Nothing</h1>";
	}
}
