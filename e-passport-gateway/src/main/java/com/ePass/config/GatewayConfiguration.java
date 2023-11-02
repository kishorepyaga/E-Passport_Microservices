package com.ePass.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
	
	@Bean
	RouteLocator gatewayRoute(RouteLocatorBuilder route) {
		return route.routes()
				.route(r -> r.path("/users/**").uri("lb://user-service"))
//				.route(r -> r.path("/u/admin/**").uri("lb://user-service"))
				.route(r -> r.path("/admin/**").uri("lb://user-service"))
				.route(r -> r.path("/appointments/**").uri("lb://appointment-service"))
				.route(r -> r.path("/offices/**").uri("lb://office-service"))
			.build();
	}
	
	
}
