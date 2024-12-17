package com.tinyurl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tinyurl_tbl") // table name
public class TinyUrlEntity {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, unique = true)
	private String originalURL;

	@Column(nullable = false, unique = true) // to store the unique hashcode
	private String shortURL;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public String getShortURL() {
		return shortURL;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

}
