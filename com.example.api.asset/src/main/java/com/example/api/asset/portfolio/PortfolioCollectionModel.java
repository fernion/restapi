package com.example.api.asset.portfolio;

import java.util.Collections;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class PortfolioCollectionModel extends RepresentationModel<PortfolioCollectionModel> {
	private final List<RepresentationModel<?>> portfolios;

	public PortfolioCollectionModel(List<RepresentationModel<?>> thePortfolios) {
		portfolios = Collections.unmodifiableList(thePortfolios);
	}

	public List<RepresentationModel<?>> getPortfolios() {
		return portfolios;
	}
}