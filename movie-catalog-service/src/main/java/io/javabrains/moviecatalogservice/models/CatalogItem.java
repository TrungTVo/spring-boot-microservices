package io.javabrains.moviecatalogservice.models;

import lombok.Getter;
import lombok.Setter;

public class CatalogItem {
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String desc;
	
	@Getter @Setter
	private double rating;

	public CatalogItem(String name, String desc, double rating) {
		super();
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}
	
	public CatalogItem() {}
}
