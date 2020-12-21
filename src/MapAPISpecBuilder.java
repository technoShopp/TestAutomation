import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.lang.*;
import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MapAPISpecBuilder {

	@Test
	public void SerializeDeserialize() {
		
		
	RequestSpecification requestSpec=	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
	ResponseSpecification responseSpec=	new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
		//Serialize - Deserialize
	ArrayList<String> tlist = new ArrayList<String> ();
	tlist.add("Shoes");
	tlist.add("Pant");
	Location lr = new Location();
	lr.setLat(-38.383494);
	lr.setLng(33.427362);
	//	RestAssured.baseURI="https://rahulshettyacademy.com";	
		MapRequest mr= new MapRequest();
		mr.setAccuracy(50);
		mr.setAddress("29, side layout, cohen 09");
		mr.setLanguage("French-IN");
		mr.setLocation(lr);
		mr.setName("Malini Deepak Aadhi Avenue");
		mr.setPhone_number("(+91) 983 893 3937");
		mr.setTypes(tlist);
		mr.setWebsite("http://google.com");
		
		
		RequestSpecification rss=given()
		.spec(requestSpec)
		.body(mr);
		
		
		
		
		
		
		MapPostResponse mpr=rss
		.when().post("/maps/api/place/add/json")
		.then()
		.spec(responseSpec).extract().response().as(MapPostResponse.class);
		
         String PlaceId=mpr.getPlace_id();
         System.out.println("PLACE = "+PlaceId);
	
		

	}
	
	
	
	
	
}
