package pages.SauceLabs;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Common.BaseUtil;
import util.Common.SeleniumUtil;

public class CartPage extends BaseUtil {
	SeleniumUtil selenium;
	WebDriver driver;
	
	public CartPage() {
		this.selenium = Selenium.get();
		this.driver = selenium.getDriver();
		selenium.waitPageLoad();
		PageFactory.initElements(driver, this);	
	}


	@FindBy(xpath="//button[@id='checkout']") 
	WebElement clickoncheckout;
	@FindBy(xpath="//button[@class='btn btn_secondary btn_small btn_inventory']") 
	WebElement RemoveCart;
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_large inventory_details_back_button']") 
	WebElement Back;
	@FindBy(xpath="//*[contains(@class,'cart_quantity')]") 
	List<WebElement> count;
	
	public void QTYcounitem(int itemcount) {
		
		for (int i =1; i<=itemcount;i++)
		{
			selenium.Log("Item "+i+" Qty : "+count.get(i).getText());
		}

	}

	public void removeProduct(String ProNam) {
		selenium.jsClick(selenium.findBy_LinkText(ProNam));
		selenium.jsClick(RemoveCart);
		selenium.jsClick(Back);

		
	}

	public void clickCheckout() {
		selenium.jsClick(clickoncheckout);
		
	}

}
