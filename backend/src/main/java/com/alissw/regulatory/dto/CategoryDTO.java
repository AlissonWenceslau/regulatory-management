package com.alissw.regulatory.dto;

import com.alissw.regulatory.entities.Category;

import jakarta.validation.constraints.NotBlank;

public class CategoryDTO {

	private Long id;
	@NotBlank
	private String name;
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public CategoryDTO(Category entity) {
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
