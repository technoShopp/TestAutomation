package utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Config {
	public static AndroidDriver<AndroidElement> driverApp;
	public static AndroidDriver<AndroidElement> getDriver() throws Throwable 
	{
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "GalaxyS10e");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	//cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
	//cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.appium.android.apis.ApiDemos");
	cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.sec.android.app.popupcalculator");
	cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.sec.android.app.popupcalculator.Calculator");

	//cap.setCapability(MobileCapabilityType.NO_RESET, true);
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");
	driverApp =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
driverApp.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driverApp;
}
}
