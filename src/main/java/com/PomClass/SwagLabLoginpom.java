package com.PomClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Baseclass.Baseclass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.interfaces.SwagElements;
import com.pommanager.SwagPomManager;

public class SwagLabLoginpom extends Baseclass implements SwagElements {

	
	public static WebDriver SwagLabLoginpomdriver;
	
	SwagPomManager pom = new SwagPomManager();

	@FindBy(id = user_id)
	private WebElement username;

	@FindBy(name = pswd_name)
	private WebElement password;

	@FindBy(xpath = Login_xpath)
	private WebElement loginBtn;

	@FindBy(xpath = ProductpageAssert_xpath)
	private WebElement productPageAssert;

	@FindBy(xpath = InvalidUsernameAssert_xpath)
	private WebElement invalidUsernameAssert;
	
	@FindBy(xpath = emptyCredentialAssert_xpath)
	private WebElement emptyUsernameEmptyPasswordAssert;
	
	@FindBy(xpath = validUsernameEmptyPsed_xpath)
	private WebElement validUsernameEmptyPasswordAssert;

	public SwagLabLoginpom(WebDriver driver) {

		SwagLabLoginpomdriver = driver;
		
		PageFactory.initElements(driver, this);

	}

	public boolean validLogin(ExtentTest extendtest) {
		try {

			launchUrl("https://www.saucedemo.com/");
			inputValue(driver, username, pom.getSwaglabConfigReader().getUserName());
			inputValue(driver, password, pom.getSwaglabConfigReader().getPassword());
			clickOnElement(driver, loginBtn);
			Assert.assertEquals(productPageAssert.getText(), "Products");
			extendtest.log(Status.PASS, "Login Successfull");
			


		} catch (AssertionError e) {

			extendtest.log(Status.FAIL, "Login Failed" + e.getMessage());
			return false;
		}

		return true;
	}

	public void invalidUsernameAndValidPassword() {

		launchUrl("https://www.saucedemo.com/");
		inputValue(driver, username, pom.getSwaglabConfigReader().getInvalidUserName());
		inputValue(driver, password, pom.getSwaglabConfigReader().getPassword());
		clickOnElement(driver, loginBtn);
		String text = driver.findElement(By.xpath("//button[@class='error-button']")).getText();
		System.out.println(text);
		Assert.assertEquals(invalidUsernameAssert.getText(),
				"Epic sadface: Username and password do not match any user in this service");

	}
	
	public void emptyUsernameAndEmptyPassword() {

		launchUrl("https://www.saucedemo.com/");
		inputValue(driver, username, "");
		inputValue(driver, password, "");
		clickOnElement(driver, loginBtn);
		Assert.assertEquals(emptyUsernameEmptyPasswordAssert.getText(),
				"Epic sadface: Username is required");

	}
	
	public void validUsernameAndEmptyPassword() {

		launchUrl("https://www.saucedemo.com/");
		inputValue(driver, username, pom.getSwaglabConfigReader().getUserName());
		inputValue(driver, password, "");
		clickOnElement(driver, loginBtn);
		Assert.assertEquals(validUsernameEmptyPasswordAssert.getText(),
				"Epic sadface: Password is required");

	}

}
