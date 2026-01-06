package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	// a[contains(text(), \"Sign in\"
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//div/a[@title='Log in to your customer account']");
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);// to call parent class constructor from child class
		// goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(UAT).getUrl());
		maximizeWindow();
	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite("http://www.automationpractice.pl/index.php");
	}

	public HomePage(String browserName) {
		super(browserName);
		goToWebsite("http://www.automationpractice.pl/index.php");
	}

	public LoginPage goToLoginPage() {// Page functions--- > Cant use void return type
		logger.info("Trying to perform click to go to Sign In page");
		ClickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	
}
