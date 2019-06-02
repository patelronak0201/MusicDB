package com.springboot.musicdb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album extends BaseModel {

	private String name;

	@Column(name = "year_released")
	private Integer released;

	@ManyToOne
	@JoinTable(name = "artist_albums", joinColumns = { @JoinColumn(name = "albums_id") }, inverseJoinColumns = {
			@JoinColumn(name = "artist_id") })
	private Artist artist;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "album")	
	private List<Song> song = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getReleased() {
		return released;
	}

	public void setReleased(Integer released) {
		this.released = released;
	}

	public List<Song> getSong() {
		return song;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

}
