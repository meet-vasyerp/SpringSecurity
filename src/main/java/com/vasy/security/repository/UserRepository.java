package com.vasy.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasy.security.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
		Optional<Users> findByUserEmail(String user);
}
