package com.ui.tests;

import static com.constants.Browser.CHROME;
import static com.constants.Browser.FIREFOX;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestutility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest ;
	

	@Parameters({ "browser", "isLambdaTest", "isHeadLess" })
	@BeforeMethod(description = "Load the Homepage of website")
	public void setup(
			@Optional("chrome") String browser, 
			@Optional("false") boolean isLambdaTest, 
			@Optional("false") boolean isHeadLess, ITestResult result) {

		this.isLambdaTest = isLambdaTest;
		WebDriver LambdaTestDriver;
		if (isLambdaTest) {
			LambdaTestDriver = LambdaTestutility.initializeLambdaTestSession(browser,
					result.getMethod().getMethodName());
			homePage = new HomePage(LambdaTestDriver);

		} else {
			// Running tests on Local machine
			logger.info("Load the Homepage of website.");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadLess);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {
		if (isLambdaTest) {
			LambdaTestutility.quitSession();// close LanbdaTest session
		} else {
			homePage.quit();// local
		}
	}
}
