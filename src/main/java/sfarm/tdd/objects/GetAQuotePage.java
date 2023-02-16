package sfarm.tdd.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GetAQuotePage {
	
	@FindBy(id = "oneX-sf-logo-mobile")
	WebElement pageLogo;
	@FindBy(xpath = "//input[@id='quote-main-zip-code-input’]")
	WebElement zipCode;
	@FindBy(id = "quote-main-zip-btn")
	WebElement startAQuote;
	@FindBy(id = "nyLegacyCloseLinkId")
	WebElement continueBtn;
	
	public void validatePageLogo() {
		
	}

}
