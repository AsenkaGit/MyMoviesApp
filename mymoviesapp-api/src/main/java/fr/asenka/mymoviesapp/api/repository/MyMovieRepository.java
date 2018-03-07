package fr.asenka.mymoviesapp.api.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.asenka.mymoviesapp.model.Movie;

/**
 * 
 *
 */
public interface MyMovieRepository extends PagingAndSortingRepository<Movie, String>{

	List<Movie> findByTitle(String title);
}
