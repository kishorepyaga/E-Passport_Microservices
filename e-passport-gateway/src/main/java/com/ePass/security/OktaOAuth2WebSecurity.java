package com.ePass.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity(useAuthorizationManager = true)
public class OktaOAuth2WebSecurity {
	
	@Bean
	SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
		http
				.authorizeExchange(a -> a
						.pathMatchers("/public/**", "/actuator/**").permitAll()
						.pathMatchers("/admin/**", "/admin").hasAuthority("ROLE_ADMIN")
						.anyExchange().authenticated())
				.oauth2Login(
						Customizer.withDefaults())
				.logout(l -> l
						.logoutUrl("/"))
//				.httpBasic(Customizer.withDefaults())
				.oauth2ResourceServer(
						(o -> o.jwt(Customizer.withDefaults())));
		
		return http.build();
	}

}
