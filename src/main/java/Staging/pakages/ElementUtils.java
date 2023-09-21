package Staging.pakages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

;

public class ElementUtils {
	public static String FilterText;


	public static void sendOTPDigits(WebDriver driver, String otp, String otp_input, WebDriverWait wait) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (int i = 0; i < otp.length(); i++) {
			Thread.sleep(50);
			String dynamicXpath = "(" + otp_input + ")[" + (i + 1) + "]";
			Thread.sleep(50);
//			WebElement otpElement = driver.findElement(By.xpath(dynamicXpath));
			WebElement otpElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));
			Thread.sleep(200);
			char digit = otp.charAt(i);
			Thread.sleep(200);
			otpElement.sendKeys(Character.toString(digit));
		}
	}

	// Method to replicate click function with wait for visibility using By locator
	public static void clickElementByLocator(WebDriver driver, By locator, WebDriverWait wait) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait up to 10 seconds
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}

	public static WebElement getElement(WebDriver driver, By locator, WebDriverWait wait) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}
	public static List<WebElement> getElements(WebDriver driver, By locator, WebDriverWait wait) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElements(locator);
	}
	public static WebElement Mousehover(WebDriver driver, By locator, WebDriverWait wait) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
	
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	public static void scroll(WebDriver driver, By locator, WebDriverWait wait) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scroll =driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView();",scroll);
	}

	public static void jsclick(WebDriver driver, By locator, WebDriverWait wait) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele =driver.findElement(locator);
		js.executeScript("arguments[0].click();",ele);
	}

	public static void update(WebDriver driver, String updatedNumber ,WebDriverWait wait) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		String xpathExpression = "//td[.//div[contains(text(), '" + updatedNumber + "')]]/parent::tr//button";
		WebElement numberclick = driver.findElement(By.xpath(xpathExpression));

		numberclick.click();
	}

	public static void dropdownHandling(WebDriver driver,By locator,WebDriverWait wait){
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Select dropdown = new Select(driver.findElement(locator));
		List<WebElement> options = driver.findElements( locator);

		Random rand = new Random();
		int randomIndex = rand.nextInt(options.size());


		// Click the random option
		WebElement opt =options.get(randomIndex);
		FilterText=opt.getText();
				opt.click();


//		for (WebElement option : options) {
//			String optionText = option.getText();
//
//			// Build the dynamic XPath using the option text
//			String dynamicXPath = String.format("//option[text()='%s']", optionText);
//
//			// Find the web element using the dynamic XPath and click it
//			WebElement element = driver.findElement(By.xpath(dynamicXPath));
//			element.click();
//
//			// Do whatever you need to do after clicking
//			// For example, you can interact with other elements on the page
//		}

	}
}
