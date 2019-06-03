package com.springboot.musicdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.musicdb.exception.ResourceNotFoundException;
import com.springboot.musicdb.model.Artist;
import com.springboot.musicdb.repository.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;

	public List<Artist> getAllArtists() {
		return artistRepository.findAll();
	}

	public Artist findById(long id) {
		return artistRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ArtistId " + id + " not found"));
	}

	public Artist createArtist(Artist artist) {
		return artistRepository.save(artist);
	}

	public Artist updateArtist(Artist artist, long id) {
		return artistRepository.findById(id).map(newArtist -> {
			newArtist.setName(artist.getName());
			return artistRepository.save(newArtist);
		}).orElseThrow(() -> new ResourceNotFoundException("ArtistId " + id + " not found"));
	}

	public ResponseEntity<?> deleteArtist(long id) {
		return artistRepository.findById(id).map(artist -> {
			artistRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("ArtistId " + id + " not found"));
	}

}
