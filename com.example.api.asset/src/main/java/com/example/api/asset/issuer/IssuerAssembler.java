package com.example.api.asset.issuer;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.example.api.asset.dao.IssuerEntity;

@Component
public class IssuerAssembler extends RepresentationModelAssemblerSupport<IssuerEntity, IssuerModel> {

	public IssuerAssembler() {
		super(IssuerController.class, IssuerModel.class);
	}

	@Override
	public IssuerModel toModel(IssuerEntity theEntity) {
		String id = theEntity.getId();
		IssuerModel issuerModel = new IssuerModel(id, theEntity.getName());

		issuerModel.add(linkTo(methodOn(IssuerController.class).getSingle(id)).withSelfRel());

		return issuerModel;
	}

	@Override
	public CollectionModel<IssuerModel> toCollectionModel(Iterable<? extends IssuerEntity> theEntities) {
		CollectionModel<IssuerModel> issuers = super.toCollectionModel(theEntities);

		issuers.add(linkTo(methodOn(IssuerController.class).getAll()).withSelfRel());

		return issuers;
	}
}
