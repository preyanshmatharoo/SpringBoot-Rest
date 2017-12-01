package com.dbd.hackathon.RestClient;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class RestClientApplication {

	public static final String URI1 = "http://localhost:8080/hackathon/members/";
	public static final String URI2 = "http://localhost:8080/hackathon/membersJSONObject/";
	
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
	
	public static void main(String[] args) {
		getMemberListURI1();
		
		getMemberListURI2();
	}
}
