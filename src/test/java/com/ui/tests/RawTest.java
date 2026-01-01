package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RawTest {
	WebDriver wd;

	@BeforeMethod
	public void setup() {
		wd = new ChromeDriver();
		wd.get("http://www.automationpractice.pl/index.php");
		wd.manage().window().maximize();
	}

	@Test
	public void LoginTest() {
		// Interface RefVar =Object ChildClass -- > Loose Coupling
		// Launch a Browser Window / Session is created!!!

		// a[@title='Log in to your customer account']
		// WebElement SignInLinkLocator=wd.findElement(By.xpath("//a[contains(text(),
		// \"Sign in\")]")); // a[@class='login']
		WebElement SignInLinkLocator = wd.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		SignInLinkLocator.click();

		WebElement EmailAddressLocator = wd.findElement(By.xpath("//input[@id='email']"));
		EmailAddressLocator.sendKeys("woleg69912@rykone.com");

		WebElement passwordLocator = wd.findElement(By.xpath("//input[@id='passwd']"));
		passwordLocator.sendKeys("Password@2189");

		WebElement subLoginLocator = wd.findElement(By.xpath("//button[@id='SubmitLogin']/span"));
		subLoginLocator.click();
	}

	@Test
	public void createAccountTest() {
		// Register Account
		WebElement SignInLinkLocator = wd.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		SignInLinkLocator.click();
		
		WebElement Email_Create_Locator = wd.findElement(By.xpath("//input[@id='email_create']"));
		Email_Create_Locator.sendKeys("popobo9754@intady.com");

		WebElement createAccountLocator = wd.findElement(By.xpath("//button[@id='SubmitCreate']"));
		createAccountLocator.click();
		
		WebElement create_Account_Header = wd.findElement(By.xpath("//h1[@class='page-heading']"));
		String header=create_Account_Header.getText();
		Assert.assertEquals(header, "AUTHENTICATION"); 
		
//		WebElement TitleLocator = wd.findElement(By.id("id_gender1"));
//		TitleLocator.click();
		
		WebElement firstname_Locator = wd.findElement(By.id("customer_firstname"));
		firstname_Locator.sendKeys("Suleman");
		
		WebElement latstname_Locator = wd.findElement(By.id("customer_lastname"));
		latstname_Locator.sendKeys("King");
		
		WebElement password_Locator = wd.findElement(By.id("passwd"));
		password_Locator.sendKeys("password@123");
		
		WebElement Register_Locator = wd.findElement(By.id("submitAccount"));
		Register_Locator.click();
		
		
		
		
		
		
		
		//wd.quit();

	}

}
