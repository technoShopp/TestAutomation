import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class JIRA {

	@Test
	public void createIssue()
	{
		String sessionTag="JSESSIONID=";
		RestAssured.baseURI ="http://localhost:8080";
		
		// Creating SessionID
	String response=	given().log().all().header("Content-Type","application/json")
		.body(Utilities.getSessionID())
		.when().post("rest/auth/1/session")
		.then().assertThat().statusCode(200).extract().response().asString();
	String sessionID=Utilities.getJsonPathToString(response,"session.value");
	System.out.println(sessionID);
	
	
	
	
		// Creating Issue
	String resCI=given().log().all().header("Content-Type","application/json")
	.header("Cookie",sessionTag+sessionID)
	.body(Utilities.getRequestCreateIssue())
	.when().post("/rest/api/2/issue")
	.then().assertThat().statusCode(201).extract().response().asString();
	String jiraID=Utilities.getJsonPathToString(resCI,"self");
	System.out.println(jiraID);
		
		
	// updating comments
	
	/*String resComments=given().log().all().header("Content-Type","application/json")
	.header("Cookie",sessionTag+sessionID)
	.body(Utilities.getRequestAddComment())
	.when().post("/rest/api/2/issue/MAL-3/comment")
	.then().assertThat().statusCode(201).extract().response().asString();
	String jiraComment=Utilities.getJsonPathToString(resComments,"self");
	System.out.println(jiraComment);*/
	
	//updating comments through path parameter
	String resComments=given().pathParam("key", "MAL-2").log().all().header("Content-Type","application/json")
			.header("Cookie",sessionTag+sessionID)
			.body(Utilities.getRequestAddComment())
			.when().post("/rest/api/2/issue/{key}/comment")
			.then().assertThat().statusCode(201).extract().response().asString();
			String jiraComment=Utilities.getJsonPathToString(resComments,"self");
			System.out.println(jiraComment);
		
	}
	
	
	
	
	
	
	
}
