package fr.asenka.mymoviesapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "movies", indexes = { @Index(name = "idx_movies_title", columnList = "title") })
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 12)
	private String id;

	@Column(length = 32)
	private String title;

	@Column(length = 4)
	private String year;

	@Column(length = 32)
	private String director;

	@Column(length = 32)
	private String country;

	@Column(length = 1)
	private String myRating;

	@Version
	private Integer version;

	/**
	 * Default constructor
	 */
	public Movie() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMyRating() {
		return myRating;
	}

	public void setMyRating(String myRating) {
		this.myRating = myRating;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
