package com.alissw.regulatory.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alissw.regulatory.dto.EmployeeDTO;
import com.alissw.regulatory.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {

	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findEmployeesDownTraining(){
		List<EmployeeDTO> dto = service.findEmployeeDownTraining();
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id){
		EmployeeDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
