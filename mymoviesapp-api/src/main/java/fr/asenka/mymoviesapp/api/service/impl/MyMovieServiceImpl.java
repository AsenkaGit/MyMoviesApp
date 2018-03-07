package fr.asenka.mymoviesapp.api.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.asenka.mymoviesapp.api.repository.MyMovieRepository;
import fr.asenka.mymoviesapp.api.service.MyMovieService;
import fr.asenka.mymoviesapp.model.Movie;

@Service
public class MyMovieServiceImpl implements MyMovieService {

	@Autowired
	private MyMovieRepository repository;

	@Override
	public String put(Movie movie) throws IOException {

		final Movie dbMovie = get(movie.getId());

		if (dbMovie == null) {
			repository.save(movie);
		} else {
			dbMovie.setCountry(movie.getCountry());
			dbMovie.setTitle(movie.getTitle());
			dbMovie.setDirector(movie.getDirector());
			dbMovie.setMyRating(movie.getMyRating());
			dbMovie.setYear(movie.getYear());
			repository.save(dbMovie);
		}
		return movie.getId();
	}

	@Override
	public List<Movie> listAll() throws IOException {

		// Convert the iterable from repository into a list
		Iterable<Movie> result = repository.findAll();
		List<Movie> movies = new ArrayList<Movie>();
		result.forEach(movies::add);

		return movies;
	}

	@Override
	public Page<Movie> listAll(Pageable pageable) throws IOException {

		return repository.findAll(pageable);
	}

	@Override
	public Movie get(String id) throws IOException {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void delete(String id) throws IOException {
		repository.deleteById(id);
	}
}
