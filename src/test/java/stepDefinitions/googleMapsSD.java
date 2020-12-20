package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;

import POJO.Location;
import POJO.MapRequest;
import Utilities.utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;	
import static org.junit.Assert.assertEquals;

public class googleMapsSD {
	
	ArrayList<String> tlist = new ArrayList<String> ();
	Location lr = new Location();
	MapRequest mr= new MapRequest();
	RequestSpecification req;
	ResponseSpecification res;
	Response response1;
	
		@Given("the query parameter and the payload")
		public void the_queryparameter_and_the_payload() throws Throwable {
			/*
			tlist.add("Shoes");
			tlist.add("Pant");
			
			lr.setLat(-38.383494);
			lr.setLng(33.427362);
			
			
				mr.setAccuracy(50);
				mr.setAddress("29, side layout, cohen 09");
				mr.setLanguage("French-IN");
				mr.setLocation(lr);
				mr.setName("Malini Deepak Aadhi Avenue");
				mr.setPhone_number("(+91) 983 893 3937");
				mr.setTypes(tlist);
				mr.setWebsite("http://google.com");
				 req=	given().spec(utilities.requestFunc()).body(mr);*/
			
				
				Map<String, Object> m=utilities.providePayload();
		 req=	given().spec(utilities.requestFunc()).body(m);
		 System.out.println(req);
		}


		

		@When("the POST request is hit for the end point URL")
		public void the_post_request_is_hit_for_the_end_point_url() {
		  
		response1=	req.when().post("/maps/api/place/add/json").then().extract().response();
		 System.out.println(response1);
		}
		
	/*	@When("the POST two request is hit for the end point URL")
		public void the_post_two_request_is_hit_for_the_end_point_url() {
		  
		String response2=	req.when().post("/maps/api/place/add/json").then().extract().response();
		 System.out.println(response1);
		}
		
		@When("the POST three request is hit for the end point URL")
		public void the_post_three_request_is_hit_for_the_end_point_url() {
		  
		String response3=	req.when().post("/maps/api/place/add/json").then().extract().response();
		 System.out.println(response1);
		}
		*/
		@Then("the STATUSCODE should be OK")
		public void the_statuscode_should_be_ok() {
		   
			int status =response1.getStatusCode();
			System.out.println("STATUS = "+status);
			assertEquals(status,200);
		}
		
		@Then("the STATUSCODE two should be OK")
		public void the_statuscode_two_should_be_ok() {
		   
			int status =response1.getStatusCode();
			System.out.println("STATUS = "+status);
			assertEquals(status,200);
		}
		
		@Then("the STATUSCODE three should be OK")
		public void the_statuscode_three_should_be_ok() {
		   
			int status =response1.getStatusCode();
			System.out.println("STATUS = "+status);
			assertEquals(status,200);
		}

		

			@When("the {string} request is hit")
			public void the_request_is_hit_for_the(String a) {
				String resourceURL=utilities.getHTTPEndPointURL(a);
				response1=	req.when().post(resourceURL).then().extract().response();
				 System.out.println(response1); 
			}


		

			@Then("the statusCode should be {string}")
			public void the_should_be(String a) {
				int b=Integer.parseInt(a);
				int status =response1.getStatusCode();
				System.out.println("STATUS = "+status);
				assertEquals(status,b);
			}




	
	
	
	
	
	

}
