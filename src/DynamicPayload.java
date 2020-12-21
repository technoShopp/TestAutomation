import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class DynamicPayload {
	
	
	@Test(dataProvider="BookData")
	public void getPayloadDynamic(String name, String address, String language)
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";	
		// Create
		String response=given()
		//.log().all()
		.queryParam("key", "qaclick123").header("Content-Type","application/json").body(Utilities.getJsonPayloadDynamic(name,address,language))
		.when().post("/maps/api/place/add/json")
		.then()
		//.log().all()
		.assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		//System.out.println("RESPONSE" + response);

		//Parsing JSON

		String PlaceId=Utilities.getJsonPathToString(response,"place_id");
		System.out.println("PLACE = "+PlaceId);
		
	}
	
	@DataProvider(name="BookData")
	public Object[][] getData()
	{
		return new Object[][]{{"AB","123","French"},{"CD","456","Germen"},{"EF","789","English"}};
		
	}
	
	
	
	

}
