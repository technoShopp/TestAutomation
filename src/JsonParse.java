import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonParse {

	
	@Test
	public void testCase1()
	{
		
		JsonPath js= new JsonPath(Utilities.getJsonMockResponse());
		System.out.println(js.getInt("courses.size()"));
		
		System.out.println(js.getString("courses[0].title"));
		System.out.println(js.get("courses[0].price").toString());
		System.out.println(js.get("courses[0].copies").toString());
		
		System.out.println(js.getString("courses[1].title"));
		System.out.println(js.get("courses[1].price").toString());
		System.out.println(js.get("courses[1].copies").toString());
		
		System.out.println(js.getString("courses[2].title"));
		System.out.println(js.get("courses[2].price").toString());
		System.out.println(js.get("courses[2].copies").toString());
		
		
		int price1=js.get("courses[0].price");
		System.out.println("P1="+price1);
		int price2=js.get("courses[1].price");
		System.out.println("P2="+price2);
		int price3=js.get("courses[2].price");
		System.out.println("P3="+price3);
		
		int copy1=js.get("courses[0].copies");	
		System.out.println("C1="+copy1);
		int copy2=js.get("courses[1].copies");
		System.out.println("C2="+copy2);
		int copy3=js.get("courses[2].copies");
		System.out.println("C3="+copy3);
		
		int sum=0;
		int len=js.getInt("courses.size()");	
		System.out.println("LENGTH= "+len);
		for(int i=0;i<len;i++)
		{
			int priceI=js.get("courses["+i+"].price");
			int copyI=js.get("courses["+i+"].copies");	
			sum =sum+(priceI*copyI);
			
		}
		
		int expSum=js.get("dashboard.purchaseAmount");
		System.out.println("Actual Sum = "+sum);
		System.out.println("Expected Sum = "+expSum);
		
		Assert.assertEquals(sum, expSum);
		
		
	}
	
	
	
	
	
}
