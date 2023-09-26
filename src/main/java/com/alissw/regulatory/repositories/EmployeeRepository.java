package com.alissw.regulatory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissw.regulatory.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
