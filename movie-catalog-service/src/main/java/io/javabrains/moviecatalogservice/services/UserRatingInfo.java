package io.javabrains.moviecatalogservice.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;

public class UserRatingInfo {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(String userId) {
		String url = "http://ratings-data-service/ratingsData/users/" + userId;
		UserRating userRating = restTemplate.getForObject(url, UserRating.class);
		return userRating;
	}
	
	public UserRating getFallbackUserRating(String userId) {
		return new UserRating(userId, Arrays.asList(new Rating("0", 0.0)));
	}
}
