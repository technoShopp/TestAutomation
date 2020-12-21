import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class BasicAPI {
public static void main(String[] a)
{
	String newAddress = "Malini Avenue";
RestAssured.baseURI="https://rahulshettyacademy.com";	
// Create
String response=given()
//.log().all()
.queryParam("key", "qaclick123").header("Content-Type","application/json").body(Utilities.getJsonPayloadOne())
.when().post("/maps/api/place/add/json")
.then()
//.log().all()
.assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
//System.out.println("RESPONSE" + response);

//Parsing JSON

String PlaceId=Utilities.getJsonPathToString(response,"place_id");
System.out.println("PLACE = "+PlaceId);


//Get 

String getResponse=
given().
log().all()
.queryParam("key", "qaclick123").queryParam("place_id", PlaceId)
.when().get("/maps/api/place/get/json")
.then()
.log().all()
.assertThat().extract().response().asString();

//Parsing JSOn


String Address=Utilities.getJsonPathToString(getResponse,"address");
System.out.println("Address = "+Address);


//Update
String updatedResponse=given()
.log().all()
.queryParam("key", "qaclick123").header("Content-Type","application/json").body(Utilities.getJsonPayloadOneUpdate(PlaceId, newAddress))
.when().put("/maps/api/place/update/json")
.then()
.log().all()
.assertThat().extract().response().asString();

//Parsing JSON




String status=Utilities.getJsonPathToString(updatedResponse,"msg");
System.out.println("Updated Address = "+status);


//Get 

String getResponsePostUpdate=
given().
log().all()
.queryParam("key", "qaclick123").queryParam("place_id", PlaceId)
.when().get("/maps/api/place/get/json")
.then()
.log().all()
.assertThat().extract().response().asString();

//Parsing JSOn


String UpdatedAddress=Utilities.getJsonPathToString(getResponsePostUpdate,"address");
System.out.println("New Address = "+UpdatedAddress);


//Get all - service not developed

//Delete
given()
.log().all()
.queryParam("key", "qaclick123").header("Content-Type","application/json").body(Utilities.getJsonPayloadOneDelete(PlaceId))
.when().delete("/maps/api/place/delete/json")
.then()
.log().all()
.assertThat().extract().response().asString();

//Get 

String getResponsePostDelete=
given().
log().all()
.queryParam("key", "qaclick123").queryParam("place_id", PlaceId)
.when().get("/maps/api/place/get/json")
.then()
.log().all()
.assertThat().extract().response().asString();

//Parsing JSOn


String deletedAddress=Utilities.getJsonPathToString(getResponsePostDelete,"address");
System.out.println("Deleted Address = "+deletedAddress);
Assert.assertEquals(deletedAddress, newAddress);

}

}
