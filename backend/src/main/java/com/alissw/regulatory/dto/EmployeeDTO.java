package com.alissw.regulatory.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alissw.regulatory.entities.Employee;
import com.alissw.regulatory.entities.EmployeeTraining;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long registration;
	private String firstName;
	private String lastName;
	private List<EmployeeTrainingDTO> trainings = new ArrayList<>();
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(Long id, Long registration, String firstName, String lastName) {
		super();
		this.id = id;
		this.registration = registration;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public EmployeeDTO(Employee entity) {
		super();
		id = entity.getId();
		registration = entity.getRegistration();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		for(EmployeeTraining x : entity.getEmployees()) {
			this.trainings.add(new EmployeeTrainingDTO(x));
		}
	}

	public Long getId() {
		return id;
	}

	public Long getRegistration() {
		return registration;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<EmployeeTrainingDTO> getTrainings() {
		return trainings;
	}
}
