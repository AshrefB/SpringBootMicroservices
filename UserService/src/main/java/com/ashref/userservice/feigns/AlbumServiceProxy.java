package com.ashref.userservice.feigns;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashref.userservice.dto.AlbumDTO;

@FeignClient(name = "album-service", url = "http://localhost:8010/album-service")
public interface AlbumServiceProxy {
	
	@GetMapping("/user/{userId}")
	public List<AlbumDTO> getUserAlbums(@PathVariable Long userId);
}
