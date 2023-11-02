package com.ePass.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ePass.entity.User;

@FeignClient(value = "user-service")//, url = "localhost:8000")
public interface UserProxy {

	@GetMapping("admin/users/{id}")
	public User getById(@PathVariable Integer id);
	
	@GetMapping("admin/users/u/{userName}")
	public User findByEmailId(@PathVariable String userName);
}
