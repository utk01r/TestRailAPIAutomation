package com.pawan.testRail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class TestCaseManagment {
	static String URL = XmlFileHandler.getXmlXpathValue("config/application/url");
	static String USERNAME = XmlFileHandler.getXmlXpathValue("config/user/username");
	static String PASSWORD = XmlFileHandler.getXmlXpathValue("config/user/password");
	static APIClient apiClient = new APIClient(URL);
	
	public static void addTestCase() {
		apiClient.setUser(USERNAME);
		apiClient.setPassword(PASSWORD);

		Map<String, Object> data = new HashMap<>();
		data.put("title", "Test with Java and selenium");
		data.put("template_id", 1);
		data.put("type_id", 3);
		data.put("priority_id", 2);
		data.put("estimate", "30s");
		data.put("custom_preconds", "These are the preconditions for a test case");
		data.put("custom_steps", "1. Navigate to ULR, 2. Click on home");
		data.put("custom_expected", "Expected: Home page should display");
		//data.put("custom_abcd", "T01");
		//data.put(“custom_description”, desc);
		//data.put(“custom_objective”, objctv);
		try {
			JSONObject c = (JSONObject)apiClient.sendPost("add_case/1", data);
			System.out.println(c.get("title"));
		} catch (IOException | APIException e) {
			
			e.printStackTrace();
		}
	}

	public static void updateTestCase(String test_case_Id, String value_to_update) {
		apiClient.setUser(USERNAME);
		apiClient.setPassword(PASSWORD);
		
		Map<String, Object> data = new HashMap<>();
		data.put("custom_expected", value_to_update);
		try {
			JSONObject c = (JSONObject)apiClient.sendPost("update_case/"+test_case_Id, data);
			System.out.println(c.get("title"));
		} catch (IOException | APIException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//addTestCase();
		updateTestCase("26", "Updated value :next");
	}
}
