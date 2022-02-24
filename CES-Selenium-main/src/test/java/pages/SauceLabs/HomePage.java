package pages.SauceLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Common.BaseUtil;
import util.Common.SeleniumUtil;

public class HomePage  extends BaseUtil {

	SeleniumUtil selenium;
	WebDriver driver;

	public HomePage() {
		this.selenium = Selenium.get();
		this.driver = selenium.getDriver();
		selenium.waitPageLoad();
		PageFactory.initElements(driver, this);	
		
	}

	@FindBy(xpath="//span[@class='shopping_cart_badge']") 
	public WebElement Cart_item_count;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']") 
	public WebElement clickonCart;
	
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']")
	public WebElement AddCart;
	
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_large inventory_details_back_button']") 
	public WebElement Back;

	public HomePage AddProduct(String ProNam) {
		WebElement productName = selenium.findBy_LinkText(ProNam);
		selenium.scroll_XY(productName);
		selenium.sleep(1);
		selenium.jsClick(productName);
		selenium.Log(ProNam+" - Product Clicked");
		selenium.sleep(1);
		selenium.actionClick(AddCart);
		selenium.Log(ProNam+" - AddCart Button Clicked");
		selenium.sleep(1);
		selenium.actionClick(Back);
		selenium.Log(ProNam+" - Back Button Clicked");
		selenium.sleep(1);
		return this;

	}

	public int Check_Cart_item_count() {
		selenium.sleep(1);
		return selenium.StringToInt(Cart_item_count.getText());

	}

	public void clickonCart() {
		selenium.jsClick(clickonCart);

	}

}
