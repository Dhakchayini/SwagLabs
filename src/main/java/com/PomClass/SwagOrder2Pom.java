package com.PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Baseclass.Baseclass;
import com.interfaces.SwagElements;
import com.pommanager.SwagPomManager;

public class SwagOrder2Pom extends Baseclass implements SwagElements {

	public static WebDriver SwagOrder2Pomdriver;
	
	SwagPomManager pom = new SwagPomManager();
	
	@FindBy(id = user_id)
	private WebElement username;

	@FindBy(name = pswd_name)
	private WebElement password;

	@FindBy(xpath = Login_xpath)
	private WebElement loginBtn;
	
	@FindBy(xpath = order2_xpath)
	private WebElement order2;
	
	@FindBy(xpath = order1CartBadge_xpath)
	private WebElement order1CartBadge;
	
	@FindBy(name = orderCheckoutBtn_name)
	private WebElement orderCheckout;
	
	@FindBy(id = order1firstName_id)
	private WebElement firstName1;
	
	@FindBy(id = order1LastName_id)
	private WebElement lastName1;
	
	@FindBy(id = order1Zip_id)
	private WebElement Zip1;
	
	@FindBy(id = continueBtn_id)
	private WebElement continueBtn;
	
	@FindBy(id = finishBtn_id)
	private WebElement finishBtn;
	
	@FindBy(id = logoutLines_id)
	private WebElement threeLines;
	
	@FindBy(id = logOut_id)
	private WebElement logOut;
	
	@FindBy(xpath=order2Asset_xpath)
	private WebElement order2Asset;
	
	public SwagOrder2Pom(WebDriver driver) {

		SwagOrder2Pomdriver = driver;
		
		PageFactory.initElements(driver, this);

	}
	
	public void order2() {
		
		launchUrl("https://www.saucedemo.com/");
		inputValue(driver, username, pom.getSwaglabConfigReader().getUserName());
		inputValue(driver, password, pom.getSwaglabConfigReader().getPassword());
		clickOnElement(driver, loginBtn);
		clickOnElement(driver,order2);
		clickOnElement(driver, order1CartBadge);
		clickOnElement(driver, orderCheckout);
		inputValue(driver, firstName1, pom.getSwaglabConfigReader().getFirstName1());
		inputValue(driver, lastName1, pom.getSwaglabConfigReader().getLastName1());
		inputValue(driver, Zip1, pom.getSwaglabConfigReader().getzip1());
		clickOnElement(driver, continueBtn);
		Assert.assertEquals(order2Asset.getText(), "Sauce Labs Bike Light");
		clickOnElement(driver, finishBtn);
		clickOnElement(driver, threeLines);
javaScriptClick(driver, logOut);
	}
	
	
	
	
}
