package com.alissw.regulatory.services.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alissw.regulatory.entities.User;
import com.alissw.regulatory.repositories.UserRepository;
import com.alissw.regulatory.services.UserService;

@Service
public class AuthorizationService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if(user == null) {
			logger.error("Not Found: " + username);
			throw new UsernameNotFoundException(" Email Not Found: " + username);
		}
		logger.info("Found User: " + username);
		return user;
	}
}
