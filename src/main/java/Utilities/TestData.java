package Utilities;

import org.testng.annotations.DataProvider;

public class TestData {


@DataProvider(name="inputDisplay")
public Object[][] inputDataMethod()
{
	Object[][] obj = new Object[][]
			{
		
		{"TestData1"},{"TestData2"}
		
	};
	
	return obj;
	
			
}
	
	
}
