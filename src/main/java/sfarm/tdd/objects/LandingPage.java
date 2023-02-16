package sfarm.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static sfarm.tdd.common.CommonActions.*;
import sfarm.tdd.base.BaseClass;

public class LandingPage extends BaseClass {

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "oneX-sf-logo-mobile")
	WebElement pageLogo;

	@FindBy(id = "//span[text()='Log in']")
	WebElement loginBtn;
	@FindBy(name = "IDToken1")
	WebElement userId;
	@FindBy(name = "IDToken2")
	WebElement password;
	@FindBy(className = "-oneX-login-remember-me-label")
	WebElement rememberMeBox;
	@FindBy(css = "button.-oneX-util-login-button.-oneX-btn-primary.-oneX-btn-fit-content")
	WebElement loginBtn02;
	

	public void validatePageLogo(String expectedLogo) throws InterruptedException {
		validate(pageLogo, expectedLogo);
		Thread.sleep(3000);
	}
	
	public void clickLoginBtn() throws InterruptedException {
		click(loginBtn);
		Thread.sleep(3000);
	}

	public void insertUserId(String userID) throws InterruptedException {
		insert(userId, userID);
		Thread.sleep(3000);
	}
	public void insertPassword(String passWord) throws InterruptedException {
		insert(password, passWord);
		Thread.sleep(3000);
	}
	public void clickRememberMeBox() throws InterruptedException {
		clickRememberMeBox();
		Thread.sleep(3000);
	}
	public void clickLoginBtn02() throws InterruptedException {
		click(loginBtn);
		Thread.sleep(3000);
		
	}

}
