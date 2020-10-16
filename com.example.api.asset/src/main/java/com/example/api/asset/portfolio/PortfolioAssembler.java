package com.example.api.asset.portfolio;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.mediatype.hal.HalModelBuilder;
import org.springframework.stereotype.Component;

import com.example.api.asset.dao.IssuerDao;
import com.example.api.asset.dao.IssuerEntity;
import com.example.api.asset.dao.PortfolioEntity;
import com.example.api.asset.issuer.IssuerAssembler;

@Component
public class PortfolioAssembler {
	private IssuerAssembler issuerAssembler = new IssuerAssembler();
	private IssuerDao issuerDao = new IssuerDao();

	public RepresentationModel<?> toModel(PortfolioEntity theEntity) {
		String id = theEntity.getId();
		PortfolioModel portfolioModel = new PortfolioModel(id, theEntity.getName());

		IssuerEntity issuerEntity = issuerDao.getSingle(theEntity.getIssuerId());

		RepresentationModel<?> model = HalModelBuilder.halModelOf(portfolioModel)
				.link(linkTo(methodOn(PortfolioController.class).getSingle(portfolioModel.getId())).withSelfRel())
				.embed(issuerAssembler.toModel(issuerEntity))
				.build();

		return model;
	}

	public PortfolioCollectionModel toCollectionModel(Iterable<? extends PortfolioEntity> theEntities) {
		List<RepresentationModel<?>> portfolioModels = new ArrayList<>();
		for (PortfolioEntity portfolioEntity : theEntities) {
			portfolioModels.add(toModel(portfolioEntity));
		}

		PortfolioCollectionModel model = new PortfolioCollectionModel(portfolioModels);
		model.add(linkTo(methodOn(PortfolioController.class).getAll()).withSelfRel());
		return model;
	}
}
