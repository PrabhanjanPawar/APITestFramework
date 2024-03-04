package com.spotify.authManager;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TokenManager 
{

	public static String createToken() // Token generated from this method will alive until we will not use in all code
	{
		// We have form URL Encoded data as body for this API 
		// Hence, I will be using the HashMap to pass into formParam() method
		
		HashMap<String,String> param = new HashMap<String,String>();
		
		param.put("grant_type", "refresh_token");
		param.put("refresh_token", "AQAkbqntipJn-qa9aI8pdchWYiflrMZBEYze3Ek9Ys1AkCgDUSRmm7WZwhbjWfEpuVN6-DXZMfIBXmX9qr61793ZqoU_dv7UYS6Pa_63LgnAfCjuJFCTgPTf9ExTq4QsJFQ");
		param.put("client_id", "970927987af1478ba8af256d0d373d78");
		param.put("client_secret", "5bdd09a7c50b4235a96435f7f50d8aad");
		
		RestAssured.baseURI="https://accounts.spotify.com";
		
		Response response = given()
		.contentType(ContentType.URLENC)	// For URL Encoded body use the content type
		.formParams(param)					// to pass the body
		.when()
		.post("/api/token")
		.then()
		.extract()
		.response();
		
		if(response.statusCode()!=200)
		{
			throw new RuntimeException("Failed to create the Access Token"); // RuntimeException is parent for all runtimeexceptions
		}
		
		String token = response.path("access_token");
		
		return token;
		
	}
}
