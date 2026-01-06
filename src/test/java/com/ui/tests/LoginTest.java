package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

/* Clean Code Ch. 9 Unit Tests
 		* Test Method Rules !!!
 		* 1. Make tests scripts small 
 		* 2. No Conditional statements, loops, try catch in Tests 
 		* 3. Tests Scripts only follow Tests Steps
 		* 4. Reduce use of Local variables 
 		* 5. At least one assertion
 */ 

@Listeners({ com.ui.listeners.TestListener.class })
public class LoginTest extends TestBase {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "Verify login into the application from JSON file", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {
		// Interface RefVar =Object ChildClass -- > Loose Coupling

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Vik Kumar");
	}

	@Test(description = "Verify login into the application from CSV file", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Vik Kumar");
	}

	@Test(description = "Verify login into the application from Excel file", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Vik Kumar1");

	}
}
