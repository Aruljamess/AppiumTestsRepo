package tests;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AppiumTest
{
	static AppiumDriver<MobileElement> driver;

	public static void main(String[] args)
	{
		try
		{
			openCalculator();
		} catch (Exception e)
		{
			System.out.println("GetCaues: "+e.getCause());
			System.out.println("GetMessage:"+e.getMessage());
			e.printStackTrace();
		}
	}

	public static void openCalculator() throws Exception
	{
		System.out.println("DesiredCapabilities setup");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "vivo 1716");
		cap.setCapability("udid", "5689c21a");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("appPackage", "com.android.bbkcalculator");
		cap.setCapability("appActivity", "com.android.bbkcalculator.Calculator");

		URL url = new URL("http://0.0.0.0:4723/wd/hub"); // URL of appium server
		driver = new AppiumDriver<MobileElement>(url, cap);
		System.out.println("Application Started.....");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// use uiautomatorviewer to find element id
		MobileElement two = driver.findElement(By.id("com.android.bbkcalculator:id/digit2"));
		MobileElement plus= driver.findElement(By.id("com.android.bbkcalculator:id/plus"));
		MobileElement three= driver.findElement(By.id("com.android.bbkcalculator:id/digit3"));
		MobileElement equals = driver.findElement(By.id("com.android.bbkcalculator:id/equal"));
		
		two.click();
		plus.click();
		three.click();
		equals .click();
		
		// to verify result press 2 , tab, press +, tab, press 3 , tab, press = , tab,  select result 5, copy class name attribute and paste 
		MobileElement results = driver.findElement(By.className("com.android.bbkcalculator:id/input_edit"));
				
		String res = results.getText();
		System.out.println("Results is :" +res);
	}

}
