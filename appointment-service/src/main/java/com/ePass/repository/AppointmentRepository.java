package com.ePass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ePass.entity.AppointmentDetails;

public interface AppointmentRepository extends JpaRepository<AppointmentDetails, Integer>{

}
