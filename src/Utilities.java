import io.restassured.path.json.JsonPath;

public class Utilities {
	
	public static String payloadOne= "{\r\n" + 
			"  \"location\": {\r\n" + 
			"    \"lat\": -38.383494,\r\n" + 
			"    \"lng\": 33.427362\r\n" + 
			"  },\r\n" + 
			"  \"accuracy\": 50,\r\n" + 
			"  \"name\": \"Frontline house\",\r\n" + 
			"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
			"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
			"  \"types\": [\r\n" + 
			"    \"shoe park\",\r\n" + 
			"    \"shop\"\r\n" + 
			"  ],\r\n" + 
			"  \"website\": \"http://google.com\",\r\n" + 
			"  \"language\": \"French-IN\"\r\n" + 
			"}\r\n" + 
			"";
	

	
public static String getJsonPayloadOne()
{

	return payloadOne;
	
}
	

public static String getJsonPayloadDynamic(String name, String address, String language)
{

return "{\r\n" + 
			"  \"location\": {\r\n" + 
			"    \"lat\": -38.383494,\r\n" + 
			"    \"lng\": 33.427362\r\n" + 
			"  },\r\n" + 
			"  \"accuracy\": 50,\r\n" + 
			"  \"name\": \""+name+"\",\r\n" + 
			"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
			"  \"address\": \""+address+"\",\r\n" + 
			"  \"types\": [\r\n" + 
			"    \"shoe park\",\r\n" + 
			"    \"shop\"\r\n" + 
			"  ],\r\n" + 
			"  \"website\": \"http://google.com\",\r\n" + 
			"  \"language\": \""+language+"\"\r\n" + 
			"}\r\n" + 
			"";
	

}	

public static String getJsonPayloadOneUpdate(String placeid, String address)
{

return "{\r\n" + 
		"\"place_id\":\""+placeid+"\",\r\n" + 
		"\"address\":\""+address+"\",\r\n" + 
		"\"key\":\"qaclick123\"\r\n" + 
		"}\r\n" + 
		"";

}


public static String getJsonPayloadOneDelete(String placeid)
{

return "\"place_id\":\"928b51f64aed18713b0d164d9be8d67f\"";

}	

public static String getJsonPathToString(String response, String tagNameDes)
{
	JsonPath js= new JsonPath(response);
	return js.get(tagNameDes);
	}


public static String getJsonMockResponse()
{
	return "{\r\n" + 
			"\r\n" + 
			"\"dashboard\": {\r\n" + 
			"\r\n" + 
			"\"purchaseAmount\": 910,\r\n" + 
			"\r\n" + 
			"\"website\": \"rahulshettyacademy.com\"\r\n" + 
			"\r\n" + 
			"},\r\n" + 
			"\r\n" + 
			"\"courses\": [\r\n" + 
			"\r\n" + 
			"{\r\n" + 
			"\r\n" + 
			"\"title\": \"Selenium Python\",\r\n" + 
			"\r\n" + 
			"\"price\": 50,\r\n" + 
			"\r\n" + 
			"\"copies\": 6\r\n" + 
			"\r\n" + 
			"},\r\n" + 
			"\r\n" + 
			"{\r\n" + 
			"\r\n" + 
			"\"title\": \"Cypress\",\r\n" + 
			"\r\n" + 
			"\"price\": 40,\r\n" + 
			"\r\n" + 
			"\"copies\": 4\r\n" + 
			"\r\n" + 
			"},\r\n" + 
			"\r\n" + 
			"{\r\n" + 
			"\r\n" + 
			"\"title\": \"RPA\",\r\n" + 
			"\r\n" + 
			"\"price\": 45,\r\n" + 
			"\r\n" + 
			"\"copies\": 10\r\n" + 
			"\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"]\r\n" + 
			"\r\n" + 
			"}";

}
public static String getSessionID()
{
	return "{ \"username\": \"malinii.aus\", \"password\": \"malini\" }";
	}
public static String getRequestCreateIssue()
{
	return "{\r\n" + 
			"  \"fields\": {\r\n" + 
			"    \"project\": {\r\n" + 
			"      \"key\": \"MAL\"\r\n" + 
			"    },\r\n" + 
			"    \"summary\": \"My Fourth JIRA Issue\",\r\n" + 
			"    \"issuetype\": {\r\n" + 
			"      \"name\": \"Bug\"\r\n" + 
			"    },\r\n" + 
			"    \"description\": \"My Fourth JIRA Issue Description\"\r\n" + 
			"  }\r\n" + 
			"}";
	}
	
public static String getRequestAddComment()
{
	return "{\r\n" + 
			"    \"body\": \"Fourth Comment from Rest Assured\",\r\n" + 
			"    \"visibility\": {\r\n" + 
			"        \"type\": \"role\",\r\n" + 
			"        \"value\": \"Administrators\"\r\n" + 
			"    }\r\n" + 
			"}";
	}

public static String getRequestDynamicAddComment(String comment)
{
	return "{\r\n" + 
			"    \"body\": \""+comment+"\",\r\n" + 
			"    \"visibility\": {\r\n" + 
			"        \"type\": \"role\",\r\n" + 
			"        \"value\": \"Administrators\"\r\n" + 
			"    }\r\n" + 
			"}";
	}


}
