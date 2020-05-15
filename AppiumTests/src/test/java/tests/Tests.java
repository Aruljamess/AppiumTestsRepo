package tests;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Tests extends BaseClass{
	
	@Test
	public void testOne() {
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("testOne", "testOne description");
        
        test.log(Status.INFO, "testOne is started)");
		driver.get("www.google.com");
		test.log(Status.PASS, "Navigated to testOne)");
		driver.findElement(By.name("q")).sendKeys("Aruljames");
		test.log(Status.PASS, "Entered Aruljames)");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		test.log(Status.PASS, "Hit Keyboard Enter key)");
		System.out.println("completed");
		test.log(Status.INFO, "testOne is completed)");
	}
	
	@Test(priority=1) // it will execute first 
	  public void testLogin() throws Exception {
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    driver.findElement(By.xpath("//div[@id='divUsername']/span")).click();
	    driver.findElement(By.id("txtUsername")).clear();
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.id("txtPassword")).click();
	    driver.findElement(By.id("txtPassword")).clear();
	    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	    driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
		 for (int second = 0;; second++) {
		    	if (second >= 60) fail("timeout"); // import assert fail 
		    	try { if (isElementPresent(By.id("btnLogin"))) break; } catch (Exception e) {}
		    	Thread.sleep(1000);
		    }
	    //driver.findElement(By.id("btnLogin")).click();
	    driver.findElement(By.id("welcome")).click();
	    driver.findElement(By.linkText("Logout")).click(); 
	  }
	
	private boolean isElementPresent(By by) {
	    try {
			driver.findElement(by);
			return true;
	    } catch (NoSuchElementException e) {
			return false;
	    }
	  }

}
