package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class utilities {
	public static RequestSpecification  reqCommon;
	public static RequestSpecification requestFunc() throws Throwable
	{
		Properties p= new Properties();
		FileInputStream f= new FileInputStream("C:\\Users\\maliniv\\Desktop\\Technology Upgrade\\API\\End to End Framework\\Framework\\src\\test\\java\\Utilities\\golbal.properties");
		p.load(f);
		String baseUri=p.getProperty("UriBase");
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		reqCommon= new RequestSpecBuilder().setBaseUri(baseUri)
		.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	return reqCommon;
	
	
	}
	
	
	public static Map<String, Object> providePayload()
	{
		Map<String, Object> jsonToMap = new HashMap<String,Object>();
		Map<String, Object> map2 = new HashMap<String,Object>();
		map2.put("lat",-38.383494);
		map2.put("lng",33.427362);
		ArrayList<String> al = new ArrayList<String>();
		al.add("POC");
		al.add("YUI");
		jsonToMap.put("accuracy",50);
		jsonToMap.put("name","Malini");
		jsonToMap.put("name","(+91) 983 893 3937");
		jsonToMap.put("address","ABC Home");
		jsonToMap.put("website","http://google.com");
		jsonToMap.put("language","French-IN");
		jsonToMap.put("types", al);
		jsonToMap.put("location", map2 );
		return jsonToMap;
		
		
		
		
		
	}
	
public static String getHTTPEndPointURL(String a)
{
	if(a=="post")
		return "/maps/api/place/add/json";
	else if(a=="get")
		return "/maps/api/place/get/json";
	else
		return "";
	
	
	
}
	
}
