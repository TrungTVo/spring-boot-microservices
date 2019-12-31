package io.javabrains.ratingsdataservice.models;

import lombok.Getter;
import lombok.Setter;

public class Rating {
	@Getter @Setter
	private String movieId;
	
	@Getter @Setter
	private double rating;

	public Rating(String movieId, double rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	} 
	
	public Rating() {}
}
