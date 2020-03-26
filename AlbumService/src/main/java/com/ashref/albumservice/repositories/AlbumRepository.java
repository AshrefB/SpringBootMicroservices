package com.ashref.albumservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashref.albumservice.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{
	List<Album> findByUserId(Long userId);
}
