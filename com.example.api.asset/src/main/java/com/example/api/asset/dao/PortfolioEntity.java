package com.example.api.asset.dao;

//TODO this will be whatever we deserialize from the internal API
public class PortfolioEntity {
	private String id;
	private String name;
	private String issuerId;

	public PortfolioEntity(String theId, String theName, String theIssuerId) {
		id = theId;
		name = theName;
		issuerId = theIssuerId;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getIssuerId() {
		return issuerId;
	}

	public void setIssuerId(String theIssuerId) {
		issuerId = theIssuerId;
	}
}
