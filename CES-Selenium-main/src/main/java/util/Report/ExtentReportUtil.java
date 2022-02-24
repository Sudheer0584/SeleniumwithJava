package util.Report;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import util.Common.BaseUtil;

public class ExtentReportUtil extends BaseUtil{
	ExtentReports Ereport;
	ExtentSparkReporter Espark;
	
	public void StartExtentReport() {
		Ereport = new ExtentReports();
		File extentReportRoot = new File(pathUtil.getExtentReportPath("ExtentReport.html"));
		Espark = new ExtentSparkReporter(extentReportRoot.getAbsolutePath());
		Espark.config().setDocumentTitle(java.time.LocalDate.now().toString());
		Espark.config().setTimelineEnabled(false);
		Espark.config().setEncoding("utf-8");
		Espark.config().setTimeStampFormat("dd MMM yyyy hh:mm:ss a");
		Ereport.attachReporter(Espark);
	}
	
	ThreadLocal<ExtentTest> testThread = new ThreadLocal<ExtentTest>();

	public ExtentTest getTestThread() {
		return testThread.get();
	}
	
	public void StartExtentTest(String TestName, String AuthorName, String TagName) {
		testThread.set(Ereport.createTest(TestName).assignAuthor(AuthorName).assignCategory(TagName));
	}
	public void StartExtentTest(String TestName) {
		testThread.set(Ereport.createTest(TestName));
	}
	  public void removeThread() {
		  testThread.remove();
	   }
	
	public void EndExtentReport() {
		Ereport.flush();
	}
	
	}
