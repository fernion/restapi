package com.example.api.asset.portfolio;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.asset.dao.PortfolioDao;
import com.example.api.asset.dao.PortfolioEntity;

@RestController
@ExposesResourceFor(PortfolioModel.class)
@RequestMapping("/portfolios")
public class PortfolioController {
	private PortfolioAssembler assembler = new PortfolioAssembler();
	private PortfolioDao portfolioDao = new PortfolioDao();

	@GetMapping
	HttpEntity<CollectionModel<RepresentationModel<?>>> getAll() {
		List<PortfolioEntity> entities = portfolioDao.getAll();

		CollectionModel<RepresentationModel<?>> model = assembler.toCollectionModel(entities);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	@GetMapping(value = "/{portfolio-id}")
	HttpEntity<RepresentationModel<?>> getSingle(@PathVariable("portfolio-id") String theId) {
		PortfolioEntity entity = portfolioDao.getSingle(theId);

		if (entity != null) {
			return new ResponseEntity<>(assembler.toModel(entity), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
