package com.alissw.regulatory.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alissw.regulatory.dto.EmployeeDTO;
import com.alissw.regulatory.dto.EmployeeInsertDTO;
import com.alissw.regulatory.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {

	@Autowired
	private EmployeeService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id){
		EmployeeDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/downtrainings")
	public ResponseEntity<Page<EmployeeDTO>> findEmployeesDownTraining(
			@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(name = "employeeId", defaultValue = "0") Integer employeeId
			){
		Page<EmployeeDTO> dto = service.findEmployeeDownTraining(pageNumber, pageSize, employeeId);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody EmployeeInsertDTO dto){
		service.insert(dto);
		return ResponseEntity.created(null).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @RequestBody EmployeeInsertDTO dto){
		EmployeeDTO newDto = service.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/updateTableEmployeeTraining")
	public void updateTableEmployeeTrainigBasedActualDate() {
		service.updateTableEmployeeTrainigBasedActualDate();
	}
}
