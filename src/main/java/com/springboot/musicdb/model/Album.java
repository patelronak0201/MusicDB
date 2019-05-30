package com.springboot.musicdb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Album  {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(name = "year_released")
	private Integer released;

	@ManyToMany(mappedBy = "albums")
	private List<Artist> artist;

	/*@OneToMany
	@JoinColumn(name = "album_id")
	private List<Song> song = new ArrayList<>();*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

/*	public List<Song> getSong() {
		return song;
	}
*/
}
