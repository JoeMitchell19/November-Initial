package com.qa.util;

import com.google.gson.Gson;

public class JSONConversion {
	private static Gson gson;
	
	public JSONConversion() {
		this.gson = new Gson();
	}
	public static String getJSONFromObject(Object obj) {
		return gson.toJson(obj);
	}
	public static <T> T getObjectForJSON(String jsonString, Class<T> clas){
		return gson.fromJson(jsonString, clas);
	}

}
