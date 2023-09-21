package Staging.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataEntryPradesh {
	private WebDriver driver;
	//Xpath for dynamic xpath
	private By DataEntrylevelbutton  = By.xpath("//h5[text()='Pradesh']//parent::div//parent::div//parent::div//following-sibling::div//span[@class='mat-ripple mat-button-ripple']");
	
	public DataEntryPradesh(WebDriver driver) {
		this.driver=driver;

	}
	
	public void primarydata() {
		driver.findElement(DataEntrylevelbutton).click();
		
		
		
		
//		return new DataEntryPradeshPage(driver);
	}
	
	

}
