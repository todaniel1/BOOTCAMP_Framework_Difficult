package com.bootcamp_part1_difficult_submission;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
WebDriver driver;
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
			
	@FindBy(xpath ="//img[@title='MacBook']")
	private WebElement macCom;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement AddToCartButton;
			
	 }
	
	 



