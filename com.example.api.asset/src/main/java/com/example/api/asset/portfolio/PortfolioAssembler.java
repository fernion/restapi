package com.example.api.asset.portfolio;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.mediatype.hal.HalModelBuilder;
import org.springframework.stereotype.Component;

import com.example.api.asset.dao.IssuerEntity;
import com.example.api.asset.dao.PortfolioEntity;
import com.example.api.asset.issuer.IssuerAssembler;

@Component
public class PortfolioAssembler {
	IssuerAssembler issuerAssembler = new IssuerAssembler();

	public RepresentationModel<?> toModel(PortfolioEntity theEntity) {
		String id = theEntity.getId();
		PortfolioModel portfolioModel = new PortfolioModel(id, theEntity.getName());

		IssuerEntity issuerEntity = getIssuer(theEntity.getIssuerId());

		RepresentationModel<?> model = HalModelBuilder.halModelOf(portfolioModel)
				.link(linkTo(methodOn(PortfolioController.class).getSingle(portfolioModel.getId())).withSelfRel())
				.embed(issuerAssembler.toModel(issuerEntity))
				.build();

		return model;
	}

	public CollectionModel<RepresentationModel<?>> toCollectionModel(Iterable<? extends PortfolioEntity> theEntities) {
		List<RepresentationModel<?>> portfolioModels = new ArrayList<>();
		for (PortfolioEntity portfolioEntity : theEntities) {
			portfolioModels.add(toModel(portfolioEntity));
		}

		Link selfRel = linkTo(methodOn(PortfolioController.class).getAll()).withSelfRel();
		CollectionModel<RepresentationModel<?>> portfolios = CollectionModel.of(portfolioModels, selfRel);

		return portfolios;
	}

	private IssuerEntity getIssuer(String theIssuerId) {
		//TODO dummy representation
		return new IssuerEntity(theIssuerId, "Issuer " + theIssuerId);
	}
}
