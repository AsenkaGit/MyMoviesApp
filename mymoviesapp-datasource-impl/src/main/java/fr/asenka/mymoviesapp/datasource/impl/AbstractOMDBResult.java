package fr.asenka.mymoviesapp.datasource.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractOMDBResult {

	protected Boolean response;

	@JsonProperty("response")
	public Boolean getResponse() {

		return response;
	}

	@JsonProperty("Response")
	public void setResponse(Boolean response) {

		this.response = response;
	}
	
//	public boolean isEmpty() {
//
//		return !Boolean.parseBoolean(this.response.toLowerCase());
//	}
}
