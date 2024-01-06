package com.bootcamp_part1_difficult_submission;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "input-email")
	private WebElement emailInput;

	@FindBy(id = "input-password")
	private WebElement passwordInput;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String email, String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();
	}
}
