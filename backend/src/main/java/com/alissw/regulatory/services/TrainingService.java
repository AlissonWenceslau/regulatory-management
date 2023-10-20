package com.alissw.regulatory.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alissw.regulatory.dto.TrainingDTO;
import com.alissw.regulatory.entities.Category;
import com.alissw.regulatory.entities.Training;
import com.alissw.regulatory.repositories.CategoryRepository;
import com.alissw.regulatory.repositories.TrainingRepository;
import com.alissw.regulatory.services.exceptions.DatabaseException;
import com.alissw.regulatory.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TrainingService {

	@Autowired
	private TrainingRepository repository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public List<TrainingDTO> findAll() {
		List<Training> list = repository.findAll();
		return list.stream().map(c -> new TrainingDTO(c)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public TrainingDTO findById(Long id) {
		Optional<Training> optional = repository.findById(id);
		Training entity = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new TrainingDTO(entity);
	}
	
	@Transactional
	public TrainingDTO insert(TrainingDTO dto) {
		try {
			Category category = categoryRepository.getReferenceById(dto.getCategory().getId());
			Training entity = new Training();
			entity.setName(dto.getName());
			entity = repository.save(entity);
			entity.setCategory(category);
			
			return new TrainingDTO(entity);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Name already exists on database");
		}
	}
	
	@Transactional
	public TrainingDTO update(Long id, TrainingDTO dto) {
		try {
			Category category = categoryRepository.getReferenceById(dto.getCategory().getId());
			Training entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			entity.setCategory(category);
			
			return new TrainingDTO(entity);
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
