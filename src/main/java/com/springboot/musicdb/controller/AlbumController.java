package com.springboot.musicdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.musicdb.model.Album;
import com.springboot.musicdb.service.AlbumService;

@RestController
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	@GetMapping("/albums")
	public List<Album> getAllAlbums() {
		return albumService.getAllAlbums();
	}

	@GetMapping("/albums/{id}")
	public Album findById(@PathVariable long id) {
		return albumService.findById(id);
	}
	

	@PostMapping("/artists/{artistId}/albums")
	public Album createAlbumByArtist(@RequestBody Album album, @PathVariable long artistId) {
		return albumService.createAlbumByArtist(album, artistId);
	}

	@PutMapping("/artists/{artistId}/albums/{albumId}")
	public Album updateAlbumByArtist(@RequestBody Album album, @PathVariable long artistId,
			@PathVariable long albumId) {
		return albumService.updateAlbum(album, artistId, albumId);
	}

	@DeleteMapping("/albums/{id}")
	public ResponseEntity<?> deleteAlbum(@PathVariable long id) {
		return albumService.deleteAlbum(id);
	}
}
