package com.PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Baseclass.Baseclass;
import com.interfaces.SwagElements;
import com.pommanager.SwagPomManager;

public class SwagOrder1Pom extends Baseclass implements SwagElements {

	public static WebDriver SwagOrder1Pomdriver;
	
	SwagPomManager pom = new SwagPomManager();
	
	@FindBy(id = user_id)
	private WebElement username;

	@FindBy(name = pswd_name)
	private WebElement password;

	@FindBy(xpath = Login_xpath)
	private WebElement loginBtn;
	
	@FindBy(xpath = order1_xpath)
	private WebElement order1;
	
	@FindBy(xpath = order1CartBadge_xpath)
	private WebElement order1CartBadge;
	
	@FindBy(name = orderCheckoutBtn_name)
	private WebElement orderCheckout;
	
	@FindBy(id = order1firstName_id)
	private WebElement order1firstName;
	
	@FindBy(id = order1LastName_id)
	private WebElement order1LastName;
	
	@FindBy(id = order1Zip_id)
	private WebElement order1Zip;
	
	@FindBy(id = continueBtn_id)
	private WebElement continueBtn;
	
	@FindBy(id = finishBtn_id)
	private WebElement finishBtn;
	
	@FindBy(id = logoutLines_id)
	private WebElement threeLines;
	
	@FindBy(id = logOut_id)
	private WebElement logOut;
	
	@FindBy(xpath=order1Asset_xpath)
	private WebElement order1Asset;
	
	
	public SwagOrder1Pom(WebDriver driver) {

		SwagOrder1Pomdriver = driver;
		
		PageFactory.initElements(driver, this);

	}
	
	
	public  void order1() {
		
		launchUrl("https://www.saucedemo.com/");
		inputValue(driver, username, pom.getSwaglabConfigReader().getUserName());
		inputValue(driver, password, pom.getSwaglabConfigReader().getPassword());
		clickOnElement(driver, loginBtn);
		implicitWait(driver, 20);
		clickOnElement(driver,order1);
		clickOnElement(driver, order1CartBadge);
		Assert.assertEquals(order1Asset.getText(),"Sauce Labs Backpack");
		clickOnElement(driver, orderCheckout);
		inputValue(driver, order1firstName, pom.getSwaglabConfigReader().getFirstName());
		inputValue(driver, order1LastName, pom.getSwaglabConfigReader().getLastName());
		inputValue(driver, order1Zip, pom.getSwaglabConfigReader().getzip());
		clickOnElement(driver, continueBtn);
		clickOnElement(driver, finishBtn);
		clickOnElement(driver, threeLines);
		clickOnElement(driver, logOut);
		
		
	}
	
	
	
}
