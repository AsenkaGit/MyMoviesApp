package fr.asenka.mymoviesapp.datasource.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.asenka.mymoviesapp.model.Movie;

public class SearchedByTitleResult extends AbstractOMDBResult {

	private OMDBMovie[] omdbMovies;

	@JsonProperty("omdbMovies")
	public OMDBMovie[] getOmdbMovies() {

		return omdbMovies;
	}

	@JsonProperty("Search")
	public void setOmdbMovies(OMDBMovie[] movies) {

		this.omdbMovies = movies;
	}

	public List<Movie> getMovies() {

		List<Movie> movies = new ArrayList<Movie>(this.omdbMovies.length);
		Arrays.stream(this.omdbMovies).forEach(omdbMovie -> movies.add(omdbMovie.getMovie()));
		return movies;
	}
}
