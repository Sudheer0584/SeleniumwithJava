package pages.SauceLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Common.BaseUtil;
import util.Common.SeleniumUtil;

public class CheckoutInform  extends BaseUtil{
	
	SeleniumUtil selenium;
	WebDriver driver;
	
	public CheckoutInform() {
		this.selenium = Selenium.get();
		this.driver = selenium.getDriver();
		selenium.waitPageLoad();
		PageFactory.initElements(driver, this);	
		}
	
	@FindBy(id="first-name") 
	WebElement firstname;
	@FindBy(id="last-name") 
	WebElement lastname;
	@FindBy(id="postal-code") 
	WebElement postalcode;
	@FindBy(xpath="//input[@id='continue']") 
	WebElement ClickContinue;
	
	public void EnterFirstName(String Fname) {
		selenium.type(firstname,Fname);

	}
	public void EnterLastName(String Lname) {
		selenium.type(lastname,Lname);

	}
	public void EnterZipCode(String Zipcode) {
		selenium.type(postalcode,Zipcode);

	}
	
	public void ClickContinue() {
		selenium.jsClick(ClickContinue);
	}
	
}
