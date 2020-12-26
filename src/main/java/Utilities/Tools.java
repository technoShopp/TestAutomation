package Utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Tools {
	private static AppiumDriverLocalService service;
	private static AndroidDriver<AndroidElement> driver;
	
	
	public static AndroidDriver<AndroidElement> intializeDriver(DesiredCapabilities cap) throws Throwable
	{
		
		driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		
		try
		{
			serverSocket = new ServerSocket(port);
			serverSocket.close();
			
		}
		catch(IOException e)
		{
			isServerRunning = true;
		}
		finally
		{
			serverSocket = null;
		}
		
		return isServerRunning;
	}

	
	public static AppiumDriverLocalService startServer()
	{
		boolean serviceCheck=Utilities.Tools.checkIfServerIsRunning(4723);
		if(!serviceCheck)
		{
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
	
	public static void stopServer(AppiumDriverLocalService serviceFrom)
	{
		serviceFrom.stop();
	}
	
	public static void killAllNodes()throws Exception
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	public static void getScreenshots(String fileName) throws Throwable
	{
	File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\"+fileName+".png"));
		
	}
	
	
	
	

	
}
