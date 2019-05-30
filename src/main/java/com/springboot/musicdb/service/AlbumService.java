package com.springboot.musicdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.musicdb.model.Album;
import com.springboot.musicdb.model.Artist;
import com.springboot.musicdb.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRespository;

	public List<Album> getAllAlbums() {
		return albumRespository.findAll();
	}

	public Album findByName(String name) {
		return albumRespository.findByName(name);
	}

	public Album addAlbum(Album album) {
		albumRespository.save(album);
		return albumRespository.findByName(album.getName());
	}

	public ResponseEntity<Object> updateAlbum(Album album, long id) {
		Optional<Album> albumOptional = albumRespository.findById(id);
		if (!albumOptional.isPresent())
			return ResponseEntity.notFound().build();

		album.setId(id);
		album.setName(album.getName());
		album.setReleased(album.getReleased());
		albumRespository.save(album);
		return ResponseEntity.noContent().build();
	}

	public void deleteAlbum(long id) {
		albumRespository.deleteById(id);
	}
	
	
	//Get all artists for a given Album
	public List<Artist> getAllArtistForAlbum(String name) {
		Album album = albumRespository.findByName(name);
		return album.getArtist();
	}
}
