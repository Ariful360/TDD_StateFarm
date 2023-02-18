package test_auto;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sfarm.tdd.base.BaseClass;
import sfarm.tdd.utils.AutoData;

public class ParameterizedTest extends BaseClass {

	@Parameters({ "homePageTitle", "zipCode", "firstName", "lastName", "address", "aptNum", "DOB" })
	@Test(enabled = false)
	public void autoQuoteTest(String homePageTitle, String zipCode, String firstName, String lastName, String address,
			String aptNum, String DOB) throws InterruptedException {
		addressPage.validateHomePageTitle(homePageTitle);
		addressPage.zipCode(zipCode);
		addressPage.clickStartAQuote();
		addressPage.clickContinueBtn();
		autoQuotePage.insertFirstName(firstName);
		autoQuotePage.insertlasttName(lastName);
		autoQuotePage.insertAddress(address);
		autoQuotePage.insertAptNumber(aptNum);
		autoQuotePage.insertDOB(DOB);
		autoQuotePage.clickCheckBox();
		autoQuotePage.clicknextVehiclesBtn();

	}

	@Parameters({ "homePageTitle", "zipCode", "firstName", "lastName" })
	@Test(enabled = true)
	public void autoDataTest(String homePageTitle, String zipCode, String firstName, String lastName)
			throws InterruptedException {
		AutoData data = new AutoData(homePageTitle, zipCode, firstName, lastName);
		addressPage.validateHomePageTitle(data.getHomePageTitle());
		addressPage.zipCode(data.getZipCode());
		addressPage.clickStartAQuote();
		addressPage.clickContinueBtn();
		autoQuotePage.insertFirstName(data.getFirstName());
		autoQuotePage.insertlasttName(data.getLastName());
	}

}
