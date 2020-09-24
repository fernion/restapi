package com.example.api.asset.portfolio2;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Arrays;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.example.api.asset.dao.IssuerEntity;
import com.example.api.asset.dao.PortfolioEntity;
import com.example.api.asset.issuer.IssuerAssembler;

@Component
public class Portfolio2Assembler extends RepresentationModelAssemblerSupport<PortfolioEntity, Portfolio2Model> {
	IssuerAssembler issuerAssembler = new IssuerAssembler();

	public Portfolio2Assembler() {
		super(Portfolio2Controller.class, Portfolio2Model.class);
	}

	@Override
	public Portfolio2Model toModel(PortfolioEntity theEntity) {
		String id = theEntity.getId();
		Portfolio2Model portfolioModel = new Portfolio2Model(id, theEntity.getName());

		IssuerEntity issuerEntity = getIssuer(theEntity.getIssuerId());
		portfolioModel.setDetails(CollectionModel.of(Arrays.asList(issuerAssembler.toModel(issuerEntity))));

		//portfolioModel.add(linkTo(methodOn(Portfolio2Controller.class).getSingle(id)).withSelfRel());

		return portfolioModel;
	}

	@Override
	public CollectionModel<Portfolio2Model> toCollectionModel(Iterable<? extends PortfolioEntity> theEntities) {
		CollectionModel<Portfolio2Model> portfolios = super.toCollectionModel(theEntities);

		portfolios.add(linkTo(methodOn(Portfolio2Controller.class).getAll()).withSelfRel());

		return portfolios;
	}

	private IssuerEntity getIssuer(String theIssuerId) {
		//TODO dummy representation
		return new IssuerEntity(theIssuerId, "Issuer " + theIssuerId);
	}
}
