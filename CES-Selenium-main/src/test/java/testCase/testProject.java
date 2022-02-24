package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import io.testproject.sdk.drivers.web.ChromeDriver;

public class testProject {
	public static void main(String[] args) throws Exception {
	      ChromeDriver driver = new ChromeDriver ("YOUR_DEV_TOKEN", new ChromeOptions());
	        driver.navigate ().to ("https://www.softwaretestingmaterial.com");
	        //identify an element and input text to that field
	        driver.findElement (By.cssSelector ("#form-field-name")).sendKeys ("P");
	        // verify the email edit box is displayed
	        //Thread.sleep(20000);
	        boolean r = driver.findElement(By.id("form-field-email")).isDisplayed ();
	        // checking the test case passed condition
	        if (r) {
	            System.out.println ("Test Case has passed");
	        } else {
	            System.out.println ("Test Case has failed");
	        }
	        driver.quit ();
	    }
	
	}

