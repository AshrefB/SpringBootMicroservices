package com.ashref.albumservice.services.jpa;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ashref.albumservice.dto.AlbumDTO;
import com.ashref.albumservice.entities.Album;
import com.ashref.albumservice.repositories.AlbumRepository;
import com.ashref.albumservice.services.AlbumService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbumServiceImp implements AlbumService {
	private AlbumRepository albumRepository;
	private ModelMapper mapper;
	
	@Override
	public AlbumDTO addAlbum(AlbumDTO albumDTO) {
		Album album = mapper.map(albumDTO, Album.class);
		albumRepository.save(album);
		return albumDTO;
	}

}
