package com.vasy.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vasy.security.dto.UsersDto;
import com.vasy.security.exception.UserNotFoundException;
import com.vasy.security.model.Role;
import com.vasy.security.model.Users;
import com.vasy.security.repository.RoleRepository;
import com.vasy.security.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void AddUser(UsersDto userDto) {
		Users user = new Users();
		user.setUserName(userDto.getUserName());
		user.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
		user.setUserEmail(userDto.getUserEmail());
		user.setUserAge(userDto.getUserAge());
		Role role=roleRepository.findById(2l).orElseThrow(()->new UserNotFoundException("User Not Found!"));		
		user.setRole(role);
		userRepository.save(user);
	}


}
