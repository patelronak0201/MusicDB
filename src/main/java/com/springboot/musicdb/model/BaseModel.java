package com.springboot.musicdb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public class BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	protected Long id;

	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date created = new Date();

	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	private Date lastModified;

	public BaseModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = (this.created == null) ? new Date() : created;
	}

	public Date getLastModified() {
		return this.lastModified;

	}

	public void setLastModified(Date lastModified) {
		this.lastModified = (this.lastModified == null) ? new Date() : lastModified;
	}

}
