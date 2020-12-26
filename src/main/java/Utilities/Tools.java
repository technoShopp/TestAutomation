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
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Tools {
	private static AppiumDriverLocalService service;
	private static AndroidDriver<AndroidElement> driver;
	
	//Make it run on Jenkins -----
	private static final String NODE_JS_PATH = "C:/Program Files/nodejs/node.exe";

	private static final String APPIUM_JS_PATH = "C:/Users/maliniv/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";
	//----
	
	public static AndroidDriver<AndroidElement> intializeDriver(DesiredCapabilities cap) throws Throwable
	{
		
	// 	driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap); for local execution, please invoke it
		//---- Just for jenkins
		driver =new AndroidDriver<AndroidElement>(service,cap);
		//--- just for jenkins
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
		// Make it run on jenkins  -----
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingDriverExecutable(new File(NODE_JS_PATH));
		builder.withAppiumJS(new File(APPIUM_JS_PATH));
		builder.usingAnyFreePort();
		//*****
		service=AppiumDriverLocalService.buildService(builder);
		System.out.println("******URL + PORT *****"+service.getUrl());
		
		String x= service.getUrl().toString();
		System.out.println("STRING : "+x);
		String a[]=x.split(":");
		String b[]=a[2].split("/");
		System.out.println("URL  : "+b[0]);
		int portUsed=Integer.parseInt(b[0]);
		System.out.println("PORT USED  : "+portUsed);
		//****
		//--------
		
		boolean serviceCheck=Utilities.Tools.checkIfServerIsRunning(portUsed);
		if(!serviceCheck)
		{
			//---- Make it work for Jenkins
			//**
		//	service=AppiumDriverLocalService.buildService(builder);
			//System.out.println("******URL + PORT *****"+service.getUrl());
			//**
			//-------
		//service=AppiumDriverLocalService.buildDefaultService(); for local execution please invoke this
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
