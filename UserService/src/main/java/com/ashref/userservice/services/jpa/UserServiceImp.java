package com.ashref.userservice.services.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.ashref.userservice.dto.AlbumDTO;
import com.ashref.userservice.dto.UserDTO;
import com.ashref.userservice.entities.User;
import com.ashref.userservice.feigns.AlbumServiceProxy;
import com.ashref.userservice.repositories.UserRepository;
import com.ashref.userservice.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
	private UserRepository userRepository;
	private ModelMapper mapper;
	private AlbumServiceProxy albumServiceProxy;

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		User user = mapper.map(userDTO, User.class);
		userRepository.save(user);
		return userDTO;
	}

	@Override
	public UserDTO getUserByIdWithAlbums(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No user found with ID:"+id));
		List<AlbumDTO> albums = albumServiceProxy.getUserAlbums(id);
		UserDTO userDTO = mapper.map(user, UserDTO.class);
		userDTO.setAlbums(albums);
		return userDTO;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		List<UserDTO> usersDTO = mapper.map(users, new TypeToken<List<UserDTO>>(){}.getType());
		return usersDTO;
	}

}
