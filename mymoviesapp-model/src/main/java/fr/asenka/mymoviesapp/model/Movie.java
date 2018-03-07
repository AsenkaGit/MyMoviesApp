package fr.asenka.mymoviesapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Version;

import fr.asenka.mymoviesapp.model.Movie;

@Entity
@Table(name = "movies", indexes = { @Index(name = "idx_movies_title", columnList = "title") })
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String id;

	@Column
	private String title;

	@Column
	private String type;

	@Column
	private String year;

	@Column
	private String director;

	@Column
	private String country;

	@Column
	private String poster;

	@Column
	private String myRating;

	@Version
	private Integer version;

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

	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public String getPoster() {

		return poster;
	}

	public void setPoster(String poster) {

		this.poster = poster;
	}

}
