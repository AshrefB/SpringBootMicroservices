package com.ashref.albumservice.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {
	@Size(min = 3, max = 50, message = "Name Should have [3-50] chars")
	private String name;
	private String description;
	@NotNull(message = "UserId is required")
	private Long userId;
}
