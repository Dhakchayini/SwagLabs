package com.Baseclass;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Baseclass {
	
	public static ExtentReports extentReports;
	
	public static File file;

	public static WebDriver driver;

	protected static WebDriver browserLaunch(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();

			options.addArguments("incognito");

			options.addArguments("start-maximized");

			driver = new ChromeDriver(options);

		} else if (browsername.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

		} else if (browsername.equalsIgnoreCase("ie")) {

			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();

		return driver;
	}

	protected static void inputValue(WebDriver driver, WebElement element, String value) {
		
		element.sendKeys(value);
	
	}

	protected static void launchUrl(String urlname) {

		driver.get(urlname);

	}

	protected static void clearTheValues(WebDriver driver, WebElement element) {

		element.clear();
	
	}

	protected static void clickOnElement(WebDriver driver, WebElement element) {

		element.click();

	}

	protected static String title(WebDriver driver) {

		String title = driver.getTitle();
		
		return title;

	}

	protected static String currentUrl(WebDriver driver) {

		String currentUrl = driver.getCurrentUrl();

		return currentUrl;

	}

	protected static String getText(WebDriver driver,WebElement element) {

		String text = element.getText();
		
		return text;

	}

	protected static String getAttribute(WebDriver driver,WebElement element, String value) {

		String attribute = element.getAttribute(value);

		return attribute;
		
	}

	protected static void navigate(WebDriver driver, String url) {

		driver.navigate().to(url);
	}

	protected static void navigateRefresh(WebDriver driver) {

		driver.navigate().refresh();

	}

	protected static void navigateback(WebDriver driver) {

		driver.navigate().back();

	}

	protected static void navigateforward(WebDriver driver) {

		driver.navigate().forward();

	}

	protected static void quitbrowser(WebDriver driver, String value) {

		
		if(value.equalsIgnoreCase("close")) {
			
			driver.close();
			
		}else if(value.equalsIgnoreCase("quit")) {
			
			driver.quit();
			
		}
	
	}

	protected static String getAttribute(WebDriver driver,WebElement element) {

		String attribute = element.getAttribute("value");

		return attribute;

	}

	protected static void simpleAlert(WebDriver driver) {

		driver.switchTo().alert().accept();

	}

	protected static void confirmAlert(WebDriver driver, String alert) {

		if (alert.equalsIgnoreCase("confirmAlertAccept")) {

			driver.switchTo().alert().accept();

		} else if (alert.equalsIgnoreCase("confirmAlertDismiss")) {

			driver.switchTo().alert().dismiss();

		}

	}

	protected static void promptAlert(WebDriver driver, String text) {

		driver.switchTo().alert().sendKeys(text);

		driver.switchTo().alert().accept();

	}

	protected static void action(WebDriver driver, WebElement element, String actionName) {

		Actions action = new Actions(driver);

		if (actionName.equalsIgnoreCase("contextclick")) {

			action.contextClick(element).build().perform();

		} else if (actionName.equalsIgnoreCase("click")) {

			action.click(element).build().perform();

		} else if (actionName.equalsIgnoreCase("doubleclick")) {

			action.doubleClick(element).build().perform();

		} else if (actionName.equalsIgnoreCase("moveToElement")) {

			action.moveToElement(element).build().perform();

		}

	}

	protected static void action(WebDriver driver, WebElement source, WebElement dest) {

		Actions act = new Actions(driver);

		act.dragAndDrop(source, dest).build().perform();

	}

	protected static boolean isEnabled(WebDriver driver,WebElement element) {

		 boolean enabled = element.isEnabled();
		 
		 return enabled;

	}

	protected static boolean isDisplayed(WebDriver driver,WebElement element) {

		boolean displayed = element.isDisplayed();
		
		return displayed;

	}

	public static boolean isSelected(WebDriver driver,WebElement element) {

		boolean selected = element.isSelected();
		
		return selected;
		
	}

	protected static void javaScriptClick(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);

	}

	protected static void javaScriptScroll(WebDriver driver, String value) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (value.equalsIgnoreCase("scrolldown")) {

			js.executeScript("window.scrollBy(0,1200)", "");

		} else if (value.equalsIgnoreCase("scrollup")) {

			js.executeScript("window.scrollBy(0,-1200)", "");

		}
	}
	
	protected static void dropDown(WebDriver driver, WebElement element, String option, String value) {
		
		Select s = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(value));
		} else if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
	}

	protected static void implicitWait(WebDriver driver, long seconds) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}
	
	public static void extentReportStart(String location) {
		
		extentReports = new ExtentReports();
		
		file = new File (location);
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
	
		extentReports.attachReporter(sparkReporter);
		
		extentReports.setSystemInfo("OS",System.getProperty("os.name"));
		
		extentReports.setSystemInfo("Java version", System.getProperty("Java Version"));
				
		
	}
	
	public  static void extentReportTearDown(String location) throws IOException {
		
		extentReports.flush();
		
		file = new File(location);
		
		Desktop.getDesktop().browse((file).toURI());
		
	}
	
	public String takeScreenshot() throws IOException {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshort\\.png" + "_" + timeStamp + ".png");
		FileUtils.copyFile(scrfile, destfile);
		return destfile.getAbsolutePath();
	}
	

	protected static void explicit_wait(WebDriver driver, WebElement element, String value, Duration seconds) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);

		if (value.equalsIgnoreCase("alert accept")) {

			wait.until(ExpectedConditions.alertIsPresent()).accept();

		} else if (value.equalsIgnoreCase("alert dismiss")) {

			wait.until(ExpectedConditions.alertIsPresent()).dismiss();

		} else if (value.equalsIgnoreCase("visibility")) {

			wait.until(ExpectedConditions.visibilityOf(element)).click();

		} else if (value.equalsIgnoreCase("all visibility")) {

			wait.until(ExpectedConditions.visibilityOfAllElements(element));

		} else if (value.equalsIgnoreCase("clickable")) {

			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}

	}

}
