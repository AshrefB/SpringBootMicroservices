package com.ashref.userservice.services.jpa;

import java.util.NoSuchElementException;

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

	@Override
	public UserDTO getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No user found with ID:"+id));
		return mapper.map(user, UserDTO.class);
	}

}
