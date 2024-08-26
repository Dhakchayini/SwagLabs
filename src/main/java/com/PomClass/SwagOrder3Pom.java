package com.PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Baseclass.Baseclass;
import com.interfaces.SwagElements;
import com.pommanager.SwagPomManager;

public class SwagOrder3Pom extends Baseclass implements SwagElements {

	public static WebDriver SwagOrder3Pomdriver;

	SwagPomManager pom = new SwagPomManager();
	
	@FindBy(id = user_id)
	private WebElement username;

	@FindBy(name = pswd_name)
	private WebElement password;

	@FindBy(xpath = Login_xpath)
	private WebElement loginBtn;

	@FindBy(xpath = order3_xpath)
	private WebElement order3;

	@FindBy(xpath = order1CartBadge_xpath)
	private WebElement order1CartBadge;

	@FindBy(name = orderCheckoutBtn_name)
	private WebElement orderCheckout;

	@FindBy(id = order1firstName_id)
	private WebElement firstname2;

	@FindBy(id = order1LastName_id)
	private WebElement lastName2;

	@FindBy(id = order1Zip_id)
	private WebElement Zip2;

	@FindBy(id = continueBtn_id)
	private WebElement continueBtn;

	@FindBy(id = finishBtn_id)
	private WebElement finishBtn;

	@FindBy(id = logoutLines_id)
	private WebElement threeLines;

	@FindBy(id = logOut_id)
	private WebElement logOut;
	
	@FindBy(xpath=order3Asset_xpath)
	private WebElement order3Asset;

	public SwagOrder3Pom(WebDriver driver) {

		SwagOrder3Pomdriver = driver;

		PageFactory.initElements(driver, this);

	}

	public void order3() {

		launchUrl("https://www.saucedemo.com/");
		inputValue(driver, username, pom.getSwaglabConfigReader().getUserName());
		inputValue(driver, password, pom.getSwaglabConfigReader().getPassword());
		clickOnElement(driver, loginBtn);
		clickOnElement(driver, order3);
		clickOnElement(driver, order1CartBadge);
		clickOnElement(driver, orderCheckout);
		inputValue(driver, firstname2, pom.getSwaglabConfigReader().getFirstName2());
		inputValue(driver, lastName2, pom.getSwaglabConfigReader().getLastName2());
		inputValue(driver, Zip2, pom.getSwaglabConfigReader().getzip2());
		clickOnElement(driver, continueBtn);
		Assert.assertEquals(order3Asset.getText(), "Sauce Labs Bolt T-Shirt");
		clickOnElement(driver, finishBtn);
		clickOnElement(driver, threeLines);
		javaScriptClick(driver, logOut);
	}

}
