package com.springboot.musicdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.musicdb.exception.ResourceNotFoundException;
import com.springboot.musicdb.model.Album;
import com.springboot.musicdb.model.Song;
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

	public Song createSong(Song song) {
		songRepository.save(song);
		return songRepository.findByName(song.getName());
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

	public void deleteSong(long id) {
		songRepository.deleteById(id);
	}

}
