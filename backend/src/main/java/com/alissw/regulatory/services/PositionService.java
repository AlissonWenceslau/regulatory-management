package com.alissw.regulatory.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alissw.regulatory.dto.PositionDTO;
import com.alissw.regulatory.entities.Position;
import com.alissw.regulatory.repositories.PositionRepository;
import com.alissw.regulatory.services.exceptions.DatabaseException;
import com.alissw.regulatory.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PositionService {

	@Autowired
	private PositionRepository repository;
	
	@Transactional(readOnly = true)
	public List<PositionDTO> findAll() {
		List<Position> list = repository.findAll();
		return list.stream().map(x -> new PositionDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public PositionDTO findById(Long id) {
		Optional<Position> optional = repository.findById(id);
		Position entity = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new PositionDTO(entity);
	}
	
	@Transactional
	public PositionDTO insert(PositionDTO dto) {
		try {
			Position entity = new Position();
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new PositionDTO(entity);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Name already exists on database");
		}
	}
	
	@Transactional
	public PositionDTO update(Long id, PositionDTO dto) {
		try {
			Position entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new PositionDTO(entity);
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
