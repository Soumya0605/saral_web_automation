package StStepdefination;

import java.util.List;
import java.util.Map;
import java.text.ParseException;

import Staging.Pages.ProfilePage;
import org.testng.Assert;

import factory.DriverFactory;
import Staging.Pages.HomePage;
import Staging.Pages.LoginPage;
import Staging.pakages.DataList;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AbhiyanDataEntrySteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private HomePage homepage;
	private ProfilePage profilepage;
	@Given("User has already logged into the Saral")
	public void user_has_already_logged_into_the_saral(DataTable Userdata) throws InterruptedException {
		List<Map<String,String>> user= Userdata.asMaps(String.class,String.class);
		String EmailID = user.get(0).get("EmailID");
		String Password = user.get(0).get("Password");
		String Otp_string= user.get(0).get("Otp_String");
		String Otp = user.get(0).get("otp");
		
		DriverFactory.getDriver().get("https://zila-staging.ccdms.in/");
		  
		loginpage.Email_id(EmailID);
		loginpage.Password(Password);
		Thread.sleep(300);
		loginpage.SendOTP();
		Thread.sleep(300);
		loginpage.OtpInput(Otp, Otp_string);
		homepage=loginpage.login();
	   
	 
	  
	}

	@Given("User is on Homepage")
	public void user_is_on_homepage() {
		homepage.gettiltle();
	   
	}

	@When("user click on profile page")
	public void user_click_on_profile_page() {
		homepage.gettiltle();
		   
	}
//
	@Then("user gets the user name")
	public void user_gets_the_user_name() throws InterruptedException {

		profilepage=homepage.ProfileSection();
		profilepage.profilerole();

	  
	}

	@When("user click on Abhiyan data entry")
	public void user_click_on_abhiyan_data_entry()throws InterruptedException  {
		Thread.sleep(2000);
	    homepage.AdbiyancardDataEntry();
	}

//	@When("User lands on dataentry selection")
//	public void user_lands_on_dataentry_selection() {
//	  
//	}
//
//	@When("User Select the data entry")
//	public void user_select_the_data_entry() {
//	  
//	}
//
//	@Then("User goes to abhiyan data entry page and search")
//	public void user_goes_to_abhiyan_data_entry_page_and_search() {
////		 List<String> listinput = 
//				 DataList.getStringList();


	@Then("User enters the data")
	public void user_enters_the_data(DataTable vibhagdata) throws InterruptedException, ParseException {
//		List<Map<String,String>> user= vibhagdata.asMaps(String.class,String.class);
//		String Name = user.get(0).get("Name");
//		String FatherName = user.get(0).get("FatherName");
//		String Age= user.get(0).get("Age");
//		String phoneNumber = user.get(0).get("phoneNumber");
//		String primaryNumber = user.get(0).get("primaryNumber");
//		Name,FatherName,Age,phoneNumber,primaryNumber

	  homepage.AbhiyanDataSearch();
//	  homepage.AbhiyanPradeshDataEntry();
//	  homepage.AbhiyanLoksabhaDataEntry();
	  List<String> Genrated = DataList.getStringList();
	  System.out.println("List of generated strings:");
      for (String str : Genrated) {System.out.println(str); }
	  Thread.sleep(3000);
	  
	  
	  
	  homepage.dataverifcation();
	
	
	  List<String> Fetched = DataList.getStringList();
	  System.out.println("List of Fetched strings:");
      for (String str : Fetched) {
          System.out.println(str);
      }
	  
	  boolean areEqual = Genrated.equals(Fetched);

      // Print the result of the comparison
      if (areEqual) {
          System.out.println("The two ArrayLists are equal.");
      } else {
          System.out.println("The two ArrayLists are not equal.");
      }
      
//      Assert.assertEquals(areEqual, true);
      homepage.dataDeletion();

	}



	@When("User click on Abhiyanpradesh Data Entry")

	public void User_click_on_Abhiyanpradesh_Data_Entry() throws InterruptedException {
		homepage.AdbiyancardpradeshDataEntry();

	}

	@Then("User Ennters pradesh Data entry")
	public void User_Ennters_pradesh_Data_entry() throws ParseException, InterruptedException {
homepage.AbhiyanPradeshDataEntry();
	}


	@When("User click on Loksabha Data Entry")

	public void User_click_on_Loksabha_Data_Entry() throws InterruptedException {
		homepage.AdbiyancardloksabhaDataEntry();

	}

	@Then("User Ennters Loksabha Data entry")
	public void User_Ennters_Loksabha_Data_entry() throws ParseException, InterruptedException {
		homepage.AbhiyanLoksabhaDataEntry();

	}

}
