package com.example.api.asset.issuer;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.asset.dao.IssuerDao;
import com.example.api.asset.dao.IssuerEntity;

@RestController
@ExposesResourceFor(IssuerModel.class)
@RequestMapping("/issuers")
public class IssuerController {
	private IssuerAssembler assembler = new IssuerAssembler();
	private IssuerDao issuerDao = new IssuerDao();

	@GetMapping
	public HttpEntity<CollectionModel<IssuerModel>> getAll() {
		List<IssuerEntity> asList = issuerDao.getAll();
		return new ResponseEntity<>(assembler.toCollectionModel(asList), HttpStatus.OK);
	}

	@GetMapping(value = "/{issuer-id}")
	public HttpEntity<IssuerModel> getSingle(@PathVariable("issuer-id") String theId) {
		IssuerEntity entity = issuerDao.getSingle(theId);

		if (entity != null) {
			return new ResponseEntity<>(assembler.toModel(entity), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
