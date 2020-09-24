package com.example.api.asset.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortfolioDao {

	private static Map<String, PortfolioEntity> dummyData = new HashMap<>();

	static {
		for (int i = 0; i < 10; i++) {
			dummyData.put("p" + i, new PortfolioEntity("p" + i, "Portfolio " + i, "i" + i));
		}
	}

	public List<PortfolioEntity> getAll() {
		return new ArrayList<>(dummyData.values());
	}

	public PortfolioEntity getSingle(String theId) {
		return dummyData.get(theId);
	}
}
