package test_auto;

import org.testng.annotations.Test;

import sfarm.tdd.base.BaseClass;

public class AutoQuoteTest extends BaseClass{

	@Test
	public void autoTest() throws InterruptedException {
		landingPage.clickLoginBtn();
		landingPage.insertUserId("ariful123");
		landingPage.insertPassword("03223451");
		landingPage.clickRememberMeBox();
		landingPage.clickLoginBtn02();
		
	}
}
