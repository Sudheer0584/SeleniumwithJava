package testCase;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import util.Common.BaseUtil;
import util.Common.SeleniumUtil;

public class demo3 extends BaseUtil {
	
	@Test()
	public void saucedemo3() {
		String webURL ="https://www.saucedemo.com/";
		String AuthorName ="Vignesh";
		String TagName ="LoginTest";

		SeleniumUtil selenium = Selenium(webURL,AuthorName,TagName);
		WebElement Username = selenium.findBy_ID("user-name");
		WebElement password = selenium.findBy_ID("password");
		WebElement loginbutton = selenium.findBy_ID("login-button");
		
		selenium.type(Username, "standard_use");
		selenium.type(password, "secret_sauce");
		selenium.click(loginbutton);
		selenium.pageScreenShot();

		selenium.Log("Direct Login not successfully");
		selenium.sleep(5);

		selenium.clear(Username);
		selenium.type(Username, "standard_user");
		selenium.click(loginbutton);
		selenium.pageScreenShot();
		selenium.sleep(5);
		selenium.Log("Direct Login successfully");


		
	}

}
