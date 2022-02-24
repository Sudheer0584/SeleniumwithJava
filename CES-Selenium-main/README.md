# Automation Framework
##### Java-Selenium-RestAssured-TestNG-ExtentReport-Framework
##### Author : Vignesh Dhakshnamoorthy



## For API Automation

```
public class demo extends BaseUtil {

	@Test
	public void demoAPI() {
		String baseURI ="https://reqres.in/";
		String AuthorName ="Dhakshna";
		String TagName ="getUserTest";

		RestAPIUtil restAPI= RestAPI(baseURI,AuthorName,TagName);
		restAPI.Log( restAPI.getStatusCode() );
    }

}
```
#### Helper Methods : API

```
restAPI.getStatusCode
restAPI.getBody
restAPI.getMethodName
restAPI.Log
restAPI.logC
restAPI.logE
restAPI.IntToString
restAPI.StringToInt
restAPI.StringEquals
restAPI.Today
restAPI.Yesterday
restAPI.Tomorrow
restAPI.localDate
restAPI.toCharArray
restAPI.getRandom
```

## For Web Automation

#### PageObject
```
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

	public  HomePage Login() {
		selenium.type(Username, "standard_user");
		selenium.type(password, "secret_sauce");
		selenium.click(loginbutton);
		return new HomePage();
	}
```

#### TestCase
```
public class demo extends BaseUtil {

	@Test
	public void demoWEB() {
		String webURL ="https://www.saucedemo.com/";
		String AuthorName ="Vignesh";
		String TagName ="Login Test";

		SeleniumUtil selenium = Selenium(webURL,AuthorName,TagName);
		
		HomePage HomePage = new LoginPage().Login();
		selenium.Log("Logged in successfully");
    }

}
```

#### Helper Methods : Web

```
selenium.Log
selenium.logC
selenium.logE
selenium.logList
selenium.logListString
selenium.logCList
selenium.logCListString
selenium.logEList
selenium.logEListString

selenium.findBy_ClassName
selenium.findBy_CssSelector
selenium.findBy_ID
selenium.findBy_LinkText
selenium.findBy_Name
selenium.findBy_PartialLinkText
selenium.findBy_Xpath

selenium.findAll_ClassName
selenium.findAll_CssSelector
selenium.findAll_ID
selenium.findAll_LinkText
selenium.findAll_Name
selenium.findAll_PartialLinkText
selenium.findAll_Xpath

selenium.getElement
selenium.getElements
selenium.getList

selenium.click
selenium.type
selenium.back
selenium.clear
selenium.clickList
selenium.clickSleep
selenium.forward
selenium.getAttribute
selenium.getCurrentUrl
selenium.getDriver
selenium.getLocation
selenium.getMethodName
selenium.getPageSource
selenium.getText
selenium.getTitle
selenium.isDisplayed
selenium.isEnabled
selenium.isSelected
selenium.maximize
selenium.minimize
selenium.navigateTo
selenium.refresh
selenium.screenHeight
selenium.screenWidth
selenium.windowDimension

selenium.getDropDownSelectValue
selenium.selectDropDown

selenium.sleep
selenium.sleepMilliSeconds
selenium.waitDisplayed
selenium.waitEnabled
selenium.waitil_Alert
selenium.waitil_Click
selenium.waitPageLoad
selenium.waitSelected

selenium.elementScreenShot
selenium.pageScreenShot

selenium.defaultFrame
selenium.parentFrame
selenium.switchFrame
selenium.getTabs
selenium.switchTab
selenium.countTabs
selenium.currentTab

selenium.acceptAlert
selenium.dismissAlert
selenium.getAlert
selenium.textAlert
selenium.typeAlert

selenium.jsClick
selenium.jsType
selenium.scroll_XY
selenium.scrollTo
selenium.executeScript

selenium.actionClick
selenium.actionDOWN
selenium.actionENTER
selenium.actionESCAPE
selenium.actionLEFT
selenium.actionRETURN
selenium.actionRIGHT
selenium.actionTAB
selenium.actionType
selenium.actionUP
selenium.contextClick
selenium.doubleClick
selenium.dragAndDrop

selenium.mouseLeftClick
selenium.mouseMove
selenium.mouseRightClick
selenium.moveTo
selenium.robotBACKSPACE
selenium.robotCOPY
selenium.robotCUT
selenium.robotDOWN
selenium.robotENTER
selenium.robotESCAPE
selenium.robotLEFT
selenium.robotPASTE
selenium.robotRIGHT
selenium.robotSELECT
selenium.robotTAB
selenium.robotUP

selenium.countList
selenium.compare
selenium.IntToString
selenium.getRandom
selenium.localDate
selenium.listContains
selenium.StringEquals
selenium.StringToInt
selenium.toCharArray
selenium.Today
selenium.Tomorrow
selenium.Yesterday
```


