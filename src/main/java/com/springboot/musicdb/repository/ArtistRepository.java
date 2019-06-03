package com.springboot.musicdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.musicdb.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {	
}