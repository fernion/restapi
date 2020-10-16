package com.example.api.asset.issuer;

import org.springframework.hateoas.server.core.Relation;

import com.example.api.asset.BaseModel;

@Relation(collectionRelation = "issuers", itemRelation = "issuer")
public class IssuerModel extends BaseModel<IssuerModel> {
	private String country;

	public IssuerModel(String theId, String theName, String theCountry) {
		super(theId, theName);
		country = theCountry;
	}

	public String getCountry() {
		return country;
	}
}
