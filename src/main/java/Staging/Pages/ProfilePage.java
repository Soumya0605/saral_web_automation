package Staging.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/* */
import org.openqa.selenium.support.ui.WebDriverWait;

import Staging.pakages.ElementUtils;

public class ProfilePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public static String role_name;


   private By Role = By.xpath("//b[contains(text(),'Role:')]//parent::div");
	
	
   

    public ProfilePage(WebDriver driver){
        this.driver=driver;
	 }
    
    public HomePage profilerole() {
    	 role_name=ElementUtils.getElement(driver,Role,wait).getText();
//      String role_name = driver.findElement(Role).getText();
      System.out.println("User has a role of :"+role_name);
    	return new HomePage(driver);
    	
    }
    
    
    
    


    }
    
    
    
    

