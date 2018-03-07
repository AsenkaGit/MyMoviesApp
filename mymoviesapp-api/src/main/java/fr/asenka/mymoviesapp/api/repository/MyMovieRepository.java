package fr.asenka.mymoviesapp.api.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.asenka.mymoviesapp.model.Movie;

/**
 * 
 * @
 */
public interface MyMovieRepository extends PagingAndSortingRepository<Movie, String>{

	/**
	 * Look for a list of movies in the repository that match the requested title
	 * @param title the requested title
	 * @return a list of movies
	 */
	List<Movie> findByTitle(String title);
}
