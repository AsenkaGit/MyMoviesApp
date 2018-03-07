package fr.asenka.mymoviesapp.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.asenka.mymoviesapp.model.Movie;

/**
 * Service interface to manage the Database of movies (myMoviesDB)
 */
public interface MyMovieService {

	/**
	 * Add or updare a movie into myMoviesDB
	 * @param movie
	 * @return
	 * @throws IOException
	 */
	public String put(Movie movie) throws IOException;
	
	/**
	 * Get all the movies from myMoviesDB
	 * @return a list of movies
	 * @throws IOException
	 */
	public List<Movie> listAll() throws IOException;
	
	/**
	 * Get all the movies from myMoviesDB.
	 * @param pageable the pageable object created by spring to return the result with pagination mecanism
	 * @return a subset of the list of movies => a page
	 * @throws IOException
	 */
	public Page<Movie> listAll(Pageable pageable) throws IOException;
	
	/**
	 * Get a specific movie with its ID from myMoviesDB
	 * @param id
	 * @return the movie if found, or <code>null</code>
	 * @throws IOException
	 */
	public Movie get(String id) throws IOException;
	
	/**
	 * Delete a movie from myMoviesDB
	 * @param id the id of the movie to remove
	 * @throws IOException
	 */
	public void delete(String id) throws IOException;
}
