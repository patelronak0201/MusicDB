package com.springboot.musicdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.musicdb.entity.Album;
import com.springboot.musicdb.entity.Song;
import com.springboot.musicdb.exception.ResourceNotFoundException;
import com.springboot.musicdb.repository.AlbumRepository;
import com.springboot.musicdb.repository.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepository;

	@Autowired
	private AlbumRepository albumRepository;

	public List<Song> getAllSong() {
		return songRepository.findAll();
	}

	public Song findById(long id) {
		return songRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("SongId " + id + " not found"));
	}

	public Song createSongForAlbum(Song song, long albumId) {
		Optional<Album> album = albumRepository.findById(albumId);
		if (!album.isPresent()) {
			throw new ResourceNotFoundException("AlbumId " + album + " not found");
		}
		song.setAlbum(album.get());
		return songRepository.save(song);
	}

	public Song updateSong(Song songRequest, long albumId, long songId) {
		Optional<Album> album = albumRepository.findById(albumId);
		if (!album.isPresent()) {
			throw new ResourceNotFoundException("AlbumId " + album + " not found");
		}

		return songRepository.findById(songId).map(song -> {
			song.setName(songRequest.getName());
			song.setTrack(songRequest.getTrack());
			song.setAlbum(album.get());
			return songRepository.save(song);
		}).orElseThrow(() -> new ResourceNotFoundException("SongId " + songId + "not found"));
	}

	public ResponseEntity<?> deleteSong(long id) {
		return songRepository.findById(id).map(song -> {
			songRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("SongId " + id + " not found"));
	}

}
