package test_auto;

import org.testng.Assert;
import org.testng.annotations.Test;

import sfarm.tdd.base.BaseClass;
import sfarm.tdd.reporting.Logs;

public class LoginPageTest extends BaseClass {
	

	@Test(enabled = false, priority = 1)
	public void autoTest() throws InterruptedException {
		landingPage.clickLoginBtn();
		landingPage.insertUserId("ariful123");
		landingPage.insertPassword("03223451");
		landingPage.clickRememberMeBox();
		landingPage.clickLoginBtn02();
	}

	@Test(enabled = false, retryAnalyzer = sfarm.tdd.retry.RetryFailedTests.class)
	public void retry01() throws InterruptedException {
		Logs.log("retryTest");
		Assert.fail();

	}

	@Test(enabled = false, priority = 1, dependsOnMethods = "autoTest", groups = { "loginTest", "functional",
			"non-functional" })
	public void mockTest() throws InterruptedException {
		landingPage.clickLoginBtn();
		landingPage.insertUserId("ariful123");
		landingPage.insertPassword("03223451");
	}

}
