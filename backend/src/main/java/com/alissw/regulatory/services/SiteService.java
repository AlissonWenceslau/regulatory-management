package com.alissw.regulatory.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alissw.regulatory.dto.SiteDTO;
import com.alissw.regulatory.entities.Site;
import com.alissw.regulatory.repositories.SiteRepository;
import com.alissw.regulatory.services.exceptions.DatabaseException;
import com.alissw.regulatory.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SiteService {

	@Autowired
	private SiteRepository repository;
	
	@Transactional(readOnly = true)
	public List<SiteDTO> findAll() {
		List<Site> list = repository.findAll();
		return list.stream().map(c -> new SiteDTO(c)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public SiteDTO findById(Long id) {
		Optional<Site> optional = repository.findById(id);
		Site entity = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new SiteDTO(entity);
	}
	
	@Transactional
	public SiteDTO insert(SiteDTO dto) {
		try {
			Site entity = new Site();
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new SiteDTO(entity);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Name already exists on database");
		}
	}
	
	@Transactional
	public SiteDTO update(Long id, SiteDTO dto) {
		try {
			Site entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new SiteDTO(entity);
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
