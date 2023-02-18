package test_auto;

import org.testng.annotations.Test;

import sfarm.tdd.base.BaseClass;

public class RentersQuotetest extends BaseClass {

	@Test(enabled = false, groups = "renters")
	public void renterQuoteTest() throws InterruptedException {
		addressPage.validateHomePageTitle("Create an affordable price, just for you");
		addressPage.dropdn("Renters");
		addressPage.zipCode("11372");
		Thread.sleep(3000);
		addressPage.clickStartAQuote();
		renterQuotePage.addressInput("1234 woodside ave ");
		renterQuotePage.aptNumberInput("3A");
		renterQuotePage.clickContinueBtn();

	}

}
