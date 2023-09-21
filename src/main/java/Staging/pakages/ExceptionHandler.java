package Staging.pakages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class ExceptionHandler {

	  private static final int MAX_RETRIES = 50;
	    static WebDriver driver;
	    static WebDriverWait wait, wait2;


	    public static void clickElementWithRetry(WebDriver driver, By locator, WebDriverWait wait) {
	        int retries = 0;
	        boolean clicked = false;
	        //driver = DriverFactory.getDriver();
	        //wait = new WebDriverWait(driver, Duration.ofSeconds(110));
	        while (retries < MAX_RETRIES && !clicked) {
	            try {
	            	wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
	        		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        		element.click();
	             
	                clicked = true;
	            } catch (ElementClickInterceptedException | NoSuchElementException | StaleElementReferenceException e) {
	                System.out.println("Exception occurred: " + e.getMessage());
	                retries++;
	            }
	        }

	        if (!clicked) {

	            System.out.println("Failed to click element after " + MAX_RETRIES + " retries");
	            // wait.until(ExpectedConditions.elementToBeClickable(element));
	            //element.click();
	        }
	    }

	    public static String getTextOfElementWithRetry(WebElement element) {
	        int retries = 0;
	        boolean getText = false;

	        while (retries < MAX_RETRIES && !getText) {
	            try {
	                element.getText();
	                getText = true;
	            } catch (StaleElementReferenceException | IndexOutOfBoundsException e) {
	                System.out.println("Exception occurred: " + e.getMessage());
	                retries++;
	            }
	        }

	        if (!getText) {
	            System.out.println("not get any text after retries");

	        }
	        return element.getText();

	    }

}
