package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.qa.base.TestBase;

public class RestClient extends TestBase{
	
	//1. GET Method
	public void get(String url) throws ClientProtocolException, IOException
	{
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpGet httpGet=new HttpGet(url);  //http get request
	CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);  //hit the GET URL
    //a. Status Code
	int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
	System.out.println("Status Code is ---> "+statusCode);
	//b. Json String 
	String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
	JSONObject responseJson=new JSONObject(responseString);
	System.out.println("Response JSON from API --->"+responseJson);
	//c. All Headers
	Header[] headersArray = closeableHttpResponse.getAllHeaders();
	HashMap<String, String > allHeaders=new HashMap<String, String>();
	
	for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());
	}
	System.out.println("Response all header is --->"+allHeaders);
	}
	
	//2. POST Method
	public void createUser(String url,String name,String job) throws ClientProtocolException, IOException
	{
		JSONObject holder=new JSONObject();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		holder.put("name", name);
		holder.put("job", job);
		System.out.println("Json body is "+holder.toString());
		StringEntity se=new StringEntity(holder.toString());
		HttpPost http=new HttpPost(url);
		http.setHeader("Content-Type", "application/json");
		http.setEntity(se);
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(http);
		 //a. Status Code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is ---> "+statusCode);
		//b. Json String 
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson=new JSONObject(responseString);
		System.out.println("Response JSON from API --->"+responseJson);
		//c. All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String > allHeaders=new HashMap<String, String>();
		
		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Response all header is --->"+allHeaders);
	}
	
	
	

}
