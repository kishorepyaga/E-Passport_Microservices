package com.ePass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ePass.entity.AddressDetails;

public interface AddressRepository extends JpaRepository<AddressDetails, Integer>{

}
