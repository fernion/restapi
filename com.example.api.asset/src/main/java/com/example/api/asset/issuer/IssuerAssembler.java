package com.example.api.asset.issuer;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import com.example.api.asset.dao.IssuerEntity;

@Component
public class IssuerAssembler {

	public IssuerModel toModel(IssuerEntity theEntity) {
		String id = theEntity.getId();
		IssuerModel issuerModel = new IssuerModel(id, theEntity.getName());

		issuerModel.add(linkTo(methodOn(IssuerController.class).getSingle(id)).withSelfRel());

		return issuerModel;
	}

	public IssuerCollectionModel toCollectionModel(Iterable<? extends IssuerEntity> theEntities) {
		List<RepresentationModel<?>> issuers = new ArrayList<>();
		for (IssuerEntity portfolioEntity : theEntities) {
			issuers.add(toModel(portfolioEntity));
		}

		IssuerCollectionModel model = new IssuerCollectionModel(issuers);
		model.add(linkTo(methodOn(IssuerController.class).getAll()).withSelfRel());
		return model;
	}
}
