package com.springboot.musicdb.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass  
public class BaseModel {

	@Id	
	@GeneratedValue
	protected Long id;
	
	
	/*@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;*/

	public BaseModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public Date getCreated() {
		return created;
	}

	@PrePersist
	public void setCreated() {
		this.created = new Date();
	}

	public Date getLastModified() {
		return lastModified;
	}

	@PreUpdate  
	public void setLastModified() {
		this.lastModified = new Date();
	}*/

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;

		BaseModel other = (BaseModel) object;
		if (this.getId() != other.getId() && (this.getId() == null || !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [ID=" + id + "]";
	}

}
