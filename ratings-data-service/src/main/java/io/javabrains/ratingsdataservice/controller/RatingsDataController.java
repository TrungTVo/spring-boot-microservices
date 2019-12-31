package io.javabrains.ratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingsdataservice.models.Rating;
import io.javabrains.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsData")
public class RatingsDataController {
	
	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4.6);
	}
	
	@GetMapping("/users/{userId}")
	public UserRating getRatings(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("123", 4.6), new Rating("5678", 5.7));
		return new UserRating(ratings);
	}
}
