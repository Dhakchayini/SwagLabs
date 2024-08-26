package com.PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Baseclass.Baseclass;
import com.interfaces.SwagElements;
import com.pommanager.SwagPomManager;

public class SwagOrder4Pom extends Baseclass implements SwagElements {

	public static WebDriver SwagOrder4Pomdriver;

	SwagPomManager pom = new SwagPomManager();
	
	@FindBy(id = user_id)
	private WebElement username;

	@FindBy(name = pswd_name)
	private WebElement password;

	@FindBy(xpath = Login_xpath)
	private WebElement loginBtn;

	@FindBy(xpath = order4_xpath)
	private WebElement order4;

	@FindBy(xpath = order1CartBadge_xpath)
	private WebElement order1CartBadge;

	@FindBy(name = orderCheckoutBtn_name)
	private WebElement orderCheckout;

	@FindBy(id = order1firstName_id)
	private WebElement firstname3;

	@FindBy(id = order1LastName_id)
	private WebElement lastName3;

	@FindBy(id = order1Zip_id)
	private WebElement Zip3;

	@FindBy(id = continueBtn_id)
	private WebElement continueBtn;

	@FindBy(id = finishBtn_id)
	private WebElement finishBtn;

	@FindBy(id = logoutLines_id)
	private WebElement threeLines;

	@FindBy(id = logOut_id)
	private WebElement logOut;
	
	@FindBy(xpath=order4Asset_xpath)
	private WebElement order4Asset;

	public SwagOrder4Pom(WebDriver driver) {

		SwagOrder4Pomdriver = driver;

		PageFactory.initElements(driver, this);

	}

	public void order4() {

		launchUrl("https://www.saucedemo.com/");
		inputValue(driver, username, pom.getSwaglabConfigReader().getUserName());
		inputValue(driver, password, pom.getSwaglabConfigReader().getPassword());
		clickOnElement(driver, loginBtn);
		clickOnElement(driver, order4);
		clickOnElement(driver, order1CartBadge);
		clickOnElement(driver, orderCheckout);
		inputValue(driver, firstname3, pom.getSwaglabConfigReader().getFirstName3());
		inputValue(driver, lastName3, pom.getSwaglabConfigReader().getLastName3());
		inputValue(driver, Zip3, pom.getSwaglabConfigReader().getzip3());
		clickOnElement(driver, continueBtn);
		Assert.assertEquals(order4Asset.getText(), "Sauce Labs Fleece Jacket");
		clickOnElement(driver, finishBtn);
		clickOnElement(driver, threeLines);
		javaScriptClick(driver, logOut);
	}

}
