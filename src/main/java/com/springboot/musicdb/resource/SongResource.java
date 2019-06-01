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

import com.springboot.musicdb.model.Song;
import com.springboot.musicdb.service.SongService;

@RestController

public class SongResource {

	@Autowired
	private SongService songService;

	@GetMapping("/songs")
	public List<Song> getAllArtists() {
		return songService.getAllSong();
	}

	@GetMapping("/songs/{name}")
	public Song findByName(@PathVariable final String name) {
		return songService.findByName(name);
	}

	@PostMapping("/song/add")
	public Song addArtist(@RequestBody Song song) {
		return songService.addSong(song);
	}

	@PutMapping("/songs/{id}")
	public ResponseEntity<Object> updateArtist(@RequestBody Song song, @PathVariable long id) {
		return songService.updateSong(song, id);
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
