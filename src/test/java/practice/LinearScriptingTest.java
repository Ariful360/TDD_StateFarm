package practice;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LinearScriptingTest  {

	WebDriver driver;

	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.statefarm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@Test(enabled = false)
	public void linearScriptingTest() {
		WebElement login = driver.findElement(By.xpath("//span[text()='Log in']"));
		login.click();
	}
	@Test(enabled = false)
	public void linearScriptingTest1() {
		WebElement insurencebtn = driver.findElement(By.xpath("//span[text()='Insurance']"));
		insurencebtn.click();
	}
	@Test(enabled = false)
	public void findAgentTest() {
		WebElement findAgent = driver.findElement(By.xpath("//span[text()='Find an Agent']"));
		findAgent.click();
	}
	
	@Test(enabled = true)
	public void searchBoxTest() {
		WebElement searchBox = driver.findElement(By.xpath("div.-oneX-util-menu-icon.-oneX-util-menu-icon-search"));
		searchBox.click();
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
}
