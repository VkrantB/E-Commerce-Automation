package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

/* Clean Code Ch. 9 Unit Tests
 		* Test Method Rules !!!
 		* 1. Make tests scripts small 
 		* 2. No Conditional statements, loops, try catch in Tests 
 		* 3. Tests Scripts only follow Tests Steps
 		* 4. Reduce use of Local variables 
 		* 5. At least one assertion
 */
public class LoginTest {
	HomePage homePage;

	@BeforeMethod(description = "Load the Homepage of website")
	public void setup() {
		homePage = new HomePage(CHROME);
	}

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
	@Test(description = "Verify login into the application from CSV file", groups = { "e2e",
	"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
public void loginExcelTest(User user) {

assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
		"Vik Kumar");
}
}
