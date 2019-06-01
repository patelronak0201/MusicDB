package com.springboot.musicdb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Artist extends BaseModel {

	private String name;

	/*
	 * @ManyToMany(fetch = FetchType.LAZY) private List<Album> albums;
	 */

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "artist_albums", joinColumns = { @JoinColumn(name = "artist_id") }, inverseJoinColumns = {
			@JoinColumn(name = "albums_id") })
	private List<Album> albums;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

}
