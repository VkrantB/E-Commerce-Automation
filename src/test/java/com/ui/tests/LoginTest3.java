package com.ui.tests;

import static com.constants.Browser.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTest3 {
	HomePage homePage;

	@BeforeMethod(description = "Load the homepage of website")
	public void setUp() {
		homePage = new HomePage(CHROME);
	}

	// Interface RefVar =Object ChildClass -- > Loose Coupling
	// Launch a Browser Window / Session is created!!!
	@Test(description = "Verifies valid user is able to login to the application", groups = { "e2e", "sanity" }, 
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void validLoginTest(User user) {

		String useName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
		Assert.assertEquals(useName, "Vik Kumar");
	}

	@Test(description = "Verifies invalid user is not able to login to the application", groups = { "e2e", "sanity",
			"smoke" })
	public void invalidLoginTest() {

		String userName = homePage.goToLoginPage().doLoginWith("123@gmail.com", "Password").getUserName();
		Assert.assertEquals(userName, "Vik Kumar");
	}

	public void tearDown() {

	}
}
