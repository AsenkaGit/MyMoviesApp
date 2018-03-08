package fr.asenka.mymoviesapp.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import fr.asenka.mymoviesapp.api.service.MyMovieService;
import fr.asenka.mymoviesapp.model.Movie;
import fr.asenka.mymoviesapp.model.utilities.MovieUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MyMoviesAppWriteTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	MyMovieService service;

	@Test
	public void testInsertMovie() {

		// Build the movie that will be inserted in the DB
		final Movie movieToInsert = MovieUtils.createMovie("Avalon", "2001", "tt0267287", "movie",
				"https://images-na.ssl-images-amazon.com/images/M/MV5BMTE1ZGJkNDYtNzA0Zi00MmY1LWJhOTctOThkODcwZWIxZTBiXkEyXkFqcGdeQXVyMzg2MzE2OTE@._V1_SX300.jpg",
				"Mamoru Oshii", "Japan, Poland");

		try {
			// Create an HTTP request on with the movie value as parameters
			MvcResult result = this.mvc
					.perform(MockMvcRequestBuilders.post("/movie")
							.param("id", movieToInsert.getId())
							.param("year", movieToInsert.getYear())
							.param("title", movieToInsert.getTitle())
							.param("type", movieToInsert.getType())
							.param("director", movieToInsert.getDirector())
							.param("country", movieToInsert.getCountry())
							.param("poster", movieToInsert.getPoster()))
					.andExpect(status().is(201)).andReturn(); // Expect the response status to be CREATED (201)

			// The response when inserting a movie with success is the id of the movie
			String insertedMovieId = result.getResponse().getContentAsString();

			// If everything is ok, at this point we have the ID of the movie. We can
			// interrogate the DB
			// To have a movie matching this ID.
			final Movie movieFromDB = service.get(insertedMovieId);

			// The two movies shoud be exactly the same since they have the same id.
			// (This test required to have a properly implemented equals() method on the
			// Movie class)
			assertNotNull(movieFromDB);
			assertEquals(movieToInsert, movieFromDB);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
