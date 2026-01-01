package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LoginTest2 {

	public static void main(String[] args) {

		// Interface RefVar =Object ChildClass -- > Loose Coupling
		WebDriver wd = new ChromeDriver();// Launch a Browser Window / Session is created!!!
		HomePage homePage = new HomePage(wd);
		LoginPage loginPage= homePage.goToLoginPage();
		loginPage.doLoginWith("woleg69912@rykone.com", "Password@2189");

	}

}
