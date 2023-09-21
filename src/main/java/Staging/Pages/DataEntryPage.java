package Staging.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Staging.pakages.DataList;
import Staging.pakages.ElementUtils;
import Staging.pakages.RandomDataGenerator;

public class DataEntryPage {
	private WebDriver driver;
	private WebDriverWait wait;

	
	//WebElement Declaration 
	
public static DataList listinput,listoutput; 
	
	String Voter_card = "UTC026351";
	String Adhacard = "123490877842";
	String boothno="1";
	
	private By ProfilIcon =By.xpath("//*[name()='path' and contains(@d,'M0 15C0 6.')]");
	private By AbhiyanCard = By.xpath("//mat-card-title[text()=' Abhiyan Data Entry ' ]");
	private By Role = By.xpath("//b[contains(text(),'Role:')]//parent::div");  
	private By Datalevel = By.xpath("//h5[contains(text(),'Vibhag')]//parent::div//parent::div//parent::div[@class='col-md-3']//following-sibling::div[@class='col-md-9']//button//span[@class='mat-button-wrapper']");
	
	
	private By vibhag = By.xpath("//div[text()='Select Vibhag']");
	private By unit = By.xpath("//div[text()='Select Organisation Unit']");
	private By subUnit= By.xpath("//div[text()='Select Organisation Sub Unit']");
	private By dropdownOption = By.xpath("//div[@role='option'][1]");
	private By searchButton = By.xpath("//button//span[contains(text(),'Search')]");
	
	//For AutoFill enabled  private By = By.xpath("");
	private By PhonenumberBox= By.xpath("//div[@class='mat-form-field-infix ng-tns-c107-30']");
	private By SearchButton = By.xpath("//button[@type='submit']");
	private By AddEntry = By.xpath("//button[@class='mat-focus-indicator btn orange-btn zoom mat-raised-button mat-button-base']//span[@class='mat-button-wrapper' and contains(text(),' Add New ') ]");
//  private By = By.xpath("");
	private By name = By.xpath("//input[@placeholder='Name']");
	private By Father= By.xpath("//input[@placeholder=\"Father's/Husband's Name\"]");
	private By designation = By.xpath("//ng-select//div[@class='ng-placeholder'and contains(text(),'Select Designation *')]");
	private By hasPhone = By.xpath("//ng-select//div[@class='ng-placeholder'and contains(text(),'Has Smartphone')]");
	private By PhoneNumber = By.xpath("//input[@data-placeholder='Phone Number']");
	private By primarynumber = By.xpath("//input[@data-placeholder='Primary Member Id']");
	private By Age = By.xpath("//input[@data-placeholder='Age']");
	
	private By enterdetailInfo = By.xpath("//mat-panel-title[contains(text(),'Enter More Details ')]");
	
	
	private By BloodGroup = By.xpath("//input[@data-placeholder='Blood Group']");
	private By addMobile = By.xpath("//span[contains(text(),'Add Mobiles')]");
	private By phonnumberenter = By.xpath("//input[@placeholder='Enter your Mobile Number']");
	private By Savebutton = By.xpath("//span[contains(text(),'Save')]");
	private By Cancelbutton = By.xpath("//span[contains(text(),'Cancel')]");
	//span[contains(text(),'Cancel')]
	private By Pradesh = By.xpath("//span[contains(text(),'Add An Address')]");
	private By address  = By.xpath("//input[@placeholder='Enter your address']");
	private By area = By.xpath("//input[@placeholder='Enter your area']");
	private By pincode  = By.xpath("//input[@placeholder='Enter your pin code']");
	private By towncity = By.xpath("//input[@placeholder='Enter your town/city']");
	private By state = By.xpath("//input[@placeholder='Enter your state']");
	private By home = By.xpath("//mat-chip[@role='option' and contains(text(),'Home')]");
	private By office = By.xpath("//mat-chip[@role='option' and contains(text(),'Office')]");
	private By Other = By.xpath("//mat-chip[@role='option' and contains(text(),'Other')]");
//	private By  = By.xpath("");
//	private By  = By.xpath("");
	
	

	
	
	
	
	
	
	
	
	private By Gender = By.xpath("//label[@for='mat-radio-2-input']//span[@class='mat-radio-outer-circle']");
	
	private By whattsapp = By.xpath("//input[@placeholder='WhatsApp Number']");
	private By Std = By.xpath("//input[@data-placeholder='STD Code']");
	private By landline = By.xpath("//input[@data-placeholder='Landline Number']");
	//div[contains(text(),'Select Category')]
	private By category = By.xpath("//div[contains(text(),'Select Category')]");
	private By categoryType = By.xpath("//div[@role='option'][1]");
	private By Cast = By.xpath("//div[contains(text(),'Caste')]");
	private By Casttype = By.xpath("//div[@role='option'][1]");
	private By email= By.xpath("//input[@data-placeholder='Email']");
	
	private By dob  = By.xpath("//input[@data-placeholder='Dob']");
	private By fulladdress= By.xpath("//input[@placeholder='Full Address']");
	private By Vibhagward = By.xpath("//input[@placeholder='Village/Ward']");
	private By talukatehsil = By.xpath("//input[contains(@placeholder, 'Taluka')]");
	
	private By District = By.xpath("//div[contains(text(),'Select District')]");
	private By Districlist = By.xpath("//div[@role='option'][1]");
	private By Pincode = By.xpath("//input[@placeholder='Pin Code']");
	
	private By Educaion  = By.xpath("//div[contains(text(),'Select Education')]");
	private By profession  = By.xpath("//div[contains(text(),'Select Profession')]");
	private By Bike = By.xpath("//div[contains(text(),'Bike')]");
	private By car = By.xpath("//div[contains(text(),'Car')]");
	private By vidhansabha = By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]");
	private By Booth = By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]");
	
		String Voter ="//input[contains(@placeholder, 'ex. UTC026351')]";	
	private By Voterid = By.xpath(Voter);
	private By AdharID = By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]");
	
	private By pannanumber = By.xpath("//input[contains(@placeholder, 'Panna Number')]");
	private By ration = By.xpath("//input[contains(@placeholder, 'Ration Card Number')]");
	private By facebook= By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]");
	private By twittter = By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]");
	private By insta = By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]");
	private By Linkdone = By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]");
	private By PaNmae = By.xpath("//input[contains(@placeholder, 'PA Name')]");
	private By Panumber = By.xpath("//input[contains(@placeholder, 'PA Number')]");
	private By NativeState = By.xpath("//div [contains(text(), 'Native State')]");
	private By Votingstate = By.xpath("//div [contains(text(), 'Voting State')]");
	private By Termstart =By.xpath("//input[@data-placeholder= 'Term Start']");
//	private By TermEndd =By.xpath("//input[@data-placeholder= 'Term End']");
	private By CurrentResponsibility =By.xpath("//input[contains(@placeholder, 'Responsibility in Govt.')]");
//	("mat-select-value-text")
//	private By Relligion = By.;
//	By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c126-67 ng-star-inserted']");
	//mat-select[@id='mat-select-6'])[1]
	private By PastResponsibility =By.xpath("//input[contains(@placeholder, 'Past Responsibility in Govt.')]");
	private By PastResponsibilityparty =By.xpath("//input[contains(@placeholder, 'Past Responsibility in party')]");
	private By sluation = By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c126-73 ng-star-inserted']");
	private By subcate = By.xpath("//input[contains(@placeholder, 'Sub cast')]");
	private By qualification = By.xpath("//input[contains(@placeholder, 'Qualification')]");
	private By termnumber = By.xpath("//input[contains(@placeholder, 'No of Terms')]");
	private By partyZila = By.xpath("//div[contains(text(),'Select Party Zila')]");
	private By partymandal = By.xpath("//div[contains(text(),'Select Party Mandal')]");
	
	
	
	
	
	
	private By relative = By.xpath("//input[@id='mat-input-27']");
	private By addphoto= By.xpath("//a[@role='menuitem']");
	private By saluation = By.xpath("//div[@class='mat-select-panel-wrap ng-tns-c126-101 ng-trigger ng-trigger-transformPanelWrap ng-star-inserted']");
	private By satlutionlist = By.xpath("//span[normalize-space()='Shri']");
	private By subcast = By.xpath("//input[@id='mat-input-29']");
	
	private By religion= By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c126-105 ng-star-inserted']");
	private By islam = By.xpath("//span[normalize-space()='Islam']");
	private By activememberid= By.xpath("//input[@id='mat-input-31']");
	private By zila = By.xpath("//ng-select[@class='ng-select ng-select-single ng-select-searchable ng-select-clearable ng-untouched ng-pristine ng-valid ng-star-inserted ng-select-opened ng-select-top ng-select-focused']//input[@role='combobox']");
	private By Zilatype = By.xpath("//div[@id='aaf1f32d4165-2']");
	private By mandal = By.xpath("//ng-select[@class='ng-select ng-select-single ng-select-searchable ng-select-clearable ng-pristine ng-valid ng-star-inserted ng-select-bottom ng-touched ng-select-focused ng-select-opened']//div[@class='ng-value-container']");
	private By mandallist= By.xpath("//span[@class='ng-option-label ng-star-inserted'][normalize-space()='Dangtol']");
	private By incharge = By.xpath("//ng-select[@class='ng-select ng-select-single ng-select-searchable ng-select-clearable ng-untouched ng-pristine ng-valid ng-star-inserted ng-select-focused ng-select-opened ng-select-top']//input[@role='combobox']");
	private By inchargelist= By.xpath("//div[@id='a001bc710ebb-1']");
	private By addentry = By.xpath("normalize-space()='Add'");
	private By add = By.xpath("//button[@type='submit']");
	//mat-icon[normalize-space()='more_vert']
	private By action = By.xpath("//mat-icon[normalize-space()='more_vert']");
//	private By action=By.xpath("//span[@class='mat-button-wrapper'] //mat-icon[contains(text(),'more_vert')]");
	//img[@title='Edit With More Details']
	private By edit = By.xpath("//button//span[contains(text(),'Edit')]");
	
	
	
	
	
	
	
	

	public DataEntryPage(WebDriver driver) {
		this.driver=driver;
}
	
	
	
	
	public void AutoFill() {
		ElementUtils.getElement(driver,PhonenumberBox,wait)
		  	.sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
		ElementUtils.clickElementByLocator(driver,SearchButton,wait);
		ElementUtils.clickElementByLocator(driver,AddEntry,wait);
	}
	
	public void DataentryFormFilter() {
		ElementUtils.clickElementByLocator(driver,vibhag,wait);
		   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
		   ElementUtils.clickElementByLocator(driver,unit,wait);
		   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
		   ElementUtils.clickElementByLocator(driver,subUnit,wait);
		   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
		   ElementUtils.clickElementByLocator(driver,searchButton,wait);
		
	}
	
	
	public void PrimaryEntry(){
		 listinput= new DataList();
		   String fulname = RandomDataGenerator.generateRandomName();
		   System.out.println("User has a nmae :"+fulname);
		   ElementUtils.getElement(driver, name, wait)
		    .sendKeys(fulname);
		    listinput.addString(fulname);
		   
		   String Fathername = RandomDataGenerator.generateRandomName();
		   System.out.println("User has a Father :"+Fathername);
		   ElementUtils.getElement(driver, Father, wait)
		    .sendKeys(Fathername);
		   listinput.addString(Fathername);
		   
		   ElementUtils.clickElementByLocator(driver,designation,wait);
		   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
//		   ElementUtils.clickElementByLocator(driver,hasPhone,wait);
//		   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
		  String Phname =RandomDataGenerator.generateRandomPhoneNumber();
				  ElementUtils.getElement(driver,PhoneNumber,wait)
		    .sendKeys(Phname);
				  System.out.println("User has a phone number:"+Phname);
		   listinput.addString(Phname);
		  String prino = RandomDataGenerator.generateRandomPrimaryNumber();
		   ElementUtils.getElement(driver,primarynumber,wait)
		    .sendKeys(prino);
		   System.out.println("User has a primary number:"+prino);
		   
		   listinput.addString(prino);
//		   driver.findElement(Age).sendKeys(age2);
		   
	}
		
		public void AbhiyanDataSearch() throws InterruptedException {
			
			
			   //Search Action 
			  
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   
			   
//			   Main Data entry
			   ElementUtils.clickElementByLocator(driver,enterdetailInfo,wait);
			   ElementUtils.getElement(driver, BloodGroup, wait).sendKeys("o+");
//			   ElementUtils.clickElementByLocator(driver,addMobile,wait);
//			   ElementUtils.elementsendkeysrandom(driver,phonnumberenter,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//			   ElementUtils.clickElementByLocator(driver,Savebutton,wait);

			   ElementUtils.clickElementByLocator(driver,Pradesh,wait);
			   ElementUtils.getElement(driver,address,wait).sendKeys(RandomDataGenerator.generateRandomName());
			   ElementUtils.getElement(driver,area,wait).sendKeys(RandomDataGenerator.generateRandomName());
			   ElementUtils.getElement(driver,pincode,wait).sendKeys("110056");
			   ElementUtils.getElement(driver,towncity,wait).sendKeys(RandomDataGenerator.generateRandomName());
			   ElementUtils.getElement(driver,state,wait).sendKeys(RandomDataGenerator.generateRandomName());
			   ElementUtils.clickElementByLocator(driver,home,wait);
			   ElementUtils.clickElementByLocator(driver,Savebutton,wait);
			   
			   WebElement scroll =driver.findElement(Pradesh);
		       js.executeScript("arguments[0].scrollIntoView();",scroll);

			   ElementUtils.getElement(driver,whattsapp,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
			   ElementUtils.getElement(driver,Std,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
			   ElementUtils.getElement(driver,landline,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
			   ElementUtils.clickElementByLocator(driver,category,wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   ElementUtils.clickElementByLocator(driver,Cast,wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
		       ElementUtils.getElement(driver,email,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
			   ElementUtils.getElement(driver,dob,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
			   ElementUtils.getElement(driver,fulladdress,wait).sendKeys(RandomDataGenerator.generateRandomName());
			   ElementUtils.getElement(driver,Vibhagward,wait).sendKeys(RandomDataGenerator.generateRandomName());
			   ElementUtils.getElement(driver,talukatehsil,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());;
			  
			   ElementUtils.clickElementByLocator(driver,District, wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   
			   ElementUtils.getElement(driver,Pincode,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
			   
			   ElementUtils.clickElementByLocator(driver,Educaion,wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   ElementUtils.clickElementByLocator(driver,profession,wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   ElementUtils.clickElementByLocator(driver,Bike,wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   ElementUtils.clickElementByLocator(driver,car,wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   ElementUtils.clickElementByLocator(driver,vidhansabha,wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   ElementUtils.getElement(driver,Booth,wait).sendKeys(boothno);

			   ElementUtils.getElement(driver,Voterid, wait).sendKeys(Voter_card);
			   ElementUtils.getElement(driver,AdharID,wait).sendKeys(Adhacard);
			   
			   ElementUtils.getElement(driver,pannanumber,wait).sendKeys("5");
			   ElementUtils.getElement(driver,ration,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
			   ElementUtils.getElement(driver,facebook,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
			   ElementUtils.getElement(driver,twittter,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
			   ElementUtils.getElement(driver,insta,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
			   ElementUtils.getElement(driver,Linkdone,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
			   ElementUtils.getElement(driver,PaNmae,wait).sendKeys(RandomDataGenerator.generateRandomName());
			   ElementUtils.getElement(driver,Panumber,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
			   ElementUtils.clickElementByLocator(driver,NativeState,wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   ElementUtils.clickElementByLocator(driver,Votingstate,wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   ElementUtils.getElement(driver,Termstart,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//			   ElementUtils.elementsendkeysrandom(driver,TermEndd,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
			   ElementUtils.getElement(driver,CurrentResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.clickElementByLocator(driver,Relligion,wait);
//			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   ElementUtils.getElement(driver,PastResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
			   ElementUtils.getElement(driver,PastResponsibilityparty,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.clickElementByLocator(driver,sluation,wait);
//			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
				ElementUtils.getElement(driver,subcate,wait);
			   ElementUtils.getElement(driver,qualification,wait).sendKeys(RandomDataGenerator.generateRandomName());
			   ElementUtils.getElement(driver,termnumber,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());

			   ElementUtils.clickElementByLocator(driver,partyZila,wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);

			   ElementUtils.clickElementByLocator(driver,partymandal,wait);
			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   
			   
			   ElementUtils.clickElementByLocator(driver,add,wait);
			   Thread.sleep(3000);
		   }

		   public void dataverifcation() {
			   listoutput= new DataList();
			   JavascriptExecutor js = (JavascriptExecutor) driver;
//			   JavascriptExecutor js2 = (JavascriptExecutor) driver;
		       // Scroll to the top of the page (y-coordinate = 0)
			   WebElement scroll =driver.findElement(action);
		       js.executeScript("arguments[0].scrollIntoView();",scroll);
			   ElementUtils.clickElementByLocator(driver,action,wait);
			   ElementUtils.clickElementByLocator(driver,edit,wait);
			   
			   String Oname=ElementUtils.getElement(driver, name, wait).getAttribute("value");
					   System.out.println("User has a ro nmae :"+Oname);	   
			   listoutput.addString(Oname);
			   
//			   String OFathername = RandomDataGenerator.generateRandomName();
//			   System.out.println("User has a role of :"+OFathername);
			   String OFathername = ElementUtils.getElement(driver, Father, wait)
					   .getAttribute("value");
			   System.out.println("User has a ofname:"+OFathername);
		       listoutput.addString( OFathername);

			   
//			   ElementUtils.clickElementByLocator(driver,designation,wait);
//			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
//			   ElementUtils.clickElementByLocator(driver,hasPhone,wait);
//			   ElementUtils.clickElementByLocator(driver,dropdownOption,wait);
			   String OPHnmae = ElementUtils.getElement(driver,PhoneNumber,wait)
			    .getAttribute("value");
			   System.out.println("User has a role phn nome :"+OPHnmae);
			   listoutput.addString(OPHnmae);
			   
			   String Opri =ElementUtils.getElement(driver,primarynumber,wait)
			    .getAttribute("value");
			   System.out.println("User has a role pri :"+Opri);
			   listoutput.addString(Opri);
			   
			   //Delete the data listoutput= new DataList();
//			   JavascriptExecutor js2 = (JavascriptExecutor) driver;
////			   JavascriptExecutor js2 = (JavascriptExecutor) driver;
//		       // Scroll to the top of the page (y-coordinate = 0)
//			   WebElement scroll2 =driver.findElement(action);
		       js.executeScript("arguments[0].scrollIntoView();",scroll);
			   ElementUtils.clickElementByLocator(driver,action,wait);
			   ElementUtils.clickElementByLocator(driver,edit,wait);
			   
			   
		   }
		   
		   public void AdbiyancardDataEntry() throws InterruptedException{
			   ElementUtils.clickElementByLocator(driver,AbhiyanCard,wait);
			   ElementUtils.clickElementByLocator(driver,Datalevel,wait);

		   }
//		   public void AbhiyanPradeshDataEntry() throws InterruptedException, ParseException {
//
//			   ElementUtils.clickElementByLocator(driver,unit,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   filterlist.addString(ElementUtils.FilterText);
//			   ElementUtils.clickElementByLocator(driver,subUnit,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   filterlist.addString(ElementUtils.FilterText);
//			   ElementUtils.clickElementByLocator(driver,searchButton,wait);
//
//
//
////	   Main Data entry
//			   listinput=new DataList();
//			   String fulname = RandomDataGenerator.generateRandomName();
//			   System.out.println("User has a nmae :"+fulname);
//			   ElementUtils.getElement(driver, name, wait)
//					   .sendKeys(fulname);
//			   listinput.addString(fulname);
//
//			   String Fathername = RandomDataGenerator.generateRandomName();
//			   System.out.println("User has a Father :"+Fathername);
//			   ElementUtils.getElement(driver, Father, wait)
//					   .sendKeys(Fathername);
//			   listinput.addString(Fathername);
//
//			   ElementUtils.clickElementByLocator(driver,designation,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//			   ElementUtils.dropdownHandling(driver,hasPhone,wait);
////		apply_validation_in_any_contact_number();
//			   String Phname =RandomDataGenerator.generateRandomPhoneNumber();
//			   ElementUtils.getElement(driver,PhoneNumber,wait) .sendKeys(Phname);
//			   System.out.println("User has a phone number:"+Phname);
//			   listinput.addString(Phname);
//			   String prino = RandomDataGenerator.generateRandomPrimaryNumber();
//			   ElementUtils.getElement(driver,primarynumber,wait)
//					   .sendKeys(prino);
//			   System.out.println("User has a primary number:"+prino);
//
//			   listinput.addString(prino);
//
//
//			   ElementUtils.clickElementByLocator(driver,enterdetailInfo,wait);
//			   ElementUtils.getElement(driver, BloodGroup, wait).sendKeys("o+");
//			   ElementUtils.clickElementByLocator(driver,addMobile,wait);
//	   			ElementUtils.getElement(driver,phonnumberenter,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//				   ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//
//			   ElementUtils.clickElementByLocator(driver,Pradesh,wait);
//			   ElementUtils.getElement(driver,address,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.getElement(driver,area,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.getElement(driver,pincode,wait).sendKeys("110056");
//			   ElementUtils.getElement(driver,towncity,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.getElement(driver,state,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.clickElementByLocator(driver,home,wait);
//			   ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//			   ElementUtils.clickElementByLocator(driver, Gender, wait);
//
//			   ElementUtils.scroll(driver, Pradesh, wait);
//
//			   ElementUtils.getElement(driver,whattsapp,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//			   ElementUtils.getElement(driver,Std,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//			   ElementUtils.getElement(driver,landline,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//
//
//			   apply_validation_in_category_and_caste();
//			   ElementUtils.clickElementByLocator(driver,category,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   ElementUtils.clickElementByLocator(driver,Cast,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   apply_validation_in_email();
//			   ElementUtils.getElement(driver,email,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//			   apply_validation_in_dob();
//			   ElementUtils.getElement(driver,dob,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//			   ElementUtils.getElement(driver,fulladdress,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.getElement(driver,Vibhagward,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.getElement(driver,talukatehsil,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());;
//
//			   ElementUtils.clickElementByLocator(driver,District, wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//			   ElementUtils.getElement(driver,Pincode,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//
//			   ElementUtils.clickElementByLocator(driver,Educaion,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   ElementUtils.clickElementByLocator(driver,profession,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   ElementUtils.clickElementByLocator(driver,Bike,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   ElementUtils.clickElementByLocator(driver,car,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   ElementUtils.clickElementByLocator(driver,vidhansabha,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   ElementUtils.getElement(driver,Booth,wait).sendKeys(boothno);
//
//			   ElementUtils.getElement(driver,Voterid, wait).sendKeys(Voter_card);
//			   apply_validation_in_aadhar_number();
//			   ElementUtils.getElement(driver,AdharID,wait).sendKeys(Adhacard);
//			   ElementUtils.scroll(driver, Linkdone, wait);
//			   apply_validation_in_panna_number();
//			   ElementUtils.getElement(driver,pannanumber,wait).sendKeys("5");
//			   ElementUtils.getElement(driver,ration,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//			   ElementUtils.getElement(driver,facebook,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//			   ElementUtils.getElement(driver,twittter,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//			   ElementUtils.getElement(driver,insta,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//			   ElementUtils.getElement(driver,Linkdone,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//			   ElementUtils.getElement(driver,PaNmae,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.getElement(driver,Panumber,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//			   ElementUtils.clickElementByLocator(driver,NativeState,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   ElementUtils.clickElementByLocator(driver,Votingstate,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   ElementUtils.getElement(driver,Termstart,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//
//			   ElementUtils.getElement(driver, TermEndd, wait).sendKeys(RandomDataGenerator.generateEndDOB());
//			   Thread.sleep(3000);
//			   ElementUtils.getElement(driver,CurrentResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//
//			   ElementUtils.jsclick(driver, religion, wait);
//			   ElementUtils.jsclick(driver, islam, wait);
//			   ElementUtils.getElement(driver,PastResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.getElement(driver,PastResponsibilityparty,wait).sendKeys(RandomDataGenerator.generateRandomName());
////		String image = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\image1.jpg";
////		ElementUtils.getElement(driver,addphoto,wait).sendKeys("\\src\\main\\java\\resources\\image1.jpg");
//			   ElementUtils.jsclick(driver, saluation, wait);
//			   ElementUtils.jsclick(driver, saluationlist, wait);
////	    ElementUtils.clickElementByLocator(driver,sluation,wait);
////	    ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   ElementUtils.getElement(driver,subcate,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.getElement(driver,qualification,wait).sendKeys(RandomDataGenerator.generateRandomName());
//			   ElementUtils.getElement(driver,termnumber,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//			   apply_validation_in_party_zila_and_mandal();
//			   ElementUtils.clickElementByLocator(driver,partyZila,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//			   ElementUtils.clickElementByLocator(driver,partymandal,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//			   ElementUtils.clickElementByLocator(driver,incharge,wait);
//			   ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//
//			   ElementUtils.clickElementByLocator(driver,add,wait);
//			   Thread.sleep(3000);
//
//		   }
//	public void AbhiyanLoksabhaDataEntry() throws InterruptedException, ParseException {
//		//Loksabha element to be added
//
//		ElementUtils.clickElementByLocator(driver,unit,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		filterlist.addString(ElementUtils.FilterText);
//		ElementUtils.clickElementByLocator(driver,subUnit,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		filterlist.addString(ElementUtils.FilterText);
//		ElementUtils.clickElementByLocator(driver,searchButton,wait);
//
//
//
////	   Main Data entry
//		listinput=new DataList();
//		String fulname = RandomDataGenerator.generateRandomName();
//		System.out.println("User has a nmae :"+fulname);
//		ElementUtils.getElement(driver, name, wait)
//				.sendKeys(fulname);
//		listinput.addString(fulname);
//
//		String Fathername = RandomDataGenerator.generateRandomName();
//		System.out.println("User has a Father :"+Fathername);
//		ElementUtils.getElement(driver, Father, wait)
//				.sendKeys(Fathername);
//		listinput.addString(Fathername);
//
//		ElementUtils.clickElementByLocator(driver,designation,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.dropdownHandling(driver,hasPhone,wait);
////		apply_validation_in_any_contact_number();
//		String Phname =RandomDataGenerator.generateRandomPhoneNumber();
//		ElementUtils.getElement(driver,PhoneNumber,wait) .sendKeys(Phname);
//		System.out.println("User has a phone number:"+Phname);
//		listinput.addString(Phname);
//		String prino = RandomDataGenerator.generateRandomPrimaryNumber();
//		ElementUtils.getElement(driver,primarynumber,wait)
//				.sendKeys(prino);
//		System.out.println("User has a primary number:"+prino);
//
//		listinput.addString(prino);
//
//
//		ElementUtils.clickElementByLocator(driver,enterdetailInfo,wait);
//		ElementUtils.getElement(driver, BloodGroup, wait).sendKeys("o+");
//		ElementUtils.clickElementByLocator(driver,addMobile,wait);
//		ElementUtils.getElement(driver,phonnumberenter,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//
//		ElementUtils.clickElementByLocator(driver,Pradesh,wait);
//		ElementUtils.getElement(driver,address,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,area,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,pincode,wait).sendKeys("110056");
//		ElementUtils.getElement(driver,towncity,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,state,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.clickElementByLocator(driver,home,wait);
//		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//		ElementUtils.clickElementByLocator(driver, Gender, wait);
//
//		ElementUtils.scroll(driver, Pradesh, wait);
//
//		ElementUtils.getElement(driver,whattsapp,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.getElement(driver,Std,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.getElement(driver,landline,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//
//
//		apply_validation_in_category_and_caste();
//		ElementUtils.clickElementByLocator(driver,category,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Cast,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		apply_validation_in_email();
//		ElementUtils.getElement(driver,email,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		apply_validation_in_dob();
//		ElementUtils.getElement(driver,dob,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//		ElementUtils.getElement(driver,fulladdress,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,Vibhagward,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,talukatehsil,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());;
//
//		ElementUtils.clickElementByLocator(driver,District, wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.getElement(driver,Pincode,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//
//		ElementUtils.clickElementByLocator(driver,Educaion,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,profession,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Bike,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,car,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,vidhansabha,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,Booth,wait).sendKeys(boothno);
//
//		ElementUtils.getElement(driver,Voterid, wait).sendKeys(Voter_card);
//		apply_validation_in_aadhar_number();
//		ElementUtils.getElement(driver,AdharID,wait).sendKeys(Adhacard);
//		ElementUtils.scroll(driver, Linkdone, wait);
//		apply_validation_in_panna_number();
//		ElementUtils.getElement(driver,pannanumber,wait).sendKeys("5");
//		ElementUtils.getElement(driver,ration,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		ElementUtils.getElement(driver,facebook,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,twittter,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,insta,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,Linkdone,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,PaNmae,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,Panumber,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.clickElementByLocator(driver,NativeState,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Votingstate,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,Termstart,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//
//		ElementUtils.getElement(driver, TermEndd, wait).sendKeys(RandomDataGenerator.generateEndDOB());
//		Thread.sleep(3000);
//		ElementUtils.getElement(driver,CurrentResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//
//		ElementUtils.jsclick(driver, religion, wait);
//		ElementUtils.jsclick(driver, islam, wait);
//		ElementUtils.getElement(driver,PastResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,PastResponsibilityparty,wait).sendKeys(RandomDataGenerator.generateRandomName());
////		String image = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\image1.jpg";
////		ElementUtils.getElement(driver,addphoto,wait).sendKeys("\\src\\main\\java\\resources\\image1.jpg");
//		ElementUtils.jsclick(driver, saluation, wait);
//		ElementUtils.jsclick(driver, saluationlist, wait);
////	    ElementUtils.clickElementByLocator(driver,sluation,wait);
////	    ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,subcate,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,qualification,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,termnumber,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		apply_validation_in_party_zila_and_mandal();
//		ElementUtils.clickElementByLocator(driver,partyZila,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.clickElementByLocator(driver,partymandal,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,incharge,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//
//		ElementUtils.clickElementByLocator(driver,add,wait);
//		Thread.sleep(3000);
//
//	}
//	public void AbhiyanZilaDataEntry() throws InterruptedException, ParseException {
//		//Zila element to be added
//
//		ElementUtils.clickElementByLocator(driver,unit,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		filterlist.addString(ElementUtils.FilterText);
//		ElementUtils.clickElementByLocator(driver,subUnit,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		filterlist.addString(ElementUtils.FilterText);
//		ElementUtils.clickElementByLocator(driver,searchButton,wait);
//
//
//
////	   Main Data entry
//		listinput=new DataList();
//		String fulname = RandomDataGenerator.generateRandomName();
//		System.out.println("User has a nmae :"+fulname);
//		ElementUtils.getElement(driver, name, wait)
//				.sendKeys(fulname);
//		listinput.addString(fulname);
//
//		String Fathername = RandomDataGenerator.generateRandomName();
//		System.out.println("User has a Father :"+Fathername);
//		ElementUtils.getElement(driver, Father, wait)
//				.sendKeys(Fathername);
//		listinput.addString(Fathername);
//
//		ElementUtils.clickElementByLocator(driver,designation,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.dropdownHandling(driver,hasPhone,wait);
////		apply_validation_in_any_contact_number();
//		String Phname =RandomDataGenerator.generateRandomPhoneNumber();
//		ElementUtils.getElement(driver,PhoneNumber,wait) .sendKeys(Phname);
//		System.out.println("User has a phone number:"+Phname);
//		listinput.addString(Phname);
//		String prino = RandomDataGenerator.generateRandomPrimaryNumber();
//		ElementUtils.getElement(driver,primarynumber,wait)
//				.sendKeys(prino);
//		System.out.println("User has a primary number:"+prino);
//
//		listinput.addString(prino);
//
//
//		ElementUtils.clickElementByLocator(driver,enterdetailInfo,wait);
//		ElementUtils.getElement(driver, BloodGroup, wait).sendKeys("o+");
//		ElementUtils.clickElementByLocator(driver,addMobile,wait);
//		ElementUtils.getElement(driver,phonnumberenter,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//
//		ElementUtils.clickElementByLocator(driver,Pradesh,wait);
//		ElementUtils.getElement(driver,address,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,area,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,pincode,wait).sendKeys("110056");
//		ElementUtils.getElement(driver,towncity,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,state,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.clickElementByLocator(driver,home,wait);
//		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//		ElementUtils.clickElementByLocator(driver, Gender, wait);
//
//		ElementUtils.scroll(driver, Pradesh, wait);
//
//		ElementUtils.getElement(driver,whattsapp,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.getElement(driver,Std,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.getElement(driver,landline,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//
//
//		apply_validation_in_category_and_caste();
//		ElementUtils.clickElementByLocator(driver,category,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Cast,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		apply_validation_in_email();
//		ElementUtils.getElement(driver,email,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		apply_validation_in_dob();
//		ElementUtils.getElement(driver,dob,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//		ElementUtils.getElement(driver,fulladdress,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,Vibhagward,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,talukatehsil,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());;
//
//		ElementUtils.clickElementByLocator(driver,District, wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.getElement(driver,Pincode,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//
//		ElementUtils.clickElementByLocator(driver,Educaion,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,profession,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Bike,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,car,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,vidhansabha,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,Booth,wait).sendKeys(boothno);
//
//		ElementUtils.getElement(driver,Voterid, wait).sendKeys(Voter_card);
//		apply_validation_in_aadhar_number();
//		ElementUtils.getElement(driver,AdharID,wait).sendKeys(Adhacard);
//		ElementUtils.scroll(driver, Linkdone, wait);
//		apply_validation_in_panna_number();
//		ElementUtils.getElement(driver,pannanumber,wait).sendKeys("5");
//		ElementUtils.getElement(driver,ration,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		ElementUtils.getElement(driver,facebook,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,twittter,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,insta,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,Linkdone,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,PaNmae,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,Panumber,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.clickElementByLocator(driver,NativeState,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Votingstate,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,Termstart,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//
//		ElementUtils.getElement(driver, TermEndd, wait).sendKeys(RandomDataGenerator.generateEndDOB());
//		Thread.sleep(3000);
//		ElementUtils.getElement(driver,CurrentResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//
//		ElementUtils.jsclick(driver, religion, wait);
//		ElementUtils.jsclick(driver, islam, wait);
//		ElementUtils.getElement(driver,PastResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,PastResponsibilityparty,wait).sendKeys(RandomDataGenerator.generateRandomName());
////		String image = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\image1.jpg";
////		ElementUtils.getElement(driver,addphoto,wait).sendKeys("\\src\\main\\java\\resources\\image1.jpg");
//		ElementUtils.jsclick(driver, saluation, wait);
//		ElementUtils.jsclick(driver, saluationlist, wait);
////	    ElementUtils.clickElementByLocator(driver,sluation,wait);
////	    ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,subcate,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,qualification,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,termnumber,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		apply_validation_in_party_zila_and_mandal();
//		ElementUtils.clickElementByLocator(driver,partyZila,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.clickElementByLocator(driver,partymandal,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,incharge,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//
//		ElementUtils.clickElementByLocator(driver,add,wait);
//		Thread.sleep(3000);
//
//	}
//	public void AbhiyanMandalDataEntry() throws InterruptedException, ParseException {
//		//Mandal element to be added
////Zila element
//		//has primary id in main entry
//		// No incgarge adrress and phone number
//		ElementUtils.clickElementByLocator(driver,unit,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		filterlist.addString(ElementUtils.FilterText);
//		ElementUtils.clickElementByLocator(driver,subUnit,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		filterlist.addString(ElementUtils.FilterText);
//		ElementUtils.clickElementByLocator(driver,searchButton,wait);
//
//
//
////	   Main Data entry
//		listinput=new DataList();
//		String fulname = RandomDataGenerator.generateRandomName();
//		System.out.println("User has a nmae :"+fulname);
//		ElementUtils.getElement(driver, name, wait)
//				.sendKeys(fulname);
//		listinput.addString(fulname);
//
//		String Fathername = RandomDataGenerator.generateRandomName();
//		System.out.println("User has a Father :"+Fathername);
//		ElementUtils.getElement(driver, Father, wait)
//				.sendKeys(Fathername);
//		listinput.addString(Fathername);
//
//		ElementUtils.clickElementByLocator(driver,designation,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.dropdownHandling(driver,hasPhone,wait);
////		apply_validation_in_any_contact_number();
//		String Phname =RandomDataGenerator.generateRandomPhoneNumber();
//		ElementUtils.getElement(driver,PhoneNumber,wait) .sendKeys(Phname);
//		System.out.println("User has a phone number:"+Phname);
//		listinput.addString(Phname);
//		String prino = RandomDataGenerator.generateRandomPrimaryNumber();
//		ElementUtils.getElement(driver,primarynumber,wait)
//				.sendKeys(prino);
//		System.out.println("User has a primary number:"+prino);
//
//		listinput.addString(prino);
//
//
//		ElementUtils.clickElementByLocator(driver,enterdetailInfo,wait);
//		ElementUtils.getElement(driver, BloodGroup, wait).sendKeys("o+");
//		ElementUtils.clickElementByLocator(driver,addMobile,wait);
//		ElementUtils.getElement(driver,phonnumberenter,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//
//		ElementUtils.clickElementByLocator(driver,Pradesh,wait);
//		ElementUtils.getElement(driver,address,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,area,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,pincode,wait).sendKeys("110056");
//		ElementUtils.getElement(driver,towncity,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,state,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.clickElementByLocator(driver,home,wait);
//		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//		ElementUtils.clickElementByLocator(driver, Gender, wait);
//
//		ElementUtils.scroll(driver, Pradesh, wait);
//
//		ElementUtils.getElement(driver,whattsapp,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.getElement(driver,Std,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.getElement(driver,landline,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//
//
//		apply_validation_in_category_and_caste();
//		ElementUtils.clickElementByLocator(driver,category,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Cast,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		apply_validation_in_email();
//		ElementUtils.getElement(driver,email,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		apply_validation_in_dob();
//		ElementUtils.getElement(driver,dob,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//		ElementUtils.getElement(driver,fulladdress,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,Vibhagward,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,talukatehsil,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());;
//
//		ElementUtils.clickElementByLocator(driver,District, wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.getElement(driver,Pincode,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//
//		ElementUtils.clickElementByLocator(driver,Educaion,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,profession,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Bike,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,car,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,vidhansabha,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,Booth,wait).sendKeys(boothno);
//
//		ElementUtils.getElement(driver,Voterid, wait).sendKeys(Voter_card);
//		apply_validation_in_aadhar_number();
//		ElementUtils.getElement(driver,AdharID,wait).sendKeys(Adhacard);
//		ElementUtils.scroll(driver, Linkdone, wait);
//		apply_validation_in_panna_number();
//		ElementUtils.getElement(driver,pannanumber,wait).sendKeys("5");
//		ElementUtils.getElement(driver,ration,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		ElementUtils.getElement(driver,facebook,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,twittter,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,insta,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,Linkdone,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,PaNmae,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,Panumber,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.clickElementByLocator(driver,NativeState,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Votingstate,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,Termstart,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//
//		ElementUtils.getElement(driver, TermEndd, wait).sendKeys(RandomDataGenerator.generateEndDOB());
//		Thread.sleep(3000);
//		ElementUtils.getElement(driver,CurrentResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//
//		ElementUtils.jsclick(driver, religion, wait);
//		ElementUtils.jsclick(driver, islam, wait);
//		ElementUtils.getElement(driver,PastResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,PastResponsibilityparty,wait).sendKeys(RandomDataGenerator.generateRandomName());
////		String image = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\image1.jpg";
////		ElementUtils.getElement(driver,addphoto,wait).sendKeys("\\src\\main\\java\\resources\\image1.jpg");
//		ElementUtils.jsclick(driver, saluation, wait);
//		ElementUtils.jsclick(driver, saluationlist, wait);
////	    ElementUtils.clickElementByLocator(driver,sluation,wait);
////	    ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,subcate,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,qualification,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,termnumber,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		apply_validation_in_party_zila_and_mandal();
//		ElementUtils.clickElementByLocator(driver,partyZila,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.clickElementByLocator(driver,partymandal,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,incharge,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//
//		ElementUtils.clickElementByLocator(driver,add,wait);
//		Thread.sleep(3000);
//
//	}
//	public void AbhiyanShaktikendraDataEntry() throws InterruptedException, ParseException {
//		//Vidhan sabha element to be added
////shakti kendra element
//		//has primary id in main entry
//		// No incgarge adrress and phone number
//		ElementUtils.clickElementByLocator(driver,unit,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		filterlist.addString(ElementUtils.FilterText);
//		ElementUtils.clickElementByLocator(driver,subUnit,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		filterlist.addString(ElementUtils.FilterText);
//		ElementUtils.clickElementByLocator(driver,searchButton,wait);
//
//
//
////	   Main Data entry
//		listinput=new DataList();
//		String fulname = RandomDataGenerator.generateRandomName();
//		System.out.println("User has a nmae :"+fulname);
//		ElementUtils.getElement(driver, name, wait)
//				.sendKeys(fulname);
//		listinput.addString(fulname);
//
//		String Fathername = RandomDataGenerator.generateRandomName();
//		System.out.println("User has a Father :"+Fathername);
//		ElementUtils.getElement(driver, Father, wait)
//				.sendKeys(Fathername);
//		listinput.addString(Fathername);
//
//		ElementUtils.clickElementByLocator(driver,designation,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.dropdownHandling(driver,hasPhone,wait);
////		apply_validation_in_any_contact_number();
//		String Phname =RandomDataGenerator.generateRandomPhoneNumber();
//		ElementUtils.getElement(driver,PhoneNumber,wait) .sendKeys(Phname);
//		System.out.println("User has a phone number:"+Phname);
//		listinput.addString(Phname);
//		String prino = RandomDataGenerator.generateRandomPrimaryNumber();
//		ElementUtils.getElement(driver,primarynumber,wait)
//				.sendKeys(prino);
//		System.out.println("User has a primary number:"+prino);
//
//		listinput.addString(prino);
//
//
//		ElementUtils.clickElementByLocator(driver,enterdetailInfo,wait);
//		ElementUtils.getElement(driver, BloodGroup, wait).sendKeys("o+");
//		ElementUtils.clickElementByLocator(driver,addMobile,wait);
//		ElementUtils.getElement(driver,phonnumberenter,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//
//		ElementUtils.clickElementByLocator(driver,Pradesh,wait);
//		ElementUtils.getElement(driver,address,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,area,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,pincode,wait).sendKeys("110056");
//		ElementUtils.getElement(driver,towncity,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,state,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.clickElementByLocator(driver,home,wait);
//		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//		ElementUtils.clickElementByLocator(driver, Gender, wait);
//
//		ElementUtils.scroll(driver, Pradesh, wait);
//
//		ElementUtils.getElement(driver,whattsapp,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.getElement(driver,Std,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.getElement(driver,landline,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//
//
//		apply_validation_in_category_and_caste();
//		ElementUtils.clickElementByLocator(driver,category,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Cast,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		apply_validation_in_email();
//		ElementUtils.getElement(driver,email,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		apply_validation_in_dob();
//		ElementUtils.getElement(driver,dob,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//		ElementUtils.getElement(driver,fulladdress,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,Vibhagward,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,talukatehsil,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());;
//
//		ElementUtils.clickElementByLocator(driver,District, wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.getElement(driver,Pincode,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//
//		ElementUtils.clickElementByLocator(driver,Educaion,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,profession,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Bike,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,car,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,vidhansabha,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,Booth,wait).sendKeys(boothno);
//
//		ElementUtils.getElement(driver,Voterid, wait).sendKeys(Voter_card);
//		apply_validation_in_aadhar_number();
//		ElementUtils.getElement(driver,AdharID,wait).sendKeys(Adhacard);
//		ElementUtils.scroll(driver, Linkdone, wait);
//		apply_validation_in_panna_number();
//		ElementUtils.getElement(driver,pannanumber,wait).sendKeys("5");
//		ElementUtils.getElement(driver,ration,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		ElementUtils.getElement(driver,facebook,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,twittter,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,insta,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,Linkdone,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,PaNmae,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,Panumber,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.clickElementByLocator(driver,NativeState,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Votingstate,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,Termstart,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//
//		ElementUtils.getElement(driver, TermEndd, wait).sendKeys(RandomDataGenerator.generateEndDOB());
//		Thread.sleep(3000);
//		ElementUtils.getElement(driver,CurrentResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//
//		ElementUtils.jsclick(driver, religion, wait);
//		ElementUtils.jsclick(driver, islam, wait);
//		ElementUtils.getElement(driver,PastResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,PastResponsibilityparty,wait).sendKeys(RandomDataGenerator.generateRandomName());
////		String image = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\image1.jpg";
////		ElementUtils.getElement(driver,addphoto,wait).sendKeys("\\src\\main\\java\\resources\\image1.jpg");
//		ElementUtils.jsclick(driver, saluation, wait);
//		ElementUtils.jsclick(driver, saluationlist, wait);
////	    ElementUtils.clickElementByLocator(driver,sluation,wait);
////	    ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,subcate,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,qualification,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,termnumber,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		apply_validation_in_party_zila_and_mandal();
//		ElementUtils.clickElementByLocator(driver,partyZila,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.clickElementByLocator(driver,partymandal,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,incharge,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//
//		ElementUtils.clickElementByLocator(driver,add,wait);
//		Thread.sleep(3000);
//
//	}
//	public void AbhiyanBoothDataEntry() throws InterruptedException, ParseException {
//		//Vidhan sabha element to be added
////booth element
//		//has primary id in main entry
//		// No incgarge adrress and phone number
//		ElementUtils.clickElementByLocator(driver,unit,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		filterlist.addString(ElementUtils.FilterText);
//		ElementUtils.clickElementByLocator(driver,subUnit,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		filterlist.addString(ElementUtils.FilterText);
//		ElementUtils.clickElementByLocator(driver,searchButton,wait);
//
//
//
////	   Main Data entry
//		listinput=new DataList();
//		String fulname = RandomDataGenerator.generateRandomName();
//		System.out.println("User has a nmae :"+fulname);
//		ElementUtils.getElement(driver, name, wait)
//				.sendKeys(fulname);
//		listinput.addString(fulname);
//
//		String Fathername = RandomDataGenerator.generateRandomName();
//		System.out.println("User has a Father :"+Fathername);
//		ElementUtils.getElement(driver, Father, wait)
//				.sendKeys(Fathername);
//		listinput.addString(Fathername);
//
//		ElementUtils.clickElementByLocator(driver,designation,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.dropdownHandling(driver,hasPhone,wait);
////		apply_validation_in_any_contact_number();
//		String Phname =RandomDataGenerator.generateRandomPhoneNumber();
//		ElementUtils.getElement(driver,PhoneNumber,wait) .sendKeys(Phname);
//		System.out.println("User has a phone number:"+Phname);
//		listinput.addString(Phname);
//		String prino = RandomDataGenerator.generateRandomPrimaryNumber();
//		ElementUtils.getElement(driver,primarynumber,wait)
//				.sendKeys(prino);
//		System.out.println("User has a primary number:"+prino);
//
//		listinput.addString(prino);
//
//
//		ElementUtils.clickElementByLocator(driver,enterdetailInfo,wait);
//		ElementUtils.getElement(driver, BloodGroup, wait).sendKeys("o+");
//		ElementUtils.clickElementByLocator(driver,addMobile,wait);
//		ElementUtils.getElement(driver,phonnumberenter,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//
//		ElementUtils.clickElementByLocator(driver,Pradesh,wait);
//		ElementUtils.getElement(driver,address,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,area,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,pincode,wait).sendKeys("110056");
//		ElementUtils.getElement(driver,towncity,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,state,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.clickElementByLocator(driver,home,wait);
//		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
//		ElementUtils.clickElementByLocator(driver, Gender, wait);
//
//		ElementUtils.scroll(driver, Pradesh, wait);
//
//		ElementUtils.getElement(driver,whattsapp,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.getElement(driver,Std,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.getElement(driver,landline,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//
//
//		apply_validation_in_category_and_caste();
//		ElementUtils.clickElementByLocator(driver,category,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Cast,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		apply_validation_in_email();
//		ElementUtils.getElement(driver,email,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		apply_validation_in_dob();
//		ElementUtils.getElement(driver,dob,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//		ElementUtils.getElement(driver,fulladdress,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,Vibhagward,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,talukatehsil,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());;
//
//		ElementUtils.clickElementByLocator(driver,District, wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.getElement(driver,Pincode,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//
//		ElementUtils.clickElementByLocator(driver,Educaion,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,profession,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Bike,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,car,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,vidhansabha,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,Booth,wait).sendKeys(boothno);
//
//		ElementUtils.getElement(driver,Voterid, wait).sendKeys(Voter_card);
//		apply_validation_in_aadhar_number();
//		ElementUtils.getElement(driver,AdharID,wait).sendKeys(Adhacard);
//		ElementUtils.scroll(driver, Linkdone, wait);
//		apply_validation_in_panna_number();
//		ElementUtils.getElement(driver,pannanumber,wait).sendKeys("5");
//		ElementUtils.getElement(driver,ration,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		ElementUtils.getElement(driver,facebook,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,twittter,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,insta,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,Linkdone,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
//		ElementUtils.getElement(driver,PaNmae,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,Panumber,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//		ElementUtils.clickElementByLocator(driver,NativeState,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,Votingstate,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,Termstart,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
//
//		ElementUtils.getElement(driver, TermEndd, wait).sendKeys(RandomDataGenerator.generateEndDOB());
//		Thread.sleep(3000);
//		ElementUtils.getElement(driver,CurrentResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//
//		ElementUtils.jsclick(driver, religion, wait);
//		ElementUtils.jsclick(driver, islam, wait);
//		ElementUtils.getElement(driver,PastResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,PastResponsibilityparty,wait).sendKeys(RandomDataGenerator.generateRandomName());
////		String image = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\image1.jpg";
////		ElementUtils.getElement(driver,addphoto,wait).sendKeys("\\src\\main\\java\\resources\\image1.jpg");
//		ElementUtils.jsclick(driver, saluation, wait);
//		ElementUtils.jsclick(driver, saluationlist, wait);
////	    ElementUtils.clickElementByLocator(driver,sluation,wait);
////	    ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.getElement(driver,subcate,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,qualification,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,termnumber,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		apply_validation_in_party_zila_and_mandal();
//		ElementUtils.clickElementByLocator(driver,partyZila,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//		ElementUtils.clickElementByLocator(driver,partymandal,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,incharge,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//
//
//		ElementUtils.clickElementByLocator(driver,add,wait);
//		Thread.sleep(3000);
//
//	}

	}
	

