package com.example.api.asset.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssuerDao {

	private static Map<String, IssuerEntity> dummyData = new HashMap<>();

	static {
		for (int i = 0; i < 10; i++) {
			dummyData.put("i" + i, new IssuerEntity("i" + i, "Issuer " + i));
		}
	}

	public List<IssuerEntity> getAll() {
		return new ArrayList<>(dummyData.values());
	}

	public IssuerEntity getSingle(String theId) {
		return dummyData.get(theId);
	}
}
