package com.capgemini.moviesservices.model;

import java.util.List;

public class Movie {
	private int movieId;
	private String movieTitle;
	private int releaseYear;
	private List<String> casts;
	
	
	
	public Movie() {
		super();
	}

	public Movie(int movieId, String movieTitle, int relaseYear, List<String> casts) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.releaseYear = relaseYear;
		this.casts = casts;
	}

	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getRelaseYear() {
		return releaseYear;
	}
	public void setRelaseYear(int relaseYear) {
		this.releaseYear = relaseYear;
	}
	public List<String> getCasts() {
		return casts;
	}
	public void setCasts(List<String> casts) {
		this.casts = casts;
	}
	
}
