package com.ashref.albumservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashref.albumservice.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}
