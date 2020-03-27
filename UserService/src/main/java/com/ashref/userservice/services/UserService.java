package com.ashref.userservice.services;

import java.util.List;

import com.ashref.userservice.dto.UserDTO;

public interface UserService {
	public UserDTO addUser(UserDTO userDTO);
	public UserDTO getUserByIdWithAlbums(Long id);
	public List<UserDTO> getAllUsersWithAlbums();
}
