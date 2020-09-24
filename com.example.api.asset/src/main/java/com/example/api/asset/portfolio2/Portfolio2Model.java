package com.example.api.asset.portfolio2;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "portfolios2", itemRelation = "portfolio2")
public class Portfolio2Model extends RepresentationModel<Portfolio2Model> {
	private String id;
	private String name;

	private CollectionModel<Object> details;

	public Portfolio2Model(String theId, String theName) {
		id = theId;
		name = theName;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setDetails(CollectionModel<Object> theDetails) {
		details = theDetails;
	}

	public CollectionModel<Object> getDetails() {
		return details;
	}
}
