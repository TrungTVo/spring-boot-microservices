package io.javabrains.movieinfoservice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {
	
	@Value("${api.key}")
	private String API_KEY;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + API_KEY;
		return restTemplate.getForObject(url, Movie.class);
	}
}
