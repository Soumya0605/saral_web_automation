package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WardPageObjects {

    WebDriver driver;
    WebDriverWait wait;
    int MAX_RETRIES = 5;
    By wardAddEntryButton = By.xpath("(//h5[text()='Ward']/following::button[contains(., 'Add Entry')])[1]");

    By wardFilters = By.xpath("//div[@class='ng-value-container']");

    By getSelectedDropdownElements = By.xpath("//div[@class='ng-value ng-star-inserted']");





    public WardPageObjects(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getWardAddEntryEle(){
        return driver.findElement(wardAddEntryButton);
    }

    public List<WebElement> getWardFilterEles(){
       return  driver.findElements(wardFilters);
    }

    public WebElement getSelectStateEle(String stateName){
        return driver.findElement(By.xpath("//div[contains(text(),'" + stateName + "')]"));

    }

    public WebElement getULBTypeEle(String ULBName){
        return driver.findElement(By.xpath("//div[contains(text(),'" + ULBName + "')]"));
    }

    public WebElement getAdministrativeDistrictEle(String ADName){
        return driver.findElement(By.xpath("//div[contains(text(),'" + ADName + "')]"));
    }

    public WebElement getLocalBodyEle(String localBodyName){
        return driver.findElement(By.xpath("//div[contains(text(),'" + localBodyName + "')]"));
    }

    public WebElement getWardEle(String wardName){
        return driver.findElement(By.xpath("//div[contains(text(),'" + wardName + "')]"));
    }

    public WebElement getOrganisationUnitEle(String organisationUnitName){
        return driver.findElement(By.xpath("(//div[contains(text(),'" + organisationUnitName + "')])[2]"));

    }

    public WebElement getOrganisationSubUnitEle(String organisationSubUnitName){
        return driver.findElement(By.xpath("(//div[contains(text(),'" + organisationSubUnitName + "')])[2]"));

    }

    public List<WebElement> getSelectedDropdownEle(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.presenceOfElementLocated(getSelectedDropdownElements));
        return driver.findElements(getSelectedDropdownElements);
    }

    public void waitForVisibilityOfEle(WebElement element) {
        int retries = 0;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        while (retries < MAX_RETRIES) {
            try {


            } catch (StaleElementReferenceException e) {

            }
        }
    }


}
