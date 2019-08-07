package com.capgemini.moviecatalogservice.model;

import java.util.List;

public class MovieCatalog {

	private List<CatalogItem> catalogItem;

	public List<CatalogItem> getCatalogItem() {
		return catalogItem;
	}

	public void setCatalogitem(List<CatalogItem> catalogItem) {
		this.catalogItem = catalogItem;
	}

	public MovieCatalog() {
		super();
	}

	public MovieCatalog(List<CatalogItem> catalogItem) {
		super();
		this.catalogItem = catalogItem;
	}
}
