package fr.asenka.mymoviesapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import fr.asenka.mymoviesapp.model.Movie;

/**
 * Movie entity used to store the movies and to return movie data to the client
 */
@JsonInclude(Include.NON_NULL) // The null values are not displayed in the JSON result
@Entity
@Table(name = "movies", indexes = { @Index(name = "idx_movies_title", columnList = "title") })
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10)
	private String id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false, length = 32)
	private String type;

	@Column(length = 4)
	private String year;

	@Column
	private String director;

	@Column(length = 32)
	private String country;

	@Column(columnDefinition = "VARCHAR(1000)")
	private String poster;

	@Column
	private Integer myRating;

	@JsonIgnore
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

	public Integer getMyRating() {

		return myRating;
	}

	public void setMyRating(Integer myRating) {

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

	@Override
	public String toString() {
		return "Movie [" + id + ", " + title + ", " + type + ", " + year + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((myRating == null) ? 0 : myRating.hashCode());
		result = prime * result + ((poster == null) ? 0 : poster.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (myRating == null) {
			if (other.myRating != null)
				return false;
		} else if (!myRating.equals(other.myRating))
			return false;
		if (poster == null) {
			if (other.poster != null)
				return false;
		} else if (!poster.equals(other.poster))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
}
