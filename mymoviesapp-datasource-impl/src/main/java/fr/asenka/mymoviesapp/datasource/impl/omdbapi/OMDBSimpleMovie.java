package fr.asenka.mymoviesapp.datasource.impl.omdbapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.asenka.mymoviesapp.model.Movie;

/**
 * A sub result of the OMDBSearchByTitleResult.
 * 
 * @see OMDBSearchByTitleResult
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OMDBSimpleMovie {

	private String imdbID;

	private String title;

	private String type;

	private String year;

	private String poster;

	@JsonProperty("imdbID")
	public String getImdbId() {

		return this.imdbID;
	}

	@JsonProperty("imdbID")
	public void setImdbId(String id) {

		this.imdbID = id;
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

	/**
	 * Convert this OMDB Movie into a Movie entity
	 * 
	 * @return a movie entity based on the OMDB result values. The result cannot be null because the instance should not exist if
	 *         it has no values
	 */
	public Movie getMovie() {

		final Movie movie = new Movie();

		movie.setId(this.imdbID);
		movie.setYear(this.year);
		movie.setPoster(this.poster);
		movie.setTitle(this.title);
		movie.setType(this.type);

		return movie;
	}
}
