package com.springboot.musicdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		artistRepository.save(artist);
		return artistRepository.findByName(artist.getName());
	}

	public Artist updateArtist(Artist artist, long id) {
		return artistRepository.findById(id).map(newArtist -> {
			newArtist.setName(artist.getName());
			return artistRepository.save(newArtist);
		}).orElseThrow(() -> new ResourceNotFoundException("ArtistId " + id + " not found"));
	}

	public void deleteArtist(long id) {
		artistRepository.deleteById(id);
	}

}
