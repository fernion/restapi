package com.example.api.asset.dao;

public class IssuerEntity {
	private String id;
	private String name;

	public IssuerEntity(String theId, String theName) {
		id = theId;
		name = theName;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}
