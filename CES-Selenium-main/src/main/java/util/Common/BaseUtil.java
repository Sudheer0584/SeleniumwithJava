package util.Common;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import util.Capability.DriverUtil;
import util.Capability.ClassInitUtil;
import util.Capability.PathUtil;
import util.Data.TextUtil;
import util.Report.ExtentReportUtil;
import util.Report.ScreenShotUtil;

public class BaseUtil {
	
	protected static ClassInitUtil classUtil;
	protected static PathUtil pathUtil;
	protected static ExtentReportUtil exUtil;
	protected static TextUtil textUtil;
	protected static DriverUtil drUtil;
	protected static ScreenShotUtil shotUtil;
	protected static String BrowserName;
	protected static int waitTime;

	
	protected static ThreadLocal<String> testType = new ThreadLocal<String>();
	
	protected static ThreadLocal<SeleniumUtil> Selenium = new ThreadLocal<SeleniumUtil>();
	protected static SeleniumUtil Selenium(String webURL,String AuthorName, String TagName) {
 		exUtil.StartExtentTest(Reporter.getCurrentTestResult().getName(),AuthorName,TagName);
		testType.set("Selenium");
		drUtil = new DriverUtil();
		Selenium.set(new SeleniumUtil(drUtil.getDriver(),exUtil.getTestThread(),BrowserName,webURL,waitTime));
		return Selenium.get();
	}
	
	protected static SeleniumUtil Selenium(String webURL) {
 		exUtil.StartExtentTest(Reporter.getCurrentTestResult().getName());
		testType.set("Selenium");
		drUtil = new DriverUtil();
		Selenium.set(new SeleniumUtil(drUtil.getDriver(),exUtil.getTestThread(),BrowserName,webURL,waitTime));
		return Selenium.get();
	}

	protected static ThreadLocal<RestAPIUtil> RestAPI = new ThreadLocal<RestAPIUtil>();
	protected static RestAPIUtil RestAPI(String baseURI,String AuthorName, String TagName) {
 		exUtil.StartExtentTest(Reporter.getCurrentTestResult().getName(),AuthorName,TagName);
		testType.set("RestAPI");
		RestAPI.set(new RestAPIUtil(baseURI,exUtil.getTestThread()));
		return RestAPI.get();
	}
	
	protected static RestAPIUtil RestAPI(String baseURI) {
 		exUtil.StartExtentTest(Reporter.getCurrentTestResult().getName());
		testType.set("RestAPI");
		RestAPI.set(new RestAPIUtil(baseURI,exUtil.getTestThread()));
		return RestAPI.get();
	}
	
	
	@BeforeSuite(alwaysRun = true)
	public void initialize() {
		classUtil = new ClassInitUtil();
		classUtil.BeforeSuite();
	}

	@AfterMethod(alwaysRun = true)
	public void quitBrowser(ITestResult result) {
		classUtil.AfterMethod(result,testType.get());
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		classUtil.AfterSuite();
	}

}
