package com.vasy.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasy.security.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
