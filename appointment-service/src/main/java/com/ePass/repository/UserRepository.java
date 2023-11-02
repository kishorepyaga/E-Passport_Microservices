package com.ePass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ePass.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
