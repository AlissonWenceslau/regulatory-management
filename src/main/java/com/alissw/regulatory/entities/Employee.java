package com.alissw.regulatory.entities;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long registration;
	private String firstName;
	private String lastName;
	private Long indentification;
	private Long phone;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, Long registration, String firstName, String lastName, Long indentification, Long phone) {
		super();
		this.id = id;
		this.registration = registration;
		this.firstName = firstName;
		this.lastName = lastName;
		this.indentification = indentification;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getIndentification() {
		return indentification;
	}

	public void setIndentification(Long indentification) {
		this.indentification = indentification;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
}
