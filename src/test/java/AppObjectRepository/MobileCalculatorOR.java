package AppObjectRepository;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.Config;

public class MobileCalculatorOR extends Config {
	
	
	
	private AndroidElement a=driverApp.findElementsByClassName("android.widget.Button").get(12);
	private AndroidElement b=	driverApp.findElementsByClassName("android.widget.Button").get(13);
	private AndroidElement c=	driverApp.findElementsByClassName("android.widget.Button").get(14);
	private AndroidElement gEle=	driverApp.findElementById("com.sec.android.app.popupcalculator:id/calc_edt_formula");
	private AndroidElement operator=	driverApp.findElementsByClassName("android.widget.Button").get(15);
	private AndroidElement d=	driverApp.findElementsByClassName("android.widget.Button").get(8);
	private AndroidElement e=driverApp.findElementsByClassName("android.widget.Button").get(9);
	private AndroidElement f=	driverApp.findElementsByClassName("android.widget.Button").get(10);
	private AndroidElement equalTo=	driverApp.findElementsByClassName("android.widget.Button").get(19);
	
	public AndroidElement getA() {
		return a;
	}
	
	public AndroidElement getB() {
		return b;
	}
	
	public AndroidElement getC() {
		return c;
	}
	
	public AndroidElement getgEle() {
		return gEle;
	}
	
	public AndroidElement getOperator() {
		return operator;
	}
	
	public AndroidElement getD() {
		return d;
	}
	
	public AndroidElement getE() {
		return e;
	}
	
	public AndroidElement getF() {
		return f;
	}
	
	public AndroidElement getEqualTo() {
		return equalTo;
	}
	


	
	
	
	
	
	
}
