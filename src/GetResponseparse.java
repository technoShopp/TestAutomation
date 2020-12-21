import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class GetResponseparse {
	@Test
	public void getIssue()
	{
		String comment ="Comment for MAL-2" ;
		String actual=null;
		RestAssured.baseURI ="http://localhost:8080";
		SessionFilter sf= new SessionFilter();
		// Creating SessionID
	given().log().all().header("Content-Type","application/json")
		.body(Utilities.getSessionID())
		.filter(sf)
		.when().post("rest/auth/1/session")
		.then().assertThat().statusCode(200).extract().response().asString();
	
	
	
	
	String resComments=given().pathParam("key", "MAL-2").log().all().header("Content-Type","application/json")
			.filter(sf)
			.body(Utilities.getRequestDynamicAddComment(comment))
			.when().post("/rest/api/2/issue/{key}/comment")
			.then().assertThat().statusCode(201).extract().response().asString();
			String jiraComment=Utilities.getJsonPathToString(resComments,"self");
			System.out.println(jiraComment);
	
	
	
	
		
			// Getting Issue
	String resCI=given().log().all()
			.header("Content-Type","application/json")
			.queryParam("fields","comment")
			.pathParam("key", "MAL-2")
	    	.filter(sf)
	        .when().get("/rest/api/2/issue/{key}")
	        .then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	
	
	
	
	
	
	
	JsonPath js= new JsonPath(resCI);
	int len=js.getInt("fields.comment.comments.size()");
	
	for (int i=0;i<len;i++)
	{
	
		System.out.println(js.getString("fields.comment.comments["+i+"].id"));
		System.out.println(js.getString("fields.comment.comments["+i+"].body"));
		
		String b=js.getString("fields.comment.comments["+i+"].body");
		
		if(b.equalsIgnoreCase(comment))
		{
			actual=b;
			break;
		}
	}

	Assert.assertEquals(actual, comment);
	
System.out.println("ACTUAL = "+actual);
System.out.println("EXPECTED = "+comment);
		
		
	
	}
}
