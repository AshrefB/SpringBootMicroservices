package com.ashref.albumservice.services;

import java.util.List;

import com.ashref.albumservice.dto.AlbumDTO;

public interface AlbumService {
	public AlbumDTO addAlbum(AlbumDTO albumDTO);
	public List<AlbumDTO> getUserAlbums(Long userId);
}
