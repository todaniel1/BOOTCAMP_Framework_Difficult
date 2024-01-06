package com.bootcamp_part1_difficult_submission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchPageTest {
	private WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
	}

	@Test
	public void testAddProductToCartAndVerify() throws Exception {
		SearchPage searchPage = new SearchPage(driver);

		searchPage.searchProduct("HP");

		String expectedProductName = "HP LP3065";
		boolean isProductCorrect = searchPage.isProductInCheckout(expectedProductName);
		System.out.println("Is the correct product displayed on the checkout page? " + isProductCorrect);

		String actualWarningMessage = driver
				.findElement(By.xpath("//h2[text()='Products meeting the search criteria']")).getText();
		String expectedWarningMessage = "Products meeting the search criteria";
		System.out.println(actualWarningMessage);
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

		searchPage.addProductToCart();
		// Other assertions or actions as needed

		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
