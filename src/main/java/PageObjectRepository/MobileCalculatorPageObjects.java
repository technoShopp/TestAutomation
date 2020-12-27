package PageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MobileCalculatorPageObjects {

	@AndroidFindBy(className="android.widget.Button")
	private List<WebElement> ElementNumbers;
	

	@AndroidFindBy(id="com.sec.android.app.popupcalculator:id/calc_edt_formula")
	private WebElement ElementTextDisplay;

	
	public MobileCalculatorPageObjects(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}


	public List<WebElement> getElementNumbers() {
		return ElementNumbers;
	}



	public WebElement getElementTextDisplay() {
		return ElementTextDisplay;
	}


	}
	
	
	

