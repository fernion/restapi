package com.example.api.asset.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

public class IssuerDao {

	private static Map<String, IssuerEntity> dummyData = new HashMap<>();

	static {
		String[] isoCountries = Locale.getISOCountries();
		Function<Integer, String> randomCountryGetter = index -> {
			int arrayIndex = index % isoCountries.length;
			return isoCountries[arrayIndex];
		};

		//TODO need to support / in ids, using %2F does not seem to be working
		for (int i = 0; i < 10; i++) {
			String id = "i" + i;
			dummyData.put(id, new IssuerEntity(id, "Issuer " + i, randomCountryGetter.apply(i)));
		}
	}

	public List<IssuerEntity> getAll() {
		return new ArrayList<>(dummyData.values());
	}

	public IssuerEntity getSingle(String theId) {
		return dummyData.get(theId);
	}
}
