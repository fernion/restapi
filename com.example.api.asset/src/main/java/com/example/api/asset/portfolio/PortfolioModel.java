package com.example.api.asset.portfolio;

import org.springframework.hateoas.server.core.Relation;

import com.example.api.asset.BaseModel;

@Relation(collectionRelation = "portfolios")
public class PortfolioModel extends BaseModel<PortfolioModel> {

	public PortfolioModel(String theId, String theName) {
		super(theId, theName);
	}
}
