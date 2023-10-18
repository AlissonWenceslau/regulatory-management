package com.alissw.regulatory.dto;

import com.alissw.regulatory.entities.Site;

public class SiteDTO {

	private Long id;
	private String name;
	
	public SiteDTO() {
		// TODO Auto-generated constructor stub
	}

	public SiteDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public SiteDTO(Site entity) {
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
