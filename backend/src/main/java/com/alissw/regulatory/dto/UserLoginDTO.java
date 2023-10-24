package com.alissw.regulatory.dto;

public class UserLoginDTO extends UserResponseDTO {

	private String password;
	
	public UserLoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserLoginDTO(String email, String senha) {
		super(email);
		this.password = senha;
	}

	public String getPassword() {
		return password;
	}
}
