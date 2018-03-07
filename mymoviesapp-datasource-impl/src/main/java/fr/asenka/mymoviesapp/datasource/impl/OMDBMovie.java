package fr.asenka.mymoviesapp.datasource.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.asenka.mymoviesapp.model.Movie;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OMDBMovie extends Movie {

	private static final long serialVersionUID = 2L;

}
