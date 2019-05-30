package com.springboot.musicdb.resource;

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
import com.springboot.musicdb.model.Artist;
import com.springboot.musicdb.service.AlbumService;

@RestController

public class AlbumResource {

	@Autowired
	private AlbumService albumService;

	@GetMapping("/albums")
	public List<Album> getAllArtists() {
		return albumService.getAllAlbums();
	}

	@GetMapping("/albums/{name}")
	public Album findByName(@PathVariable final String name) {
		return albumService.findByName(name);
	}

	@PostMapping("/albums/add")
	public Album addArtist(@RequestBody Album album) {
		return albumService.addAlbum(album);
	}

	@PutMapping("/albums/{id}")
	public ResponseEntity<Object> updateArtist(@RequestBody Album album, @PathVariable long id) {
		return albumService.updateAlbum(album, id);
	}

	@DeleteMapping("/albums/{id}")
	public void deleteAlbum(@PathVariable long id) {
		albumService.deleteAlbum(id);
	}

	////
	@GetMapping("/albums/getAllArtistForAlbum/{name}")
	public List<Artist> getAllArtistForAlbum(@PathVariable final String name) {
		return albumService.getAllArtistForAlbum(name);
	}
}
