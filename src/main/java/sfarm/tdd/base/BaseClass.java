package sfarm.tdd.base;

import static sfarm.tdd.utils.IConstant.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.github.dockerjava.api.model.Driver;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfarm.tdd.objects.LandingPage;
import sfarm.tdd.reporting.ExtentReporting;
import sfarm.tdd.reporting.ExtentTestManager;
import sfarm.tdd.utils.Constant;
import sfarm.tdd.utils.ReadProperties;

public class BaseClass extends ExtentListener{
	protected WebDriver driver;
	public LandingPage landingPage;
	ReadProperties envVar = new ReadProperties();
	

	//@Parameters("browser")
	
	@BeforeMethod
	public void setUpDriver() {
		String browser = envVar.getProperties(BROWSER);
		String url = envVar.getProperties(URL);
		//driver.get(envVar.getProperties(URL));
		long pageLoadWait = envVar.getNumProperties(PAGELOAD_WAIT);
		long implicitWait=envVar.getNumProperties(IMPLICITLY_WAIT);
		//long explicitWait=envVar.getNumProperty(EXPLICITLY_WAIT);
		initDriver(browser);
		initClasses(driver);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
				
	}
	
	private void initClasses(WebDriver driver) {
		landingPage = new LandingPage(driver);
		
	}
	
	
	private void initDriver(String driverName) {
		switch (driverName) {
		
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
	}
	
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, PASSED);
		}else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, FAILED);
		}else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, SKIPPED);
		}
	}
	
	@SuppressWarnings("unused")
	private String getString(Constant constant){
		return constant.name();
	}
}
