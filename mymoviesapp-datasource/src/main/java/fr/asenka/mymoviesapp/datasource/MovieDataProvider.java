package fr.asenka.mymoviesapp.datasource;

import java.io.IOException;
import java.util.List;

import fr.asenka.mymoviesapp.datasource.exceptions.MovieNotFoundException;
import fr.asenka.mymoviesapp.model.Movie;

/**
 * The interface representing the exceptected behavior of a data source provider. Whatever the movies data source is, we have to
 * interrogate it through these methods.
 */
public interface MovieDataProvider {

	/**
	 * Find the movies that matches the specified title
	 * 
	 * @param title
	 * @return a list of movies (it can be empty but not null)
	 * @throws IOException if there is any issue to read the data source
	 */
	public List<Movie> findMoviesByTitle(String title) throws IOException;

	/**
	 * Find a movie according to its ID.
	 * 
	 * @param id
	 * @return the movie that matches the ID (the movie is returned or an exception should be thrown, no null value)
	 * @throws IOException if there is any issue to read the data source
	 * @throws MovieNotFoundException if the id doesn't match any movie from the data source
	 */
	public Movie findMovieById(String id) throws IOException, MovieNotFoundException;
}
