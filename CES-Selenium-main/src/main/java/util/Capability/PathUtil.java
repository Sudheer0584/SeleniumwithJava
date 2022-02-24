package util.Capability;

import java.io.File;

public class PathUtil  {
	public File classPathRoot = new File(System.getProperty("user.dir"));
	public File resourcesRoot = new File(classPathRoot,"src/test/resources");
	public File rsRoot = new File(classPathRoot,"Report-ScreenShot");
	public File testoutputRoot = new File(classPathRoot,"test-output");

	public String getFileinResources(String filePath) {
		File resourcesFile= new File(resourcesRoot,filePath);
		return resourcesFile.getAbsolutePath();
	}
	
	public String getFileinClassPathRoot(String filePath) {
		File classPathRootFile= new File(classPathRoot,filePath);
		return classPathRootFile.getAbsolutePath();
	}
	
	public String getFileinReportScreenshot(String filePath) {
		File reportScreenshotFile= new File(rsRoot,filePath);
		return reportScreenshotFile.getAbsolutePath();
	}
	
	public String getAppPath(String AppName){
		File app= new File(resourcesRoot,"APK/"+AppName);
		return app.getAbsolutePath();

	}
	
	public String getPropertyPath(String PropertyName){
		File property= new File(resourcesRoot,"Properties/"+PropertyName);
		return property.getAbsolutePath();

	}
	
	public String getTestDataPath(String DataName){
		File excel= new File(resourcesRoot,"TestData/"+DataName);
		return excel.getAbsolutePath();

	}
	

	public String getDriverPath(String browser){
		File browserdriver= new File(resourcesRoot,"WebDriver/"+browser);
		return browserdriver.getAbsolutePath();

	}
	
	public String getExtentReportPath(String reportName) {
		File extentReport= new File(rsRoot,"ExtentReport/"+reportName);
		return extentReport.getAbsolutePath();

	}
	
	public String getScreenshotPath(String imageName) {
		File screenShot= new File(rsRoot,"ScreenShots/"+imageName);
		return screenShot.getAbsolutePath();

	}
	
	public String getScreenshotPathPASS(String imageName) {
		File screenShot= new File(rsRoot,"ScreenShots/Passed/"+imageName);
		return screenShot.getAbsolutePath();

	}
	
	public String getScreenshotPathFAIL(String imageName) {
		File screenShot= new File(rsRoot,"ScreenShots/Failed/"+imageName);
		return screenShot.getAbsolutePath();

	}
	
	public String getScreenshotPathSKIP(String imageName) {
		File screenShot= new File(rsRoot,"ScreenShots/Skipped/"+imageName);
		return screenShot.getAbsolutePath();

	}
	
	public String getLoggerPath(String logName) {
		File screenShot= new File(rsRoot,"Logs/"+logName);
		return screenShot.getAbsolutePath();

	}
	
}
