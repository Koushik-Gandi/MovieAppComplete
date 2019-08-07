package com.capgemini.moviesservices.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviesservices.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private List<Movie> movies;
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	@GetMapping("/")
	public String getInfo() {
		return "Hello";
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public MovieController() {
		super();
		movies = new ArrayList<Movie>();
		movies.add(new Movie(101,"Matrix",2000,Arrays.asList("Json Taylor", "Bob Martin")));
		movies.add(new Movie(102,"Transformer",2004,Arrays.asList("Grant","Bryan Bash")));
	}
	
	@GetMapping("/{movieId}")
	public Movie getMovieDetails(@PathVariable int movieId){
	for(Movie movie:movies) {
		if(movie.getMovieId()==movieId)
			return movie;
	}
		return null;
		
	}
}
