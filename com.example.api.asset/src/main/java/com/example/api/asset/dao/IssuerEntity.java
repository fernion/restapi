package com.example.api.asset.dao;

public class IssuerEntity {
	private String id;
	private String name;
	private String country;

	public IssuerEntity(String theId, String theName, String theCountry) {
		id = theId;
		name = theName;
		country = theCountry;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}
}
