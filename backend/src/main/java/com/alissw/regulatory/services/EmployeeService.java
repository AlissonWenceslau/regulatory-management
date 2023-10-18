package com.alissw.regulatory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Page<EmployeeDTO> findEmployeeDownTraining(Integer pageNumber, Integer pageSize, Integer employeeId) {
		try {
			Pageable pageable = PageRequest.of(pageNumber, pageSize);
			List<Employee> list = repository.findEmployeesDownTraining(employeeId);
			int start = (int) pageable.getOffset();
			int end = Math.min((start + pageable.getPageSize()), list.size());
			Page<Employee> page = new PageImpl<>(list.subList(start, end), pageable, list.size());
			
			return page.map(x -> new EmployeeDTO(x));
		}catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException("Resource not found");
		}
	}
}
