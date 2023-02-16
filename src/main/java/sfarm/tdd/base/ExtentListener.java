package sfarm.tdd.base;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.lang.reflect.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.dockerjava.api.model.Driver;

import sfarm.tdd.reporting.ExtentReporting;
import sfarm.tdd.reporting.ExtentTestManager;

public class ExtentListener {
	ExtentReports extentReports;
	ExtentTest test;

	
	@BeforeSuite
	public void initExtentReport() {
		extentReports = ExtentTestManager.initialExtentReport();
	}
	
	@BeforeMethod
	public void startExtentReport(Method method) {
		test = ExtentReporting.createTest(method.getName());
	}
	
	@AfterSuite
	public void closeReport() {
		extentReports.flush();
	}
	
	public String captureScreenShot(WebDriver driver) {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File folder = new File("screenShot");
		if (!folder.exists()) {
			//folder.
			
		}
		return "";
	}
	
	
	
	
	
	
	

}
