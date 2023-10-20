package com.alissw.regulatory.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alissw.regulatory.dto.DepartmentDTO;
import com.alissw.regulatory.entities.Department;
import com.alissw.regulatory.repositories.DepartmentRepository;
import com.alissw.regulatory.services.exceptions.DatabaseException;
import com.alissw.regulatory.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	@Transactional(readOnly = true)
	public List<DepartmentDTO> findAll() {
		List<Department> list = repository.findAll();
		return list.stream().map(c -> new DepartmentDTO(c)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public DepartmentDTO findById(Long id) {
		Optional<Department> optional = repository.findById(id);
		Department entity = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new DepartmentDTO(entity);
	}
	
	@Transactional
	public DepartmentDTO insert(DepartmentDTO dto) {
		try {
			Department entity = new Department();
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new DepartmentDTO(entity);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Name already exists on database");
		}
	}
	
	@Transactional
	public DepartmentDTO update(Long id, DepartmentDTO dto) {
		try {
			Department entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new DepartmentDTO(entity);
		}catch (EntityNotFoundException  e) {
			throw new ResourceNotFoundException("Entity not found");
		}
	}
	
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Entity not found");
		}
		
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
	}
}
