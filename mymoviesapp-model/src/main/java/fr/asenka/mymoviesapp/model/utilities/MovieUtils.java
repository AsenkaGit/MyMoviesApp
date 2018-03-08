package fr.asenka.mymoviesapp.model.utilities;

import fr.asenka.mymoviesapp.model.Movie;

public class MovieUtils {

	public static final Movie createSimpleMovie(String title, String year, String id, String type, String poster) {

		final Movie movie = new Movie();
		movie.setTitle(title);
		movie.setYear(year);
		movie.setId(id);
		movie.setType(type);
		movie.setPoster(poster);
		return movie;
	}

	public static final Movie createMovie(String title, String year, String id, String type, String poster,
			String director, String country) {

		final Movie movie = createSimpleMovie(title, year, id, type, poster);
		movie.setDirector(director);
		movie.setCountry(country);
		return movie;
	}
}
