package com.alissw.regulatory.dto;

import java.io.Serializable;

import com.alissw.regulatory.entities.Training;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TrainingDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotNull(message = "Can't not be null")
	private CategoryDTO category;
	
	public TrainingDTO() {
		// TODO Auto-generated constructor stub
	}

	public TrainingDTO(Long id, String name, CategoryDTO category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
	public TrainingDTO(Training entity) {
		id = entity.getId();
		name = entity.getName();
		category = new CategoryDTO(entity.getCategory());
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public CategoryDTO getCategory() {
		return category;
	}
}
