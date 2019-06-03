package com.springboot.musicdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.musicdb.entity.Album;
import com.springboot.musicdb.entity.Artist;
import com.springboot.musicdb.exception.ResourceNotFoundException;
import com.springboot.musicdb.repository.AlbumRepository;
import com.springboot.musicdb.repository.ArtistRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRespository;

	@Autowired
	private ArtistRepository artistRespository;

	public List<Album> findAllAlbumsByArtistId(long artistId) {
		return albumRespository.findByArtistId(artistId);
	}

	public List<Album> findAlbumByArtistId(long albumId, long artistId) {
		Optional<List<Album>> albums = albumRespository.findByIdAndArtistId(albumId, artistId);
		if (!albums.isPresent()) {
			throw new ResourceNotFoundException("AlbumId " + albumId + " not found");
		}
		return albums.get();
	}

	public Album createAlbum(Album album) {
		return albumRespository.save(album);
	}

	public Album createAlbumByArtist(Album album, long artistId) {
		Optional<Artist> artist = artistRespository.findById(artistId);
		if (!artist.isPresent()) {
			throw new ResourceNotFoundException("ArtistId " + artistId + " not found");
		}
		album.setArtist(artist.get());
		return albumRespository.save(album);
	}

	public Album updateAlbum(Album albumRequest, long artistId, long albumId) {
		Optional<Artist> artist = artistRespository.findById(artistId);
		if (!artist.isPresent()) {
			throw new ResourceNotFoundException("ArtistId " + artistId + " not found");
		}

		return albumRespository.findById(albumId).map(album -> {
			album.setName(albumRequest.getName());
			album.setReleased(albumRequest.getReleased());
			album.setArtist(artist.get());
			return albumRespository.save(album);
		}).orElseThrow(() -> new ResourceNotFoundException("AlbumId " + albumId + "not found"));
	}

	public ResponseEntity<?> deleteAlbum(long artistId, long albumId) {
		return albumRespository.findByIdAndArtistId(albumId, artistId).map(album -> {
			albumRespository.deleteById(albumId);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("AlbumId " + albumId + " not found"));
	}
}
