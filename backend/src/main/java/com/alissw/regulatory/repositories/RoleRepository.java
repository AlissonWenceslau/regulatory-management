package com.alissw.regulatory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissw.regulatory.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
