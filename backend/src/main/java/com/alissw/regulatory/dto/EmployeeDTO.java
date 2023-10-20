package com.alissw.regulatory.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alissw.regulatory.entities.Employee;
import com.alissw.regulatory.entities.EmployeeTraining;
import com.alissw.regulatory.entities.enums.Shift;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long employeeID;
	private String firstName;
	private String lastName;
	private Shift shift;
	private PositionDTO position;
	private DepartmentDTO department;
	private SiteDTO site;
	private List<EmployeeTrainingDTO> trainings = new ArrayList<>();
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(Long registration, String firstName, String lastName, PositionDTO position, Shift shift, DepartmentDTO department, SiteDTO site) {
		super();
		this.employeeID = registration;
		this.firstName = firstName;
		this.lastName = lastName;
		this.shift = shift;
		this.department = department;
		this.position = position;
		this.site = site;
	}
	
	public EmployeeDTO(Employee entity) {
		super();
		employeeID = entity.getEmployeeID();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		shift = entity.getShift();
		department = new DepartmentDTO(entity.getDepartment());
		position = new PositionDTO(entity.getPosition());
		site = new SiteDTO(entity.getSite());
		for(EmployeeTraining x : entity.getEmployees()) {
			this.trainings.add(new EmployeeTrainingDTO(x));
		}
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Shift getShift() {
		return shift;
	}
	
	public DepartmentDTO getDepartment() {
		return department;
	}

	public PositionDTO getPosition() {
		return position;
	}
	
	public SiteDTO getSite() {
		return site;
	}

	public List<EmployeeTrainingDTO> getTrainings() {
		return trainings;
	}
}
