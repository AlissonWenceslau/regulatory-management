package com.alissw.regulatory.dto;

import java.io.Serializable;

import com.alissw.regulatory.entities.Training;

public class TrainingDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
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
