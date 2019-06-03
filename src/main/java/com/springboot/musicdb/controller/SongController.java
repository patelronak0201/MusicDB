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

import com.springboot.musicdb.entity.Song;
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

	@PostMapping("/albums/{albumId}/songs")
	public Song createArtist(@RequestBody Song song, @PathVariable long albumId) {
		return songService.createSongForAlbum(song, albumId);
	}

	@PutMapping("/albums/{albumId}/songs/{songId}")
	public Song updateArtist(@RequestBody Song song, @PathVariable long albumId, @PathVariable long songId) {
		return songService.updateSong(song, albumId, songId);
	}

	@DeleteMapping("/songs/{id}")
	public ResponseEntity<?> deleteAlbum(@PathVariable long id) {
		return songService.deleteSong(id);
	}
}
