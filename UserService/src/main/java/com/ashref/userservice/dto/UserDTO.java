package com.ashref.userservice.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@Size(min = 3, max = 30, message = "Name should have [3-30] chars")
	private String name;
	@Email(message = "Email should have a valid email")
	private String email;
	@Pattern(regexp = "$[0-9]{6-8}^")
	private String password;
	private List<AlbumDTO> albums = new ArrayList<>();
}
