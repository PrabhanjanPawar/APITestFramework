package com.spotiy.api.reusable;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.ResponseSpecBuilder;

public class SpecBuilder 
{
	public static RequestSpecification reqSpec() 
	{
		return new RequestSpecBuilder()
		.setBaseUri("https://api.spotify.com")
		.setBasePath("/v1")
//		.addHeader("Authorization", "Bearer BQBQq9OhjdhGnMz88GysDdCNwUH_eJmmMwH8vWHsPTtjh82O3YLsVETfdO5-qpTZOVhFFXDJiGli74ZJU32KkxgHOJt-aTMQXMszp36vlvKEcIBFNE8Uh2yJGHeR5jrbuEqKjZL432pnIxSKqrlBqm03O3o8ksXqaGgFa2KqNlC1Fa7H4pQ02I6BWGxtT_xbr6vqkDf8sPdwhcpbSh-Q072L21oN_2pQR9xFMRKnPDb2fmZaCypHajBgxHbmeMab9sAS33e5R8Bit-Ox")
		.setContentType(ContentType.JSON)
		.log(LogDetail.ALL)
		.build();
	}
	
	
	public static ResponseSpecification respSpec() 
	{
		return new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.log(LogDetail.ALL)
		.build();
	}
//	RequestSpecBuilder requestspecbuilder = new RequestSpecBuilder();
	
}
