package com.springboot.musicdb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.musicdb.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
	
	Album findByName(String name);
	List<Album> findByArtistId(Long artistId);
	Optional<List<Album>> findByIdAndArtistId(Long id, Long artistId);

}