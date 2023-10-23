package com.alissw.regulatory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.alissw.regulatory.dto.UserDTO;
import com.alissw.regulatory.dto.UserResponseDTO;
import com.alissw.regulatory.entities.User;
import com.alissw.regulatory.repositories.UserRepository;
import com.alissw.regulatory.security.TokenService;
import com.alissw.regulatory.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	@Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Transactional
	public UserResponseDTO login(@RequestBody UserDTO dto) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return new UserResponseDTO(token, auth.getName());
        
	}
	
    @Transactional
	public void insert(UserDTO dto) {
        if(this.repository.findByEmail(dto.getEmail()) != null) {
        	throw new ResourceNotFoundException("User already exists");
        }
        User entity = new User();
        copyToEntity(dto, entity);
        repository.save(entity);	
	}
	
	private void copyToEntity(UserDTO dto, User entity) {
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setPasssword(bCryptPasswordEncoder.encode(dto.getPassword()));
	}
}
