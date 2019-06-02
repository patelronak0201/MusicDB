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
import com.springboot.musicdb.model.Song;
import com.springboot.musicdb.service.SongService;

@RestController

public class SongController {

	@Autowired
	private SongService songService;

	@GetMapping("/songs")
	public List<Song> getAllArtists() {
		return songService.getAllSong();
	}

	@GetMapping("/songs/{id}")
	public Song findById(@PathVariable long id) {
		return songService.findById(id);
	}

	@PostMapping("/songs")
	public Song createArtist(@RequestBody Song song) {
		return songService.createSong(song);
	}

	@PutMapping("/albums/{albumId}/songs/{songId}")
	public Song updateArtist(@RequestBody Song song, @PathVariable long albumId,
			@PathVariable long songId) {
		return songService.updateSong(song, albumId,songId);
	}

	@DeleteMapping("/songs/{id}")
	public void deleteAlbum(@PathVariable long id) {
		songService.deleteSong(id);
	}

	////
	/*
	 * @GetMapping("/albums/getAllArtistForAlbum/{name}") public List<Artist>
	 * getAllArtistForAlbum(@PathVariable final String name) { return
	 * albumService.getAllArtistForAlbum(name); }
	 */
}
