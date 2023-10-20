package com.alissw.regulatory.services;

import java.time.Instant;
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
import com.alissw.regulatory.dto.EmployeeInsertDTO;
import com.alissw.regulatory.dto.EmployeeTrainingDTO;
import com.alissw.regulatory.entities.Department;
import com.alissw.regulatory.entities.Employee;
import com.alissw.regulatory.entities.EmployeeTraining;
import com.alissw.regulatory.entities.Position;
import com.alissw.regulatory.entities.Site;
import com.alissw.regulatory.entities.Training;
import com.alissw.regulatory.repositories.DepartmentRepository;
import com.alissw.regulatory.repositories.EmployeeRepository;
import com.alissw.regulatory.repositories.EmployeeTrainingRepository;
import com.alissw.regulatory.repositories.PositionRepository;
import com.alissw.regulatory.repositories.SiteRepository;
import com.alissw.regulatory.repositories.TrainingRepository;
import com.alissw.regulatory.services.exceptions.DatabaseException;
import com.alissw.regulatory.services.exceptions.ResourceNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private PositionRepository positionRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private TrainingRepository trainingRepository;
	@Autowired
	private EmployeeTrainingRepository employeeTrainingRepository;
	
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
	
	@Transactional
	public void insert (EmployeeInsertDTO dto) {
		if(repository.existsById(dto.getEmployeeID())) {
			throw new DatabaseException("EmployeeId already exists: " + dto.getEmployeeID());
		}
		Employee entity = new Employee();
		copyToEntity(dto, entity);
	}
	
	@Transactional
	public EmployeeDTO update(Long id, EmployeeInsertDTO dto) {
		Employee entity = repository.getReferenceById(id);		
		copyToEntity(dto, entity);
		return new EmployeeDTO(entity);
		
	}
	
	@Transactional
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
		repository.deleteById(id);
	}
	
	private void copyToEntity(EmployeeInsertDTO dto, Employee entity) {
		entity.setEmployeeID(dto.getEmployeeID());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setIndentification(dto.getIdentification());
		entity.setCodeArea(dto.getCodeArea());
		entity.setPhone(dto.getPhone());
		entity.setShift(dto.getShift());
		
		Position position = positionRepository.getReferenceById(dto.getPosition().getId());
		entity.setPosition(position);
		
		Department department = departmentRepository.getReferenceById(dto.getDepartment().getId());
		entity.setDepartment(department);
		
		Site site = siteRepository.getReferenceById(dto.getSite().getId());
		entity.setSite(site);
		
		entity = repository.save(entity);
		
		entity.getEmployees().clear();
		for(EmployeeTrainingDTO emp : dto.getTrainings()) {
			Training training = trainingRepository.getReferenceById(emp.getTraining().getId());
			EmployeeTraining employeeTraining = new EmployeeTraining(entity, training, emp.getStartDate(), emp.getEndDate());
			employeeTraining = employeeTrainingRepository.save(employeeTraining);
			entity.getEmployees().add(employeeTraining);
			training.getTrainings().add(employeeTraining);
		}
	}
	
	@Transactional
	public void updateTableEmployeeTrainigBasedActualDate() {
		List<EmployeeTraining> entity = employeeTrainingRepository.findAll();
		for(EmployeeTraining emp : entity) {
			if(emp.getDays()<0) {
				emp.setStatus();
			}
		}
		System.out.println("A tabela de EmployeeTraining Foi atualizada hoje: " + Instant.now());
	}
}
