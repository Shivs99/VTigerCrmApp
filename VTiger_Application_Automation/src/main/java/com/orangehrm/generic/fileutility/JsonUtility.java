package com.orangehrm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {

	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader fr = new FileReader("./ConfiguartionData/AppCommonData.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		JSONObject jobj = (JSONObject) obj;
		String keydata = jobj.get(key).toString();
		return keydata;
	}
}
