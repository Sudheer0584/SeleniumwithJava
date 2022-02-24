package pages.SauceLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Common.BaseUtil;
import util.Common.SeleniumUtil;

public class LoginPage  extends BaseUtil{
	
	SeleniumUtil selenium;
	WebDriver driver;
	
	public LoginPage() {
		this.selenium = Selenium.get();
		this.driver = selenium.getDriver();
		selenium.waitPageLoad();
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="user-name") private WebElement Username;
	@FindBy(id="password") private WebElement password;
	@FindBy(id="login-button") private WebElement loginbutton;

	public  LoginPage Login(String UserNa, String UserPas) {
		selenium.type(Username, UserNa);
		selenium.type(password, UserPas);
		selenium.click(loginbutton);
		selenium.Log("Login Failed");
		return this;

	}
	
	public  HomePage Login() {
		selenium.type(Username, "standard_user");
		selenium.type(password, "secret_sauce");
		selenium.click(loginbutton);
		selenium.Log("Direct Login successfully");
		return new HomePage();

	}
	

}
