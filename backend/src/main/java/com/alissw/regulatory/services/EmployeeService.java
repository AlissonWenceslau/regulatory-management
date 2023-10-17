package com.alissw.regulatory.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alissw.regulatory.dto.EmployeeDTO;
import com.alissw.regulatory.entities.Employee;
import com.alissw.regulatory.repositories.EmployeeRepository;
import com.alissw.regulatory.services.exceptions.ResourceNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Transactional(readOnly = true)
	public EmployeeDTO findById(Long id) {
		Optional<Employee> optional = repository.findById(id);
		Employee entity = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EmployeeDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<EmployeeDTO> findEmployeeDownTraining() {
		List<Employee> list = repository.findEmployeesDownTraining();
		return list.stream().map(x -> new EmployeeDTO(x)).collect(Collectors.toList());
	}
}
