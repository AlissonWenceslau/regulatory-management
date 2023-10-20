package com.alissw.regulatory.dto;

import java.io.Serializable;

import com.alissw.regulatory.entities.Department;

import jakarta.validation.constraints.NotBlank;

public class DepartmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	public DepartmentDTO() {
		// TODO Auto-generated constructor stub
	}

	public DepartmentDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public DepartmentDTO(Department entity) {
		super();
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
