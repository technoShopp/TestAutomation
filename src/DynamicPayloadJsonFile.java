import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class DynamicPayloadJsonFile {
	
	

	public static void main(String[] a) throws Exception
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";	
		// Create
		String response=given()
		//.log().all()
		.queryParam("key", "qaclick123").header("Content-Type","application/json").body(new String(Files.readAllBytes(Paths.get("C:\\Users\\maliniv\\Desktop\\Technology Upgrade\\Appium\\MobileBasics\\APITesting\\addBook.json"))))
		.when().post("/maps/api/place/add/json")
		.then()
		//.log().all()
		.assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		//System.out.println("RESPONSE" + response);

		//Parsing JSON

		String PlaceId=Utilities.getJsonPathToString(response,"place_id");
		System.out.println("PLACE = "+PlaceId);
		
	}
	
	
	
	
	

}
