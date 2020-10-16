package com.example.api.asset;

import org.springframework.hateoas.RepresentationModel;

public abstract class BaseModel<TheType extends BaseModel<? extends TheType>> extends RepresentationModel<TheType> {
	private String id;
	private String name;

	public BaseModel(String theId, String theName) {
		id = theId;
		name = theName;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}
