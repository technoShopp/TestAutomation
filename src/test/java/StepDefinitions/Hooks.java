package StepDefinitions;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.TakesScreenshot;

import Utilities.Tools;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Tools {
	
	private static final String NODE_JS_PATH = "C:/Program Files/nodejs/node.exe";
	private static final String APPIUM_JS_PATH = "C:/Users/maliniv/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";
	public static String log4jPath = System.getProperty("user.dir")+"\\log4j.properties";
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	
	@Before ("@auto")
	public void beforeScenario() throws Throwable
	{
		PropertyConfigurator.configure(log4jPath);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingDriverExecutable(new File(NODE_JS_PATH));
		builder.withAppiumJS(new File(APPIUM_JS_PATH));
		builder.usingAnyFreePort();
		service=AppiumDriverLocalService.buildService(builder);
		System.out.println("******URL + PORT *****"+service.getUrl());
		String x= service.getUrl().toString();
		System.out.println("STRING : "+x);
		String a[]=x.split(":");
		String b[]=a[2].split("/");
		System.out.println("URL  : "+b[0]);
		int portUsed=Integer.parseInt(b[0]);
		System.out.println("PORT USED  : "+portUsed);
		boolean serviceCheck=Utilities.Tools.checkIfServerIsRunning(portUsed);
		if(!serviceCheck)
		{
				service.start();
		}
		log.info("Server successfully started");
		}
	@After ("@auto")
	public void afterScenario(Scenario scenario) throws Throwable
	{
		
		if(scenario.isFailed())
		{
			Tools.getScreenshots(scenario.getName());
			log.info("failed and took screenshot");
		}
		else
		{
		log.info("passed");
		}
		Tools.closeDriver();
		service.stop();
		log.info("Server successfully stopped");
		
		
		
	}
	
	
	
	
	
}
