package sfarm.tdd.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import sfarm.tdd.reporting.ExtentReporting;
import sfarm.tdd.reporting.ExtentTestManager;
import sfarm.tdd.reporting.Logs;

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

	String captureScreenShot(WebDriver driver) {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File folder = new File("screenShot");
		folder.mkdirs();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM:dd:YYYY_HH:mm:ss");
		String dateTime = dateFormat.format(date);
		File ssLocation = new File(folder + "/" + dateTime + "png");
		File sourceFile = ss.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(sourceFile, ssLocation);
			Logs.log("--->Screen has been capture");
		} catch (IOException e) {
			Logs.log("---->Failed to capture screenshot at : " + ssLocation.getAbsolutePath());
			e.printStackTrace();
		}
		return ssLocation.getAbsolutePath();
	}

}
