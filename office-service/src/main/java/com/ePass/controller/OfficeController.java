package com.ePass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ePass.entity.Office;
import com.ePass.repository.OfficeRepository;

@RestController
@RequestMapping("offices")
public class OfficeController {

	@Autowired
	private OfficeRepository repo;
	
	@GetMapping
	public List<Office> getAll(){
		return repo.findAll();
	}
	
	@GetMapping("{juridiction}")
	public Office getByJuridiction(@PathVariable String juridiction) {
		return repo.findByJuridiction(juridiction).orElseThrow(
				() -> new RuntimeException("Office is not present with the given Juridiction/District"));
	}
	
	@PostMapping("addOffice")//, consumes = {"application/json"}) not required
	public Office addOffice(@RequestBody Office office) {
		return repo.save(office);
	}
	
}
