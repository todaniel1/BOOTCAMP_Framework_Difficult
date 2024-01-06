package com.bootcamp_part1_difficult_submission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	private WebDriver driver;
	private ChromeOptions options;
	private LoginPage loginPage;

	@BeforeMethod
	public void loginSetup() {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://tutorialsninja.com/demo");

		loginPage = new LoginPage(driver);
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
	}

	@Test
	public void verifyLoginWithValidCredentials() {

		loginPage.login("seleniumpanda@gmail.com", "Selenium@123");

		WebElement editYourAccountInfoLink = driver.findElement(By.linkText("Edit your account information"));
		WebElement logoutLink = driver.findElement(By.linkText("Logout"));

		Assert.assertTrue(editYourAccountInfoLink.isDisplayed() && logoutLink.isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
