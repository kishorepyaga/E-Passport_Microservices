package com.ePass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EPassportGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EPassportGatewayApplication.class, args);
	}
}
