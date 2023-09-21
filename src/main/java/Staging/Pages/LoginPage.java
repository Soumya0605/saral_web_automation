package Staging.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Staging.pakages.ElementUtils;
import Staging.pakages.ExceptionHandler;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	private By emailId =By.name("email");
    private By password=By.name("password");
    private By sendotp=By.xpath("//button/span[contains(.,'Send OTP')]");
//    String otp_input="//input[@type='password']";
    private By loginButton=By.tagName("button");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public String getLoginPageTitle(){
        return driver.getTitle();

    }
    public void phone_number(String PhoneNumber){
    	ElementUtils.getElement(driver,emailId,wait)
	  	.sendKeys(PhoneNumber);


    }
    public void Email_id(String EamiliD){
    	ElementUtils.getElement(driver,emailId,wait)
	  	.sendKeys(EamiliD);


    }
    public void Password(String PassWord) throws InterruptedException{

    	ElementUtils.getElement(driver,password,wait)
	  	.sendKeys(PassWord);

    }
    public void SendOTP() throws InterruptedException{

    	ExceptionHandler.clickElementWithRetry(driver,sendotp,wait);


    }
    public void OtpInput(String sendOtp,String otp_input) throws InterruptedException{
        Thread.sleep(2000);
//        ElementUtils.getElement(driver,loginButton,wait);
        ElementUtils.sendOTPDigits(driver,sendOtp,otp_input,wait);

    }
    public HomePage login(){
    	 ElementUtils.clickElementByLocator(driver,loginButton,wait);
//        driver.findElement(loginButton).click();
        return new HomePage (driver);
    }
//    public HomePage loginByEmail(String EamiliD,String PassWord,String sendOtp) throws InterruptedException {
//    	driver.findElement(emailId).sendKeys(EamiliD);
//    	driver.findElement(password).sendKeys(PassWord);
//    	driver.findElement(sendotp).click(); 
//    	ElementUtils.sendOTPDigits(driver,sendOtp,otp_input);
//    	driver.findElement(loginButton).click();
//    	return new HomePage (driver);
//    }

}
