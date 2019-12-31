package io.javabrains.ratingsdataservice.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class UserRating {
	@Getter @Setter
	private List<Rating> userRating;

	public UserRating() {
		
	}

	public UserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
	
}
