package com.ePass.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ePass.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmailId(String userName);
}
