package util.Capability;

import java.io.File;

import org.testng.ITestResult;

import util.Common.BaseUtil;
import util.Data.PropertiesUtil;
import util.Report.ExtentReportUtil;
import util.Report.ScreenShotUtil;

public class ClassInitUtil extends BaseUtil {

	public void BeforeSuite() {
		System.out.println("\n===============================================\n\nTest Suite Started\n\n===============================================");
		pathUtil= new PathUtil();
		dirCheck();
		exUtil = new ExtentReportUtil();
		shotUtil = new ScreenShotUtil();
		PropertiesUtil propUtil = new PropertiesUtil("browser.properties");
		BrowserName = propUtil.getValue("BrowserName").toLowerCase();
		waitTime = Integer.parseInt(propUtil.getValue("waitTime"));
    	shotUtil.cleanFolders();
    	exUtil.StartExtentReport();
    	
	}
	
	public void AfterMethod(ITestResult result,String testType) {
		if(result.getStatus() == ITestResult.FAILURE){
			shotUtil.ExtentFailShot(Selenium.get().driver, result, exUtil.getTestThread());
		}
		else if(result.getStatus() == ITestResult.SKIP){
			shotUtil.ExtentSkipShot(Selenium.get().driver, result, exUtil.getTestThread());
		} 

		if (testType.equalsIgnoreCase("Selenium")) {
			drUtil.quitDriver();
			Selenium.remove();
			exUtil.removeThread();
		}
		else if(testType.equalsIgnoreCase("RestAPI")) {
			RestAPI.remove();
			exUtil.removeThread();
		}else {
			System.out.println("testType is Wrong : "+testType);
		}
	}
	
	public void AfterSuite() {
		exUtil.EndExtentReport();
		System.out.println("\n===============================================\n\nTest Suite Completed");
	}
	
	public void dirCheck() {
		File propFile = new File (pathUtil.getFileinResources("Properties"));
		if(!propFile.isDirectory()) {
			propFile.mkdir();
		}
		
		File testDataFile = new File (pathUtil.getFileinResources("TestData"));
		if(!testDataFile.isDirectory()) {
			testDataFile.mkdir();
		}
		
		File reportscreenshotFile = new File (pathUtil.getFileinClassPathRoot("Report-ScreenShot"));
		if(!reportscreenshotFile.isDirectory()) {
			reportscreenshotFile.mkdir();
		}
		
		File screenshotFile = new File (reportscreenshotFile.getAbsolutePath()+"/ScreenShots");
		if(!screenshotFile.isDirectory()) {
			screenshotFile.mkdir();
		}
		
		File screenshotPassedFile = new File (screenshotFile.getAbsolutePath()+"/Passed");
		if(!screenshotPassedFile.isDirectory()) {
			screenshotPassedFile.mkdir();
		}
		
		File screenshotFailedFile = new File (screenshotFile.getAbsolutePath()+"/Failed");
		if(!screenshotFailedFile.isDirectory()) {
			screenshotFailedFile.mkdir();
		}
		
		File screenshotSkippedFile = new File (screenshotFile.getAbsolutePath()+"/Skipped");
		if(!screenshotSkippedFile.isDirectory()) {
			screenshotSkippedFile.mkdir();
		}
		
	}
}
