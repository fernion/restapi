package com.example.api.asset.issuer;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "issuers", itemRelation = "issuer")
public class IssuerModel extends RepresentationModel<IssuerModel> {
	private String id;
	private String name;

	public IssuerModel(String theId, String theName) {
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
