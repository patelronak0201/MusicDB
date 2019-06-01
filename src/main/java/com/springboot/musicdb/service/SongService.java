package com.springboot.musicdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.musicdb.model.Song;
import com.springboot.musicdb.repository.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepository;

	public List<Song> getAllSong() {
		return songRepository.findAll();
	}

	public Song findByName(String name) {
		return songRepository.findByName(name);
	}

	public Song addSong(Song song) {
		songRepository.save(song);
		return songRepository.findByName(song.getName());
	}

	public ResponseEntity<Object> updateSong(Song song, long id) {
		Optional<Song> songOptional = songRepository.findById(id);
		if (!songOptional.isPresent())
			return ResponseEntity.notFound().build();

		song.setId(id);
		song.setName(song.getName());
		songRepository.save(song);
		return ResponseEntity.noContent().build();
	}

	public void deleteSong(long id) {
		songRepository.deleteById(id);
	}

	///
	/*public List<Album> getAllAlbumsForArtist(String name) {
		Artist artist = songRepository.findByName(name);
		return artist.getAlbums();
	}*/

}
