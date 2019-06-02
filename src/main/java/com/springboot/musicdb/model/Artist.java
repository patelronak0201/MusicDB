package com.springboot.musicdb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = { "albums"})
public class Artist extends BaseModel {

	private String name;

	/*
	 * @ManyToMany(fetch = FetchType.LAZY) private List<Album> albums;
	 */

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "artist_albums", joinColumns = { @JoinColumn(name = "artist_id") }, inverseJoinColumns = {
			@JoinColumn(name = "albums_id")})
	
	private List<Album> albums=new ArrayList();

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
