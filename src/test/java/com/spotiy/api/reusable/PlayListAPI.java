package com.spotiy.api.reusable;

import static io.restassured.RestAssured.*;
import com.spotify.pojo.Playlist;

import io.restassured.response.Response;

public class PlayListAPI

	{

		public static Response post(Playlist reqPlaylist, String token) 
		{
			 return given(SpecBuilder.reqSpec())
//			.header("Authorization","Bearer"+token)
			.auth().oauth2(token)		 
			.body(reqPlaylist)
			.log().all()
			.when()
			.post("/users/31gkaasxsl57gwo3tn3jdocx6jxa/playlists")
			.then()
			.spec(SpecBuilder.respSpec())
			.extract()
			.response();
		}
		
		public static Response get(String playListID, String token)
		
		{
			 return given(SpecBuilder.reqSpec())
//			.header("Authorization","Bearer"+token)
			.auth().oauth2(token)
			.when()
			.get("/playlists/"+playListID)
			.then()
			.log().all()
			.spec(SpecBuilder.respSpec())
			.extract()
			.response();
		}
			
		public static Response update_put(String playListID,Playlist reqPlaylist, String token)
		{
			return given(SpecBuilder.reqSpec())
//			.header("Authorization","Bearer"+token)
			.auth().oauth2(token)
			.body(reqPlaylist)
			.when()
			.put("/playlists/"+playListID)
			.then()// We do not need to write the response as empty body is getting a response.
//			.spec(SpecBuilder.respSpec())
			.extract()
			.response();
			
		}

}


