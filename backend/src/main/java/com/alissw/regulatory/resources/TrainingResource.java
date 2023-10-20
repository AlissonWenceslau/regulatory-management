package com.alissw.regulatory.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alissw.regulatory.dto.TrainingDTO;
import com.alissw.regulatory.services.TrainingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/trainings")
public class TrainingResource {

	@Autowired
	private TrainingService service;
	
	@GetMapping
	public ResponseEntity<List<TrainingDTO>> findAll(){
		List<TrainingDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TrainingDTO> findById(@PathVariable Long id){
		TrainingDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<TrainingDTO> insert(@Valid @RequestBody TrainingDTO dto){
		dto = service.insert(dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TrainingDTO> update(@PathVariable Long id, @Valid @RequestBody TrainingDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
