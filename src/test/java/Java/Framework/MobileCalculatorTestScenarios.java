package Java.Framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.MobileCalculatorPageObject;
import Utilities.TestData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class MobileCalculatorTestScenarios {

	
	private String textDisplayFirst,textDisplayFirstSecond,sum;
	private static AppiumDriverLocalService serviceMC;
	private static AndroidDriver<AndroidElement> driverApp;
	private String device;
	
	@BeforeTest
	public void Config() throws Throwable
	{	
		device= System.getProperty("deviceName");
		Utilities.Tools.killAllNodes();
		serviceMC = Utilities.Tools.startServer();
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,device );
		System.out.println(device);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.sec.android.app.popupcalculator");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.sec.android.app.popupcalculator.Calculator");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");
		driverApp=Utilities.Tools.intializeDriver(cap);
		
		
	}
	
	
	
	
		@Test(dataProvider="inputDisplay", dataProviderClass=TestData.class)
	public void writeMobileCalculatorTestScenarios(String display) throws Throwable
	{
		
	
		MobileCalculatorPageObject mcpb= new MobileCalculatorPageObject(driverApp);
		mcpb.getElementNumbers().get(12).click();
		mcpb.getElementNumbers().get(13).click();
		mcpb.getElementNumbers().get(14).click();
		textDisplayFirst=mcpb.getElementTextDisplay().getAttribute("text").toString();
		mcpb.getElementNumbers().get(15).click();
		
		mcpb.getElementNumbers().get(8).click();
		mcpb.getElementNumbers().get(9).click();
		mcpb.getElementNumbers().get(10).click();
			
		textDisplayFirstSecond=mcpb.getElementTextDisplay().getAttribute("text").toString();
		mcpb.getElementNumbers().get(19).click();
			sum= mcpb.getElementTextDisplay().getAttribute("text").toString();
			System.out.println(sum);
			System.out.println(textDisplayFirstSecond);
			String[] k=textDisplayFirstSecond.split("\\+");

			System.out.println(k);
			int i=Integer.parseInt(textDisplayFirst);
			int j=Integer.parseInt(k[1]);

			int expSum = i+j;
			System.out.println(expSum);
			int actSum= Integer.parseInt(sum);
			System.out.println(actSum);
			System.out.println(display);
		Assert.assertEquals(actSum, expSum);
	
	}

		@AfterTest
		public void shutDown()
		{
			
			driverApp.closeApp();
			Utilities.Tools.stopServer(serviceMC);
			
		}
	
	
}
