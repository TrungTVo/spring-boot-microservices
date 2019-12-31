package io.javabrains.movieinfoservice.models;

import lombok.Getter;
import lombok.Setter;

public class Movie {
	@Getter @Setter
	private String id;
	
	@Getter @Setter
	private String title;
	
	@Getter @Setter
	private String overview;

	public Movie(String id, String title, String overview) {
		super();
		this.id = id;
		this.title = title;
		this.overview = overview;
	}
	
	public Movie() {}
}
