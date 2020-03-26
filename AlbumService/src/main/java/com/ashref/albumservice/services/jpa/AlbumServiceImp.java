package com.ashref.albumservice.services.jpa;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

	@Override
	public List<AlbumDTO> getUserAlbums(Long userId) {
		List<Album> albums = new ArrayList<>();
		albumRepository.findByUserId(userId).forEach(albums::add);
		List<AlbumDTO> albumsDTO = mapper.map(albums, new TypeToken<List<AlbumDTO>>(){}.getType());
		return albumsDTO;
	}

}
