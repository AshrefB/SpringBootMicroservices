package com.ashref.userservice.services.jpa;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ashref.userservice.dto.UserDTO;
import com.ashref.userservice.entities.User;
import com.ashref.userservice.repositories.UserRepository;
import com.ashref.userservice.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
	private UserRepository userRepository;
	private ModelMapper mapper;

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		User user = mapper.map(userDTO, User.class);
		userRepository.save(user);
		return userDTO;
	}

}
