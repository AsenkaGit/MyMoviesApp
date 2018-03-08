package fr.asenka.mymoviesapp.api.rest;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.asenka.mymoviesapp.api.service.MyMovieService;
import fr.asenka.mymoviesapp.datasource.MovieDataProvider;
import fr.asenka.mymoviesapp.datasource.exceptions.MovieNotFoundException;
import fr.asenka.mymoviesapp.model.Movie;

@RestController
public class MovieRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieRestController.class);

	@Autowired
	private MyMovieService myMovieService;

	@Autowired
	private MovieDataProvider movieDataProvider;

	@RequestMapping("/searchByTitle/{title}")
	public List<Movie> searchByTitle(@PathVariable("title") String title) throws IOException {
		LOGGER.debug("Processing search request with title: " + title );
		List<Movie> result = this.movieDataProvider.findMoviesByTitle(title);
		LOGGER.debug("Result: " + result.toString());
		return result;
	}
	
	@RequestMapping("/searchById/{id}")
	public Movie searchById(@PathVariable("id") String id) throws IOException, MovieNotFoundException {
		LOGGER.debug("Processing search request with id: " + id );
		Movie result = this.movieDataProvider.findMovieById(id);
		LOGGER.debug("Result: " + result.toString());
		return result;
	}
	
	@RequestMapping("/movies")
	public List<Movie> getMovies() throws IOException {
		
		List<Movie> result = this.myMovieService.listAll();
		return result;
	}
	
	@RequestMapping("/movies/paging")
	public Page<Movie> getMoviesPaging(Pageable pageable) throws IOException {
		
		Page<Movie> result = this.myMovieService.listAll(pageable);
		return result;
	}
	
	@RequestMapping("/movies/{id}")
	public Movie getMovie(@PathVariable("id") String id) throws IOException {
		
		Movie result = this.myMovieService.get(id);
		return result;
	}
	
	
	@RequestMapping(value="/movie",  method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addMovie(@ModelAttribute Movie movie) throws IOException {
		
		String resultId = this.myMovieService.put(movie);
		return resultId;
	}
	
	@RequestMapping(value="/movie/{id}",  method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteMovie(@PathVariable("id") String id) throws IOException {
		this.myMovieService.delete(id);
	}

	
	@ExceptionHandler(MovieNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleMovieNotFoundException(Exception ex, Locale locale) {
		LOGGER.error(ex.getMessage());
	}
	
	@ExceptionHandler(IOException.class)
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	public void handleIOException(Exception ex, Locale locale) {
		LOGGER.error(ex.getMessage());
	}
}
