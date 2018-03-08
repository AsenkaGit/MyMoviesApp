package fr.asenka.mymoviesapp.datasource.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.asenka.mymoviesapp.datasource.MovieDataProvider;
import fr.asenka.mymoviesapp.datasource.exceptions.MovieNotFoundException;
import fr.asenka.mymoviesapp.model.Movie;
import fr.asenka.mymoviesapp.model.utilities.MovieUtils;

/**
 * Dummy implementation of the data provider. It only reacts to Barry Lyndon and Alien movies... Weird tastes...
 * 
 * You can use this if you don't have internet access or work behind an enoying corporate proxy...
 */
@Service
public class DummyMovieDataProviderImpl implements MovieDataProvider {

	@Override
	public List<Movie> findMoviesByTitle(String title) throws IOException {

		switch (title) {
		case "Alien": 
			return listOfAlienMovies();
		case "Barry+Lyndon":
		case "Barry Lyndon": 
			return listOfBarryLyndonMovie();
		default:
			return Collections.emptyList();
		}
	}

	@Override
	public Movie findMovieById(String id) throws IOException, MovieNotFoundException {

		// If id == barry lyndon ID...
		if ("tt0072684".equals(id)) {
			return barryLyndonMovie();
		} else {
			throw new MovieNotFoundException("Movie not found. This is a dummy data provider : the only working id is: \"tt0072684\" (Barry Lyndon)");
		}
	}

	private static final List<Movie> listOfAlienMovies() {

		List<Movie> movies = new ArrayList<Movie>(4);

		movies.add(MovieUtils.createSimpleMovie("Alien", "1979", "tt0078748", "movie",
				"https://images-na.ssl-images-amazon.com/images/M/MV5BNDNhN2IxZWItNGEwYS00ZDNhLThiM2UtODU3NWJlZjBkYjQxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"));
		movies.add(MovieUtils.createSimpleMovie("Alien 3", "1992", "tt0103644", "movie",
				"https://images-na.ssl-images-amazon.com/images/M/MV5BNThhODA5Y2ItMzEzYy00MjE3LTgxYTUtNDIzYjc2ZTllODE0XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"));
		movies.add(MovieUtils.createSimpleMovie("Alien: Resurrection", "1997", "tt0118583", "movie",
				"https://images-na.ssl-images-amazon.com/images/M/MV5BM2YxYmFjYWMtMzBmMC00MTVmLThhMjUtYWU5Yzg2OGQwZjE3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"));
		movies.add(MovieUtils.createSimpleMovie("AVP: Alien vs. Predator", "2004", "tt0370263", "movie",
				"https://images-na.ssl-images-amazon.com/images/M/MV5BMTU4MjIwMTcyMl5BMl5BanBnXkFtZTYwMTYwNDA3._V1_SX300.jpg"));

		return movies;
	}

	private static final Movie barryLyndonMovie() {
		
		return MovieUtils.createMovie("Barry Lyndon", "1975", "tt0072684", "movie",
				"https://images-na.ssl-images-amazon.com/images/M/MV5BNmY0MWY2NDctZDdmMi00MjA1LTk0ZTQtZDMyZTQ1NTNlYzVjXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg",
				"Stanley Kubrick", "UK, USA");
	}
	
	private static final List<Movie> listOfBarryLyndonMovie() {
		List<Movie> movies = new ArrayList<Movie>(1);
		movies.add(MovieUtils.createSimpleMovie("Barry Lyndon", "1975", "tt0072684", "movie",
				"https://images-na.ssl-images-amazon.com/images/M/MV5BNmY0MWY2NDctZDdmMi00MjA1LTk0ZTQtZDMyZTQ1NTNlYzVjXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg"));
		return movies;

	}


}
