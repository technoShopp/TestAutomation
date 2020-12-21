import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class LibraryAPI {
@Test
public void getDet()
{
RestAssured.baseURI="http://216.10.245.166";	
// Create
String response=given()
.log().all()
.header("Content-Type","application/json").body("{\r\n" + 
		"\r\n" + 
		"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
		"\"isbn\":\"bcd\",\r\n" + 
		"\"aisle\":\"227\",\r\n" + 
		"\"author\":\"John foe\"\r\n" + 
		"}\r\n" + 
		"")
.when().post("Library/Addbook.php")
.then()
.log().all()
.assertThat().extract().response().asString();
//System.out.println("RESPONSE" + response);

//Parsing JSON

String Id=Utilities.getJsonPathToString(response,"ID");
System.out.println("ID = "+Id);


//Get 

 Library l = 
given()
.queryParam("ID", Id)
.when().get("/Library/GetBook.php")
.as(Library.class);

//Parsing JSOn

System.out.println(l.getBook_name());


}
}