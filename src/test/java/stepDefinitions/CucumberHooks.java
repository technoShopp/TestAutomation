package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Config;

public class CucumberHooks extends Config  {

	
	@Before ("@auto")
	public void beforeScenario() throws Throwable
	{
		getDriver();
		System.out.println("Launching the Appium Android APP");
	
		
	}
	@After ("@auto")
	public void afterScenario() throws Throwable
	{
		driverApp.closeApp();
		System.out.println("Shutting down the Appium Android APP");
		
	}
	
	
}
