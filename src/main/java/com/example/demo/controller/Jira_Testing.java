package com.example.demo.controller;


import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@RequestMapping( "jira" )
@CrossOrigin("*")
public class Jira_Testing {
	
//	@PostMapping(value ="test")
//	public void  saveAudit(@RequestBody Object object ){
//		System.out.println("///////////////////");
//	System.out.println(object.toString());
//	}
	
//	@PostMapping(value = "test")
//	public String  saveAudit(@RequestBody Object object){
//		System.out.println("///////////////////");
//	System.out.println("Checking ");
//	System.out.println(object.toString());
//	System.out.println();
//		return "Sucess";
//	}
	
	@GetMapping(value = "test")
	public String  saveAudit(){
		System.out.println("///////////////////");
	System.out.println("Checking ");
		return "Sucess";
	}
	
	@GetMapping("message")
	public String getMessage() {
		
		System.out.println("////////////WOrking");
		return "Hello Jira";
	}
	
	
	@GetMapping(value = "/search")
	public String  apiTest1( ){
		String jsonString="";
	 	ObjectMapper objectMapper = new ObjectMapper();
    	try {
			HttpResponse<JsonNode> response = Unirest.get("https://qim-dev.atlassian.net/rest/api/3/search")
					  .basicAuth("vikram221999@gmail.com", "ATATT3xFfGF0OsHseJFLOUdtbpFHHx8SeTwPDnpmxyF22sItDb0lzmQ4Q46m3ExkOzgWDNzHbe96h1Ll7fKAbLH-ah-j2agMlOmEM9pLGll-ZKrjq8FVWAyIAqkjrsWZS0qI5W7FamX8ykX2Z7Pwua51ZRUY_wwFDhPoIyi1KEhNLr_tYZnkmxs=55F3E03F"
					  		+ "")
					  .header("Accept", "application/json")
					  .asJson();
			try {
				 JSONObject jsonObject = response.getBody().getObject();
		            // Convert the JSONObject to a com.fasterxml.jackson.databind.JsonNode
		            com.fasterxml.jackson.databind.JsonNode jacksonJsonNode = objectMapper.readTree(jsonObject.toString());
		            // Serialize the Jackson JsonNode to a JSON string	
		             jsonString = objectMapper.writeValueAsString(jacksonJsonNode);
				System.out.println(jsonString);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (UnirestException e) {
			e.printStackTrace();
		}
    	return jsonString;
	}
	
	
	
	
	
	@GetMapping(value = "search2")
	public String  apiTest2( ){
		String jsonString="";
	 	ObjectMapper objectMapper = new ObjectMapper();
    	try {
			HttpResponse<JsonNode> response = Unirest.get("https://qim-dev.atlassian.net/rest/api/3/search")
					  .basicAuth("vikram221999@gmail.com", "Vino@143"
					  		+ "")
					  .header("Accept", "application/json")
					  .asJson();
			System.err.println(response.getBody());
			try {
				 JSONObject jsonObject = response.getBody().getObject();
		            // Convert the JSONObject to a com.fasterxml.jackson.databind.JsonNode
		            com.fasterxml.jackson.databind.JsonNode jacksonJsonNode = objectMapper.readTree(jsonObject.toString());
		            // Serialize the Jackson JsonNode to a JSON string	
		             jsonString = objectMapper.writeValueAsString(jacksonJsonNode);
				System.out.println(jsonString);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

		} catch (UnirestException e) {
			e.printStackTrace();
		}
    	return jsonString;
	}
}
