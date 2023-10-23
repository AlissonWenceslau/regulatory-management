package com.alissw.regulatory.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alissw.regulatory.dto.UserDTO;
import com.alissw.regulatory.dto.UserResponseDTO;
import com.alissw.regulatory.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class UserResource {
	
	@Autowired
	private UserService service;

	@PostMapping(value = "/login")
	public ResponseEntity<UserResponseDTO> login (@RequestBody UserDTO dto) {
		UserResponseDTO response = service.login(dto);
		
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<Void> insert (@RequestBody UserDTO dto) {
		service.insert(dto);
		
		return ResponseEntity.ok().build();
	}
}
