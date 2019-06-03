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

	@GetMapping("/artists/{artistId}/albums")
	public List<Album> getAllAlbumsByArtistId(@PathVariable long artistId) {
		return albumService.findAllAlbumsByArtistId(artistId);
	}
	
	@GetMapping("/artists/{artistId}/albums/{albumId}")
	public List<Album> getAlbumByArtistId(@PathVariable long artistId,@PathVariable long albumId) {
		return albumService.findAlbumByArtistId(albumId,artistId);
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

	@DeleteMapping("/artists/{artistId}/albums/{albumId}")
	public ResponseEntity<?> deleteAlbum(@PathVariable long artistId, @PathVariable long albumId) {
		return albumService.deleteAlbum(artistId, albumId);
	}
}
