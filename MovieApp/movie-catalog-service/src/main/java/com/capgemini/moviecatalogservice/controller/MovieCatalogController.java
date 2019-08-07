package com.capgemini.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.moviecatalogservice.model.CatalogItem;
import com.capgemini.moviecatalogservice.model.Movie;
import com.capgemini.moviecatalogservice.model.MovieCatalog;
import com.capgemini.moviecatalogservice.model.Rating;
import com.capgemini.moviecatalogservice.model.UserRating;
import com.capgemini.moviecatalogservice.service.MovieInfoService;
import com.capgemini.moviecatalogservice.service.MovieRatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200")
public class MovieCatalogController {
	
	@Autowired
	private MovieInfoService movieInfoService;
	
	@Autowired
	private MovieRatingService movieRatingService;


	@GetMapping("/{userId}")
	public MovieCatalog getMovieCatalog(@PathVariable String userId)

	{
		UserRating ratings = movieRatingService.getUserRating(userId);
		
		
		List<Rating> movieRatings = ratings.getRatings();
		List<CatalogItem> catalogItems = new ArrayList<CatalogItem>();
		for (Rating movieRating : movieRatings) {
			Movie movie = movieInfoService.getMovieInfo(movieRating);

			catalogItems.add(new CatalogItem(movie, movieRating.getRating()));

		}

		MovieCatalog movieCatalog = new MovieCatalog(catalogItems);
		return movieCatalog;

	}

//	@HystrixCommand(fallbackMethod = "fallbackGetMovieInfo")
//	public Movie getMovieInfo(Rating movieRating) {
//		Movie movie =movieInfoService.getMovieInfo(movieRating);
//		return movie;
//	}
//
//	@HystrixCommand(fallbackMethod = "fallbackGetUserRating")
//	public UserRating getUserRating(String userId) {
//		UserRating ratings = movieRatingService.getUserRating(userId);
//		return ratings;
//	}
//
//	public MovieCatalog fallbackGetMovieCatalog(@PathVariable String userId) {
//
//		List<CatalogItem> catalogItems = Arrays.asList(new CatalogItem(new Movie(0, "not available ", 0, null), 0));
//		MovieCatalog moviecatalog = new MovieCatalog();
//		moviecatalog.setCatalogitem(catalogItems);
//
//		return moviecatalog;
//
//	}

}
