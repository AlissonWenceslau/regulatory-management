package com.alissw.regulatory.dto;

import java.io.Serializable;

import com.alissw.regulatory.entities.Position;

import jakarta.validation.constraints.NotBlank;

public class PositionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Name is mandatory")
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
