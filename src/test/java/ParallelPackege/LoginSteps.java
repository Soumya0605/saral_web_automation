package ParallelPackege;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;
import factory.DriverFactory;
import Staging.Pages.*;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
public class LoginSteps {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	 NgWebDriver ngDriver;
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver() );
//	private LoginPage loginpage = new LoginPage();
	@Given("User is on login page")
	public void user_is_on_login_page() {
	     DriverFactory.getDriver().get("https://zila-staging.ccdms.in/");
	}

	@When("User enters EmailID and Password")
	public void user_enters_EmailID_and_Password(DataTable Cred) throws InterruptedException {
		List<Map<String,String>> user= Cred.asMaps(String.class,String.class);
		String EmailID = user.get(0).get("EmailID");
		String Password = user.get(0).get("Password");
		loginpage.Email_id(EmailID);
		
		loginpage.Password(Password);
		Thread.sleep(1000);
	}
//	@When("User enters mobile Number")
	@When("^User enters mobile Number$")
	public void user_enters_mobile_Number(DataTable Number) throws InterruptedException {
//		List<Map<String,String>> user_No= Number.asMaps(String.class,String.class);
//		
//		String Mobi = user_No.get(0).get("Mobile_number");
		
		Map<String,String> mobile = Number.asMap(String.class,String.class);
		String Mobi=mobile.get("Moble");
		
//		String Password = user.get(0).get("Password");
		loginpage.phone_number(Mobi);
//		Thread.sleep(500);
//		loginpage.Password(Password);
		
		
		
	   
	}

	
//	@When("user enters Pasword {string}")
//	public void user_enters_pasword(String string) {
//	    
//	}

	@When("User click on OTP nbutton")
	public void user_click_on_otp_nbutton() throws InterruptedException {
		loginpage.SendOTP();
		Thread.sleep(300);

	}

	@When("User enters otp")
	public void user_enters_otp(DataTable OTP_Data)throws InterruptedException  {
		List<Map<String,String>> OTP= OTP_Data.asMaps(String.class,String.class);
		String Otp_string= OTP.get(0).get("Otp_String");
		String Otp = OTP.get(0).get("otp");
//		loginpage.OtpInput(Otp, Otp_string);
//		loginpage.SendOTP();
		loginpage.OtpInput(Otp, Otp_string);
//       loginpage.login();	   		
	}

	@When("User click on login button")
	public void user_click_on_login_button() throws InterruptedException{
		loginpage.login();
//		Thread.sleep(10000);
	    
	}

}
