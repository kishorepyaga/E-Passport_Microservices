package com.ePass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ePass.entity.ApplicantDetails;

public interface ApplicantRepository extends JpaRepository<ApplicantDetails, String>{

}
