package com.ePass.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ePass.entity.Office;


public interface OfficeRepository extends JpaRepository<Office, Integer>{
	
	Optional<Office> findByJuridiction(String juridiction);
}
