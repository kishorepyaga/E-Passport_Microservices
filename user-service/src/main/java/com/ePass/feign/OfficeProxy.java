package com.ePass.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "office-service")//, url = "localhost:8100")
public interface OfficeProxy {

	@GetMapping(value = "offices/{juridiction}")
	Office getByJuridiction(@PathVariable String juridiction);
	
	@GetMapping(value = "offices")
	List<Office> getAll();
	
	@PostMapping("offices/addOffice")//, consumes = {"application/json"})
	Office addOffice(@RequestBody Office office);
}
