package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class APITest extends TestBase {
	TestBase testBase;
	String geturl;
	String posturl;
	
	
	@BeforeMethod
	public void setUp()
	{
		testBase=new TestBase();
		String url=prop.getProperty("URL");
		String apiUrl=prop.getProperty("serviceURL");
	    geturl=url+apiUrl;
	    posturl=url+prop.getProperty("serviceURLPost");
	}
	
	@Test
	public void testGetApi() throws ClientProtocolException, IOException
	{
		RestClient restClient=new RestClient();
		restClient.get(geturl);
	}
	
	@Test
	public void testPostApi() throws ClientProtocolException, IOException
	{
		RestClient restClient=new RestClient();
		restClient.createUser(posturl,"morpheus","leader");
	}
}
