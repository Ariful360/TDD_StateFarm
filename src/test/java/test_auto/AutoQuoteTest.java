package test_auto;

import org.testng.annotations.Test;

import sfarm.tdd.base.BaseClass;

public class AutoQuoteTest extends BaseClass {

	@Test(enabled = false, groups = "auto")
	public void autoQuoteTest() throws InterruptedException {
		addressPage.validateHomePageTitle("Create an affordable price, just for you");
		addressPage.zipCode("11372");
		addressPage.clickStartAQuote();
		addressPage.clickContinueBtn();
		autoQuotePage.insertFirstName("Ariful");
		autoQuotePage.insertlasttName("Islam");
		autoQuotePage.insertAddress("1234 Woodside Ave");
		autoQuotePage.insertAptNumber("3A");
		autoQuotePage.insertDOB("12-12-1999");
		autoQuotePage.clickCheckBox();
		autoQuotePage.clicknextVehiclesBtn();

	}

}
