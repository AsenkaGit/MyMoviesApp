package fr.asenka.mymoviesapp.datasource;

import java.io.IOException;
import java.util.List;

import fr.asenka.mymoviesapp.model.Movie;

public interface MovieDataProvider {

	/**
	 * Find the movies that matches the specified title
	 * @param title
	 * @return a list of movies (it can be empty but not null)
	 * @throws IOException
	 */
	public List<Movie> findMoviesByTitle(String title) throws IOException;
	
	/**
	 * Find a movie according to its ID. 
	 * @param id
	 * @return the movie that matches the ID (the movie is returned or an exception should be thrown, no null value)
	 * @throws IOException if the movie cannot be found
	 */
	public Movie findMovieById(String id) throws IOException;
}
