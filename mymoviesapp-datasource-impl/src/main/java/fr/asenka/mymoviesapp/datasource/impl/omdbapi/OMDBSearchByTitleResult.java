package fr.asenka.mymoviesapp.datasource.impl.omdbapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.asenka.mymoviesapp.model.Movie;

/**
 * The result of a search by title. The result is an object containing an array of movies.
 *
 */
public class OMDBSearchByTitleResult extends AbstractOMDBResult {

	/**
	 * The array of movies
	 */
	private OMDBSimpleMovie[] omdbMovies;

	@JsonProperty("omdbMovies")
	public OMDBSimpleMovie[] getOmdbMovies() {

		return omdbMovies;
	}

	@JsonProperty("Search")
	public void setOmdbMovies(OMDBSimpleMovie[] movies) {

		this.omdbMovies = movies;
	}

	/**
	 * Return the list of movies based on the array
	 * 
	 * @return a list of movies (it can be empty but not null)
	 */
	public List<Movie> getMovies() {

		List<Movie> movies = new ArrayList<Movie>(this.omdbMovies.length);
		Arrays.stream(this.omdbMovies).forEach(omdbMovie -> movies.add(omdbMovie.getMovie()));
		return movies;
	}
}
