package com.springboot.musicdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.musicdb.model.Album;
import com.springboot.musicdb.model.Artist;
import com.springboot.musicdb.repository.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;

	public List<Artist> getAllArtists() {
		return artistRepository.findAll();
	}

	public Artist findByName(String name) {
		return artistRepository.findByName(name);
	}

	public Artist addArtist(Artist artist) {
		artistRepository.save(artist);
		return artistRepository.findByName(artist.getName());
	}

	public ResponseEntity<Object> updateArtist(Artist artist, long id) {
		Optional<Artist> artistOptional = artistRepository.findById(id);
		if (!artistOptional.isPresent())
			return ResponseEntity.notFound().build();

		artist.setId(id);
		artist.setName(artist.getName());
		artistRepository.save(artist);
		return ResponseEntity.noContent().build();
	}

	public void deleteArtist(long id) {
		artistRepository.deleteById(id);
	}

	///
	public List<Album> getAllAlbumsForArtist(String name) {
		Artist artist = artistRepository.findByName(name);
		return artist.getAlbums();
	}

}
