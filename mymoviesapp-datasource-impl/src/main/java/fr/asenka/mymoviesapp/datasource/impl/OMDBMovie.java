package fr.asenka.mymoviesapp.datasource.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.asenka.mymoviesapp.model.Movie;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OMDBMovie {

	private String id;

	private String title;

	private String type;

	private String year;

	private String poster;

	public OMDBMovie() {

		super();
	}

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

		Movie movie = new Movie();

		movie.setId(this.id);
		movie.setYear(this.year);
		movie.setPoster(this.poster);
		movie.setTitle(this.title);
		movie.setType(this.type);

		return movie;
	}

}
