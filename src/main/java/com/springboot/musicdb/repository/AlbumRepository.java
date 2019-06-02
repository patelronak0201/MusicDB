package com.springboot.musicdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.musicdb.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}