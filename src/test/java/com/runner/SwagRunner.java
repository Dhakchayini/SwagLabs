package com.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Baseclass.Baseclass;
import com.PomClass.SwagLabLoginpom;
import com.PomClass.SwagOrder1Pom;
import com.PomClass.SwagOrder2Pom;
import com.PomClass.SwagOrder3Pom;
import com.PomClass.SwagOrder4Pom;
import com.PomClass.SwagOrder5Pom;
import com.listener.ExtentReport_Test;
import com.listener.ITestListenerClass;

@Listeners(ITestListenerClass.class)
public class SwagRunner extends Baseclass {

	@BeforeMethod
	public static void setUp() {

		browserLaunch("chrome");

	}

	@Test(priority = 4)

	public static void validLogin() {

		ExtentReport_Test.extenttest = extentReports
				.createTest("Login Test" + ": " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid Credentials");

		SwagLabLoginpom pom = new SwagLabLoginpom(driver);

		Assert.assertTrue(pom.validLogin(ExtentReport_Test.extenttest));

	}

	@Test(priority = 1)
	public void invalidUsernameValidPassword() {

		ExtentReport_Test.extenttest = extentReports
				.createTest("LoginTest" + ": " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Invalid username");

		SwagLabLoginpom pom = new SwagLabLoginpom(driver);
		pom.invalidUsernameAndValidPassword();

	}

	@Test(priority = 2)
	public void emptyCredential() {

		ExtentReport_Test.extenttest = extentReports
				.createTest("LoginTest" + ": " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Empty Username and Password");

		SwagLabLoginpom pom = new SwagLabLoginpom(driver);

		pom.emptyUsernameAndEmptyPassword();
	}

	@Test(priority = 3)
	public void validUserEmptyPassword() {

		ExtentReport_Test.extenttest = extentReports
				.createTest("LoginTest" + ": " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("valid Username and Empty Password");

		SwagLabLoginpom pom = new SwagLabLoginpom(driver);

		pom.validUsernameAndEmptyPassword();

	}

	@Test(priority = 5)
	public void order1Placed() {

		ExtentReport_Test.extenttest = extentReports.createTest(
				"Sauce Labs Backpack" + ": " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Order1 Placed");

		SwagOrder1Pom pom = new SwagOrder1Pom(driver);

		pom.order1();
	}

	@Test(priority = 6)
	public void order2Placed() {

		ExtentReport_Test.extenttest = extentReports.createTest(
				"Sauce Labs Bike Light" + ": " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Order2 Placed");

		SwagOrder2Pom pom = new SwagOrder2Pom(driver);

		pom.order2();
	}

	@Test(priority = 7)
	public void order3Placed() {

		ExtentReport_Test.extenttest = extentReports.createTest(
				"Sauce Labs Bolt T-Shirt" + ": " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Order3 Placed");

		SwagOrder3Pom pom = new SwagOrder3Pom(driver);

		pom.order3();
	}

	@Test(priority = 8)
	public void order4Placed() {

		ExtentReport_Test.extenttest = extentReports.createTest("Sauce Labs Fleece Jacket" + ": "
				+ Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Order4 Placed");

		SwagOrder4Pom pom = new SwagOrder4Pom(driver);

		pom.order4();

	}

	@Test(priority = 9)
	public void order5Placed() {

		ExtentReport_Test.extenttest = extentReports.createTest(
				"Sauce Labs Onesie " + ": " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Order5 Placed");

		SwagOrder5Pom pom = new SwagOrder5Pom(driver);

		pom.order5();

	}

	@BeforeSuite

	public static void extendStartUp() {

		extentReportStart("C:\\Swathy\\framework\\Swaglabs\\Reports");
	}

	@AfterSuite

	public static void extendReportEnd() throws IOException {

		extentReportTearDown("C:\\Swathy\\framework\\Swaglabs\\Reports\\index.html");
	}

	@AfterMethod
	public static void tearDown() {
		quitbrowser(driver, "quit");
	}

}
