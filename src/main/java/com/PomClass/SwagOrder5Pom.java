package com.PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Baseclass.Baseclass;
import com.interfaces.SwagElements;
import com.pommanager.SwagPomManager;

public class SwagOrder5Pom extends Baseclass implements SwagElements {

	public static WebDriver SwagOrder5Pomdriver;
	
	SwagPomManager pom = new SwagPomManager();
	
	@FindBy(id = user_id)
	private WebElement username;

	@FindBy(name = pswd_name)
	private WebElement password;

	@FindBy(xpath = Login_xpath)
	private WebElement loginBtn;
	
	@FindBy(xpath = order5_xpath)
	private WebElement order5;
	
	@FindBy(xpath = order1CartBadge_xpath)
	private WebElement order1CartBadge;
	
	@FindBy(name = orderCheckoutBtn_name)
	private WebElement orderCheckout;
	
	@FindBy(id = order1firstName_id)
	private WebElement firstName4;
	
	@FindBy(id = order1LastName_id)
	private WebElement lastName4;
	
	@FindBy(id = order1Zip_id)
	private WebElement Zip4;
	
	@FindBy(id = continueBtn_id)
	private WebElement continueBtn;
	
	@FindBy(id = finishBtn_id)
	private WebElement finishBtn;
	
	@FindBy(id = logoutLines_id)
	private WebElement threeLines;
	
	@FindBy(id = logOut_id)
	private WebElement logOut;
	
	@FindBy(xpath=order5Asset_xpath)
	private WebElement order5Asset;
	
	
	
	public SwagOrder5Pom(WebDriver driver) {

		SwagOrder5Pomdriver = driver;
		
		PageFactory.initElements(driver, this);

	}
	
	
	public  void order5() {
		
		launchUrl("https://www.saucedemo.com/");
		inputValue(driver, username, pom.getSwaglabConfigReader().getUserName());
		inputValue(driver, password, pom.getSwaglabConfigReader().getPassword());
		clickOnElement(driver, loginBtn);
		implicitWait(driver, 20);
		clickOnElement(driver,order5);
		clickOnElement(driver, order1CartBadge);
		clickOnElement(driver, orderCheckout);
		inputValue(driver, firstName4, pom.getSwaglabConfigReader().getFirstName4());
		inputValue(driver, lastName4, pom.getSwaglabConfigReader().getLastName4());
		inputValue(driver, Zip4, pom.getSwaglabConfigReader().getzip4());
		clickOnElement(driver, continueBtn);
		Assert.assertEquals(order5Asset.getText(), "Sauce Labs Onesie");
		clickOnElement(driver, finishBtn);
		clickOnElement(driver, threeLines);
		clickOnElement(driver, logOut);
		
		
	}
	
	
	
}
