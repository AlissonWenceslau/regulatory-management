package com.alissw.regulatory.dto;

import java.util.HashSet;
import java.util.Set;

import com.alissw.regulatory.entities.User;

public class UserDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	private Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(Long id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		email = entity.getEmail();
		entity.getRoles().forEach(role-> this.roles.add(new RoleDTO(role)));
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}
}
