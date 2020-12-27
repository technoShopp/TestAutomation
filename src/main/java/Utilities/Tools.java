package Utilities;



import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Tools {
	public static AppiumDriverLocalService service;
	private static AndroidDriver<AndroidElement> driver;
	



	


	public static AndroidDriver<AndroidElement> getDriver() {
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
	
	
	public static AndroidDriver<AndroidElement> intializeDriver(DesiredCapabilities cap) throws Throwable
	{
				
		driver =new AndroidDriver<AndroidElement>(service,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void getScreenshots(String fileName) throws Throwable
	{
	
	File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\"+fileName+".png"));
	}
	
}
