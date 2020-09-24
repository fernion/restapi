package com.example.api.asset.portfolio;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "portfolios")
public class PortfolioModel extends RepresentationModel<PortfolioModel> {
	private String id;
	private String name;

	public PortfolioModel(String theId, String theName) {
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
