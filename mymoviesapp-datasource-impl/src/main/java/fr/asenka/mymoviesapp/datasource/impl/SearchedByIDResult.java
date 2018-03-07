package fr.asenka.mymoviesapp.datasource.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.asenka.mymoviesapp.model.Movie;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchedByIDResult extends AbstractOMDBResult {

	private String id;

	private String title;

	private String type;

	private String year;

	private String director;

	private String country;

	private String poster;

	@JsonProperty("id")
	public String getId() {

		return this.id;
	}

	@JsonProperty("imdbID")
	public void setId(String id) {

		this.id = id;
	}

	@JsonProperty("title")
	public String getTitle() {

		return this.title;
	}

	@JsonProperty("Title")
	public void setTitle(String title) {

		this.title = title;
	}

	@JsonProperty("year")
	public String getYear() {

		return this.year;
	}

	@JsonProperty("Year")
	public void setYear(String year) {

		this.year = year;
	}

	@JsonProperty("director")
	public String getDirector() {

		return this.director;
	}

	@JsonProperty("Director")
	public void setDirector(String director) {

		this.director = director;
	}

	@JsonProperty("country")
	public String getCountry() {

		return this.country;
	}

	@JsonProperty("Country")
	public void setCountry(String country) {

		this.country = country;
	}

	@JsonProperty("type")
	public String getType() {

		return this.type;
	}

	@JsonProperty("Type")
	public void setType(String type) {

		this.type = type;
	}

	@JsonProperty("poster")
	public String getPoster() {

		return this.poster;
	}

	@JsonProperty("Poster")
	public void setPoster(String poster) {

		this.poster = poster;
	}

	public Movie getMovie() {

		if (!getResponse()) {
			return null;
		} else {
			Movie movie = new Movie();

			movie.setCountry(this.country);
			movie.setDirector(this.director);
			movie.setId(this.id);
			movie.setYear(this.year);
			movie.setPoster(this.poster);
			movie.setTitle(this.title);
			movie.setType(this.type);

			return movie;
		}
	}
}
