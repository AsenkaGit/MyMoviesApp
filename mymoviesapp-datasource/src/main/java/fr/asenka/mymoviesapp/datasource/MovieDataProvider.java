package fr.asenka.mymoviesapp.datasource;

import java.util.List;

import fr.asenka.mymoviesapp.model.Movie;

public interface MovieDataProvider {

	/**
	 * Find the movies that matches the specified title
	 * @param title
	 * @return a list of movies (it can be empty but not null)
	 */
	public List<Movie> findMoviesByTitle(String title);
}
