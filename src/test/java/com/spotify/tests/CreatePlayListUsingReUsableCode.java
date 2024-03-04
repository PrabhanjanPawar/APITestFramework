package com.spotify.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.spotify.authManager.TokenManager;
import com.spotify.pojo.Playlist;
import com.spotiy.api.reusable.PlayListAPI;

import io.restassured.response.Response;

public class CreatePlayListUsingReUsableCode 
{
	static String playListID;
//	String token;
	
	@Test(priority=1)
	public void createPlayList() 
	{
		Playlist reqPlaylist = new Playlist();
		
		reqPlaylist.setName("New playlist 1");
		reqPlaylist.setDescription("New Playlist 1");
		reqPlaylist.setPublic(false);
		
		Response response = PlayListAPI.post(reqPlaylist,TokenManager.createToken()); //we have created PlaylistAPI class for POST & GET Method, we need to pass 
		Playlist responsePlaylist = response.as(Playlist.class);
		
		String requestName = reqPlaylist.getName();
		
		String responseName = responsePlaylist.getName();
		
		playListID = responsePlaylist.getId();
		
		Assert.assertEquals(requestName,responseName);
		
	}
	
	@Test(priority = 2)
	public void getPlayList()
	{
		Playlist reqPlaylist = new Playlist();
		
		reqPlaylist.setName("New playlist 1");
		reqPlaylist.setDescription("New Playlist");
		reqPlaylist.setPublic(false);
		
		Response response = PlayListAPI.get(playListID,TokenManager.createToken());
		Playlist responsePlaylist = response.as(Playlist.class);
		
//		String responseName = responsePlaylist.getName();
//		String requestName = reqPlaylist.getName();
//		System.out.println(reqPlaylist.getName());
//		System.out.println(responsePlaylist.getName());

		Assert.assertEquals(responsePlaylist.getName(),reqPlaylist.getName());
	}
	
	@Test(priority=3)
	public void updatePlayList()
	{
		Playlist reqPlaylist = new Playlist();
		
		reqPlaylist.setName("Updated Playlist new 1");
		reqPlaylist.setDescription("practice Playlist 1");
		reqPlaylist.setPublic(false);
		
		  Response response = PlayListAPI.update_put(playListID, reqPlaylist,TokenManager.createToken());// We do not have anything to validate apart from status code 
		  
		 int statusCode = response.getStatusCode();   //we can directly apply the methods on response
		  											
		 Assert.assertEquals(statusCode, 200);
	}
	
}
