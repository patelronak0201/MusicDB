package com.springboot.musicdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.musicdb.model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

	Song findByName(String name);
}