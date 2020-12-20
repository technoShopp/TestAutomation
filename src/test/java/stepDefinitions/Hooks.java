package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before ("@regression")
	public void beforeScenario()
	{
		
		System.out.println("Launching the API Testing");
	}
	
	
	@After ("@regression")
	public void afterScenario()
	{
		System.out.println("Closing the API Testing");
	}

}
