import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.lang.*;
import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class MapAPI {

	@Test
	public void SerializeDeserialize() {
		//Serialize - Deserialize
	ArrayList<String> tlist = new ArrayList<String> ();
	tlist.add("Shoes");
	tlist.add("Pant");
	Location lr = new Location();
	lr.setLat(-38.383494);
	lr.setLng(33.427362);
		RestAssured.baseURI="https://rahulshettyacademy.com";	
		MapRequest mr= new MapRequest();
		mr.setAccuracy(50);
		mr.setAddress("29, side layout, cohen 09");
		mr.setLanguage("French-IN");
		mr.setLocation(lr);
		mr.setName("Malini Deepak Aadhi Avenue");
		mr.setPhone_number("(+91) 983 893 3937");
		mr.setTypes(tlist);
		mr.setWebsite("http://google.com");
		
		
		
		
		
		MapPostResponse mpr=given()
		.log().all()
		.queryParam("key", "qaclick123")
		.body(mr)
		.when().post("/maps/api/place/add/json")
		.then()
		.assertThat().statusCode(200).extract().response().as(MapPostResponse.class);
		
		System.out.println("Response  === "+mpr.getPlace_id());
String PlaceId=mpr.getPlace_id();
System.out.println("PLACE = "+PlaceId);
		//Parsing JSON

	//	String PlaceId=Utilities.getJsonPathToString(response,"place_id");
	//	System.out.println("PLACE = "+PlaceId);


		//Get  - DeSerialize


		
	/*	Map m=
		given().
		queryParam("key", "qaclick123").queryParam("place_id", PlaceId).expect().defaultParser(Parser.JSON)
		.when().get("https://rahulshettyacademy.com/maps/api/place/get/json")
		.as(Map.class);
		
		System.out.println(m.getName());
		System.out.println(m.getAccuracy());
		System.out.println(m.getLanguage());
		System.out.println(m.getAddress());
		System.out.println(m.getPhone_number());
		System.out.println(m.getTypes());
		System.out.println(m.getWebsite());
		System.out.println(m.getLocation().getLatitude());
		System.out.println(m.getLocation().getLongitude());*/
		
		

		

	}
	
	
	
	
	
}
