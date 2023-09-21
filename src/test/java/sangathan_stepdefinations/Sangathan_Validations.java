package sangathan_stepdefinations;

import com.paulhammant.ngwebdriver.NgWebDriver;
import factory.DriverFactory;
import factory.FormControlKaryakarta;
import factory.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.SangathanPageObjects;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Sangathan_Validations {

    JavascriptExecutor js;
    WebDriverWait wait, wait2;
    NgWebDriver ngDriver;
    WebDriver driver;
    WaitUtils load_wait;

    SangathanPageObjects sangathanPageObjects;


    // Phone Number Validations
    public void apply_validation_in_phone_number() throws InterruptedException {
        driver = DriverFactory.getDriver();

        wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement PhoneNumberEle = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
        WebElement PrimaryMemberIdEle = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"));

        // enter less than 10 digit as Phone Number
        PhoneNumberEle.sendKeys("234");
        PrimaryMemberIdEle.click();
        Thread.sleep(2000);

        WebElement errorTextElement = driver.findElement(with(By.className("mat-error")).below(PhoneNumberEle));
        wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, errorTextElement.getText()));
        System.out.println("errorTextElement text1:" + errorTextElement.getText());
        // enter wrong Phone Number
        PhoneNumberEle.clear();
        PhoneNumberEle.sendKeys("2222433434");
        PrimaryMemberIdEle.click();

        errorTextElement = driver.findElement(with(By.className("mat-error")).below(PhoneNumberEle));
        wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, "Please enter a valid input"));
        System.out.println("errorTextElement text2:" + errorTextElement.getText());
        // PhoneNumberEle.sendKeys(phoneNumberValue);
        // correct Phone Number
        PhoneNumberEle.clear();

    }

    //WhatsApp Number Validations
    public void apply_validation_in_whatsapp_number() throws InterruptedException {
        wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
        SangathanPageObjects sangathanPageObjects = new SangathanPageObjects(driver);
        WebElement whatsAppEle = sangathanPageObjects.getWhatsAppNumber();
        WebElement stdCodeEle = driver.findElement(By.xpath("//input[@placeholder='STD Code']"));
        // Enter wrong whatsApp Number
        // whatsAppEle.sendKeys("1234567890");
        FormControlKaryakarta.enterWhatsAppNumber("1234567890");
        js.executeScript("arguments[0].click();", stdCodeEle);
        Thread.sleep(2000);
        WebElement errorTextElement = driver.findElement(with(By.className("mat-error")).below(whatsAppEle));
        wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, "Please enter a valid input"));
        whatsAppEle.clear();

    }

    //Category and Caste Validations
    public void apply_validation_in_category_and_caste() throws InterruptedException {
        sangathanPageObjects = new SangathanPageObjects(driver);
        // Select Category
        WebElement selectCategoryEle = sangathanPageObjects.getSelectCategoryEle();

        // Caste
        WebElement CasteEle = sangathanPageObjects.getSelectCasteEle();

        Actions actions = new Actions(driver);
        actions.moveToElement(CasteEle).perform();
        Thread.sleep(4000);
        // Caste Tooltip

        WebElement casteToolltip = sangathanPageObjects.getCasteToolTipTextEle();
        String copiedCasteTooltip = casteToolltip.getText();
        Assert.assertEquals(copiedCasteTooltip, "Please select a category first to enter or select a caste");
        System.out.println("copied text for caste tooltip :" + casteToolltip.getText());
        Thread.sleep(2000);
        actions.moveToElement(selectCategoryEle).perform();

    }

    // Validation in Email
    public void apply_validation_in_email() throws InterruptedException {
        // Full Address
        WebElement fullAddressEle = sangathanPageObjects.getFullAddressEle();
        // Email
        WebElement emailEle = sangathanPageObjects.getEmailEle();
        // enter an invalid email
        FormControlKaryakarta.enterEmail("yueyewu");
        fullAddressEle.click();
        Thread.sleep(2000);
        WebElement errorTextElement = driver.findElement(with(By.className("mat-error")).below(emailEle));
        wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, "Please enter a valid input"));
        Thread.sleep(2000);
        emailEle.clear();
    }

    // Validations in Aadhaar Number
    public void apply_validation_in_aadhar_number() throws InterruptedException {
        // Voter Id
        WebElement voterIdValueEle = sangathanPageObjects.getVoterIDEle();
        // Aadhaar Number
        WebElement AadhaarNumberEle = sangathanPageObjects.getAadharNumberEle();
        // Enter AadhaarNumber less than 12 digit
        FormControlKaryakarta.enterAadharNumber("6745");
        voterIdValueEle.click();
        Thread.sleep(2000);
        WebElement errorTextElement = driver.findElement(with(By.className("mat-error")).below(AadhaarNumberEle));
        wait2.until(
                ExpectedConditions.textToBePresentInElement(errorTextElement, "Enter valid 12 digit aadhar number"));
        AadhaarNumberEle.clear();

    }

    // Validation in panna number
    public void apply_validation_in_panna_number() throws InterruptedException {
        wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
        // Voter Id
        WebElement voterIdValueEle = sangathanPageObjects.getVoterIDEle();
        // Enter Panna Number
        WebElement PannaNumberEle = sangathanPageObjects.getPannaNumberEle();
        FormControlKaryakarta.enterPannaNumber("1");
        voterIdValueEle.click();
        Thread.sleep(2000);
        WebElement errorTextElement = driver.findElement(with(By.className("mat-error")).below(PannaNumberEle));
        wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, "Please enter a valid input"));
        PannaNumberEle.clear();

    }

    // validation in party zila and party mandal
    public void apply_validation_in_party_zila_and_mandal() throws InterruptedException {
        // click Select Party Mandal
        WebElement SelectPartyMandalEle = sangathanPageObjects.getSelectPartyMandalEle();
        SelectPartyMandalEle.click();
        WebElement popUpEle = sangathanPageObjects.getPop_UPEle();
        String popUpTextPatyMandal = wait.until(ExpectedConditions.visibilityOf(popUpEle)).getText();
        System.out.println("popUpTextPatyMandal :" + popUpTextPatyMandal);
        Assert.assertEquals(popUpTextPatyMandal, "Please select party zila");
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.invisibilityOf(popUpEle));

    }

    // validation in DOB
    public void apply_validation_in_dob() throws InterruptedException {
        wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
        sangathanPageObjects = new SangathanPageObjects(driver);
        WebElement dobEle = sangathanPageObjects.getDOBEle();
        WebElement PannaNumberEle = sangathanPageObjects.getPannaNumberEle();
        String dobValue = "01/12/2022";
        dobEle.sendKeys(dobValue);
        PannaNumberEle.click();
        Thread.sleep(2000);
        WebElement errorTextElement = driver.findElement(with(By.xpath("//mat-error")).below(dobEle));
        wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, "Minimum age should be 18 years"));
        dobEle.clear();

    }

    // Get Person To Edit
    public void get_Karyakarta_Data_To_Edit(String phoneNumber) throws InterruptedException {

        List<WebElement> colms = driver.findElements(By.xpath("//table/thead/tr/th"));
        int lastColNum = colms.size();
        for (int col = 0; col < lastColNum; col++) {
            String colmValue = colms.get(col).getText();
            System.out.println("colmsValue: " + colmValue);
            if (colmValue.contains("Phone Number")) {
                List<WebElement> phoneNumberRows = driver
                        .findElements(By.xpath("//table/tbody/tr/td[" + (col + 1) + "]"));
                int phoneNumberRowSize = phoneNumberRows.size();
                System.out.println("phoneNumberRowSize: " + phoneNumberRowSize);
                for (int phoneNumberRow = 0; phoneNumberRow < phoneNumberRowSize; phoneNumberRow++) {
                    String phoneNumberValue = phoneNumberRows.get(phoneNumberRow).getText();
                    System.out.println("phoneNumberValue: " + phoneNumberValue);
                    if (phoneNumberValue.contains(phoneNumber)) {
                        System.out.println("phoneNumberValue>>: " + phoneNumberValue);
                        WebElement actionButtonEle = driver
                                .findElement(By.xpath("//table/tbody/tr[" + (phoneNumberRow + 1) + "]/td["
                                        + (lastColNum) + "]//mat-icon[contains(.,'more_vert')]"));
                        js.executeScript("arguments[0].click();", actionButtonEle);

                        List<WebElement> actionAllEle = driver.findElements(By.xpath("//button//img"));
                        js.executeScript("arguments[0].scrollIntoView(true);", actionAllEle);
                        wait.until(ExpectedConditions.visibilityOfAllElements(actionAllEle));
                        WebElement editButtonEle = driver.findElement(By.xpath("//button//span[text()='Edit']"));
                        WaitUtils.waitForElementToBeClickable(driver, editButtonEle);
                        js.executeScript("arguments[0].click();", editButtonEle);
                        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
                        Thread.sleep(2000);
                        load_wait.waitForPageLoad();
                        return;

                    }
                }
            }
        }
    }

    // Get Person to Delete
    public void get_karyakarta_data_to_delete(String phoneNumber) throws InterruptedException {
        List<WebElement> colms = driver.findElements(By.xpath("//table/thead/tr/th"));
        int lastColNum = colms.size();
        for (int col = 0; col < lastColNum; col++) {
            String colmValue = colms.get(col).getText();
            System.out.println("colmsValue: " + colmValue);
            if (colmValue.contains("Phone Number")) {
                List<WebElement> phoneNumberRows = driver
                        .findElements(By.xpath("//table/tbody/tr/td[" + (col + 1) + "]"));
                int phoneNumberRowSize = phoneNumberRows.size();
                System.out.println("phoneNumberRowSize: " + phoneNumberRowSize);
                for (int phoneNumberRow = 0; phoneNumberRow < phoneNumberRowSize; phoneNumberRow++) {
                    String phoneNumberValue = phoneNumberRows.get(phoneNumberRow).getText();
                    System.out.println("phoneNumberRow:" + phoneNumberRow);
                    if (phoneNumberValue.contains(phoneNumber)) {
                        System.out.println("phoneNumberValue>>: " + phoneNumberValue);
                        WebElement actionButtonEle = driver
                                .findElement(By.xpath("//table/tbody/tr[" + (phoneNumberRow + 1) + "]/td["
                                        + (lastColNum) + "]//mat-icon[contains(.,'more_vert')]"));
                        js.executeScript("arguments[0].click();", actionButtonEle);

                        List<WebElement> actionAllEle = driver.findElements(By.xpath("//button//img"));
                        wait.until(ExpectedConditions.visibilityOfAllElements(actionAllEle));
                        WebElement deleteButtonEle = driver.findElement(By.xpath("//button//span[text()='Delete']"));
                        js.executeScript("arguments[0].click();", deleteButtonEle);
                        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
                        Thread.sleep(2000);

                    }
                }
            }
        }
    }


    }
