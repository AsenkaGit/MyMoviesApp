package fr.asenka.mymoviesapp.datasource.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.asenka.mymoviesapp.datasource.MovieDataProvider;
import fr.asenka.mymoviesapp.model.Movie;

/**
 * Dummy implementation of the movie data provider
 */
@Service
public class MovieDataProviderImpl implements MovieDataProvider {

	@Override
	public List<Movie> findMoviesByTitle(String title) {

		if (title != null && !title.trim().isEmpty()) {
			
			final Movie dummyMovie = new Movie();

			
			dummyMovie.setId("movieId1");
			dummyMovie.setTitle(title.trim());
			dummyMovie.setCountry("US");
			dummyMovie.setDirector("Jean Counen");
			dummyMovie.setYear("1924");
			dummyMovie.setMyRating("Good");

			return Arrays.asList(dummyMovie);
		} else {
			return Collections.emptyList();
		}

	}
	
	
	

}
