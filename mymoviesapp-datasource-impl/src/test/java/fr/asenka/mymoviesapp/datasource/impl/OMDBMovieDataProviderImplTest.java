package fr.asenka.mymoviesapp.datasource.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.asenka.mymoviesapp.datasource.MovieDataProvider;
import fr.asenka.mymoviesapp.datasource.exceptions.MovieNotFoundException;
import fr.asenka.mymoviesapp.model.Movie;

/**
 * JUnit test for the OMDBMovieDataProviderImpl
 * @see OMDBMovieDataProviderImpl
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=OMDBMovieDataProviderImpl.class)
public class OMDBMovieDataProviderImplTest {

	/**
	 * The implementation of MovieDataProvider tested : an instance of OMDBMovieDataProviderImpl
	 * @see OMDBMovieDataProviderImpl
	 */
	@Autowired
	private MovieDataProvider omdbDataSource; 
	
	@Test
	public void testConnectivity() {
		
		try {
			omdbDataSource.findMovieById("dummyId");
			fail("No movie should be found by this test !");
		} catch (IOException e) {
			fail("Unable to reach the REST API: " + e.getMessage());
		} catch (MovieNotFoundException e) {
			// Success !
		}
	}
	
	@Test
	public void testFindMovieById() {
		
		final String alienImdbID = "tt0078748";
		
		try {
			final Movie alienMovie = omdbDataSource.findMovieById(alienImdbID);
			
			assertNotNull(alienMovie);
			assertEquals("Alien", alienMovie.getTitle());
			assertEquals("1979", alienMovie.getYear());
			assertEquals("Ridley Scott", alienMovie.getDirector());
			assertEquals("UK, USA", alienMovie.getCountry());
			assertEquals("movie", alienMovie.getType());
			assertEquals(alienImdbID , alienMovie.getId());
			assertNotNull(alienMovie.getPoster());
			assertFalse(alienMovie.getPoster().isEmpty());
			
		} catch (IOException | MovieNotFoundException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testFindMoviesByTitle_NoResult() {
		
		final String searchedTitle = "";
		
		try {
			List<Movie> emptyList = omdbDataSource.findMoviesByTitle(searchedTitle);
			
			assertNotNull(emptyList);
			assertTrue(emptyList.isEmpty());
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testFindMoviesByTitle_OneResult() {
		
		final String searchedTitle = "Anomalisa";
		
		try {
			List<Movie> movieList = omdbDataSource.findMoviesByTitle(searchedTitle);
			
			assertNotNull(movieList);
			assertEquals(searchedTitle, movieList.get(0).getTitle());
			assertEquals("2015", movieList.get(0).getYear());
			assertEquals("movie", movieList.get(0).getType());
			assertNull(movieList.get(0).getDirector());
			assertNull(movieList.get(0).getCountry());
			assertEquals(1, movieList.size());
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testFindMoviesByTitle_SeveralResult() {
		
		final String searchedTitle = "Die Hard 2";
		
		try {
			List<Movie> movieList = omdbDataSource.findMoviesByTitle(searchedTitle);
			
			assertNotNull(movieList);
			assertEquals(searchedTitle, movieList.get(0).getTitle());
			assertEquals("1990", movieList.get(0).getYear());
			assertEquals("movie", movieList.get(0).getType());
			assertNull(movieList.get(0).getDirector());
			assertNull(movieList.get(0).getCountry());
			assertTrue("The movies list should contains more than one movie", movieList.size() > 1);
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
