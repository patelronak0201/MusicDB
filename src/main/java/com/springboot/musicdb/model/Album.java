package com.springboot.musicdb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album extends BaseModel{

	private String name;

	@Column(name = "year_released")
	private Integer released;

	@ManyToMany(mappedBy = "albums", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Artist> artist;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id")
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

	public List<Artist> getArtist() {
		return artist;
	}

	public List<Song> getSong() {
		return song;
	}

}
