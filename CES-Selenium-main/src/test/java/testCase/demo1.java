package testCase;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SauceLabs.HomePage;
import pages.SauceLabs.LoginPage;
import util.Common.BaseUtil;
import util.Common.SeleniumUtil;


public class demo1 extends BaseUtil{
	
	@Test
	public void saucedemo1() {
		String webURL ="https://www.saucedemo.com/";
		String AuthorName ="Vignesh";
		String TagName ="ProductAddTest";

		SeleniumUtil selenium = Selenium(webURL,AuthorName,TagName);
		
		HomePage HomePage = new LoginPage().Login();

		int check_Cart_item_count = HomePage.AddProduct("Sauce Labs Onesie").Check_Cart_item_count();
		selenium.Log(Integer.toString(check_Cart_item_count));
		selenium.elementScreenShot(HomePage.Cart_item_count);

		check_Cart_item_count = HomePage.AddProduct("Sauce Labs Backpack").Check_Cart_item_count();
		selenium.Log(selenium.IntToString(check_Cart_item_count));
		selenium.pageScreenShot();
		Assert.assertTrue(true);
		
	}
	
	
	@Test
	public void saucedemo2() {
		String webURL ="https://www.saucedemo.com/";
		String AuthorName ="Dhakshna";
		String TagName ="ProductAddTest";

		SeleniumUtil selenium = Selenium(webURL,AuthorName,TagName);
		
		HomePage HomePage = new LoginPage().Login();

		int check_Cart_item_count = HomePage.AddProduct("Sauce Labs Backpack").Check_Cart_item_count();
		selenium.Log(Integer.toString(check_Cart_item_count));
		selenium.elementScreenShot(HomePage.Cart_item_count);

		check_Cart_item_count = HomePage.AddProduct("Sauce Labs Onesie").Check_Cart_item_count();
		selenium.Log(selenium.IntToString(check_Cart_item_count));
		Assert.assertTrue(false);
		
	}
	
	
}