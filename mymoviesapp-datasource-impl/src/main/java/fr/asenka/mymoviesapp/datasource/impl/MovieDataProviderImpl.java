package fr.asenka.mymoviesapp.datasource.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import fr.asenka.mymoviesapp.datasource.MovieDataProvider;
import fr.asenka.mymoviesapp.model.Movie;

/**
 * Dummy implementation of the movie data provider
 */
@Service
public class MovieDataProviderImpl implements MovieDataProvider {

	@Value("${fr.asenka.mymoviesapp.omdbapi.url}")
	private String url;

	@Value("${fr.asenka.mymoviesapp.omdbapi.apikey}")
	private String apikey;

	@Override
	public Movie findMovieById(String id) throws IOException {

		final RestTemplate restTemplate = new RestTemplate();
		final String searchUrl = buildSearchByIDUrl(url, apikey, id);

		try {
			final SearchedByIDResult result = restTemplate.getForObject(searchUrl, SearchedByIDResult.class);

			if (!result.getResponse()) {
				throw new IOException("No result for the requested id " + id);
			} else {
				return result.getMovie();
			}
		} catch (RestClientException ex) {
			throw new IOException(ex);
		}
	}

	@Override
	public List<Movie> findMoviesByTitle(String title) throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		String searchUrl = buildSearchByTitleUrl(url, apikey, title);
		
		try {
			SearchedByTitleResult result = restTemplate.getForObject(searchUrl, SearchedByTitleResult.class);
			
			if (!result.getResponse()) {
				throw new IOException("No result for the requested title " + title);
			} else {
				return result.getMovies();
			}

		} catch (RestClientException ex) {
			throw new IOException(ex);
		}
	}

	private static final String buildSearchByTitleUrl(String url, String apikey, String title) {

		return url + "/?apikey=" + apikey + "&s=" + title;
	}

	private static final String buildSearchByIDUrl(String url, String apikey, String id) {

		return url + "/?apikey=" + apikey + "&i=" + id;
	}
}
