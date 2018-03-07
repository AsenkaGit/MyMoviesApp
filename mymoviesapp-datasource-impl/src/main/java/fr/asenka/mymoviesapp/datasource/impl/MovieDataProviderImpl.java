package fr.asenka.mymoviesapp.datasource.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.asenka.mymoviesapp.datasource.MovieDataProvider;
import fr.asenka.mymoviesapp.model.Movie;

/**
 * Dummy implementation of the movie data provider
 */
@Service
public class MovieDataProviderImpl implements MovieDataProvider {
	
	private static final String url = "http://www.omdbapi.com"; 
	
	private static final String apikey = "205f72ee"; 

	@Override
	public List<Movie> findMoviesByTitle(String title) {

		return getMoviesFromOMDBApi(title);
	}
	
	
	private List<Movie> getMoviesFromOMDBApi(String value) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		OMDBMovie movieFromOMDB = restTemplate.getForObject(buildUrl(url, apikey, value), OMDBMovie.class);
		
		return Arrays.asList(movieFromOMDB);
	}
	
	private String buildUrl(String url, String apikey, String value) {
		
		return url + "/?apikey=" + apikey + "&t=" + value;
	}
}
