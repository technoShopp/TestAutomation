package StepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.remote.DesiredCapabilities;

import PageObjectRepository.MobileCalculatorPageObjects;
import Utilities.Tools;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobileCalculatorSD extends Tools {
	
	private static AndroidDriver<AndroidElement> driverApp;
	private String device;
	private String textDisplayFirst,textDisplayFirstSecond,sum;
	MobileCalculatorPageObjects mcpb;
	
		@Given("the MobileCalculatorApp")
		public void the_mobile_calculator_app() throws Throwable {
			device= System.getProperty("deviceName");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,device );
			System.out.println(device);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
				cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.sec.android.app.popupcalculator");
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.sec.android.app.popupcalculator.Calculator");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");
			driverApp=Tools.intializeDriver(cap);
		 mcpb= new MobileCalculatorPageObjects(driverApp);

		}



	
		@When("the number one {string} is entered")
		public void the_number_one_is_entered(String a) {
		
			mcpb.getElementNumbers().get(12).click();
					mcpb.getElementNumbers().get(13).click();	
			
				mcpb.getElementNumbers().get(14).click();
			
			textDisplayFirst=mcpb.getElementTextDisplay().getAttribute("text").toString();
			}


	
	

		@When("the {string} operator is clicked")
		public void the_operator_is_clicked(String operator) {
			
			mcpb.getElementNumbers().get(15).click(); 
		
		}
		
		@When("the number two {string} is entered")
		public void the_number_two_is_entered(String a) {
			
			
				mcpb.getElementNumbers().get(8).click();
			
				mcpb.getElementNumbers().get(9).click();
			
				mcpb.getElementNumbers().get(10).click();
			
							
			textDisplayFirstSecond=mcpb.getElementTextDisplay().getAttribute("text").toString();
			mcpb.getElementNumbers().get(19).click();
				}


		
		
		@Then("the result must be the sum")
		public void the_result_must_be_the_sum() {
		  
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
			
			assertEquals(actSum, 11);
			
		}



	
	
	
}
