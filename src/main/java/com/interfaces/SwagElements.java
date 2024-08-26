package com.interfaces;

public interface SwagElements {

	String user_id = "user-name";

	String pswd_name = "password";

	String Login_xpath = "//input[@type='submit']";

	String ProductpageAssert_xpath = "//*[@class='title']";

	String InvalidUsernameAssert_xpath = "//*[contains(text(),'Epic sadface: Username and password do not match any user in this service')]";

	String emptyCredentialAssert_xpath = "//*[contains(text(),'Epic sadface: Username is required')]";

	String validUsernameEmptyPsed_xpath = "//*[contains(text(),'Epic sadface: Password is required')]";
	
	String order1_xpath = "(//button[contains(text(),'Add to cart')])[1]";
	
	String order1CartBadge_xpath="//div[@id='shopping_cart_container']";
	
	String orderCheckoutBtn_name = "checkout";
	
	String order1firstName_id = "first-name";
	
	String order1LastName_id = "last-name";
	
	String order1Zip_id = "postal-code";
	
	String continueBtn_id= "continue";
	
	String finishBtn_id = "finish";
	
	String logoutLines_id = "react-burger-menu-btn";
	
	String logOut_id= "logout_sidebar_link";
	
	String order2_xpath ="(//button[contains(text(),'Add to cart')])[2]";
	
	String order3_xpath ="(//button[contains(text(),'Add to cart')])[3]";
	
	String order4_xpath = "(//button[contains(text(),'Add to cart')])[4]";
	
	String order5_xpath = "(//button[contains(text(),'Add to cart')])[5]";
	
	String order1Asset_xpath="//div[contains(text(),'Sauce Labs Backpack')]";
	
	String order2Asset_xpath="//div[contains(text(),'Sauce Labs Bike Light')]";
	
	String order3Asset_xpath="//div[contains(text(),'Sauce Labs Bolt T-Shirt')]";

	String order4Asset_xpath="//div[contains(text(),'Sauce Labs Fleece Jacket')]";
	
	String order5Asset_xpath="//div[contains(text(),'Sauce Labs Onesie')]";

}
