import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class MultiPart {
	@Test
	public void createIssue()
	{
		
		RestAssured.baseURI ="http://localhost:8080";
		SessionFilter sf= new SessionFilter();
		// Creating SessionID
	given().log().all().header("Content-Type","application/json")
		.body(Utilities.getSessionID())
		.filter(sf)
		.when().post("rest/auth/1/session")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
	
	
	
	
	
	
	
	//Add attachments through path parameter
	/*given()
			.header("X-Atlassian-Token","no-check")
			.filter(sf).pathParam("key", "MAL-4")
			.header("Content-Type","multipart/form-data")
			.multiPart("file",new File("C:\\Users\\maliniv\\Desktop\\Technology Upgrade\\Appium\\MobileBasics\\APITesting\\src\\Sample.txt"))
			.when().post("/rest/api/2/issue/{key}/attachments")
			.then().assertThat().statusCode(200);*/
	
	given().pathParam("key", "MAL-3")
	.header("X-Atlassian-Token","no-check")
	.header("Content-Type","multipart/form-data")
	.multiPart("file",new File("C:\\Users\\maliniv\\Desktop\\Technology Upgrade\\Appium\\MobileBasics\\APITesting\\src\\Sample.txt"))
	.filter(sf)
	.when().post("/rest/api/2/issue/{key}/attachments")
	.then().assertThat().statusCode(200);
	
		
	}
	
}
