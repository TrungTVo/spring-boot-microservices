package io.javabrains.moviecatalogservice.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;
import io.javabrains.moviecatalogservice.services.MovieInfo;
import io.javabrains.moviecatalogservice.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private MovieInfo movieInfoService;
	
	@Autowired
	private UserRatingInfo userRatingInfoService;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {		
		UserRating userRating = userRatingInfoService.getUserRating(userId);
		List<Rating> ratings = userRating.getUserRating();
		
		return ratings.stream()
				.map(rating -> movieInfoService.getCatalogItem(rating))
				.collect(Collectors.toList());
	}


}
