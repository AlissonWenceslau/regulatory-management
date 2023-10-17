package com.alissw.regulatory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissw.regulatory.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
