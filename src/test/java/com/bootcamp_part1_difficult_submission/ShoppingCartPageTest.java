package com.bootcamp_part1_difficult_submission;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartPageTest {
	
public WebDriver driver;
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
	public void addProductToCart() {
		driver.findElement(By.xpath("//img[@title='MacBook']")).click();
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
		
		String expectedMessage = "Success: You have added MacBook to your shopping cart!";
		String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}

