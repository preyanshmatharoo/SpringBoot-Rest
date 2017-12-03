package com.dbd.hackathon.RestClient;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClientApplication {

	public static final String URI1 = "http://localhost:8080/hackathon/members/";
	public static final String URI2 = "http://localhost:8080/hackathon/membersJSONObject/";
	public static final String URI3 = "http://localhost:8080/hackathon/membersJSONRE/";
	public static final String URI4 = "http://localhost:8080/hackathon/membersSimpleJSON/";
	public static final String URI5 = "http://localhost:8080/hackathon/addManager/";
	
	private static void getMemberListURI1() {
	
		System.out.println("Start extracting...");
		
		RestTemplate template = new RestTemplate();
		
		List response = template.getForObject(URI1, List.class);
		if(response.isEmpty()) {
			System.out.println("Empty");
		}else {
			System.out.println(response.get(0));
		}
	}
	
	private static void getMemberListURI2() {
		
		System.out.println("Start extracting...");
		
		RestTemplate template = new RestTemplate();
		
		JSONObject response = template.getForObject(URI1, JSONObject.class);
		
		if(response == null) {
			System.out.println("Empty");
		}else {
			System.out.println(response.toString());
		}
	}
	
	private static void getMemberListURI3() {
		
		System.out.println("Start extracting...");
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity response = template.getForObject(URI4, ResponseEntity.class);
		if(response == null) {
			System.out.println("Empty");
		}else {
			System.out.println(response.getBody());
		}
	}

	private static void getMemberListURI4() {
		
		System.out.println("Start extracting...");
		
		RestTemplate template = new RestTemplate();
		
		String response = template.getForObject(URI4, String.class);
		if(response == null) {
			System.out.println("Empty");
		}else {
			System.out.println(response);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void addManager() {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("manager", "Raghava");
		
		RestTemplate template = new RestTemplate();
		template.postForLocation(URI5, jsonObject.toJSONString());
		
	}
	
	public static void main(String[] args) {
		//getMemberListURI1();
		//getMemberListURI2();
		
		//getMemberListURI3();
		getMemberListURI4();
		
		addManager();
		
		getMemberListURI4();
		
	}
}
