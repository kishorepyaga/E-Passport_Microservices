package com.ePass.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;


@RestController
public class GatewayController {

	@GetMapping({"/", "hello"})
	public ResponseEntity<Object> hello(){
		return new ResponseEntity<Object>("<h1>Hello World</h1>", HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("adminTest")
	public Mono<Object> adminTest() {
		return Mono.just(new ResponseEntity<Object>("<h1>Admin Testing</h1>", HttpStatus.OK));
	}
}