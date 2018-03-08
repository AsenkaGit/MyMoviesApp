package fr.asenka.mymoviesapp.datasource.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import fr.asenka.mymoviesapp.datasource.MovieDataProvider;
import fr.asenka.mymoviesapp.datasource.exceptions.MovieNotFoundException;
import fr.asenka.mymoviesapp.datasource.impl.omdbapi.OMDBSearchByIDResult;
import fr.asenka.mymoviesapp.datasource.impl.omdbapi.OMDBSearchByTitleResult;
import fr.asenka.mymoviesapp.model.Movie;

/**
 * Implementation of the movie data provider based on the OMDB RESTful API (http://www.omdbapi.com/). It interrogates an online
 * movies database to get the info about the requested movie
 */
@Service
public class OMDBMovieDataProviderImpl implements MovieDataProvider {

	/**
	 * The URL of OMDB API (check application.properties)
	 */
	@Value("${fr.asenka.mymoviesapp.omdbapi.url}")
	private String url;

	/**
	 * The API Key required to use the OMDB Api (check application.properties). Be careful : the key validity lasts 3 years
	 */
	@Value("${fr.asenka.mymoviesapp.omdbapi.apikey}")
	private String apikey;

	@Override
	public Movie findMovieById(final String imdbID) throws IOException, MovieNotFoundException {

		final RestTemplate restTemplate = new RestTemplate();
		final String searchUrl = buildSearchByIDUrl(url, apikey, imdbID);
		
		try {
			final OMDBSearchByIDResult result = restTemplate.getForObject(searchUrl, OMDBSearchByIDResult.class);

			// If no result, then exception
			if (!result.getResponse()) {
				throw new MovieNotFoundException("No result for the requested id " + imdbID);
			} else {
				return result.getMovie();
			}
		} catch (RestClientException ex) {
			throw new IOException(ex);
		}
	}

	@Override
	public List<Movie> findMoviesByTitle(final String title) throws IOException {

		final RestTemplate restTemplate = new RestTemplate();
		final String searchUrl = buildSearchByTitleUrl(url, apikey, title);
		
		try {
			final OMDBSearchByTitleResult result = restTemplate.getForObject(searchUrl, OMDBSearchByTitleResult.class);
			return result.getResponse() ? result.getMovies() : Collections.emptyList();

		} catch (RestClientException ex) {
			throw new IOException(ex);
		}
	}

	/**
	 * Build the URL used to interrogate the OMDB REST API (http://www.omdbapi.com/)
	 * 
	 * @param url the omdb url
	 * @param apikey the api key necessary to use the OMDB API (delivered on the OMDB API website)
	 * @param title the title to search
	 * @return a URL to search movies from a title keyword : <code>http://[omdbURL]/?apikey=[apikey]&s=[title]</code>
	 */
	private static final String buildSearchByTitleUrl(String url, String apikey, String title) {

		return url + "/?apikey=" + apikey + "&s=" + title;
	}

	/**
	 * Build a URL used to interrogate the OMDB REST API (http://www.omdbapi.com/)
	 * 
	 * @param url the omdb url
	 * @param apikey the api key necessary to use the OMDB API (delivered on the OMDB API website)
	 * @param imdbID the IMDB id of a movie (check the IMDB website)
	 * @return a URL to search a movie from it's IMDB id : <code>http://[omdbURL]/?apikey=[apikey]&i=[imdbID]</code>
	 */
	private static final String buildSearchByIDUrl(String url, String apikey, String imdbID) {

		return url + "/?apikey=" + apikey + "&i=" + imdbID;
	}
}
