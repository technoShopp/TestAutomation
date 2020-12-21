import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class OAuth {
	@Test
	public void getIssue()
	{
	String accessToken=null;
	String codeE=null;
	//getCode through the front end
	
		
	String getCodeResponseURL="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2F0AY0e-g4qmHtHP-BNkRL1mLTFm27J2FVuTPQLX_0sSiZ3xHXJ0z4uRsk_yWqGpVUX18vHig&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent#";	
	
	String codePlus= getCodeResponseURL.split("code=")[1];
	codeE=codePlus.split("&scope=")[0];
	System.out.println(codeE);
	
	//getAccessToken
String getAccessTokenResponse =	given()
	.queryParam("code",codeE)
	.queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	.queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
	.queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
	.queryParam("grantType","authorization_code")
	.when().post("https://www.googleapis.com/oauth2/v4/token").asString();

accessToken=Utilities.getJsonPathToString(getAccessTokenResponse,"access_token");
System.out.println("Access Token = "+accessToken);
	
	
	
		//getCourse from Rahul shetty
	String response =	given().queryParam("access_token", accessToken)
		.when().get("https://rahulshettyacademy.com/getCourse.php").asString();
	System.out.println(response);
	
	
	
		
		
	
	
	
	
	
	
	
	
	}
}
