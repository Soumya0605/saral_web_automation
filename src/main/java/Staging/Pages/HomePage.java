package Staging.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Staging.pakages.DataList;
import Staging.pakages.ElementUtils;
import Staging.pakages.RandomDataGenerator;
import org.testng.Assert;

import static Staging.Pages.ProfilePage.role_name;
import static UIElements.DataEntryElements.*;

import java.text.ParseException;
import java.util.*;
public class HomePage {
	private JavascriptExecutor js ;
	private WebDriver driver;
	private WebDriverWait wait;
	public static DataList listinput,listoutput,filterlist;
	public static String Ophname;

	String Voter_card = "UTC026351";
	String Adhacard = "123490877842";
	String boothno="123";


	public HomePage(WebDriver driver) {
		this.driver=driver;

	}
	public String gettiltle() {
		return driver.getTitle();
	}

//	public ProfilePage ProfileSection() throws InterruptedException {
//		ElementUtils.clickElementByLocator(driver, ProfilIcon, wait);
//		return new ProfilePage(driver);
//	}
	public void ProfileSectionDropdown() throws InterruptedException {
		ElementUtils.clickElementByLocator(driver, ProfileIconDropDown, wait);
	}
	public ProfilePage ProfileButton() throws InterruptedException {
		ElementUtils.clickElementByLocator(driver, ProfileButton, wait);
		return new ProfilePage(driver);
    }





	public void AutoFill() {

		ElementUtils.getElement(driver, PhonenumberBox, wait)
				.sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
		ElementUtils.clickElementByLocator(driver, SearchButton, wait);
		ElementUtils.clickElementByLocator(driver, AddEntry, wait);
	}
	//
	public void AbhiyanVibhagDataEntry() throws InterruptedException, ParseException {

		filterlist= new DataList();
		listinput=new DataList();
		//Search Action
		JavascriptExecutor js = (JavascriptExecutor) driver;

		ElementUtils.clickElementByLocator(driver,vibhag,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
       filterlist.addString(ElementUtils.FilterText);
		ElementUtils.clickElementByLocator(driver,unit,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		filterlist.addString(ElementUtils.FilterText);
		ElementUtils.clickElementByLocator(driver,subUnit,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		filterlist.addString(ElementUtils.FilterText);
		ElementUtils.clickElementByLocator(driver,searchButton,wait);


		listinput=new DataList();
//	   Main Data entry
		listinput=new DataList();
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
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		apply_validation_in_any_contact_number();
		String Phname =RandomDataGenerator.generateRandomPhoneNumber();
		ElementUtils.getElement(driver,PhoneNumber,wait) .sendKeys(Phname);
		System.out.println("User has a phone number:"+Phname);
		listinput.addString(Phname);
		String prino = RandomDataGenerator.generateRandomPrimaryNumber();
		ElementUtils.getElement(driver,primarynumber,wait)
				.sendKeys(prino);
		System.out.println("User has a primary number:"+prino);

		listinput.addString(prino);


		ElementUtils.clickElementByLocator(driver,enterdetailInfo,wait);
		ElementUtils.getElement(driver, BloodGroup, wait).sendKeys("o+");
//	   ElementUtils.clickElementByLocator(driver,addMobile,wait);
//	   ElementUtils.getElement(driver,phonnumberenter,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
//	   ElementUtils.clickElementByLocator(driver,Savebutton,wait);

		ElementUtils.clickElementByLocator(driver,Pradesh,wait);
		ElementUtils.getElement(driver,address,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,area,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,pincode,wait).sendKeys("110056");
		ElementUtils.getElement(driver,towncity,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,state,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.clickElementByLocator(driver,home,wait);
		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
		ElementUtils.clickElementByLocator(driver, Gender, wait);

		ElementUtils.scroll(driver, Pradesh, wait);

		ElementUtils.getElement(driver,whattsapp,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
		ElementUtils.getElement(driver,Std,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
		ElementUtils.getElement(driver,landline,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());


		apply_validation_in_category_and_caste();
		ElementUtils.clickElementByLocator(driver,category,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,Cast,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		apply_validation_in_email();
		ElementUtils.getElement(driver,email,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		apply_validation_in_dob();
		ElementUtils.getElement(driver,dob,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
		ElementUtils.getElement(driver,fulladdress,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,Vibhagward,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,talukatehsil,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());;

		ElementUtils.clickElementByLocator(driver,District, wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);

		ElementUtils.getElement(driver,Pincode,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());

		ElementUtils.clickElementByLocator(driver,Educaion,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,profession,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,Bike,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,car,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,vidhansabha,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.getElement(driver,Booth,wait).sendKeys(boothno);

		ElementUtils.getElement(driver,Voterid, wait).sendKeys(Voter_card);
		apply_validation_in_aadhar_number();
		ElementUtils.getElement(driver,AdharID,wait).sendKeys(Adhacard);
		ElementUtils.scroll(driver, Linkdone, wait);
		apply_validation_in_panna_number();
		ElementUtils.getElement(driver,pannanumber,wait).sendKeys("5");
		ElementUtils.getElement(driver,ration,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
		ElementUtils.getElement(driver,facebook,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		ElementUtils.getElement(driver,twittter,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		ElementUtils.getElement(driver,insta,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		ElementUtils.getElement(driver,Linkdone,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		ElementUtils.getElement(driver,PaNmae,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,Panumber,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
		ElementUtils.clickElementByLocator(driver,NativeState,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,Votingstate,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.getElement(driver,Termstart,wait).sendKeys("20/11/1994");

		ElementUtils.getElement(driver, TermEndd, wait).sendKeys("20/11/1999");
		Thread.sleep(3000);
		ElementUtils.getElement(driver,CurrentResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());

		ElementUtils.jsclick(driver, religion, wait);
		ElementUtils.jsclick(driver, islam, wait);
		ElementUtils.getElement(driver,PastResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,PastResponsibilityparty,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		String image = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\image1.jpg";
//		ElementUtils.getElement(driver,addphoto,wait).sendKeys("\\src\\main\\java\\resources\\image1.jpg");
		ElementUtils.jsclick(driver, saluation, wait);
		ElementUtils.jsclick(driver, saluationlist, wait);
//	    ElementUtils.clickElementByLocator(driver,sluation,wait);
//	    ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.getElement(driver,subcate,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,qualification,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,termnumber,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
		apply_validation_in_party_zila_and_mandal();
		ElementUtils.clickElementByLocator(driver,partyZila,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);

		ElementUtils.clickElementByLocator(driver,partymandal,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);


		ElementUtils.clickElementByLocator(driver,add,wait);
		Thread.sleep(3000);
	}
	public void AbhiyanPradeshDataEntry() throws InterruptedException, ParseException {
		filterlist= new DataList();
		listinput=new DataList();
		ElementUtils.clickElementByLocator(driver,unit,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		filterlist.addString(ElementUtils.FilterText);
		ElementUtils.clickElementByLocator(driver,subUnit,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		filterlist.addString(ElementUtils.FilterText);
		ElementUtils.clickElementByLocator(driver,searchButton,wait);



//	   Main Data entry
		listinput=new DataList();
		String fulname = RandomDataGenerator.generateRandomName();
		System.out.println("User has a nmae :"+fulname);
		ElementUtils.getElement(driver, name, wait).sendKeys(fulname);
		listinput.addString(fulname);

		String Fathername = RandomDataGenerator.generateRandomName();
		System.out.println("User has a Father :"+Fathername);
		ElementUtils.getElement(driver, Father, wait).sendKeys(Fathername);
		listinput.addString(Fathername);

		ElementUtils.clickElementByLocator(driver,designation,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);

//		ElementUtils.dropdownHandling(driver,hasPhone,wait);
//		apply_validation_in_any_contact_number();
		String Phname =RandomDataGenerator.generateRandomPhoneNumber();
		ElementUtils.getElement(driver,PhoneNumber,wait) .sendKeys(Phname);
		System.out.println("User has a phone number:"+Phname);
		listinput.addString(Phname);
		String prino = RandomDataGenerator.generateRandomPrimaryNumber();
		ElementUtils.getElement(driver,primarynumber,wait)
				.sendKeys(prino);
		System.out.println("User has a primary number:"+prino);

		listinput.addString(prino);
		ElementUtils.scroll(driver,enterdetailInfo,wait);

		ElementUtils.clickElementByLocator(driver,enterdetailInfo,wait);

		ElementUtils.getElement(driver, BloodGroup, wait).sendKeys("o+");
		ElementUtils.clickElementByLocator(driver,addMobile,wait);
		ElementUtils.getElement(driver,phonnumberenter,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
		ElementUtils.clickElementByLocator(driver,Savebutton,wait);

		ElementUtils.jsclick(driver,Pradesh,wait);
		ElementUtils.getElement(driver,address,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,area,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,pincode,wait).sendKeys("110056");
		ElementUtils.getElement(driver,towncity,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,state,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.clickElementByLocator(driver,home,wait);
		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
		ElementUtils.clickElementByLocator(driver, Gender, wait);

		ElementUtils.scroll(driver, Pradesh, wait);

		ElementUtils.getElement(driver,whattsapp,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
		ElementUtils.getElement(driver,Std,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
		ElementUtils.getElement(driver,landline,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());


		apply_validation_in_category_and_caste();
		ElementUtils.clickElementByLocator(driver,category,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,Cast,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		apply_validation_in_email();
		ElementUtils.getElement(driver,email,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		apply_validation_in_dob();
		ElementUtils.getElement(driver,dob,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
		ElementUtils.getElement(driver,fulladdress,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,Vibhagward,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,talukatehsil,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());;

		ElementUtils.clickElementByLocator(driver,District, wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);

		ElementUtils.getElement(driver,Pincode,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());

		ElementUtils.clickElementByLocator(driver,Educaion,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,profession,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,Bike,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,car,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,vidhansabha,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.getElement(driver,Booth,wait).sendKeys(boothno);

		ElementUtils.getElement(driver,Voterid, wait).sendKeys(Voter_card);
		apply_validation_in_aadhar_number();
		ElementUtils.getElement(driver,AdharID,wait).sendKeys(Adhacard);
		ElementUtils.scroll(driver, Linkdone, wait);
		apply_validation_in_panna_number();
		ElementUtils.getElement(driver,pannanumber,wait).sendKeys("5");
		ElementUtils.getElement(driver,ration,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
		ElementUtils.getElement(driver,facebook,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		ElementUtils.getElement(driver,twittter,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		ElementUtils.getElement(driver,insta,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		ElementUtils.getElement(driver,Linkdone,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
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
//
//		ElementUtils.jsclick(driver, islam, wait);
//		ElementUtils.getElement(driver,PastResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,PastResponsibilityparty,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		String image = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\image1.jpg";
//		ElementUtils.getElement(driver,addphoto,wait).sendKeys("\\src\\main\\java\\resources\\image1.jpg");
		ElementUtils.jsclick(driver, saluation, wait);
		ElementUtils.jsclick(driver, saluationlist, wait);
//	    ElementUtils.clickElementByLocator(driver,sluation,wait);
//	    ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.getElement(driver,subcate,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,qualification,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.jsclick(driver, religion, wait);
		ElementUtils.jsclick(driver, islam, wait);
		ElementUtils.getElement(driver,activememberid,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		ElementUtils.getElement(driver,termnumber,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
		apply_validation_in_party_zila_and_mandal();
		ElementUtils.clickElementByLocator(driver,partyZila,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);

		ElementUtils.clickElementByLocator(driver,partymandal,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
//		ElementUtils.clickElementByLocator(driver,incharge,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption,wait);


		ElementUtils.clickElementByLocator(driver,add,wait);
		Thread.sleep(3000);

	}
	public void AbhiyanLoksabhaDataEntry() throws InterruptedException, ParseException {
		//Loksabha element to be added
		filterlist= new DataList();
		listinput=new DataList();
		ElementUtils.clickElementByLocator(driver,SelectLoksabha,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,unit,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		filterlist.addString(ElementUtils.FilterText);
		ElementUtils.clickElementByLocator(driver,subUnit,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		filterlist.addString(ElementUtils.FilterText);
		ElementUtils.clickElementByLocator(driver,searchButton,wait);



//	   Main Data entry
		listinput=new DataList();
		String fulname = RandomDataGenerator.generateRandomName();
		System.out.println("User has a nmae :"+fulname);
		ElementUtils.getElement(driver, name, wait).sendKeys(fulname);
		listinput.addString(fulname);

		String Fathername = RandomDataGenerator.generateRandomName();
		System.out.println("User has a Father :"+Fathername);
		ElementUtils.getElement(driver, Father, wait).sendKeys(Fathername);
		listinput.addString(Fathername);

		ElementUtils.clickElementByLocator(driver,designation,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);

//		ElementUtils.clickElementByLocator(driver,hasPhone,wait);
//		ElementUtils.dropdownHandling(driver,dropdownOption, wait);
//		apply_validation_in_any_contact_number();
		String Phname =RandomDataGenerator.generateRandomPhoneNumber();
		ElementUtils.getElement(driver,PhoneNumber,wait) .sendKeys(Phname);
		System.out.println("User has a phone number:"+Phname);
		listinput.addString(Phname);
		String prino = RandomDataGenerator.generateRandomPrimaryNumber();
		ElementUtils.getElement(driver,primarynumber,wait)
				.sendKeys(prino);
		System.out.println("User has a primary number:"+prino);

		listinput.addString(prino);
		ElementUtils.scroll(driver,enterdetailInfo,wait);

		ElementUtils.clickElementByLocator(driver,enterdetailInfo,wait);

		ElementUtils.getElement(driver, BloodGroup, wait).sendKeys("o+");
		ElementUtils.clickElementByLocator(driver,addMobile,wait);
		ElementUtils.getElement(driver,phonnumberenter,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
		ElementUtils.clickElementByLocator(driver,Savebutton,wait);

		ElementUtils.jsclick(driver,Pradesh,wait);
		ElementUtils.getElement(driver,address,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,area,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,pincode,wait).sendKeys("110056");
		ElementUtils.getElement(driver,towncity,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,state,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.clickElementByLocator(driver,home,wait);
		ElementUtils.clickElementByLocator(driver,Savebutton,wait);
		ElementUtils.clickElementByLocator(driver, Gender, wait);

		ElementUtils.scroll(driver, Pradesh, wait);

		ElementUtils.getElement(driver,whattsapp,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
		ElementUtils.getElement(driver,Std,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());
		ElementUtils.getElement(driver,landline,wait).sendKeys(RandomDataGenerator.generateRandomPhoneNumber());


		apply_validation_in_category_and_caste();
		ElementUtils.clickElementByLocator(driver,category,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,Cast,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		apply_validation_in_email();
		ElementUtils.getElement(driver,email,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		apply_validation_in_dob();
		ElementUtils.getElement(driver,dob,wait).sendKeys(RandomDataGenerator.generateRandomDOB());
		ElementUtils.getElement(driver,fulladdress,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,Vibhagward,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,talukatehsil,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());;

		ElementUtils.clickElementByLocator(driver,District, wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);

		ElementUtils.getElement(driver,Pincode,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());

		ElementUtils.clickElementByLocator(driver,Educaion,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,profession,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,Bike,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,car,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,vidhansabha,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.getElement(driver,Booth,wait).sendKeys(boothno);

		ElementUtils.getElement(driver,Voterid, wait).sendKeys(Voter_card);
		apply_validation_in_aadhar_number();
		ElementUtils.getElement(driver,AdharID,wait).sendKeys(Adhacard);
		ElementUtils.scroll(driver, Linkdone, wait);
		apply_validation_in_panna_number();
		ElementUtils.getElement(driver,pannanumber,wait).sendKeys("5");
		ElementUtils.getElement(driver,ration,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
		ElementUtils.getElement(driver,facebook,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		ElementUtils.getElement(driver,twittter,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		ElementUtils.getElement(driver,insta,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
		ElementUtils.getElement(driver,Linkdone,wait).sendKeys(RandomDataGenerator.generateRandomEmail());
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
//
//		ElementUtils.jsclick(driver, islam, wait);
//		ElementUtils.getElement(driver,PastResponsibility,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		ElementUtils.getElement(driver,PastResponsibilityparty,wait).sendKeys(RandomDataGenerator.generateRandomName());
//		String image = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\image1.jpg";
//		ElementUtils.getElement(driver,addphoto,wait).sendKeys("\\src\\main\\java\\resources\\image1.jpg");
		ElementUtils.jsclick(driver, saluation, wait);
		ElementUtils.jsclick(driver, saluationlist, wait);
//	    ElementUtils.clickElementByLocator(driver,sluation,wait);
//	    ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.getElement(driver,subcate,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.getElement(driver,qualification,wait).sendKeys(RandomDataGenerator.generateRandomName());
		ElementUtils.jsclick(driver, religion, wait);
		ElementUtils.jsclick(driver, islam, wait);
		ElementUtils.getElement(driver,activememberid,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
//		ElementUtils.getElement(driver,termnumber,wait).sendKeys(RandomDataGenerator.generateRandomPrimaryNumber());
		apply_validation_in_party_zila_and_mandal();
		ElementUtils.clickElementByLocator(driver,partyZila,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);

		ElementUtils.clickElementByLocator(driver,partymandal,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);
		ElementUtils.clickElementByLocator(driver,incharge,wait);
		ElementUtils.dropdownHandling(driver,dropdownOption,wait);


		ElementUtils.clickElementByLocator(driver,add,wait);
		Thread.sleep(3000);
	}
	public void dataverifcation() {
		listoutput= new DataList();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scroll =driver. findElement(action);
		js.executeScript("arguments[0].scrollIntoView();",scroll);
		ElementUtils.clickElementByLocator(driver,action,wait);
		ElementUtils.clickElementByLocator(driver,edit,wait);

		String Oname=ElementUtils.getElement(driver, name, wait).getAttribute("value");
		System.out.println("User has a ro nmae :"+Oname);
		listoutput.addString(Oname);

//	   String OFathername = RandomDataGenerator.generateRandomName();
//	   System.out.println("User has a role of :"+OFathername);
		String OFathername = ElementUtils.getElement(driver, Father, wait)
				.getAttribute("value");
		System.out.println("User has a ofname:"+OFathername);
		listoutput.addString( OFathername);



		Ophname = ElementUtils.getElement(driver,PhoneNumber,wait)
				.getAttribute("value");
		System.out.println("User has a role phn nome :"+Ophname);
		listoutput.addString(Ophname);

		String Opri =ElementUtils.getElement(driver,primarynumber,wait)
				.getAttribute("value");
		System.out.println("User has a role pri :"+Opri);
		listoutput.addString(Opri);


	}
	public void dataDeletion() throws InterruptedException {
		ElementUtils.scroll(driver, action, wait);
		ElementUtils.update(driver, Ophname,wait);
		ElementUtils.jsclick(driver, delete, wait);
		ElementUtils.jsclick(driver,reason,wait);
		ElementUtils.jsclick(driver,option,wait);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.ENTER).perform();







		Thread.sleep(1000);

	}
	public void AbhiyancardvibhagDataEntry() throws InterruptedException{
		ElementUtils.clickElementByLocator(driver,AbhiyanCard,wait);
//		roleVerification();
		ElementUtils.clickElementByLocator(driver,VibhagLevel,wait);

	}
	public void AbhiyancardpradeshDataEntry() throws InterruptedException{
		ElementUtils.clickElementByLocator(driver,AbhiyanCard,wait);
//		roleVerification();
		ElementUtils.clickElementByLocator(driver,PradeshDatalevel,wait);

	}
	public void AbhiyancardloksabhaDataEntry() throws InterruptedException{
		ElementUtils.clickElementByLocator(driver,AbhiyanCard,wait);
//		roleVerification();
		ElementUtils.clickElementByLocator(driver,LoksabhaLevel,wait);

	}

	public void roleVerification(){

				List<WebElement> DataEntryLevels= ElementUtils.getElements(driver,datalevelverification,wait);
				int elementSize= DataEntryLevels.size();
//				for (WebElement element : DataEntryLevels) {
////					int element= element.getSize();
////					String elementText = element.getText();
//				}
//				Assert.assertEquals(elementSize, 8);
				if(role_name.equals("natoinal")) {
					Assert.assertEquals(elementSize, 8);

				} else if (role_name.equals("natoinal")) {
					Assert.assertEquals(elementSize, 8);


				} else if (role_name.equals("national_manager")) {
					Assert.assertEquals(elementSize, 8);


				} else if (role_name.equals("state_admin")) {
					Assert.assertEquals(elementSize, 8);


				}
				else if (role_name.equals("state_manager")) {
					Assert.assertEquals(elementSize, 8);


				}
				else if (role_name.equals("zila_manager")) {
					Assert.assertEquals(elementSize, 8);


				}else if (role_name.equals("mandal_manager")) {
					Assert.assertEquals(elementSize, 8);
				}



	}
	public static void filterVarification(){

	}

	public void apply_validation_in_any_contact_number() throws InterruptedException {


		ElementUtils.getElement(driver,PhoneNumber,wait).sendKeys("167");
		ElementUtils.clickElementByLocator(driver,primarynumber,wait);
		String ten_digit_error = ElementUtils.getElement(driver,phone_ten_digit_valid,wait).getText();
		Assert.assertEquals(ten_digit_error,"Enter valid 10 digit phone number");
		ElementUtils.getElement(driver,PhoneNumber,wait).clear();

		ElementUtils.getElement(driver,PhoneNumber,wait).sendKeys("1678475581");
		ElementUtils.clickElementByLocator(driver,primarynumber,wait);
		String valid_input_error = ElementUtils.getElement(driver,panna_valid,wait).getText();
		Assert.assertEquals(valid_input_error,"Please enter a valid input");
		ElementUtils.getElement(driver,PhoneNumber,wait).clear();
		

	}




	// @And("^apply validation in category and caste$")
	public void apply_validation_in_category_and_caste() throws InterruptedException {

//		Casthover
		WebElement castver=ElementUtils.getElement(driver,Cast,wait);
		Actions actions = new Actions(driver);
		actions.moveToElement(castver).perform();

		// Caste Tooltip
		String copiedCasteTooltip=ElementUtils.getElement(driver,Casttooltip,wait).getText();
		Assert.assertEquals(copiedCasteTooltip, "Please select a category first to enter or select a caste");

	}



	public void  apply_validation_in_email() throws InterruptedException {
		ElementUtils.getElement(driver,email,wait).sendKeys("yueyewu");
		ElementUtils.clickElementByLocator(driver,dob,wait);
		String Email_error=ElementUtils.getElement(driver,error,wait).getText();
		Assert.assertEquals(Email_error,"Please enter a valid input");

	}


	public void apply_validation_in_aadhar_number() throws InterruptedException {
		ElementUtils.getElement(driver,AdharID,wait ).sendKeys("2422");
		ElementUtils.clickElementByLocator(driver,Linkdone,wait);
		String Adhar_error=ElementUtils.getElement(driver,error,wait).getText();
		Assert.assertEquals(Adhar_error,"Enter valid 12 digit aadhar number");
		ElementUtils.getElement(driver,AdharID,wait ).clear();


	}


	public void apply_validation_in_panna_number() {

		ElementUtils.getElement(driver,pannanumber,wait).sendKeys("1678");
        ElementUtils.clickElementByLocator(driver,ration,wait);
		String panna_error = ElementUtils.getElement(driver,panna_valid,wait).getText();
		Assert.assertEquals(panna_error,"Please enter a valid input");
		ElementUtils.getElement(driver,pannanumber,wait).clear();
	}

	public void apply_validation_in_party_zila_and_mandal() throws InterruptedException {
		ElementUtils.clickElementByLocator(driver,partymandal,wait);
		String popup_ele_error=ElementUtils.getElement(driver,By.className("mat-simple-snack-bar-content"),wait).getText();
		Assert.assertEquals(popup_ele_error, "Please select party zila");


	}

	public void apply_validation_in_dob() throws InterruptedException {

		ElementUtils.getElement(driver,dob,wait).sendKeys("01/12/2022");
		ElementUtils.clickElementByLocator(driver,ration,wait);
		String dob_error=ElementUtils.getElement(driver,By.xpath("//mat-error"),wait).getText();
		Assert.assertEquals(dob_error,"Minimum age should be 18 years");
		ElementUtils.getElement(driver,dob,wait).clear();


	}
}
