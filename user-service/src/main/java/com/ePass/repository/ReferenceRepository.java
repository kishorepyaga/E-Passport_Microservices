package com.ePass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ePass.entity.ReferenceDetails;

public interface ReferenceRepository extends JpaRepository<ReferenceDetails, String>{

}
