package com.example.api.asset.issuer;

import java.util.Collections;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class IssuerCollectionModel extends RepresentationModel<IssuerCollectionModel> {
	private final List<RepresentationModel<?>> issuers;

	public IssuerCollectionModel(List<RepresentationModel<?>> thePortfolios) {
		issuers = Collections.unmodifiableList(thePortfolios);
	}

	public List<RepresentationModel<?>> getIssuers() {
		return issuers;
	}
}