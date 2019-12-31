package io.javabrains.moviecatalogservice.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class UserRating {
	@Getter @Setter
	private String userId;
	
	@Getter @Setter
	private List<Rating> userRating;

	public UserRating() {
		
	}

	public UserRating(String userId, List<Rating> userRating) {
		this.userId = userId;
		this.userRating = userRating;
	}
	
}
