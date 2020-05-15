package tests;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass extends ExtentReportsEx{

	AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setup() {	
		try
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			String platform ="android";

			if(platform.equalsIgnoreCase("android"))
			{
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
				// or caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
				// or caps.setCapability("platformName", "ANDROID");
				caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
				// or caps.setCapability("platformVersion", "8.1.0");
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo 1716");
				// or caps.setCapability("deviceName", "vivo 1716");
				caps.setCapability(MobileCapabilityType.UDID, "46567834");
				// or caps.setCapability("udid", "46567834");
				caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
				caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

				//caps.setCapability(MobileCapabilityType.APP, "filepath of native app"); // for Native apllication
				//caps.setCapability("appPackage", "com.android.bbkcalculator");
				//caps.setCapability("appActivity", "com.android.bbkcalculator.Calculator");
			}

			URL url = new URL("http://127.0.0.0.1:4723/wd/hub"); // Appium server URL		
			driver = new AppiumDriver<MobileElement>(url,caps);
			//driver = new AndroidDriver<MobileElement>(url,caps);
			//driver = new IOSDriver<MobileElement>(url,caps);		

		}
		catch(Exception ex)
		{
			System.out.println("Cause is " +ex.getCause());
			System.out.println("Message is " +ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Test
	public void sampleTest()
	{
		System.out.println("Inside Sample Test");
	}

	@AfterSuite
	public void teardown() {	
		driver.close();
		driver.quit();
	}
}
