package com.springboot.musicdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.musicdb.model.Artist;
import com.springboot.musicdb.service.ArtistService;

@RestController
public class ArtistController {

	@Autowired
	private ArtistService artistService;

	@GetMapping("/artists")
	public List<Artist> getAllArtists() {
		return artistService.getAllArtists();
	}

	@GetMapping("/artists/{id}")
	public Artist findById(@PathVariable long id) {
		return artistService.findById(id);
	}

	@PostMapping("/artists")
	public Artist createArtist(@RequestBody Artist artist) {
		return artistService.createArtist(artist);
	}

	@PutMapping("/artists/{id}")
	public Artist updateArtist(@RequestBody Artist artist, @PathVariable long id) {
		return artistService.updateArtist(artist, id);
	}

	@DeleteMapping("/artists/{id}")
	public void deleteArtist(@PathVariable long id) {
		artistService.deleteArtist(id);
	}
}
