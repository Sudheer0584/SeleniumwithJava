package util.Report;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import util.Common.BaseUtil;

public class ScreenShotUtil extends BaseUtil{

	public void ExtentFailShot(WebDriver ScDriver,ITestResult result, ExtentTest Exetest) {
		String Time = new java.util.Date().getTime()+"";
		
		File screenShotLocation = new File(pathUtil.getScreenshotPathFAIL(result.getName()+"-"+Time+".png"));
		try {
			File screenShot  = ((TakesScreenshot)ScDriver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenShot, screenShotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Exetest.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenShotLocation.getAbsolutePath()).build());
		Exetest.fail(result.getThrowable());

	}
	
	public void ExtentSkipShot(WebDriver ScDriver,ITestResult result, ExtentTest Exetest) {
		String Time = new java.util.Date().getTime()+"";

		File screenShotLocation = new File(pathUtil.getScreenshotPathSKIP(result.getName()+"-"+Time+".png"));
		try {
			File screenShot  = ((TakesScreenshot)ScDriver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenShot, screenShotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Exetest.skip(MediaEntityBuilder.createScreenCaptureFromPath(screenShotLocation.getAbsolutePath()).build());
		Exetest.skip(result.getThrowable());

	}
	
	public void ExtentPassShot(WebDriver ScDriver, ExtentTest Exetest, String tstName) {
		String Time = new java.util.Date().getTime()+"";

		File screenShotLocation = new File(pathUtil.getScreenshotPathPASS(tstName+"-"+Time+".png"));
		try {
			File screenShot  = ((TakesScreenshot)ScDriver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenShot, screenShotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Exetest.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenShotLocation.getAbsolutePath()).build());

	}
	
	public void ExtentElementShot(WebElement ele, ExtentTest Exetest, String tstName) {
		String Time = new java.util.Date().getTime()+"";

		File screenShotLocation = new File(pathUtil.getScreenshotPathPASS(tstName+"-Element-"+ele.getText()+"-"+Time+".png"));
		try {
			File screenShot  = ((TakesScreenshot)ele).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenShot, screenShotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Exetest.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenShotLocation.getAbsolutePath()).build());

	}
	
	
    public void deleteReportScreenShot() {
			File mainFolder = new File(pathUtil.rsRoot.toString());
			 File[] files = mainFolder.listFiles();
			 if(files!=null) { 
			        for(File f: files) {
			            if(f.isDirectory()) {
			                deleteFolder(f);
			            } else {
			                f.delete();
			            }
			        }
			    }
		}
		
		public void deleteFolder(File folder) {
			File[] files = folder.listFiles();
		    if(files!=null) {
		        for(File f: files) {
		            if(f.isDirectory()) {
		                deleteFolder(f);
		            } else {
		                f.delete();
		            }
		        }
		    }
			}
		
		public void deleteTestOutput() {
			File mainFolder = new File(pathUtil.testoutputRoot.toString());
			 File[] files = mainFolder.listFiles();
			 if(files!=null) { 
			        for(File f: files) {
			            if(f.isDirectory()) {
			                deleteFolder(f);
			            } else {
			                f.delete();
			            }
			        }
			    }
		}
		
		public void cleanFolders() {
			deleteReportScreenShot();
			deleteTestOutput();
		}
	
}
