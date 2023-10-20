package com.alissw.regulatory.dto;

import com.alissw.regulatory.entities.enums.Shift;

public class EmployeeInsertDTO extends EmployeeDTO{
	private static final long serialVersionUID = 1L;

	private Integer codeArea;
	private Long identification;
	private Long phone;
	
	public EmployeeInsertDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeInsertDTO(Long registration, String firstName, String lastName, PositionDTO position, Shift shift,
			DepartmentDTO department, SiteDTO site, Integer codeArea, Long identification, Long phone) {
		super(registration, firstName, lastName, position, shift, department, site);
		this.codeArea = codeArea;
		this.identification = identification;
		this.phone = phone;
	}

	public Integer getCodeArea() {
		return codeArea;
	}

	public Long getIdentification() {
		return identification;
	}

	public Long getPhone() {
		return phone;
	}
}
