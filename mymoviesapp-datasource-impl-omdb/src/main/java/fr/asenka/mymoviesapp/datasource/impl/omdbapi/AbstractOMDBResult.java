package fr.asenka.mymoviesapp.datasource.impl.omdbapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * All the results from the OMDB Api have a 'Response' JSON parameter to know
 * if the result contains at least a movie or not. This abstract class contains
 * this parameter.
 */
public abstract class AbstractOMDBResult {

	/**
	 * The Response parameter. If true, then the result has at least one movie. Otherwise it is empty.
	 */
	protected Boolean response;

	@JsonProperty("response") // Name of the JSON property on MyMoviesApp side
	public Boolean getResponse() {

		return this.response;
	}

	@JsonProperty("Response") // Name of the JSON property on the OMDB Api side
	public void setResponse(Boolean response) {

		this.response = response;
	}
}
