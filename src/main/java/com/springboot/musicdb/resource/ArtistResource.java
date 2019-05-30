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
import com.springboot.musicdb.service.ArtistService;

@RestController

public class ArtistResource {

	@Autowired
	private ArtistService artistService;

	@GetMapping("/artists")
	public List<Artist> getAllArtists() {
		return artistService.getAllArtists();
	}

	@GetMapping("/artists/{name}")
	public Artist findByName(@PathVariable final String name) {
		return artistService.findByName(name);
	}

	@PostMapping("/artists/add")
	public Artist addArtist(@RequestBody Artist artist) {
		return artistService.addArtist(artist);
	}

	@PutMapping("/artists/{id}")
	public ResponseEntity<Object> updateArtist(@RequestBody Artist artist, @PathVariable long id) {
		return artistService.updateArtist(artist, id);
	}

	@DeleteMapping("/artists/{id}")
	public void deleteArtist(@PathVariable long id) {
		artistService.deleteArtist(id);
	}
	
	//Retrieve Albums for a given Artist
	
	@GetMapping("/artists/getAllAlbumsForArtist/{name}")
	public List<Album> getAllAlbumsForArtist(@PathVariable final String name) {
		return artistService.getAllAlbumsForArtist(name);
	}
	

}
