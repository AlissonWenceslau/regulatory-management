package com.alissw.regulatory.dto;

import com.alissw.regulatory.entities.Position;

import jakarta.validation.constraints.NotBlank;

public class PositionDTO {

	private Long id;
	@NotBlank
	private String name;
	
	public PositionDTO() {
		// TODO Auto-generated constructor stub
	}

	public PositionDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public PositionDTO(Position entity) {
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
