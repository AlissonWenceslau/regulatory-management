package com.alissw.regulatory.dto;

public class UserResponseDTO {

	private String token;
	private String email;
	
	public UserResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserResponseDTO(String token, String email) {
		this.token = token;
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public String getEmail() {
		return email;
	}
}
