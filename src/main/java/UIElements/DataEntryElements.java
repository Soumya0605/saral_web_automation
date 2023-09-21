package UIElements;

import org.openqa.selenium.By;

public class DataEntryElements {

//	 Dyamic xpath

    public static By adminDistrict= By.xpath("//div[contains(text(),'Select Administrative District')]//parent::div//parent::div//following-sibling::ng-dropdown-panel//div[@class='ng-option ng-star-inserted']");
    public static String updatedNumber;
    String xpathExpression = "//td[.//div[contains(text(), '" + updatedNumber + "')]]/parent::tr//button";
    public static By dataEntryListHeader = By.xpath("//thead//tr//th");
    public static By dynamicPath = By.xpath("//th[contains(text(),' Phone Number ')]//parent::tr//parent::thead//following-sibling::tbody//div[contains(text(),' 8287368271')]");

//Data Level
    public static By VibhagLevel = By.xpath("//h5[contains(text(),'Vibhag')]//parent::div//parent::div//parent::div[@class='col-md-3']//following-sibling::div[@class='col-md-9']//button//span[@class='mat-button-wrapper']");
    public static By PradeshDatalevel = By.xpath("//h5[contains(text(),'Pradesh')]/../../../..//button[contains(., 'Add Entry')]");
    public static By LoksabhaLevel = By.xpath("//h5[text()='Lok Sabha']/../../../..//button[contains(., 'Add Entry')]");
    public static By VidhanSabhaLevel = By.xpath("//h5[contains(text(),'Vidhan Sabha')]/../../../..//button[contains(., 'Add Entry')]");
    public static By ZilaLevel = By.xpath("//h5[contains(text(),'Zila')]/../../../..//button[contains(., 'Add Entry')]");
    public static By MandalLevel = By.xpath("//h5[contains(text(),'Mandal')]/../../../..//button[contains(., 'Add Entry')]");
    public static By ShaktiKendraLevel = By.xpath("//h5[contains(text(),'Shakti Kendra')]/../../../..//button[contains(., 'Add Entry')]");
    public static By BoothLevel = By.xpath("//h5[contains(text(),'Booth')]/../../../..//button[contains(., 'Add Entry')]");
    //	Static xpath
    public static By ProfilIcon =By.xpath("//*[name()='path' and contains(@d,'M0 15C0 6.')]");
    public static By AbhiyanCard = By.xpath("//mat-card-title[contains(text(),'Abhiyan Data Entry' )]");
    public static By Role = By.xpath("//b[contains(text(),'Role:')]//parent::div");

    public static By datalevelverification =By.xpath("//h5");

    public static By vibhag = By.xpath("//div[text()='Select Vibhag']");
    public static By unit = By.xpath("//div[text()='Select Organisation Unit']");
    public static By subUnit= By.xpath("//div[text()='Select Organisation Sub Unit']");
    public static By dropdownOption = By.xpath("//div[@role='option'][1]");
    public static By searchButton = By.xpath("//button//span[contains(text(),'Search')]");
    //For AutoFill enabled   public static By = By.xpath("");
    public static By PhonenumberBox= By.xpath("//div[@class='mat-form-field-infix ng-tns-c107-30']");
    public static By SearchButton = By.xpath("//button[@type='submit']");
    public static By AddEntry = By.xpath("//button[@class='mat-focus-indicator btn orange-btn zoom mat-raised-button mat-button-base']//span[@class='mat-button-wrapper' and contains(text(),' Add New ') ]");
    //   public static By = By.xpath("");
    public static By name = By.xpath("//input[@placeholder='Name']");
    public static By Father= By.xpath("//input[@placeholder=\"Father's/Husband's Name\"]");
    public static By designation = By.xpath("//ng-select//div[@class='ng-placeholder'and contains(text(),'Select Designation *')]");
//    public static By hasPhone = By.xpath("//ng-select//div[@class='ng-placeholder'and contains(text(),'Has Smartphone')]");
    public static By PhoneNumber = By.xpath("//input[@data-placeholder='Phone Number']");
    public static By primarynumber = By.xpath("//input[@data-placeholder='Primary Member Id']");
    public static By Age = By.xpath("//input[@data-placeholder='Age']");

    public static By enterdetailInfo = By.xpath("//mat-panel-title[contains(text(),'Enter More Details ')]");

    public static By BloodGroup = By.xpath("//input[@data-placeholder='Blood Group']");
    public static By addMobile = By.xpath("//span[contains(text(),'Add Mobiles')]");
    public static By phonnumberenter = By.xpath("//input[@placeholder='Enter your Mobile Number']");
    public static By Savebutton = By.xpath("//span[contains(text(),'Save')]");
    public static By Cancelbutton = By.xpath("//span[contains(text(),'Cancel')]");

    public static By Pradesh = By.xpath("//span[contains(text(),'Add An Address')]");
    public static By address  = By.xpath("//input[@placeholder='Enter your address']");
    public static By area = By.xpath("//input[@placeholder='Enter your area']");
    public static By pincode  = By.xpath("//input[@placeholder='Enter your pin code']");
    public static By towncity = By.xpath("//input[@placeholder='Enter your town/city']");
    public static By state = By.xpath("//input[@placeholder='Enter your state']");
    public static By home = By.xpath("//mat-chip[@role='option' and contains(text(),'Home')]");
    public static By office = By.xpath("//mat-chip[@role='option' and contains(text(),'Office')]");
    public static By Other = By.xpath("//mat-chip[@role='option' and contains(text(),'Other')]");
    //	 public static By  = By.xpath("");
//	 public static By  = By.xpath("");
    public static By Gender = By.xpath("//input[@value='male']//parent::span");

    public static By whattsapp = By.xpath("//input[@placeholder='WhatsApp Number']");
    public static By Std = By.xpath("//input[@data-placeholder='STD Code']");
    public static By landline = By.xpath("//input[@data-placeholder='Landline Number']");
    //div[contains(text(),'Select Category')]
    public static By category = By.xpath("//div[contains(text(),'Select Category')]");
    public static By categoryType = By.xpath("//div[@role='option'][1]");
    public static By Cast = By.xpath("//div[contains(text(),'Caste')]");
    public static By Casttooltip=By.xpath("//div[@class='mat-tooltip mat-tooltip-show']");
    public static By Casttype = By.xpath("//div[@role='option'][1]");
    public static By email= By.xpath("//input[@data-placeholder='Email']");

    public static By dob  = By.xpath("//input[@data-placeholder='Dob']");
    public static By fulladdress= By.xpath("//input[@placeholder='Full Address']");
    public static By Vibhagward = By.xpath("//input[@placeholder='Village/Ward']");
    public static By talukatehsil = By.xpath("//input[contains(@placeholder, 'Taluka')]");

    public static By District = By.xpath("//div[contains(text(),'Select District')]");
    public static By Districlist = By.xpath("//div[@role='option'][1]");
    public static By Pincode = By.xpath("//input[@placeholder='Pin Code']");

    public static By Educaion  = By.xpath("//div[contains(text(),'Select Education')]");
    public static By profession  = By.xpath("//div[contains(text(),'Select Profession')]");
    public static By Bike = By.xpath("//div[contains(text(),'Bike')]");
    public static By car = By.xpath("//div[contains(text(),'Car')]");
    public static By vidhansabha = By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]");
    public static By Booth = By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]");

    public static By Voterid = By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]");
    public static By AdharID = By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]");

    public static By pannanumber = By.xpath("//input[contains(@placeholder, 'Panna Number')]");
    public static By ration = By.xpath("//input[contains(@placeholder, 'Ration Card Number')]");
    public static By facebook= By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]");
    public static By twittter = By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]");
    public static By insta = By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]");
    public static By Linkdone = By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]");
    public static By PaNmae = By.xpath("//input[contains(@placeholder, 'PA Name')]");
    public static By Panumber = By.xpath("//input[contains(@placeholder, 'PA Number')]");
    public static By NativeState = By.xpath("//div [contains(text(), 'Native State')]");
    public static By Votingstate = By.xpath("//div [contains(text(), 'Voting State')]");
    public static By Termstart =By.xpath("//input[@data-placeholder= 'Term Start']");

    public static By TermEndd =By.xpath("//input[@data-placeholder= 'Term End']");
    public static By CurrentResponsibility =By.xpath("//input[contains(@placeholder, 'Responsibility in Govt.')]");

    public static By PastResponsibility =By.xpath("//input[contains(@placeholder, 'Past Responsibility in Govt.')]");
    public static By PastResponsibilityparty =By.xpath("//input[contains(@placeholder, 'Past Responsibility in party')]");
    public static By sluation = By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c126-73 ng-star-inserted']");
    public static By subcate = By.xpath("//input[contains(@placeholder, 'Sub cast')]");
    public static By qualification = By.xpath("//input[contains(@placeholder, 'Qualification')]");
    public static By termnumber = By.xpath("//input[contains(@placeholder, 'No of Terms')]");
    public static By partyZila = By.xpath("//div[contains(text(),'Select Party Zila')]");
    public static By partymandal = By.xpath("//div[contains(text(),'Select Party Mandal')]");
    public static By add = By.xpath("//button[@type='submit']");
    //mat-icon[normalize-space()='more_vert']
    public static By action = By.xpath("//mat-icon[normalize-space()='more_vert']");


    public static By edit = By.xpath("//button//span[contains(text(),'Edit')]");
    public static By delete = By.xpath("//button//img[@title='Delete']");
    //span[contains(text(),'Delete')]
    public static By reason = By.xpath("//label//mat-label[contains(text(),'Reason')]");
    public static By option = By.xpath("//mat-option//span[contains(text(),' Left The Party ')]");
//    public static By deleteentry = By.xpath("//button[.='Delete']");
    	 public static By deleteentry = By.xpath("//span[text()='Delete']");
    //following-sibling::span[@class='mat-ripple mat-button-ripple']
    public static By relative = By.xpath("//input[@id='mat-input-27']");
    public static By PhotoEle = By.xpath("//input[@type='file']");
    public static By addphoto= By.xpath("//a[@role='menuitem']");
    public static By saluation = By.xpath("//label//mat-label[contains(text(),'Salutation')]");
    public static By saluationlist = By.xpath("//span[normalize-space()='Shri']");
    public static By subcast = By.xpath("//input[@id='mat-input-29']");

    public static 	By religion = By.xpath("//label//mat-label[contains(text(),'Religion')]");
    public static By islam = By.xpath("//span[normalize-space()='Islam']");
    public static By activememberid= By.xpath("//input[@id='mat-input-31']");
    public static By zila = By.xpath("//ng-select[@class='ng-select ng-select-single ng-select-searchable ng-select-clearable ng-untouched ng-pristine ng-valid ng-star-inserted ng-select-opened ng-select-top ng-select-focused']//input[@role='combobox']");
    public static By Zilatype = By.xpath("//div[@id='aaf1f32d4165-2']");
    public static By mandal = By.xpath("//ng-select[@class='ng-select ng-select-single ng-select-searchable ng-select-clearable ng-pristine ng-valid ng-star-inserted ng-select-bottom ng-touched ng-select-focused ng-select-opened']//div[@class='ng-value-container']");
    public static By mandallist= By.xpath("//span[@class='ng-option-label ng-star-inserted'][normalize-space()='Dangtol']");
    public static By incharge = By.xpath("//div[contains(text(),'Incharge')]");
    public static By inchargelist= By.xpath("//div[@id='a001bc710ebb-1']");
    public static By addentry = By.xpath("normalize-space()='Add'");
    public static By latestentryValidation =By.xpath("//div[contains(text(),' 8928716387')]//parent::td//parent::tr/td/div/button");

   //Valtdation element
    public static By panna_valid = By.xpath("//div//mat-error[contains(text(),'Please enter a valid input')]");
    public static By phone_ten_digit_valid = By.xpath("//div//mat-error[contains(text(),'Enter valid 10 digit phone number')]");
    public static By error = By.className("mat-error");

// Loksabha Data Entry
    //div[text()='Select Constituency (Lok Sabha)']
public static By SelectLoksabha = By.xpath("//div[text()='Select Constituency (Lok Sabha)']");
}
