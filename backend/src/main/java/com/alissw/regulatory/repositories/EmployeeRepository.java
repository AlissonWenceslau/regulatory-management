package com.alissw.regulatory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alissw.regulatory.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT obj FROM Employee obj JOIN FETCH obj.employees e WHERE "
			+ "(e.status = 2) AND "
			+ "(:employeeId = 0 OR obj.employeeID = :employeeId) Order by obj.firstName")
	List<Employee> findEmployeesDownTraining(Integer employeeId);
}
