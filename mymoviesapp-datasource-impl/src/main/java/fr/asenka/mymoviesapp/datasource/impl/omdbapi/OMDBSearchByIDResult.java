package fr.asenka.mymoviesapp.datasource.impl.omdbapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.asenka.mymoviesapp.model.Movie;

/**
 * The result of a request based on the IMDB ID. The result in that case is a single movie with many data. For the moment this
 * class capture only a sub-set of the available data returned.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OMDBSearchByIDResult extends AbstractOMDBResult {

	private String imdbID;

	private String title;

	private String type;

	private String year;

	private String director;

	private String country;

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

	/**
	 * Convert this OMDB Movie into a Movie entity
	 * 
	 * @return a movie entity based on the OMDB result values or null if there is no value
	 */
	public Movie getMovie() {

		// If no result in the response
		if (!super.response) {
			return null;
		} else {
			final Movie movie = new Movie();

			movie.setCountry(this.country);
			movie.setDirector(this.director);
			movie.setId(this.imdbID);
			movie.setYear(this.year);
			movie.setPoster(this.poster);
			movie.setTitle(this.title);
			movie.setType(this.type);

			return movie;
		}
	}
}
