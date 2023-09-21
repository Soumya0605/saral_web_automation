package factory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    JavascriptExecutor js;
    WebDriver driver;

    public void waitForPageLoad() {

        driver = DriverFactory.getInstance().getDriver();

        js = (JavascriptExecutor) driver;
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page has loaded");
        }
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println("Page has not loaded yet ");
            }
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }

        }
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("Element is clickable: " + clickableElement.getTagName());

        } catch (Exception e) {


        }

    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Maximum wait time in seconds (you can adjust as needed)

        try {
            WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("Element is visible: " + visibleElement.getTagName());
            // You can now perform actions on the element after it becomes visible
            // For example, visibleElement.click(), visibleElement.sendKeys("some text"), etc.
        } catch (Exception e) {
            System.err.println("Element is not visible: " + element.toString());
            // Handle the exception if the element is not visible within the timeout
        }
    }

}


