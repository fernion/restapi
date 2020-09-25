package com.example.api.asset.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssuerDao {

	private static Map<String, IssuerEntity> dummyData = new HashMap<>();

	static {
		//TODO need to support / in ids, using %2F does not seem to be working
		for (int i = 0; i < 10; i++) {
			String id = "i" + i;
			dummyData.put(id, new IssuerEntity(id, "Issuer " + i));
		}
	}

	public List<IssuerEntity> getAll() {
		return new ArrayList<>(dummyData.values());
	}

	public IssuerEntity getSingle(String theId) {
		return dummyData.get(theId);
	}
}
