package sangathan_stepdefinations;

import com.paulhammant.ngwebdriver.NgWebDriver;
import factory.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.SangathanPageObjects;
import utils.WardPageObjects;
import utils.KaryakaryaDataEntryFormControl;
import utils.SangathanVariableDeclaration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class WardKaryakarta {
    // public WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait, wait2;
    NgWebDriver ngDriver;
    WebDriver driver;
    WaitUtils load_wait;

    WardPageObjects wardPageObjects;
    // Ward Karyakarta Data Filter Data
    public String state;
    public String ULBType;
    public String administrativeDistrict;
    public String localBody;
    public String Ward;
    public String organisationUnit;
    public String organisationSubUnit;
    // Karyakarta Details

    public String updatedCategory;
    public String updatedCaste;
    public String updatedEmail;
    public String updatedFullAddress;
    public String updatedVillage;
    public String updatedTaluka;
    public String updatedDistrict;
    public String updatedPinCode;
    public String updatedEducation;
    public String updatedProfession;
    public String updatedBike;
    public String updatedCar;
    public String updatedVidhanSabhaWhereHeSheVotes;
    public String updatedBoothWhereHeSheVotes;
    public String updatedVoterId;
    public String updatedAadharNumber;
    public String updatedPannaNumber;
    public String updatedRationCardNumber;
    public String updatedFacebookProfile;
    public String updatedTwitterProfile;
    public String updatedLinkedinProfile;
    public String updatedInstagramProfile;
    public String updatedSalutation;
    public String updatedSubCaste;
    public String updatedQualification;
    public String updatedReligion;
    public String updatedActiveMemberId;
    public String updatedPartyZila;
    public String updatedPartyMandal;
    public String updatedBloodGroup;
    // Karyakarta_Edit_Details
    public String updatedName;
    public String updatedFatherName;
    public String updatedDesignation;
    public String updatedHasSmartPhone;
    public String updatedPhoneNumber;
    public String updatedPrimaryMemberId;
    public String updatedAge;
    public String updatedGender;
    public String updatedWhatsApp;
    public String copiedEnteredName;
    public String copiedEnteredFather_Husband_Name;
    public String copiedSelectedDesignation;
    public String copiedHasSmartPhone;
    public String copiedPhoneNo;
    public String copiedPrimaryMember;
    public String copiedAge;
    public String copiedDob;
    public String copiedWhatsAppNumber;
    public String copiedStdCode;
    public String copiedLandLineNo;
    public String copiedFullAddress;
    public String copiedVillage;
    public String copiedTaluka_Tehsil;
    public String copiedSelectedDistrict;
    public String CopiedpinCode;
    public String copiedSelectedEducation;
    public String copiedSelectedProfession;
    public String copiedHasBike;
    public String copiedHasCar;
    public String copied_vidhanSabha_where_he_sheVotes;
    public String copiedBothWhereHeSheVotes;
    public String copiedVoterId;
    public String copiedAadhaarNumber;
    public String copiedPannaNumber;
    public String copiedRationCard;
    public String copiedFacebookValue;
    public String copiedTwitterProfile;
    public String copiedInstagramProfile;
    public String copiedLinkedInProfile;
    public String copiedSalutation;
    public String copiedBloodGroup;
    public String copiedSubCaste;
    public String copiedQualification;
    public String copiedReligion;
    public String copiedActiveMemberId;
    public String copiedSelectedPartyZilaId;
    public String copiedSelectedPartyMandalId;
    public String copiedSelectedCategory;
    public String copiedSelectedCaste;
    public String copiedEmail;

    public SangathanPageObjects sangathanPageObjects;

    public static Logger log = LogManager.getLogger(WardKaryakarta.class.getName());

    @Given("^user logged in into the saral application$")
    public void user_logged_in_into_the_saral_application(DataTable login_table_ward)
            throws InterruptedException, IOException {

        // get driver
        driver = DriverFactory.getInstance().getDriver();
        //driver = DriverFactory1.getInstance().getDriver();
        // creating object for loading web page
        load_wait = new WaitUtils();
        System.out.println("URL for ward");
        Map<String, String> map = login_table_ward.asMap(String.class, String.class);

        // -----constructor for setting login values-----------

        KaryakaryaDataEntryFormControl login_values = new KaryakaryaDataEntryFormControl(map.get("Email"),
                map.get("Password"), map.get("Otp"));

        Login.login_in_saral_application(login_values.getKaryakartaEmail(), login_values.getKaryakartaPassword(),
                login_values.getKaryakartaOtp());
        log.debug("user successfully came on the dashboard page");

    }

    @Then("^user click on sangathan data management card on dashboard$")
    public void user_click_on_sangathan_data_management_card_on_dashboard() throws InterruptedException {

        // Sangathan Data Entry
        driver = DriverFactory.getInstance().getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);

        //Object for getting sangathan data management card location
        SangathanPageObjects wardPageObject = new SangathanPageObjects(driver);
        WebElement SangathanDataEntryEle = wardPageObject.getSangathanDataEntryEle().get(0);
        ExceptionHandler.clickElementWithRetry(SangathanDataEntryEle);
        load_wait.waitForPageLoad();
        log.debug("user click on sangathan data management card");
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
    }

    @And("^user click on add entry button for ward karyakarta$")
    public void user_click_on_add_entry_button_for_ward_karyakarta() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);

        //Object for getting locator for ward add entry button
        SangathanPageObjects sangathanPageObjects = new SangathanPageObjects(driver);
        WardPageObjects wardPageObjects = new WardPageObjects(driver);
        List<WebElement> elements = sangathanPageObjects.getKaryakartaDataLevelText();
        for (WebElement element : elements) {
            String elementText = element.getText();
            if (elementText.equals("Ward")) {
                WebElement button = wardPageObjects.getWardAddEntryEle();
                button.click();
                break; // Exit the loop after clicking the button
            }
        }

        log.debug("user click on add entry button for ward karyakarta");
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(2000);

    }

    @And("^user select ward karyakarta data filter$")
    public void user_select_ward_karyakarta_data_filter(DataTable ward_karyakarta_filter_data)
            throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        Map<String, String> map = ward_karyakarta_filter_data.asMap(String.class, String.class);
        state = map.get("state");
        ULBType = map.get("ULB Type");
        administrativeDistrict = map.get("Administrative District");
        localBody = map.get("Local Body");
        Ward = map.get("Ward");
        organisationUnit = map.get("Organisation Unit");
        organisationSubUnit = map.get("Organisation Sub Unit");
        js = (JavascriptExecutor) driver;


        //Object for getting ward filters location
        wardPageObjects = new WardPageObjects(driver);
        List<WebElement> ward_karyakarta_filter = wardPageObjects.getWardFilterEles();
        // state
        String selectedStateText = wardPageObjects.getSelectedDropdownEle().get(0).getText();
        System.out.println("selectedStateText:-> " + selectedStateText);
        Assert.assertEquals(selectedStateText, "Uttar Pradesh");

        // select state
        WebElement selectState = wardPageObjects.getSelectStateEle(state);
        wait.until(ExpectedConditions.visibilityOf(selectState));
        ExceptionHandler.clickElementWithRetry(selectState);
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();


        if (selectedStateText.equals(state)) {
            System.out.println("state is selected: " + state);
            // if state is selected then select ULB Type
            wait.until(ExpectedConditions.visibilityOf(ward_karyakarta_filter.get(1)));
            ExceptionHandler.clickElementWithRetry(ward_karyakarta_filter.get(1));
            ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
            // select ULB
            WebElement selectLocalBodyType = wardPageObjects.getULBTypeEle(ULBType);
            wait.until(ExpectedConditions.visibilityOf(selectLocalBodyType));

            // select ULB Type Ele
            ExceptionHandler.clickElementWithRetry(selectLocalBodyType);
            load_wait.waitForPageLoad();
            // js.executeScript("arguments[0].click();", selectLocalBodyType);
            ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'ng-value ng-star-inserted') and contains(text(), '" + ULBType + "')]")));
            //get selected ULB Ele
            String selectedULBText = wardPageObjects.getSelectedDropdownEle().get(1).getText();
            System.out.println("selectedULBText: " + selectedULBText);
            //check ULB is selected or not
            if (selectedULBText.equals(ULBType)) {
                System.out.println("ULB Type is selected");
                //If ULB Type is selected then select Administrative District
                wait.until(ExpectedConditions.visibilityOf(ward_karyakarta_filter.get(2)));
                ExceptionHandler.clickElementWithRetry(ward_karyakarta_filter.get(2));
                ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
                // Select Administrative District
                WebElement selectAdministrativeDistrict = wardPageObjects.getAdministrativeDistrictEle(administrativeDistrict);
                //wait.until(ExpectedConditions.visibilityOf(selectAdministrativeDistrict));
                //js.executeScript("arguments[0].click();", selectAdministrativeDistrict);
                ExceptionHandler.clickElementWithRetry(selectAdministrativeDistrict);
                load_wait.waitForPageLoad();
                ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
                //Thread.sleep(2000);
                //get selected Administrative District Ele
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'ng-value ng-star-inserted') and contains(text(), '" + administrativeDistrict + "')]")));
                String selectedADText = ExceptionHandler.getTextOfElementWithRetry(wardPageObjects.getSelectedDropdownEle().get(2));
                System.out.println("selectedADText: " + selectedADText);

                if (selectedADText.equals(administrativeDistrict)) {
                    System.out.println("AD is selected");

                    //If AD is selected then select Local Body
                    wait.until(ExpectedConditions.visibilityOf(ward_karyakarta_filter.get(3)));
                    ExceptionHandler.clickElementWithRetry(ward_karyakarta_filter.get(3));
                    ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
                    // select local body
                    WebElement selectLocalBody = wardPageObjects.getLocalBodyEle(localBody);
                    wait.until(ExpectedConditions.visibilityOf(selectLocalBody));
                    //js.executeScript("arguments[0].click();", selectLocalBody);
                    ExceptionHandler.clickElementWithRetry(selectLocalBody);
                    ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
                    Thread.sleep(1000);
                    load_wait.waitForPageLoad();
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'ng-value ng-star-inserted') and contains(text(), '" + localBody + "')]")));
                    String selectedLocalBodyText = ExceptionHandler.getTextOfElementWithRetry(wardPageObjects.getSelectedDropdownEle().get(3));
                    System.out.println("selectedLocalBodyText: " + selectedLocalBodyText);

                    if (selectedLocalBodyText.equals(localBody)) {
                        System.out.println("local body is selected");

                        //if Local Body is selected the select Ward
                        wait.until(ExpectedConditions.visibilityOf(ward_karyakarta_filter.get(4)));
                        ExceptionHandler.clickElementWithRetry(ward_karyakarta_filter.get(4));
                        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
                        // select ward
                        WebElement selectWard = wardPageObjects.getWardEle(Ward);
                        System.out.println("WardDrop: " + selectWard);
                        wait.until(ExpectedConditions.visibilityOf(selectWard));
                        // js.executeScript("arguments[0].click();", selectWard);
                        ExceptionHandler.clickElementWithRetry(selectWard);
                        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
                        Thread.sleep(1000);
                        load_wait.waitForPageLoad();
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'ng-value ng-star-inserted') and contains(text(), '" + Ward + "')]")));
                        String selectedWardText = ExceptionHandler.getTextOfElementWithRetry(wardPageObjects.getSelectedDropdownEle().get(4));
                        if (selectedWardText.equals(Ward)) {
                            System.out.println("ward is selected");

                            //if ward is selected then select org unit
                            wait.until(ExpectedConditions.visibilityOf(ward_karyakarta_filter.get(5)));
                            ExceptionHandler.clickElementWithRetry(ward_karyakarta_filter.get(5));
                            ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
                            // select organisation unit
                            WebElement selectOrganisationUnit = wardPageObjects.getOrganisationUnitEle(organisationUnit);
                            wait.until(ExpectedConditions.visibilityOf(selectOrganisationUnit));
                            // js.executeScript("arguments[0].click();", selectOrganisationUnit);
                            ExceptionHandler.clickElementWithRetry(selectOrganisationUnit);
                            ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
                            Thread.sleep(1000);
                            load_wait.waitForPageLoad();
                            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'ng-value ng-star-inserted') and contains(text(), '" + organisationUnit + "')]")));
                            String selectedOrganisationUnitText = ExceptionHandler.getTextOfElementWithRetry(wardPageObjects.getSelectedDropdownEle().get(5));
                            if (selectedOrganisationUnitText.equals(organisationUnit)) {
                                System.out.println("Organisation unit is selected");
                                //if org unit is selected then select organisation Sub Unit

                                wait.until(ExpectedConditions.visibilityOf(ward_karyakarta_filter.get(6)));
                                ExceptionHandler.clickElementWithRetry(ward_karyakarta_filter.get(6));
                                ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
                                // select organisation sub unit
                                WebElement selectOrganisationSubUnit = wardPageObjects.getOrganisationSubUnitEle(organisationSubUnit);
                                wait.until(ExpectedConditions.visibilityOf(selectOrganisationSubUnit));
                                //js.executeScript("arguments[0].click();", selectOrganisationSubUnit);
                                ExceptionHandler.clickElementWithRetry(selectOrganisationSubUnit);
                                ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
                                Thread.sleep(1000);
                                load_wait.waitForPageLoad();
                                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'ng-value ng-star-inserted') and contains(text(), '" + organisationSubUnit + "')]")));
                                String selectedOrganisationSubUnitText = ExceptionHandler.getTextOfElementWithRetry(wardPageObjects.getSelectedDropdownEle().get(6));
                                if (selectedOrganisationSubUnitText.equals(organisationSubUnit)) {
                                    System.out.println("org sub unit is selected");
                                } else {

                                    System.out.println("org sub unit not selected");

                                }

                            } else {
                                System.out.println("Organisation unit is not selected");

                            }

                        } else {

                            System.out.println("ward is not selected");

                        }

                    } else {
                        System.out.println("local body is not selected");
                    }


                } else {
                    System.out.println("AD is not selected");

                }


            } else {
                System.out.println("ULb Type is not selected");
            }


        } else {
            System.out.println("state is not selected.");
        }


    }

    @And("^user click on search button and verify ward karyakarta filter text$")
    public void user_click_on_search_button_and_verify_ward_karyakarta_filter_text() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        js = (JavascriptExecutor) driver;
        //object for Sangathan Page Objects
        SangathanPageObjects sangathanPageObjects = new SangathanPageObjects(driver);
        // Search Button
        WebElement searchButtonEle = sangathanPageObjects.getSearchButtonEle();
        js.executeScript("arguments[0].click();", searchButtonEle);
        load_wait.waitForPageLoad();
        // wait.until(ExpectedConditions.elementToBeClickable(searchButtonEle)).click();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        String ward_karyakarta_filter_text = driver.findElement(By.xpath("//h6[@class='locations-list']")).getText();
        System.out.println(">>>>>>>ward_karyakarta_filter_text: " + ward_karyakarta_filter_text);
        String ward_karyakarta_filter_text_format = state + "   >   " + ULBType + "   >   " + administrativeDistrict
                + "   >  " + localBody + "   >   " + Ward.replaceAll("\\s", "");

        System.out.println("-------ward_karyakarta_filter_text_format: " + ward_karyakarta_filter_text_format);
        Assert.assertEquals(ward_karyakarta_filter_text, ward_karyakarta_filter_text_format);

    }

    @And("^user clicks on enter more details$")
    public void user_clicks_on_enter_more_details() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        js = (JavascriptExecutor) driver;
        //object of sangathan page objects
        SangathanPageObjects sangathanPageObjects = new SangathanPageObjects(driver);
        WebElement extraDetailsEle = sangathanPageObjects.getExtraDetailsEle();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(extraDetailsEle));
        js.executeScript("arguments[0].click();", extraDetailsEle);
        Thread.sleep(1000);

    }

    @Then("^user input primary details in the data entry form$")
    public void user_input_primary_details_in_the_data_entry_form(DataTable Karyakarta_primary_details)
            throws InterruptedException {
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        Map<String, String> map = Karyakarta_primary_details.asMap(String.class, String.class);
        //Name
        SangathanVariableDeclaration.setNameVariableValue(map.get("Name"));
        //Father Name
        SangathanVariableDeclaration.setFatherNameVariable(map.get("Father Name"));
        //Designation
        SangathanVariableDeclaration.setDesignationVariable(map.get("Designation"));
        //Has Smart Phone
        SangathanVariableDeclaration.setHasSmartPhoneVariable(map.get("Has Smartphone"));
        //Phone Number
        SangathanVariableDeclaration.setPhoneNumberVariableValue(map.get("Phone Number"));
        //Primary Member Id
        SangathanVariableDeclaration.setPrimaryMemberIdVariable(map.get("Primary Member ID"));
        //Age
        SangathanVariableDeclaration.setAgeVariable(map.get("Age"));

        // Name
        FormControlKaryakarta.enterName(SangathanVariableDeclaration.getNameVariable());

        // Father and Husband Name
        FormControlKaryakarta.enterRelationName(SangathanVariableDeclaration.getFatherNameVariable());

        // Designation
        FormControlKaryakarta.clickOnDesignation();

        // Select Designation
        FormControlKaryakarta.selectDesignation(SangathanVariableDeclaration.getDesignationVariable());

        // hasSmartPhone
        FormControlKaryakarta.clickOnHasSmartPhone();

        // select hasSmartPhone
        FormControlKaryakarta.selectDesignation(SangathanVariableDeclaration.getHasSmartPhoneVariable());

        // Primary Member
        FormControlKaryakarta.enterPrimaryMemberId(SangathanVariableDeclaration.getPrimaryMemberIdVariable());
        // Age
        FormControlKaryakarta.enterAge(SangathanVariableDeclaration.getAgeVariable());

        // Validation for phone no.
        apply_validation_in_phone_number();
        // phone number
        FormControlKaryakarta.enterPhoneNumber(SangathanVariableDeclaration.getPhoneNumberVariable());

    }

    @Then("^user input below details in data entry form with input fields validation$")
    public void enter_karyakarta_details_in_the_form(DataTable karyakarta_details) throws InterruptedException {
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        Map<String, String> map = karyakarta_details.asMap(String.class, String.class);

        SangathanVariableDeclaration.setNameVariableValue(map.get("Name"));

        SangathanVariableDeclaration.setFatherNameVariable(map.get("Father Name"));

        SangathanVariableDeclaration.setDesignationVariable(map.get("Designation"));

        SangathanVariableDeclaration.setHasSmartPhoneVariable(map.get("Has Smartphone"));

        SangathanVariableDeclaration.setPhoneNumberVariableValue(map.get("Phone Number"));

        SangathanVariableDeclaration.setPrimaryMemberIdVariable(map.get("Primary Member ID"));

        SangathanVariableDeclaration.setAgeVariable(map.get("Age"));

        SangathanVariableDeclaration.setGenderVariable(map.get("Gender"));

        SangathanVariableDeclaration.setWhatsAppVariable(map.get("WhatsApp Number"));

        SangathanVariableDeclaration.setStdCodeVariable(map.get("STD Code"));

        SangathanVariableDeclaration.setLandlineNumberVariable(map.get("Landline Number"));
        //category = map.get("Category");
        SangathanVariableDeclaration.setCategoryVariable(map.get("Category"));
        //caste = map.get("Caste");
        SangathanVariableDeclaration.setCasteVariable(map.get("Caste"));
        //email = map.get("Email");
        SangathanVariableDeclaration.setEmailVariable(map.get("Email"));
        // dob = map.get("Dob");
        SangathanVariableDeclaration.setDobVariable(map.get("Dob"));
        // fullAddress = map.get("Full Address");
        SangathanVariableDeclaration.setFullAddressVariable(map.get("Full Address"));
        // village = map.get("Village");
        SangathanVariableDeclaration.setVillageVariable(map.get("Village"));
        //taluka = map.get("Taluka");
        SangathanVariableDeclaration.setTalukaVariable(map.get("Taluka"));
        //district = map.get("District");
        SangathanVariableDeclaration.setDistrictVariable(map.get("District"));
        // pinCode = map.get("Pin Code");
        SangathanVariableDeclaration.setPinCodeVariable(map.get("Pin Code"));
        //education = map.get("Education");
        SangathanVariableDeclaration.setEducationVariable(map.get("Education"));
        //profession = map.get("Profession");
        SangathanVariableDeclaration.setProfessionVariable(map.get("Profession"));
        //bike = map.get("Bike");
        SangathanVariableDeclaration.setBikeVariable(map.get("Bike"));
        //car = map.get("Car");
        SangathanVariableDeclaration.setCarVariable(map.get("Car"));
        //vidhanSabhaWhereHeSheVotes = map.get("Vidhan Sabha where he/she votes");
        SangathanVariableDeclaration.setVidhanSabhaWhereHeSheVotesVariable(map.get("Vidhan Sabha where he/she votes"));
        //boothWhereHeSheVotes = map.get("Booth where he/she votes");
        SangathanVariableDeclaration.setBoothWhereHeSheVotesVariable(map.get("Booth where he/she votes"));
        // voterId = map.get("Voter Id");
        SangathanVariableDeclaration.setVoterIdVariable(map.get("Voter Id"));
        //aadharNumber = map.get("Aadhaar Number");
        SangathanVariableDeclaration.setAadharNumberVariable(map.get("Aadhaar Number"));
        //pannaNumber = map.get("Panna Number");
        SangathanVariableDeclaration.setPannaNumberVariable(map.get("Panna Number"));
        //rationCardNumber = map.get("Ration Card Number");
        SangathanVariableDeclaration.setRationCardNumberVariable(map.get("Ration Card Number"));
        //facebookProfile = map.get("Facebook Profile");
        SangathanVariableDeclaration.setFacebookProfileVariable(map.get("Facebook Profile"));
        //twitterProfile = map.get("Twitter Profile");
        SangathanVariableDeclaration.setTwitterProfileVariable(map.get("Twitter Profile"));
        //instagramProfile = map.get("Intagram Profile");
        SangathanVariableDeclaration.setInstagramProfileVariable(map.get("Intagram Profile"));
        //linkedinProfile = map.get("Linkedin Profile");
        SangathanVariableDeclaration.setLinkedinProfileVariable(map.get("Linkedin Profile"));
        //image = map.get("Image");
        SangathanVariableDeclaration.setImageVariable(map.get("Image"));
        //salutation = map.get("Salutation");
        SangathanVariableDeclaration.setSalutationVariable(map.get("Salutation"));
        //subCaste = map.get("Sub Caste");
        SangathanVariableDeclaration.setSubCasteVariable(map.get("Sub Caste"));
        //qualification = map.get("Qualification");
        SangathanVariableDeclaration.setQualificationVariable(map.get("Qualification"));
        //religion = map.get("Religion");
        SangathanVariableDeclaration.setReligionVariable(map.get("Religion"));
//        activeMemberId = map.get("Active Member Id");
        SangathanVariableDeclaration.setActiveMemberIdVariable(map.get("Active Member Id"));
//        partyZila = map.get("Party Zila");
        SangathanVariableDeclaration.setPartyZilaVariable(map.get("Party Zila"));
//        partyMandal = map.get("Party Mandal");
        SangathanVariableDeclaration.setPartyMandalVariable(map.get("Party Mandal"));
//        bloodGroup = map.get("Blood Group");
        SangathanVariableDeclaration.setBloodGroupVariable(map.get("Blood Group"));

        // Object for SANGATHAN Page Object Class
        sangathanPageObjects = new SangathanPageObjects(driver);

        //Objects for ward page objects
        wardPageObjects = new WardPageObjects(driver);

        // Name
        FormControlKaryakarta.enterName(SangathanVariableDeclaration.getNameVariable());

        // Father and Husband Name
        FormControlKaryakarta.enterRelationName(SangathanVariableDeclaration.getFatherNameVariable());

        // Designation
        FormControlKaryakarta.clickOnDesignation();

        // Select Designation
        FormControlKaryakarta.selectDesignation(SangathanVariableDeclaration.getDesignationVariable());

        // hasSmartPhone
        FormControlKaryakarta.clickOnHasSmartPhone();

        // select hasSmartPhone
        FormControlKaryakarta.selectHasSmartPhone(SangathanVariableDeclaration.getHasSmartPhoneVariable());

        // Primary Member
        FormControlKaryakarta.enterPrimaryMemberId(SangathanVariableDeclaration.getPrimaryMemberIdVariable());
        // Age
        FormControlKaryakarta.enterAge(SangathanVariableDeclaration.getAgeVariable());
        int ageInt = Integer.parseInt(SangathanVariableDeclaration.getAgeVariable());
        // Dob
        String calculatedDOB = dob_calculation_based_on_age_input(ageInt);
        WebElement dobEle = sangathanPageObjects.getDOBEle();
        js.executeScript("arguments[0].scrollIntoView(true);", dobEle);
        String copiedDobAfterEnteredAge = dobEle.getAttribute("value");
        Assert.assertEquals(calculatedDOB, copiedDobAfterEnteredAge);
        dobEle.clear();
        apply_validation_in_dob();
        String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
        System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
        // AgeEle.clear();
        // AgeEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        // AgeEle.sendKeys(age);
        dobEle.sendKeys(day_and_month_updated_dob);
        String copiedDob = dobEle.getAttribute("value");
        Assert.assertEquals(day_and_month_updated_dob, copiedDob);

        // select gender
        FormControlKaryakarta.selectGender(SangathanVariableDeclaration.getGenderVariable());
        // Blood Group
        FormControlKaryakarta.enterBloodGroup(SangathanVariableDeclaration.getBloodGroupVariable());

        // Validation for phone no.
        // Validation for phone no.
        apply_validation_in_phone_number();
        // phone number
        FormControlKaryakarta.enterPhoneNumber(SangathanVariableDeclaration.getPhoneNumberVariable());
        // STD Code
        FormControlKaryakarta.enterSTDCode(SangathanVariableDeclaration.getStdCodeVariable());
        // WhatsApp
        // Validation for WhatsApp No.
        apply_validation_in_whatsapp_number();
        //whatsAppEle.sendKeys(whatsApp);
        FormControlKaryakarta.enterWhatsAppNumber(SangathanVariableDeclaration.getWhatsAppVarible());
        // Landline Number
        FormControlKaryakarta.enterLandlineNumber(SangathanVariableDeclaration.getLandlineNumberVariable());

        // Category and Caste fields handle with validation
        // Caste
        WebElement CasteEle = sangathanPageObjects.getSelectCasteEle();
        // Validation in category and caste
        apply_validation_in_category_and_caste();

        // click on select Category
        FormControlKaryakarta.clickOnCategory();
        WebElement categoryValueEle = sangathanPageObjects.getCategoryValueEle(SangathanVariableDeclaration.getCategoryVariable());
        ExceptionHandler.clickElementWithRetry(categoryValueEle);
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        // click on Caste
        ExceptionHandler.clickElementWithRetry(CasteEle);

        //select caste value
        WebElement CasteValueEle = sangathanPageObjects.getCasteValueEle(SangathanVariableDeclaration.getCasteVariable());
        ExceptionHandler.clickElementWithRetry(CasteValueEle);


        // Email

        // validation in email
        apply_validation_in_email();
        FormControlKaryakarta.enterEmail(SangathanVariableDeclaration.getEmailVariable());

        // Full Address
        FormControlKaryakarta.enterFullAddress(SangathanVariableDeclaration.getFullAddressVariable());

        // Village
        FormControlKaryakarta.enterVillage(SangathanVariableDeclaration.getVillageVariable());

        // Taluka/Tehsil
        FormControlKaryakarta.enterTaluka(SangathanVariableDeclaration.getTalukaVariable());

        // District
        FormControlKaryakarta.clickOnDistrict();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        // Select District
        FormControlKaryakarta.selectDistrict(SangathanVariableDeclaration.getDistrictVariable());

        // PinCode
        FormControlKaryakarta.enterPinCode(SangathanVariableDeclaration.getPinCodeVariable());

        // Education
        FormControlKaryakarta.clickOnEducation();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        // Select Education
        FormControlKaryakarta.selectEducation(SangathanVariableDeclaration.getEducationVariable());
        // click on Select Profession
        FormControlKaryakarta.clickOnProfession();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        // Select Profession
        FormControlKaryakarta.selectProfession(SangathanVariableDeclaration.getProfessionVariable());

        // click on Bike
        FormControlKaryakarta.clickOnHasBike();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(1000);

        // Select yes or no for bike
        FormControlKaryakarta.selectHasBike(SangathanVariableDeclaration.getBikeVariable());

        // click on Car
        FormControlKaryakarta.clickOnHasCar();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(1000);
        // Select yes or no for car
        FormControlKaryakarta.selectHasCar(SangathanVariableDeclaration.getCarVariable());

        // click on Vidhan Sabha where He/She Votes
        FormControlKaryakarta.clickOnVidhanSabhaHeSheVotes();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        // Select Vidhan Sabha
        FormControlKaryakarta.selectVidhanSabhaHeSheVotes(SangathanVariableDeclaration.getVidhanSabhaWhereHeSheVotesVariable());

        // Booth where He/She Votes
        FormControlKaryakarta.enterBoothWhereHeSheVotes(SangathanVariableDeclaration.getBoothWhereHeSheVotesVariable());

        // Voter Id
        FormControlKaryakarta.enterVoterId(SangathanVariableDeclaration.getVoterIdVariable());

        // Aadhaar Number

        // Validation AadhaarNumber.
        apply_validation_in_aadhar_number();
        FormControlKaryakarta.enterAadharNumber(SangathanVariableDeclaration.getAadharNumberVariable());

        // Panna Number

        // Panna Number Validation
        apply_validation_in_panna_number();
        FormControlKaryakarta.enterPannaNumber(SangathanVariableDeclaration.getPannaNumberVariable());

        // Ration Card Number
        FormControlKaryakarta.enterRationCardNumber(SangathanVariableDeclaration.getRationCardNumberVariable());

        // FacebookProfile
        FormControlKaryakarta.enterFacebookProfile(SangathanVariableDeclaration.getFacebookProfileVariable());

        // TwitterProfile
        FormControlKaryakarta.enterTwitterProfile(SangathanVariableDeclaration.getTwitterProfileVariable());

        // InstagramProfile
        FormControlKaryakarta.enterInstagramProfile(SangathanVariableDeclaration.getInstagramProfileVariable());

        // LinkedInProfile
        FormControlKaryakarta.enterLinkedinProfile(SangathanVariableDeclaration.getLinkedinProfileVariable());

        // Photo
        String image = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\image1.jpg";
        FormControlKaryakarta.uploadImage(image);

        // click on Salutation
        FormControlKaryakarta.clickOnSalutation();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        // Select SalutationEle
        FormControlKaryakarta.selectSalutation(SangathanVariableDeclaration.getSalutationVariable());

        // Sub Caste
        FormControlKaryakarta.enterSubCaste(SangathanVariableDeclaration.getSubCasteVariable());

        // Qualification
        FormControlKaryakarta.enterQualification(SangathanVariableDeclaration.getQualificationVariable());

        // Religion
        FormControlKaryakarta.clickOnReligion();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        // Select Religion
        FormControlKaryakarta.selectReligion(SangathanVariableDeclaration.getReligionVariable());

        // Active Member Id
        FormControlKaryakarta.enterActiveMemberId(SangathanVariableDeclaration.getActiveMemberIdVariable());

        // Party Zila and Party Mandal
        apply_validation_in_party_zila_and_mandal();

        // click Select Party Zila Id
        WebElement SelectPartyZilaIdEle = sangathanPageObjects.getSelectPartyZilaEle();
        ExceptionHandler.clickElementWithRetry(SelectPartyZilaIdEle);
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        // Select Party Zila Id
        WebElement PartyZilaIdValueEle = sangathanPageObjects.getPartyZilaValueEle(SangathanVariableDeclaration.getPartyZilaVariable());
        wait.until(ExpectedConditions.visibilityOf(PartyZilaIdValueEle));
        ExceptionHandler.clickElementWithRetry(PartyZilaIdValueEle);

        // Party Mandal
        WebElement SelectPartyMandalEle = sangathanPageObjects.getSelectPartyMandalEle();
        wait.until(ExpectedConditions.elementToBeClickable(SelectPartyMandalEle));
        ExceptionHandler.clickElementWithRetry(SelectPartyMandalEle);
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        // Select Party Mandal
        //WebElement enterPartyMandalEle = driver.findElement(with(By.tagName("input")).below(SelectPartyMandalEle));
        WebElement enterPartyMandalEle = sangathanPageObjects.getSelectPartyMandalValueEle(SangathanVariableDeclaration.getPartyMandalVariable());
        //enterPartyMandalEle.sendKeys(partyMandal);
        //enterPartyMandalEle.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(enterPartyMandalEle));
        ExceptionHandler.clickElementWithRetry(enterPartyMandalEle);
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

    }

    @And("^user click on add button$")
    public void user_click_on_add_button() throws InterruptedException {

        // click on Add button
        FormControlKaryakarta.clickOnAddEntryButton();
       load_wait.waitForPageLoad();

    }

    @And("^user verify all the added data in the person table$")
    public void user_verify_all_the_added_data_in_the_person_table() throws InterruptedException {
     Thread.sleep(2000);
     FormControlKaryakarta.scrollToViewDynamicTable();
     List<WebElement> dynamicTableRows = driver.findElements(By.xpath("//table//tr"));
        if (dynamicTableRows.size() > 0) {
            List<WebElement> firstRowElements = driver.findElements(By.xpath("(//table//tr)[2]//td")); // Fisrt Row
            System.out.println(firstRowElements.size());


            //Actual Data
            Map<Integer, String> rowData = new HashMap<>();
            int columnIndex = 0;
            for (WebElement element : firstRowElements) {
                rowData.put(columnIndex++, element.getText());
            }

            // Define expected values
            Map<Integer, String> expectedData = new HashMap<>();
            expectedData.put(0, "1");
            expectedData.put(1, SangathanVariableDeclaration.getNameVariable());
            expectedData.put(2, SangathanVariableDeclaration.getFatherNameVariable());
            expectedData.put(3, SangathanVariableDeclaration.getDesignationVariable());
            expectedData.put(4, SangathanVariableDeclaration.getHasSmartPhoneVariable());
            expectedData.put(5, SangathanVariableDeclaration.getPhoneNumberVariable());
            expectedData.put(6, SangathanVariableDeclaration.getPrimaryMemberIdVariable());


            // Compare actual data with expected data using assertions
            for (Map.Entry<Integer, String> entry : expectedData.entrySet()) {
                columnIndex = entry.getKey();
                String expectedValue = entry.getValue();
                String actualValue = rowData.get(columnIndex);

                Assert.assertEquals(actualValue, expectedValue);
            }
        } else {
            System.out.println("No rows found in the table.");
        }


    }

    @And("^user click on edit button for recently added entry$")
    public void user_click_on_edit_button_for_recently_added_entry() throws InterruptedException {
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        // Object for SANGATHAN Page Object Class
        sangathanPageObjects = new SangathanPageObjects(driver);
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(5000);
        WebElement data_entryDynamicTableEle = sangathanPageObjects.getData_EntryDynamicTableEle();
        js = (JavascriptExecutor) driver;
        WaitUtils.waitForElementToBeVisible(driver, data_entryDynamicTableEle);
        js.executeScript("arguments[0].scrollIntoView(true);", data_entryDynamicTableEle);
        get_Karyakarta_Data_To_Edit(SangathanVariableDeclaration.getPhoneNumberVariable());
    }

    @And("^user verify primary details in the data entry form$")
    public void user_verify_primary_details_in_the_data_entry_form() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        // Name
        SangathanVariableDeclaration.setCopiedName(FormControlKaryakarta.getEnteredName());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedName().toUpperCase(), SangathanVariableDeclaration.getNameVariable().toUpperCase());

        // Father's/Husband's Name
        SangathanVariableDeclaration.setCopiedFatherName(FormControlKaryakarta.getEnteredRelationName());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedFatherName().toUpperCase(), SangathanVariableDeclaration.getFatherNameVariable().toUpperCase());

        // Designation
        SangathanVariableDeclaration.setCopiedDesignation(FormControlKaryakarta.getSelectedDesignation());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedDesignation(), SangathanVariableDeclaration.getDesignationVariable());

        // Has SmartPhone
        SangathanVariableDeclaration.setCopiedHasSmartPhone(FormControlKaryakarta.getSelectedHasSmartPhone());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedHasSmartPhone(), SangathanVariableDeclaration.getHasSmartPhoneVariable());

        // Phone Number
        SangathanVariableDeclaration.setCopiedPhoneNumber(FormControlKaryakarta.getEnteredPhoneNumber());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedPhoneNumber(), SangathanVariableDeclaration.getPhoneNumberVariable());

        // Primary Member
        SangathanVariableDeclaration.setCopiedPrimaryMemberId(FormControlKaryakarta.getEnteredPrimaryMemberId());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedPrimaryMemberId(), SangathanVariableDeclaration.getPrimaryMemberIdVariable());

        // Age
        SangathanVariableDeclaration.setCopiedAge(FormControlKaryakarta.getEnteredAge());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedAge(), SangathanVariableDeclaration.getAgeVariable());

        // click on cancel button
        FormControlKaryakarta.clickOnCancelButtonEle();

        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(2000);
    }

    @And("^user verify all the added data$")
    public void user_verify_all_the_added_data() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        // get all the added data.
        user_clicks_on_enter_more_details();

        while (FormControlKaryakarta.getEnteredName() == null) {

            WebElement data_entryDynamicTableEle = sangathanPageObjects.getData_EntryDynamicTableEle();
            js.executeScript("arguments[0].scrollIntoView(true);", data_entryDynamicTableEle);
            get_Karyakarta_Data_To_Edit(SangathanVariableDeclaration.getPhoneNumberVariable());
        }
        // set copied name
        SangathanVariableDeclaration.setCopiedName(FormControlKaryakarta.getEnteredName());
        //verifying copied name and entered name
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedName().toUpperCase(), SangathanVariableDeclaration.getNameVariable().toUpperCase());

        // Father's/Husband's Name
        SangathanVariableDeclaration.setCopiedFatherName(FormControlKaryakarta.getEnteredRelationName());
        //Verifying copied father name and father name
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedFatherName().toUpperCase(), SangathanVariableDeclaration.getFatherNameVariable().toUpperCase());

        // Designation
        SangathanVariableDeclaration.setCopiedDesignation(FormControlKaryakarta.getSelectedDesignation());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedDesignation(), SangathanVariableDeclaration.getDesignationVariable());

        // Has SmartPhone
        SangathanVariableDeclaration.setCopiedHasSmartPhone(FormControlKaryakarta.getSelectedHasSmartPhone());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedHasSmartPhone(), SangathanVariableDeclaration.getHasSmartPhoneVariable());

        // set copied Phone Number
        SangathanVariableDeclaration.setCopiedPhoneNumber(FormControlKaryakarta.getEnteredPhoneNumber());
        // Verifying copied and entered phone number
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedPhoneNumber(), SangathanVariableDeclaration.getPhoneNumberVariable());

        // set copied Primary Member
        SangathanVariableDeclaration.setCopiedPrimaryMemberId(FormControlKaryakarta.getEnteredPrimaryMemberId());
        //Verifying the copied primary member id and entered primary member id
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedPrimaryMemberId(), SangathanVariableDeclaration.getPrimaryMemberIdVariable());

        // Age
        copiedAge = driver.findElement(By.xpath("//input[@placeholder='Age']")).getAttribute("value");
        Assert.assertEquals(copiedAge, SangathanVariableDeclaration.getAgeVariable());
        int ageInt = Integer.parseInt(SangathanVariableDeclaration.getAgeVariable());
        // Dob
        WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
        String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
        System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
        copiedDob = dobEle.getAttribute("value");
        Assert.assertEquals(day_and_month_updated_dob, copiedDob);

        // Blood Group
        SangathanVariableDeclaration.setCopiedBloodGroup(FormControlKaryakarta.getEnteredBloodGroup());
        // Verifying the copied blood group and entered blood group
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedBloodGroup(), SangathanVariableDeclaration.getBloodGroupVariable());

        // Gender
        String classOfselectedGender = FormControlKaryakarta.getSelectedGender(SangathanVariableDeclaration.getGenderVariable());
        // verifying the gender is selected
        Assert.assertEquals(classOfselectedGender.contains("mat-radio-checked"), true,
                "seems like gender is not selected");

        // WhatsApp
        SangathanVariableDeclaration.setCopiedWhatsApp(FormControlKaryakarta.getEnteredWhatsAppNumber());
        //Verifying the copied whatsapp number and entered whatsapp number
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedWhatsApp(), SangathanVariableDeclaration.getWhatsAppVarible());

        // set copied STD Code
        FormControlKaryakarta.scrollToViewSTDCode();
        SangathanVariableDeclaration.setCopiedStdCode(FormControlKaryakarta.getEnteredSTDCode());
        // verifying the copied std code and entered std code
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedStdCode(), SangathanVariableDeclaration.getStdCodeVariable());

        // set copied Landline Number
        SangathanVariableDeclaration.setCopiedLandlineNumber(FormControlKaryakarta.getEnteredLandlineNumber());
        //Verify copied landline number and entered landline number
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedLandlineNumber(), SangathanVariableDeclaration.getLandlineNumberVariable());

        // Select Category
        WebElement SelectCategoryEle = driver.findElement(By.xpath("//div[contains(text(),'Select Category')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", SelectCategoryEle);
        copiedSelectedCategory = driver.findElement(with(By.className("ng-value-label")).below(SelectCategoryEle))
                .getText();

        Assert.assertEquals(copiedSelectedCategory, SangathanVariableDeclaration.getCategoryVariable());

        // Caste
        WebElement SelectCasteEle = driver.findElement(By.xpath("//div[contains(text(),'Caste')]"));
        copiedSelectedCaste = driver.findElement(with(By.className("ng-value-label")).below(SelectCasteEle)).getText();
        Assert.assertEquals(copiedSelectedCaste, SangathanVariableDeclaration.getCasteVariable());

        // set copied Email
        SangathanVariableDeclaration.setCopiedEmail(FormControlKaryakarta.getEnteredEmail());
        //verify copied email and entered email
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedEmail(), SangathanVariableDeclaration.getEmailVariable());

        // Full Address
        SangathanVariableDeclaration.setCopiedFullAddress(FormControlKaryakarta.getEnteredFullAddress());
        //Verifying copied full address and entered full address
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedFullAddress(), SangathanVariableDeclaration.getFullAddressVariable());

        // Village
        SangathanVariableDeclaration.setCopiedVillage(FormControlKaryakarta.getEnteredVillage());
        //Verifying the copied village and entered village
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedVillage(), SangathanVariableDeclaration.getVillageVariable());

        // set copied Taluka/Tehsil
        SangathanVariableDeclaration.setCopiedTaluka(FormControlKaryakarta.getEnteredTaluka());
        //Verifying the copied taluka and updated taluka
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedTaluka(), SangathanVariableDeclaration.getTalukaVariable());

        // select district
        WebElement SelectDistrictEle = driver.findElement(By.xpath("//div[contains(text(),'Select District')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", SelectDistrictEle);
        copiedSelectedDistrict = driver.findElement(with(By.className("ng-value-label")).below(SelectDistrictEle))
                .getText();
        Assert.assertEquals(copiedSelectedDistrict, SangathanVariableDeclaration.getDistrictVariable());

        //  set copied Pin Code
        SangathanVariableDeclaration.setCopiedPinCode(FormControlKaryakarta.getEnteredPinCode());
        // verifying the copied pin-code and entered pin-code
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedPinCode(), SangathanVariableDeclaration.getPinCodeVariable());

        // Select Education
        WebElement SelectEducationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Education')]"));
        copiedSelectedEducation = driver.findElement(with(By.className("ng-value-label")).below(SelectEducationEle))
                .getText();
        Assert.assertEquals(copiedSelectedEducation, SangathanVariableDeclaration.getEducationVariable());

        // Select Profession
        WebElement SelectProfessionEle = driver.findElement(By.xpath("//div[contains(text(),'Select Profession')]"));
        copiedSelectedProfession = driver.findElement(with(By.className("ng-value-label")).below(SelectProfessionEle))
                .getText();
        Assert.assertEquals(copiedSelectedProfession, SangathanVariableDeclaration.getProfessionVariable());

        // hasBike
        WebElement HasBikeEle = driver.findElement(By.xpath("//div[contains(text(),'Bike')]"));
        copiedHasBike = driver.findElement(with(By.className("ng-value-label")).below(HasBikeEle)).getText();
        Assert.assertEquals(copiedHasBike, SangathanVariableDeclaration.getBikeVariable());

        // hasCar
        WebElement HasCarEle = driver.findElement(By.xpath("//div[contains(text(),'Car')]"));
        copiedHasCar = driver.findElement(with(By.className("ng-value-label")).below(HasCarEle)).getText();
        Assert.assertEquals(copiedHasCar, SangathanVariableDeclaration.getCarVariable());

        // vidhanSabha where he/she votes
        WebElement vidhanSabha_where_he_sheVotesEle = driver
                .findElement(By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]"));
        copied_vidhanSabha_where_he_sheVotes = driver
                .findElement(with(By.className("ng-value-label")).below(vidhanSabha_where_he_sheVotesEle)).getText();

        // separating number and "-" from copied_vidhanSabha_where_he_sheVotes
        // String[] vidhansabhaNameArr =
        // copied_vidhanSabha_where_he_sheVotes.split("-");
        Assert.assertEquals(copied_vidhanSabha_where_he_sheVotes, SangathanVariableDeclaration.getVidhanSabhaWhereHeSheVotesVariable());

        // Booth where He/She Votes
        SangathanVariableDeclaration.setCopiedBoothWhereHeSheVotes(FormControlKaryakarta.getEnteredBoothWhereHeSheVotes());
        // verifying copied booth-where-he-she-votes and entered booth-where-he-she-votes
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedBoothWhereHeSheVotes(), SangathanVariableDeclaration.getBoothWhereHeSheVotesVariable());

        // Voter Id
        copiedVoterId = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedVoterId, SangathanVariableDeclaration.getVoterIdVariable());

        // Aadhaar Number
        SangathanVariableDeclaration.setCopiedAadharNumber(FormControlKaryakarta.getEnteredAadharNumber());
        // verifying copied Aadhaar Number and entered Aadhaar Number
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedAadharNumber(), SangathanVariableDeclaration.getAadharNumberVariable());

        // Panna Number
        SangathanVariableDeclaration.setCopiedPannaNumber(FormControlKaryakarta.getEnteredPannaNumber());
        // verifying copied panna number and entered panna number
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedPannaNumber(), SangathanVariableDeclaration.getPannaNumberVariable());

        // Ration Card
        SangathanVariableDeclaration.setCopiedRationCardNumber(FormControlKaryakarta.getEnteredRationCardNumber());
        // verifying the copied ration card and entered ration card
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedRationCardNumber(), SangathanVariableDeclaration.getRationCardNumberVariable());

        // Facebook
        SangathanVariableDeclaration.setCopiedFacebookProfile(FormControlKaryakarta.getEnteredFacebookProfile());
        // verifying the copied facebook profile and entered facebook profile
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedFacebookProfile(), SangathanVariableDeclaration.getFacebookProfileVariable());

        // TwitterProfile
        SangathanVariableDeclaration.setCopiedTwitterProfile(FormControlKaryakarta.getEnteredTwitterProfile());
        // verifying the copied Twitter profile and entered Twitter profile
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedTwitterProfile(), SangathanVariableDeclaration.getTwitterProfileVariable());

        // InstagramProfile
        SangathanVariableDeclaration.setCopiedInstagramProfile(FormControlKaryakarta.getEnteredInstagramProfile());
        // verifying the copied instagram and entered instagram profile
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedInstagramProfile(), SangathanVariableDeclaration.getInstagramProfileVariable());

        // LinkedInProfile
        SangathanVariableDeclaration.setCopiedLinkedinProfile(FormControlKaryakarta.getEnteredLinkedinProfile());
        // verifying the copied linked in and entered linked in profile
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedLinkedinProfile(), SangathanVariableDeclaration.getLinkedinProfileVariable());

        // Salutation
        copiedSalutation = driver.findElements(By.className("mat-select-value-text")).get(0).getText();
        Assert.assertEquals(copiedSalutation, SangathanVariableDeclaration.getSalutationVariable());

        // Sub Caste
        SangathanVariableDeclaration.setCopiedSubCaste(FormControlKaryakarta.getEnteredSubCaste());
        // verifying the copied sub caste and entered sub caste
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedSubCaste(), SangathanVariableDeclaration.getSubCasteVariable());

        // Qualification
        SangathanVariableDeclaration.setCopiedQualification(FormControlKaryakarta.getEnteredQualification());
        // verifying the copied qualification and entered qualification
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedQualification(), SangathanVariableDeclaration.getQualificationVariable());

        // Religion
        copiedReligion = driver.findElements(By.className("mat-select-value-text")).get(1).getText();
        Assert.assertEquals(copiedReligion, SangathanVariableDeclaration.getReligionVariable());

        // Active Member Id
        SangathanVariableDeclaration.setCopiedActiveMemberId(FormControlKaryakarta.getEnteredActiveMemberId());
        // verifying the copied active member id and entered active member id
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedActiveMemberId(), SangathanVariableDeclaration.getActiveMemberIdVariable());

        // Select Party Zila Id
//        WebElement SelectPartyZilaIdEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Zila')]"));
//        copiedSelectedPartyZilaId = driver.findElement(with(By.className("ng-value-label")).below(SelectPartyZilaIdEle))
//                .getText();
        SangathanVariableDeclaration.setCopiedPartyZila(FormControlKaryakarta.getSelectedPartyZila());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedPartyZila(), SangathanVariableDeclaration.getPartyZilaVariable());

        // Select Party Mandal
//        WebElement SelectPartyMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
//        copiedSelectedPartyMandalId = driver
//                .findElement(with(By.className("ng-value-label")).below(SelectPartyMandalEle)).getText();
        SangathanVariableDeclaration.setCopiedPartyMandal(FormControlKaryakarta.getSelectedPartyMandal());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedPartyMandal(), SangathanVariableDeclaration.getPartyMandalVariable());

        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(2000);

        // click on cancel button
        WebElement cancelButtonEle = driver.findElement(By.xpath("//span[contains(.,'Cancel')]"));
        js.executeScript("arguments[0].click();", cancelButtonEle);

        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(2000);
    }

    @When("^user enter data with duplicate phone which is already exist on given data level, unit, and subunit$")
    public void user_enter_data_with_duplicate_phone_which_is_already_exist_on_given_data_level_unit_and_subunit(
            DataTable same_level_unit_sub_unit_dupliacte_phone_number) throws InterruptedException {
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        js = (JavascriptExecutor) driver;

        Map<String, String> map = same_level_unit_sub_unit_dupliacte_phone_number.asMap(String.class, String.class);
        String duplicatePhoneNumber = map.get("same_level_unit_sub_unit_duplicate_phone_number");

        // primary fields
        // Name
        FormControlKaryakarta.enterName(SangathanVariableDeclaration.getNameVariable());
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        // Father and Husband Name
        FormControlKaryakarta.enterRelationName(SangathanVariableDeclaration.getFatherNameVariable());
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        // Designation
       // FormControlKaryakarta.clearDesignation();
        FormControlKaryakarta.clickOnDesignation();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        // Select Designation
        FormControlKaryakarta.selectDesignation(SangathanVariableDeclaration.getDesignationVariable());
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        // phone number
        FormControlKaryakarta.enterPhoneNumber(duplicatePhoneNumber);
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        user_click_on_add_button();

        // if person with duplicate phone number exists on same unit and sub unit and on same location.
        wait.until(ExpectedConditions.visibilityOf(sangathanPageObjects.get_data_entry_dialogue_ele()));

        Assert.assertEquals(
                "We can not create an entry with given details because a person can not hold two designations at the same organizational level & unit.",
                FormControlKaryakarta.getTextFromDataEntryDialogue());

        FormControlKaryakarta.clickOnCancelButtonInDataEntryDialogue();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

    }

    @And("^user enter data with duplicate phone number which is already exist on different data level , unit and subunit$")
    public void user_enter_data_with_duplicate_phone_number_which_is_already_exist_on_different_data_level_unit_and_subunit(
            DataTable duplicate_Phone) throws InterruptedException {
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        js = (JavascriptExecutor) driver;

        // get phone number from which karyakarta already exists on diffrent location
        Map<String, String> map = duplicate_Phone.asMap(String.class, String.class);
        String duplicatePhoneNumber = map.get("Duplicate Phone Number");

        // primary fields
        // Name
        FormControlKaryakarta.enterName(SangathanVariableDeclaration.getNameVariable());
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        // Father and Husband Name
        FormControlKaryakarta.enterRelationName(SangathanVariableDeclaration.getFatherNameVariable());
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        // Designation
        FormControlKaryakarta.clearDesignation();
        FormControlKaryakarta.clickOnDesignation();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        // Select Designation
        FormControlKaryakarta.selectDesignation(SangathanVariableDeclaration.getDesignationVariable());
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        // phone number
        FormControlKaryakarta.enterPhoneNumber(duplicatePhoneNumber);
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

        user_click_on_add_button();
        // if user exists on different data level unit and sub unit
        wait.until(ExpectedConditions.visibilityOf(sangathanPageObjects.get_data_entry_dialogue_ele()));

        System.out.println("textInDialog:" + FormControlKaryakarta.getTextFromDataEntryDialogue());
        Assert.assertEquals(FormControlKaryakarta.getTextFromDataEntryDialogue(), "From Pradesh to Mandal, Karyakarta can only hold only one designation. प्रदेश से मंडल स्तर तक पदाधिकारी को एक ही पद प्रदान किया जा सकता है।");

        // cancel dialog
        FormControlKaryakarta.clickOnCancelButtonInDataEntryDialogue();
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

    }

    @Then("^user edit primary details in the data entry form$")
    public void user_edit_primary_details_in_the_data_entry_form(DataTable Karyakarta_Primary_Edit_Details)
            throws InterruptedException {

        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        Map<String, String> map = Karyakarta_Primary_Edit_Details.asMap(String.class, String.class);

        // get data from feature files
        //updatedName
        SangathanVariableDeclaration.setUpdatedName(map.get("Name"));
        //updatedFatherName
        SangathanVariableDeclaration.setUpdatedFatherName(map.get("Father Name"));
        //updatedDesignation
        SangathanVariableDeclaration.setUpdatedDesignation(map.get("Designation"));
        //updatedHasSmartPhone
        SangathanVariableDeclaration.setUpdatedHasSmartPhone(map.get("Has Smartphone"));
        //updatedPhoneNumber
        SangathanVariableDeclaration.setUpdatedPhoneNumber(map.get("Phone Number"));
        //updatedPrimaryMemberId
        SangathanVariableDeclaration.setUpdatedPrimaryMemberId(map.get("Primary Member ID"));
        //updatedAge
        SangathanVariableDeclaration.setUpdatedAge(map.get("Age"));

        // Karyakarta_Edit_Details fill into the dynamic form
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        sangathanPageObjects = new SangathanPageObjects(driver);
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(5000);
        WebElement data_entryDynamicTableEle = sangathanPageObjects.getData_EntryDynamicTableEle();
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", data_entryDynamicTableEle);
        get_Karyakarta_Data_To_Edit(SangathanVariableDeclaration.getPhoneNumberVariable());

        Thread.sleep(1000);

        // Name
        FormControlKaryakarta.clearName();
        FormControlKaryakarta.enterName(SangathanVariableDeclaration.getUpdatedName());

        // Father's/Husband's Name
        FormControlKaryakarta.clearRelationName();
        FormControlKaryakarta.enterRelationName(SangathanVariableDeclaration.getUpdatedFatherName());

        // select Designation
        FormControlKaryakarta.clearDesignation();
        FormControlKaryakarta.clickOnDesignation();
        FormControlKaryakarta.selectDesignation(SangathanVariableDeclaration.getUpdatedDesignation());

        // hasSmartPhone
        FormControlKaryakarta.clickOnHasSmartPhone();
        // select hasSmartPhone
        FormControlKaryakarta.selectHasSmartPhone(SangathanVariableDeclaration.getUpdatedHasSmartPhone());

        // Phone Number
        FormControlKaryakarta.clearPhoneNumber();
        FormControlKaryakarta.enterPhoneNumber(SangathanVariableDeclaration.getUpdatedPhoneNumber());

        // Primary Member
        FormControlKaryakarta.clearPrimaryMemberId();
        FormControlKaryakarta.enterPrimaryMemberId(SangathanVariableDeclaration.getUpdatedPrimaryMemberId());

        // Age
        FormControlKaryakarta.clearAge();
        FormControlKaryakarta.enterAge(SangathanVariableDeclaration.getUpdatedAge());

    }

    @Then("^user edit all the added data with new data$")
    public void user_edit_all_the_added_data_with_new_data(DataTable Karyakarta_Edit_Details)
            throws InterruptedException {
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        Map<String, String> map = Karyakarta_Edit_Details.asMap(String.class, String.class);
        //updatedName
        SangathanVariableDeclaration.setUpdatedName(map.get("Name"));
        //updatedFatherName
        SangathanVariableDeclaration.setUpdatedFatherName(map.get("Father Name"));
        //updatedDesignation
        SangathanVariableDeclaration.setUpdatedDesignation(map.get("Designation"));
        //updatedHasSmartPhone
        SangathanVariableDeclaration.setUpdatedHasSmartPhone(map.get("Has Smartphone"));
        //updatedPhoneNumber
        SangathanVariableDeclaration.setUpdatedPhoneNumber(map.get("Phone Number"));
        //updatedPrimaryMemberId
        SangathanVariableDeclaration.setUpdatedPrimaryMemberId(map.get("Primary Member ID"));
        //updatedAge
        SangathanVariableDeclaration.setUpdatedAge(map.get("Age"));
        //updatedGender
        SangathanVariableDeclaration.setUpdatedGender(map.get("Gender"));
        //updatedWhatsApp
        SangathanVariableDeclaration.setUpdatedWhatsApp(map.get("WhatsApp Number"));
        //updatedStdCode
        SangathanVariableDeclaration.setUpdatedStdCode(map.get("STD Code"));
        //updatedLandlineNumber
        SangathanVariableDeclaration.setUpdatedLandlineNumber(map.get("Landline Number"));
        //updatedCategory
        SangathanVariableDeclaration.setUpdatedCategory(map.get("Category"));
        //updatedCaste
        SangathanVariableDeclaration.setUpdatedCaste(map.get("Caste"));
        //updatedEmail
        SangathanVariableDeclaration.setUpdatedEmail(map.get("Email"));
        //updatedDob
        SangathanVariableDeclaration.setUpdatedDob(map.get("Dob"));
        //updatedFullAddress
        SangathanVariableDeclaration.setUpdatedFullAddress(map.get("Full Address"));
        //updatedVillage
        SangathanVariableDeclaration.setUpdatedVillage(map.get("Village"));
        //updatedTaluka
        SangathanVariableDeclaration.setUpdatedTaluka(map.get("Taluka"));
        //updatedDistrict = map.get("District");
        SangathanVariableDeclaration.setUpdatedDistrict(map.get("District"));
        //updatedPinCode
        SangathanVariableDeclaration.setUpdatedPinCode(map.get("Pin Code"));
        //updatedEducation
        SangathanVariableDeclaration.setUpdatedEducation(map.get("Education"));
        //updatedProfession
        SangathanVariableDeclaration.setUpdatedProfession(map.get("Profession"));
        //updatedBike
        SangathanVariableDeclaration.setUpdatedBike(map.get("Bike"));
        //updatedCar
        SangathanVariableDeclaration.setUpdatedCar(map.get("Car"));
        //updatedVidhanSabhaWhereHeSheVotes
        SangathanVariableDeclaration.setUpdatedVidhanSabhaWhereHeSheVotes(map.get("Vidhan Sabha where he/she votes"));
        //updatedBoothWhereHeSheVotes
        SangathanVariableDeclaration.setUpdatedBoothWhereHeSheVotes(map.get("Booth where he/she votes"));
        updatedVoterId = map.get("Voter Id");
        SangathanVariableDeclaration.setUpdatedVoterId(map.get("Voter Id"));
        //updatedAadharNumber
        SangathanVariableDeclaration.setUpdatedAadharNumber(map.get("Aadhaar Number"));
        //updatedPannaNumber
        SangathanVariableDeclaration.setUpdatedPannaNumber(map.get("Panna Number"));
        //updatedRationCardNumber
        SangathanVariableDeclaration.setUpdatedRationCardNumber(map.get("Ration Card Number"));
        //updatedFacebookProfile
        SangathanVariableDeclaration.setUpdatedFacebookProfile(map.get("Facebook Profile"));
        //updatedTwitterProfile
        SangathanVariableDeclaration.setUpdatedTwitterProfile(map.get("Twitter Profile"));
        //updatedInstagramProfile
        SangathanVariableDeclaration.setUpdatedInstagramProfile(map.get("Intagram Profile"));
        //updatedLinkedinProfile
        SangathanVariableDeclaration.setUpdatedLinkedinProfile(map.get("Linkedin Profile"));
        //updatedImage
        SangathanVariableDeclaration.setUpdatedImage(map.get("Image"));
        //updatedSalutation
        SangathanVariableDeclaration.setUpdatedSalutation(map.get("Salutation"));
        //updatedSubCaste
        SangathanVariableDeclaration.setUpdatedSubCaste(map.get("Sub Caste"));
        //updatedQualification
        SangathanVariableDeclaration.setUpdatedQualification(map.get("Qualification"));
        //updatedReligion
        SangathanVariableDeclaration.setUpdatedReligion(map.get("Religion"));
        //updatedActiveMemberId
        SangathanVariableDeclaration.setUpdatedActiveMemberId(map.get("Active Member Id"));
        //updatedPartyZila
        SangathanVariableDeclaration.setUpdatedPartyZila(map.get("Party Zila"));
        //updatedPartyMandal
        SangathanVariableDeclaration.setUpdatedPartyMandal(map.get("Party Mandal"));
        //updatedBloodGroup
        SangathanVariableDeclaration.setUpdatedBloodGroup(map.get("Blood Group"));

        System.out.println("Name:>>>> " + SangathanVariableDeclaration.getNameVariable());

        // Karyakarta_Edit_Details fill into the dynamic form
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
//
//        WebElement actionEle = driver.findElements(By.xpath("//mat-icon[contains(.,'more_vert')]")).get(0);
//        WebElement actioneleAfterClickable = wait.until(ExpectedConditions.elementToBeClickable(actionEle));
//        js.executeScript("arguments[0].scrollIntoView(true);", actioneleAfterClickable);
//        Thread.sleep(1000);
//        // click on action from 1st row
//        js.executeScript("arguments[0].click();", actionEle);
//        Thread.sleep(1000);
//        // click on Edit option
//        driver.findElement(By.xpath("//span[contains(.,'Edit')]")).click();
        sangathanPageObjects = new SangathanPageObjects(driver);
        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(5000);
        WebElement data_entryDynamicTableEle = sangathanPageObjects.getData_EntryDynamicTableEle();
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", data_entryDynamicTableEle);
        get_Karyakarta_Data_To_Edit(SangathanVariableDeclaration.getPhoneNumberVariable());

        Thread.sleep(1000);
        // ------If you want to enter extra details please use this section.------
        WebElement extraDetailsEle = driver.findElement(By.className("mat-expansion-panel-header-description"));
        js.executeScript("arguments[0].scrollIntoView(true);", extraDetailsEle);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", extraDetailsEle);

        //Enter updated name
        FormControlKaryakarta.clearName();
        FormControlKaryakarta.enterName(SangathanVariableDeclaration.getUpdatedName());

        // Enter updated father name
        FormControlKaryakarta.clearRelationName();
        FormControlKaryakarta.enterRelationName(SangathanVariableDeclaration.getUpdatedFatherName());

        // select updated Designation
        FormControlKaryakarta.clearDesignation();
        FormControlKaryakarta.clickOnDesignation();
        FormControlKaryakarta.selectDesignation(SangathanVariableDeclaration.getUpdatedDesignation());

        // selected Updated Has SmartPhone
        //FormControlKaryakarta.clickOnHasSmartPhone();
        //FormControlKaryakarta.selectHasSmartPhone(SangathanVariableDeclaration.getUpdatedHasSmartPhone());

        // Phone Number
        FormControlKaryakarta.enterPhoneNumber(SangathanVariableDeclaration.getUpdatedPhoneNumber());

        // Primary Member
        FormControlKaryakarta.clearPrimaryMemberId();
        FormControlKaryakarta.enterPrimaryMemberId(SangathanVariableDeclaration.getUpdatedPrimaryMemberId());

        // Age
        FormControlKaryakarta.clearAge();
        FormControlKaryakarta.enterAge(SangathanVariableDeclaration.getUpdatedAge());
        int ageInt = Integer.parseInt(SangathanVariableDeclaration.getUpdatedAge());
        // Dob
        String calculatedDOB = dob_calculation_based_on_age_input(ageInt);
        WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
        String copiedDobAfterEnteredAge = dobEle.getAttribute("value");
        Assert.assertEquals(calculatedDOB, copiedDobAfterEnteredAge);
        dobEle.clear();
        apply_validation_in_dob();
        String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
        System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
        // AgeEle.clear();
        // AgeEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        // AgeEle.sendKeys(age);
        dobEle.sendKeys(day_and_month_updated_dob);
        String copiedDob = dobEle.getAttribute("value");
        Assert.assertEquals(day_and_month_updated_dob, copiedDob);

        // Blood Group
        FormControlKaryakarta.clearBloodGroup();
        FormControlKaryakarta.enterBloodGroup(SangathanVariableDeclaration.getUpdatedBloodGroup());

        // select gender
        FormControlKaryakarta.selectGender(SangathanVariableDeclaration.getUpdatedGender());

        // WhatsApp Number
        FormControlKaryakarta.clearWhatsAppNumber();
        FormControlKaryakarta.enterWhatsAppNumber(SangathanVariableDeclaration.getUpdatedWhatsApp());

        // STD Code
        FormControlKaryakarta.clearSTDCode();
        FormControlKaryakarta.enterSTDCode(SangathanVariableDeclaration.getUpdatedStdCode());

        // Landline Number
        FormControlKaryakarta.clearLandlineNumber();
        FormControlKaryakarta.enterLandlineNumber(SangathanVariableDeclaration.getUpdatedLandlineNumber());

        //Clear Category
        FormControlKaryakarta.clearCategory();

        // Validation in category and caste
        apply_validation_in_category_and_caste();

        // click on select Category
        FormControlKaryakarta.clickOnCategory();
        FormControlKaryakarta.selectCategory(SangathanVariableDeclaration.getUpdatedCategory());

        // click on Caste
        FormControlKaryakarta.clickOnCaste();

        //select caste value
        FormControlKaryakarta.selectCaste(SangathanVariableDeclaration.getUpdatedCaste());

        // Email
        FormControlKaryakarta.clearEmail();
        FormControlKaryakarta.enterEmail(SangathanVariableDeclaration.getUpdatedEmail());

        // enter full Address
        FormControlKaryakarta.clearFullAddress();
        FormControlKaryakarta.enterFullAddress(SangathanVariableDeclaration.getUpdatedFullAddress());

        // Village
        FormControlKaryakarta.clearVillage();
        FormControlKaryakarta.enterVillage(SangathanVariableDeclaration.getUpdatedVillage());

        // Taluka/Tehsil
        FormControlKaryakarta.clearTaluka();
        FormControlKaryakarta.enterTaluka(SangathanVariableDeclaration.getUpdatedTaluka());

        // click on Select District
        FormControlKaryakarta.clearDistrict();
        FormControlKaryakarta.clickOnDistrict();
        FormControlKaryakarta.selectDistrict(SangathanVariableDeclaration.getUpdatedDistrict());

        // pinCode
        FormControlKaryakarta.clearPinCode();
        FormControlKaryakarta.enterPinCode(SangathanVariableDeclaration.getUpdatedPinCode());

        // click on Select Education
        FormControlKaryakarta.clearEducation();
        FormControlKaryakarta.clickOnEducation();
        FormControlKaryakarta.selectEducation(SangathanVariableDeclaration.getUpdatedEducation());

        // click on Select Profession
        FormControlKaryakarta.clearProfession();
        FormControlKaryakarta.clickOnProfession();
        FormControlKaryakarta.selectProfession(SangathanVariableDeclaration.getUpdatedProfession());

        // click on Bike
        FormControlKaryakarta.clearBike();
        FormControlKaryakarta.clickOnHasBike();
        FormControlKaryakarta.selectHasBike(SangathanVariableDeclaration.getUpdatedBike());

        // click on Car
        FormControlKaryakarta.clearHasCar();
        FormControlKaryakarta.clickOnHasCar();
        FormControlKaryakarta.selectHasCar(SangathanVariableDeclaration.getUpdatedCar());

        // click on Vidhan Sabha where He/She Votes
        FormControlKaryakarta.clearVidhanSabhaWhereHeSheVotes();
        FormControlKaryakarta.clickOnVidhanSabhaHeSheVotes();
        FormControlKaryakarta.selectVidhanSabhaHeSheVotes(SangathanVariableDeclaration.getUpdatedVidhanSabhaWhereHeSheVotes());

        // Booth where He/She Votes
        FormControlKaryakarta.clearBoothWhereHeSheVotes();
        FormControlKaryakarta.enterBoothWhereHeSheVotes(SangathanVariableDeclaration.getUpdatedBoothWhereHeSheVotes());

        // Voter Id
        FormControlKaryakarta.clearVoterId();
        FormControlKaryakarta.enterVoterId(SangathanVariableDeclaration.getUpdatedVoterId());

        // Aadhaar Number
        FormControlKaryakarta.clearAadharNumber();
        FormControlKaryakarta.enterAadharNumber(SangathanVariableDeclaration.getUpdatedAadharNumber());

        // Panna Number
        FormControlKaryakarta.clearPannaNumber();
        FormControlKaryakarta.enterPannaNumber(SangathanVariableDeclaration.getUpdatedPannaNumber());

        // Ration Card Number
        FormControlKaryakarta.clearRationCardNumber();
        FormControlKaryakarta.enterRationCardNumber(SangathanVariableDeclaration.getUpdatedRationCardNumber());

        // FacebookProfile
        FormControlKaryakarta.clearFacebookProfile();
        FormControlKaryakarta.enterFacebookProfile(SangathanVariableDeclaration.getUpdatedFacebookProfile());

        // TwitterProfile
        FormControlKaryakarta.clearTwitterProfile();
        FormControlKaryakarta.enterTwitterProfile(SangathanVariableDeclaration.getUpdatedTwitterProfile());

        // InstagramProfile
        FormControlKaryakarta.clearInstagramProfile();
        FormControlKaryakarta.enterInstagramProfile(SangathanVariableDeclaration.getUpdatedInstagramProfile());

        // LinkedInProfile
        FormControlKaryakarta.clearLinkedinProfile();
        FormControlKaryakarta.enterLinkedinProfile(SangathanVariableDeclaration.getUpdatedTwitterProfile());


        // click on Salutation
        FormControlKaryakarta.clickOnSalutation();
        FormControlKaryakarta.selectSalutation(SangathanVariableDeclaration.getUpdatedSalutation());


        // Sub Caste
        FormControlKaryakarta.clearSubCaste();
        FormControlKaryakarta.enterSubCaste(SangathanVariableDeclaration.getUpdatedSubCaste());

        // Qualification
        FormControlKaryakarta.clearQualification();
        FormControlKaryakarta.enterQualification(SangathanVariableDeclaration.getUpdatedQualification());

        // Religion
        FormControlKaryakarta.clickOnReligion();
        FormControlKaryakarta.selectReligion(SangathanVariableDeclaration.getUpdatedReligion());

        // Active Member Id
        FormControlKaryakarta.clearActiveMemberId();
        FormControlKaryakarta.enterActiveMemberId(SangathanVariableDeclaration.getUpdatedActiveMemberId());

        // Clear Party Zila
        FormControlKaryakarta.clearPartyZila();

        // Party Zila and Party Mandal validation
        apply_validation_in_party_zila_and_mandal();

        // click on party zila placeholder
        FormControlKaryakarta.clickOnPartyZila();

        // Select Party Zila Id
        FormControlKaryakarta.selectPartyZila(SangathanVariableDeclaration.getUpdatedPartyZila());

        // Click On Party Mandal
        FormControlKaryakarta.clickOnPartyMandal();
        // Select Party Mandal
        FormControlKaryakarta.selectPartyMandal(SangathanVariableDeclaration.getUpdatedPartyMandal());

    }

    @And("^user click on update button$")
    public void user_click_on_update_button() throws InterruptedException {
        Thread.sleep(2000);
        WebElement updateButton = driver.findElement(By.xpath("//span[contains(.,'Update')]"));
        updateButton.click();

    }

    @And("^user delete person after all the operations$")
    public void user_delete_person_after_all_the_operations(DataTable reason_for_person_deletion)
            throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        js = (JavascriptExecutor) driver;
        // Object for SANGATHAN Page Object Class
        sangathanPageObjects = new SangathanPageObjects(driver);
        Map<String, String> map = reason_for_person_deletion.asMap(String.class, String.class);
        String deleteReason = map.get("Reason For Person Deletion");
        //fatherName = map.get("Father Name");
        Thread.sleep(2000);
        WebElement data_entryDynamicTableEle = sangathanPageObjects.getData_EntryDynamicTableEle();
        js.executeScript("arguments[0].scrollIntoView(true);", data_entryDynamicTableEle);

        get_karyakarta_data_to_delete(SangathanVariableDeclaration.getUpdatedPhoneNumber());
        WebElement deleteEleBoxText = driver
                .findElement(By.xpath("//mat-label[.='Please Select A Reason For Deletion']"));
        wait.until(ExpectedConditions.visibilityOf(deleteEleBoxText));
        WebElement deleteReasonsDropdown = driver.findElement(By.xpath("(//mat-select)[4]"));
        deleteReasonsDropdown.click();
        Thread.sleep(2000);
        WebElement deleteResonEle = driver.findElement(By.xpath("//span[contains(text(),'" + deleteReason + "')]"));
        js.executeScript("arguments[0].click();", deleteResonEle);
        Thread.sleep(2000);
        WebElement deleteButton = driver.findElement(By.xpath("//span[text()='Delete']"));
        deleteButton.click();
        // person deleted successfully text
        WebElement infoDeletedPersonTextEle = driver
                .findElement(By.xpath("//simple-snack-bar/span[contains(text(),'Person Entry Deleted')]"));
        wait.until(ExpectedConditions.visibilityOf(infoDeletedPersonTextEle));
        Assert.assertEquals("Person Entry Deleted", infoDeletedPersonTextEle.getText());

    }

    @And("^user verify all the updated data$")
    public void user_verify_all_the_updated_data() throws InterruptedException {

        // click on edit button
        user_click_on_edit_button_for_recently_added_entry();

        // user verify all the added data
        js = (JavascriptExecutor) driver;
        // get all the added data.
        user_clicks_on_enter_more_details();

        // set copied name
        SangathanVariableDeclaration.setCopiedName(FormControlKaryakarta.getEnteredName());
        // Verifying copied and updated name
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedName(), SangathanVariableDeclaration.getUpdatedName().toUpperCase());

        // set copied father name
        SangathanVariableDeclaration.setCopiedFatherName(FormControlKaryakarta.getEnteredRelationName());
        //Verifying copied and updated father name
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedFatherName().toUpperCase(), SangathanVariableDeclaration.getUpdatedFatherName()
                .toUpperCase());

        // set copied designation
//        WebElement SelectDesignationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Designation')]"));
//        copiedSelectedDesignation = driver.findElement(with(By.className("ng-value-label")).below(SelectDesignationEle))
//                .getText();
        SangathanVariableDeclaration.setCopiedDesignation(FormControlKaryakarta.getSelectedDesignation());
        //verifying copied designation and updated designation
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedDesignation(), SangathanVariableDeclaration.getUpdatedDesignation());

        // Set Copied Has SmartPhone
//        WebElement hasSmartPhoneEle = driver.findElement(By.xpath("//div[contains(text(),'Has Smartphone')]"));
//        copiedHasSmartPhone = driver.findElement(with(By.className("ng-value-label")).below(hasSmartPhoneEle))
//                .getText();
        SangathanVariableDeclaration.setCopiedHasSmartPhone(FormControlKaryakarta.getSelectedHasSmartPhone());
        //Verifying copied and updated Has Smart Phone
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedHasSmartPhone(), SangathanVariableDeclaration.getUpdatedHasSmartPhone());

        // Phone Number
        copiedPhoneNo = driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).getAttribute("value");
        Assert.assertEquals(copiedPhoneNo, updatedPhoneNumber);

        // Primary Member
        copiedPrimaryMember = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"))
                .getAttribute("value");
        Assert.assertEquals(copiedPrimaryMember, updatedPrimaryMemberId);

        // Age
        copiedAge = driver.findElement(By.xpath("//input[@placeholder='Age']")).getAttribute("value");
        Assert.assertEquals(copiedAge, updatedAge);
        int ageInt = Integer.parseInt(updatedAge);
        // Dob
        WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
        String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
        System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
        copiedDob = dobEle.getAttribute("value");
        Assert.assertEquals(day_and_month_updated_dob, copiedDob);

        // Blood Group
        WebElement BloodGroupEle = driver.findElement(By.xpath("//input[@data-placeholder='Blood Group']"));
        copiedBloodGroup = BloodGroupEle.getAttribute("value");
        Assert.assertEquals(copiedBloodGroup, updatedBloodGroup);

        // Gender
        String genderFormating = updatedGender.toLowerCase();
        if (genderFormating.equals("other")) {
            genderFormating = genderFormating + "s";
        }
        System.out.println("genderFormating :" + genderFormating);

        String classOfselectedGender = driver
                .findElement(By.xpath("//mat-radio-button[@value='" + genderFormating + "']")).getAttribute("class");
        System.out.println("classOfselectedGender :" + classOfselectedGender);
        Assert.assertEquals(classOfselectedGender.contains("mat-radio-checked"), true,
                "seems like gender is not selected");

        // set copied WhatsApp Number
        SangathanVariableDeclaration.setCopiedWhatsApp(FormControlKaryakarta.getEnteredWhatsAppNumber());
        //Verifying copied whatsapp number and updated whatsapp number
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedWhatsApp(), SangathanVariableDeclaration.getUpdatedWhatsApp());

        // set STD Code
        SangathanVariableDeclaration.setCopiedStdCode(FormControlKaryakarta.getEnteredSTDCode());
        // Verifying copied std code and updated std code
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedStdCode(), SangathanVariableDeclaration.getUpdatedStdCode());

        // Landline Number
        SangathanVariableDeclaration.setCopiedLandlineNumber(FormControlKaryakarta.getEnteredLandlineNumber());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedLandlineNumber(), SangathanVariableDeclaration.getUpdatedLandlineNumber());

        // Select Category
        WebElement SelectCategoryEle = driver.findElement(By.xpath("//div[contains(text(),'Select Category')]"));
        copiedSelectedCategory = driver.findElement(with(By.className("ng-value-label")).below(SelectCategoryEle))
                .getText();
        Assert.assertEquals(copiedSelectedCategory, updatedCategory);

        // Caste
        WebElement SelectCasteEle = driver.findElement(By.xpath("//div[contains(text(),'Caste')]"));
        copiedSelectedCaste = driver.findElement(with(By.className("ng-value-label")).below(SelectCasteEle)).getText();
        Assert.assertEquals(copiedSelectedCaste, updatedCaste);

        // Email
        copiedEmail = driver.findElement(By.xpath("//input[@placeholder='Email']")).getAttribute("value");
        Assert.assertEquals(copiedEmail, updatedEmail);

        // Full Address
        copiedFullAddress = driver.findElement(By.xpath("//input[@placeholder='Full Address']")).getAttribute("value");
        Assert.assertEquals(copiedFullAddress, updatedFullAddress);

        // Village
        copiedVillage = driver.findElement(By.xpath("//input[@placeholder='Village/Ward']")).getAttribute("value");
        Assert.assertEquals(copiedVillage, updatedVillage);

        // Taluka/Tehsil
        copiedTaluka_Tehsil = driver.findElement(By.xpath("//input[contains(@placeholder, 'Taluka')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedTaluka_Tehsil, updatedTaluka);

        // select district
        WebElement SelectDistrictEle = driver.findElement(By.xpath("//div[contains(text(),'Select District')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", SelectDistrictEle);
        copiedSelectedDistrict = driver.findElement(with(By.className("ng-value-label")).below(SelectDistrictEle))
                .getText();
        Assert.assertEquals(copiedSelectedDistrict, updatedDistrict);

        // Pin Code
        CopiedpinCode = driver.findElement(By.xpath("//input[@placeholder='Pin Code']")).getAttribute("value");
        Assert.assertEquals(CopiedpinCode, updatedPinCode);

        // Select Education
        WebElement SelectEducationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Education')]"));
        copiedSelectedEducation = driver.findElement(with(By.className("ng-value-label")).below(SelectEducationEle))
                .getText();
        Assert.assertEquals(copiedSelectedEducation, updatedEducation);

        // Select Profession
        WebElement SelectProfessionEle = driver.findElement(By.xpath("//div[contains(text(),'Select Profession')]"));
        copiedSelectedProfession = driver.findElement(with(By.className("ng-value-label")).below(SelectProfessionEle))
                .getText();
        Assert.assertEquals(copiedSelectedProfession, updatedProfession);

        // hasBike
        WebElement HasBikeEle = driver.findElement(By.xpath("//div[contains(text(),'Bike')]"));
        copiedHasBike = driver.findElement(with(By.className("ng-value-label")).below(HasBikeEle)).getText();
        Assert.assertEquals(copiedHasBike, updatedBike);

        // hasCar
        WebElement HasCarEle = driver.findElement(By.xpath("//div[contains(text(),'Car')]"));
        copiedHasCar = driver.findElement(with(By.className("ng-value-label")).below(HasCarEle)).getText();
        Assert.assertEquals(copiedHasCar, updatedCar);

        // vidhanSabha where he/she votes
        WebElement vidhanSabha_where_he_sheVotesEle = driver
                .findElement(By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]"));
        copied_vidhanSabha_where_he_sheVotes = driver
                .findElement(with(By.className("ng-value-label")).below(vidhanSabha_where_he_sheVotesEle)).getText();

        // separating number and "-" from copied_vidhanSabha_where_he_sheVotes
        // String[] vidhansabhaNameArr =
        // copied_vidhanSabha_where_he_sheVotes.split("-");
        Assert.assertEquals(copied_vidhanSabha_where_he_sheVotes, updatedVidhanSabhaWhereHeSheVotes);

        // Booth where He/She Votes
        copiedBothWhereHeSheVotes = driver
                .findElement(By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedBothWhereHeSheVotes, updatedBoothWhereHeSheVotes);

        // Voter Id
        SangathanVariableDeclaration.setCopiedVoterId(FormControlKaryakarta.getEnteredVoterId());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedVoterId(), SangathanVariableDeclaration.getUpdatedVoterId());

        // Aadhaar Number
        copiedAadhaarNumber = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedAadhaarNumber, updatedAadharNumber);

        // Panna Number
        copiedPannaNumber = driver.findElement(By.xpath("//input[contains(@placeholder, 'Panna Number')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedPannaNumber, updatedPannaNumber);

        // Ration Card
        copiedRationCard = driver.findElement(By.xpath("//input[contains(@placeholder, 'Ration Card Number')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedRationCard, updatedRationCardNumber);

        // Facebook
        copiedFacebookValue = driver.findElement(By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedFacebookValue, updatedFacebookProfile);

        // TwitterProfile
        copiedTwitterProfile = driver
                .findElement(By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedTwitterProfile, updatedTwitterProfile);

        // InstagramProfile
        copiedInstagramProfile = driver
                .findElement(By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedInstagramProfile, updatedInstagramProfile);

        // LinkedInProfile
        copiedLinkedInProfile = driver
                .findElement(By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedLinkedInProfile, updatedLinkedinProfile);

        // Salutation
        copiedSalutation = driver.findElements(By.className("mat-select-value-text")).get(0).getText();
        Assert.assertEquals(copiedSalutation, updatedSalutation);

        // Sub Caste
        copiedSubCaste = driver.findElement(By.xpath("//input[contains(@placeholder, 'Sub caste')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedSubCaste, updatedSubCaste);

        // Qualification
        copiedQualification = driver.findElement(By.xpath("//input[contains(@placeholder, 'Qualification')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedQualification, updatedQualification);

        // Religion
        copiedReligion = driver.findElements(By.className("mat-select-value-text")).get(1).getText();
        Assert.assertEquals(copiedReligion, updatedReligion);

        // Active Member Id
        copiedActiveMemberId = driver.findElement(By.xpath("//input[contains(@placeholder, 'Active Member Id')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedActiveMemberId, updatedActiveMemberId);

        // Select Party Zila Id
        WebElement SelectPartyZilaIdEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Zila')]"));
        copiedSelectedPartyZilaId = driver.findElement(with(By.className("ng-value-label")).below(SelectPartyZilaIdEle))
                .getText();
        Assert.assertEquals(copiedSelectedPartyZilaId, updatedPartyZila);

        // Select Party Mandal
        WebElement SelectPartyMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
        copiedSelectedPartyMandalId = driver
                .findElement(with(By.className("ng-value-label")).below(SelectPartyMandalEle)).getText();
        Assert.assertEquals(copiedSelectedPartyMandalId, updatedPartyMandal);

        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(2000);

        // click on cancel button
        WebElement cancelButtonEle = driver.findElement(By.xpath("//span[contains(.,'Cancel')]"));
        js.executeScript("arguments[0].click();", cancelButtonEle);

        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(2000);

    }

    @And("^user scroll to view data table and search for data which need to edit and get all the data$")
    public void user_scroll_to_view_data_table_and_search_for_data_which_need_to_edit_and_get_all_the_data(
            DataTable Karyakarta_Edit_Details) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        js = (JavascriptExecutor) driver;
        Map<String, String> map = Karyakarta_Edit_Details.asMap(String.class, String.class);
        // Get Data
        //updatedName
        SangathanVariableDeclaration.setUpdatedName(map.get("Name"));
        //updatedFatherName
        SangathanVariableDeclaration.setUpdatedFatherName(map.get("Father Name"));
        //updatedDesignation
        SangathanVariableDeclaration.setUpdatedDesignation(map.get("Designation"));
        //updatedHasSmartPhone
        SangathanVariableDeclaration.setUpdatedHasSmartPhone(map.get("Has Smartphone"));
        //updatedPhoneNumber
        SangathanVariableDeclaration.setUpdatedPhoneNumber(map.get("Phone Number"));
        //updatedPrimaryMemberId
        SangathanVariableDeclaration.setUpdatedPrimaryMemberId(map.get("Primary Member ID"));
        //updatedAge
        SangathanVariableDeclaration.setUpdatedAge("Age");
        //updatedGender
        SangathanVariableDeclaration.setUpdatedGender(map.get("Gender"));
        //updatedWhatsApp
        SangathanVariableDeclaration.setUpdatedWhatsApp(map.get("WhatsApp Number"));
        //updatedStdCode
        SangathanVariableDeclaration.setUpdatedStdCode(map.get("STD Code"));
        //updatedLandlineNumber
        SangathanVariableDeclaration.setUpdatedLandlineNumber(map.get("Landline Number"));
        //updatedCategory
        SangathanVariableDeclaration.setUpdatedCategory(map.get("Category"));
        //updatedCaste
        SangathanVariableDeclaration.setUpdatedCaste(map.get("Caste"));
        //updatedEmail
        SangathanVariableDeclaration.setUpdatedEmail(map.get("Email"));
        //updatedDob
        SangathanVariableDeclaration.setUpdatedDob(map.get("Dob"));
        //updatedFullAddress
        SangathanVariableDeclaration.setUpdatedFullAddress(map.get("Full Address"));
        //updatedVillage
        SangathanVariableDeclaration.setUpdatedVillage(map.get("Village"));
        //updatedTaluka
        SangathanVariableDeclaration.setUpdatedTaluka(map.get("Taluka"));
        //updatedDistrict = map.get("District");
        SangathanVariableDeclaration.setUpdatedDistrict(map.get("District"));
        //updatedPinCode
        SangathanVariableDeclaration.setUpdatedPinCode(map.get("Pin Code"));
        //updatedEducation
        SangathanVariableDeclaration.setUpdatedEducation(map.get("Education"));
        //updatedProfession
        SangathanVariableDeclaration.setUpdatedProfession(map.get("Profession"));
        //updatedBike
        SangathanVariableDeclaration.setUpdatedBike(map.get("Bike"));
        //updatedCar
        SangathanVariableDeclaration.setUpdatedCar(map.get("Car"));
        //updatedVidhanSabhaWhereHeSheVotes
        SangathanVariableDeclaration.setUpdatedVidhanSabhaWhereHeSheVotes(map.get("Vidhan Sabha where he/she votes"));
        //updatedBoothWhereHeSheVotes
        SangathanVariableDeclaration.setUpdatedBoothWhereHeSheVotes(map.get("Booth where he/she votes"));
        updatedVoterId = map.get("Voter Id");
        SangathanVariableDeclaration.setUpdatedVoterId(map.get("Voter Id"));
        //updatedAadharNumber
        SangathanVariableDeclaration.setUpdatedAadharNumber(map.get("Aadhaar Number"));
        //updatedPannaNumber
        SangathanVariableDeclaration.setUpdatedPannaNumber(map.get("Panna Number"));
        //updatedRationCardNumber
        SangathanVariableDeclaration.setUpdatedRationCardNumber(map.get("Ration Card Number"));
        //updatedFacebookProfile
        SangathanVariableDeclaration.setUpdatedFacebookProfile(map.get("Facebook Profile"));
        //updatedTwitterProfile
        SangathanVariableDeclaration.setUpdatedTwitterProfile(map.get("Twitter Profile"));
        //updatedInstagramProfile
        SangathanVariableDeclaration.setUpdatedInstagramProfile(map.get("Intagram Profile"));
        //updatedLinkedinProfile
        SangathanVariableDeclaration.setUpdatedLinkedinProfile(map.get("Linkedin Profile"));
        //updatedImage
        SangathanVariableDeclaration.setUpdatedImage(map.get("Image"));
        //updatedSalutation
        SangathanVariableDeclaration.setUpdatedSalutation(map.get("Salutation"));
        //updatedSubCaste
        SangathanVariableDeclaration.setUpdatedSubCaste(map.get("Sub Caste"));
        //updatedQualification
        SangathanVariableDeclaration.setUpdatedQualification(map.get("Qualification"));
        //updatedReligion
        SangathanVariableDeclaration.setUpdatedReligion(map.get("Religion"));
        //updatedActiveMemberId
        SangathanVariableDeclaration.setUpdatedActiveMemberId(map.get("Active Member Id"));
        //updatedPartyZila
        SangathanVariableDeclaration.setUpdatedPartyZila(map.get("Party Zila"));
        //updatedPartyMandal
        SangathanVariableDeclaration.setUpdatedPartyMandal(map.get("Party Mandal"));
        //updatedBloodGroup
        SangathanVariableDeclaration.setUpdatedBloodGroup(map.get("Blood Group"));
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table")));
        System.out.println("updatedPhoneNumber????: " + updatedPhoneNumber);
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
                    System.out.println("phoneNumberRow:" + phoneNumberRow);
                    String phoneNumberValue = phoneNumberRows.get(phoneNumberRow).getText();
                    if (phoneNumberValue.contains(updatedPhoneNumber)) {
                        System.out.println("phoneNumberValue>>: " + phoneNumberValue);
                        WebElement actionButtonEle = driver
                                .findElement(By.xpath("//table/tbody/tr[" + (phoneNumberRow + 1) + "]/td["
                                        + (lastColNum) + "]//mat-icon[contains(.,'more_vert')]"));
                        js.executeScript("arguments[0].click();", actionButtonEle);

                        List<WebElement> actionAllEle = driver.findElements(By.xpath("//button//img"));
                        wait.until(ExpectedConditions.visibilityOfAllElements(actionAllEle));
                        WebElement editButtonEle = driver.findElement(By.xpath("//button//span[text()='Edit']"));
                        js.executeScript("arguments[0].click();", editButtonEle);
                        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
                        Thread.sleep(2000);
                        user_clicks_on_enter_more_details();
                        // get all the data from the update mode
                        // Name
                        copiedEnteredName = driver.findElement(By.xpath("//input[@placeholder='Name']"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedEnteredName.toUpperCase(), updatedName.toUpperCase());

                        // Father's/Husband's Name
                        copiedEnteredFather_Husband_Name = driver
                                .findElement(By.xpath("//input[contains(@placeholder, 'Father')]"))
                                .getAttribute("value");
                        Assert.assertEquals(updatedFatherName.toUpperCase(),
                                copiedEnteredFather_Husband_Name.toUpperCase());

                        // Designation
                        WebElement SelectDesignationEle = driver
                                .findElement(By.xpath("//div[contains(text(),'Select Designation')]"));
                        copiedSelectedDesignation = driver
                                .findElement(with(By.className("ng-value-label")).below(SelectDesignationEle))
                                .getText();
                        Assert.assertEquals(copiedSelectedDesignation, updatedDesignation);

                        // Has SmartPhone
                        WebElement hasSmartPhoneEle = driver
                                .findElement(By.xpath("//div[contains(text(),'Has Smartphone')]"));
                        copiedHasSmartPhone = driver
                                .findElement(with(By.className("ng-value-label")).below(hasSmartPhoneEle)).getText();
                        Assert.assertEquals(copiedHasSmartPhone, updatedHasSmartPhone);

                        // Phone Number
                        copiedPhoneNo = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedPhoneNo, updatedPhoneNumber);

                        // Primary Member
                        copiedPrimaryMember = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedPrimaryMember, updatedPrimaryMemberId);

                        // Age
                        copiedAge = driver.findElement(By.xpath("//input[@placeholder='Age']")).getAttribute("value");
                        Assert.assertEquals(copiedAge, updatedAge);
                        int ageInt = Integer.parseInt(updatedAge);
                        // Dob
                        WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
                        String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
                        System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
                        copiedDob = dobEle.getAttribute("value");
                        Assert.assertEquals(day_and_month_updated_dob, copiedDob);

                        // Blood Group
                        WebElement BloodGroupEle = driver
                                .findElement(By.xpath("//input[@data-placeholder='Blood Group']"));
                        copiedBloodGroup = BloodGroupEle.getAttribute("value");
                        Assert.assertEquals(copiedBloodGroup, updatedBloodGroup);

                        // Gender
                        String genderFormating = updatedGender.toLowerCase();
                        if (genderFormating.equals("other")) {
                            genderFormating = genderFormating + "s";
                        }
                        System.out.println("genderFormating :" + genderFormating);

                        String classOfselectedGender = driver
                                .findElement(By.xpath("//mat-radio-button[@value='" + genderFormating + "']"))
                                .getAttribute("class");
                        System.out.println("classOfselectedGender :" + classOfselectedGender);
                        Assert.assertEquals(classOfselectedGender.contains("mat-radio-checked"), true,
                                "seems like gender is not selected");

                        // WhatsApp
                        copiedWhatsAppNumber = driver.findElement(By.xpath("//input[@placeholder='WhatsApp Number']"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedWhatsAppNumber, updatedWhatsApp);

                        // STD Code
                        SangathanVariableDeclaration.setCopiedStdCode(FormControlKaryakarta.getEnteredSTDCode());
                        Assert.assertEquals(SangathanVariableDeclaration.getCopiedStdCode(), SangathanVariableDeclaration.getUpdatedStdCode());

                        // Landline Number
                        SangathanVariableDeclaration.setCopiedLandlineNumber(FormControlKaryakarta.getEnteredLandlineNumber());
                        Assert.assertEquals(SangathanVariableDeclaration.getCopiedLandlineNumber(), SangathanVariableDeclaration.getUpdatedLandlineNumber());

                        // Select Category
                        WebElement SelectCategoryEle = driver
                                .findElement(By.xpath("//div[contains(text(),'Select Category')]"));
                        copiedSelectedCategory = driver
                                .findElement(with(By.className("ng-value-label")).below(SelectCategoryEle)).getText();
                        Assert.assertEquals(copiedSelectedCategory, updatedCategory);

                        // Caste
                        WebElement SelectCasteEle = driver.findElement(By.xpath("//div[contains(text(),'Caste')]"));
                        copiedSelectedCaste = driver
                                .findElement(with(By.className("ng-value-label")).below(SelectCasteEle)).getText();
                        Assert.assertEquals(copiedSelectedCaste, updatedCaste);

                        // Email
                        copiedEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedEmail, updatedEmail);

                        // Full Address
                        copiedFullAddress = driver.findElement(By.xpath("//input[@placeholder='Full Address']"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedFullAddress, updatedFullAddress);

                        // Village
                        copiedVillage = driver.findElement(By.xpath("//input[@placeholder='Village/Ward']"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedVillage, updatedVillage);

                        // Taluka/Tehsil
                        copiedTaluka_Tehsil = driver.findElement(By.xpath("//input[contains(@placeholder, 'Taluka')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedTaluka_Tehsil, updatedTaluka);

                        // select district
                        WebElement SelectDistrictEle = driver
                                .findElement(By.xpath("//div[contains(text(),'Select District')]"));
                        js.executeScript("arguments[0].scrollIntoView(true);", SelectDistrictEle);
                        copiedSelectedDistrict = driver
                                .findElement(with(By.className("ng-value-label")).below(SelectDistrictEle)).getText();
                        Assert.assertEquals(copiedSelectedDistrict, updatedDistrict);

                        // Pin Code
                        CopiedpinCode = driver.findElement(By.xpath("//input[@placeholder='Pin Code']"))
                                .getAttribute("value");
                        Assert.assertEquals(CopiedpinCode, updatedPinCode);

                        // Select Education
                        WebElement SelectEducationEle = driver
                                .findElement(By.xpath("//div[contains(text(),'Select Education')]"));
                        copiedSelectedEducation = driver
                                .findElement(with(By.className("ng-value-label")).below(SelectEducationEle)).getText();
                        Assert.assertEquals(copiedSelectedEducation, updatedEducation);

                        // Select Profession
                        WebElement SelectProfessionEle = driver
                                .findElement(By.xpath("//div[contains(text(),'Select Profession')]"));
                        copiedSelectedProfession = driver
                                .findElement(with(By.className("ng-value-label")).below(SelectProfessionEle)).getText();
                        Assert.assertEquals(copiedSelectedProfession, updatedProfession);

                        // hasBike
                        WebElement HasBikeEle = driver.findElement(By.xpath("//div[contains(text(),'Bike')]"));
                        copiedHasBike = driver.findElement(with(By.className("ng-value-label")).below(HasBikeEle))
                                .getText();
                        Assert.assertEquals(copiedHasBike, updatedBike);

                        // hasCar
                        WebElement HasCarEle = driver.findElement(By.xpath("//div[contains(text(),'Car')]"));
                        copiedHasCar = driver.findElement(with(By.className("ng-value-label")).below(HasCarEle))
                                .getText();
                        Assert.assertEquals(copiedHasCar, updatedCar);

                        // vidhanSabha where he/she votes
                        WebElement vidhanSabha_where_he_sheVotesEle = driver
                                .findElement(By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]"));
                        copied_vidhanSabha_where_he_sheVotes = driver
                                .findElement(
                                        with(By.className("ng-value-label")).below(vidhanSabha_where_he_sheVotesEle))
                                .getText();

                        // separating number and "-" from copied_vidhanSabha_where_he_sheVotes
                        String[] vidhansabhaNameArr = copied_vidhanSabha_where_he_sheVotes.split("-");
                        Assert.assertEquals(vidhansabhaNameArr[1].trim(), updatedVidhanSabhaWhereHeSheVotes);

                        // Booth where He/She Votes
                        copiedBothWhereHeSheVotes = driver
                                .findElement(By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedBothWhereHeSheVotes, updatedBoothWhereHeSheVotes);

                        // Voter Id
                        copiedVoterId = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedVoterId, updatedVoterId);

                        // Aadhaar Number
                        copiedAadhaarNumber = driver
                                .findElement(By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedAadhaarNumber, updatedAadharNumber);

                        // Panna Number
                        copiedPannaNumber = driver
                                .findElement(By.xpath("//input[contains(@placeholder, 'Panna Number')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedPannaNumber, updatedPannaNumber);

                        // Ration Card
                        copiedRationCard = driver
                                .findElement(By.xpath("//input[contains(@placeholder, 'Ration Card Number')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedRationCard, updatedRationCardNumber);

                        // Facebook
                        copiedFacebookValue = driver
                                .findElement(By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedFacebookValue, updatedFacebookProfile);

                        // TwitterProfile
                        copiedTwitterProfile = driver
                                .findElement(By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedTwitterProfile, updatedTwitterProfile);

                        // InstagramProfile
                        copiedInstagramProfile = driver
                                .findElement(By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedInstagramProfile, updatedInstagramProfile);

                        // LinkedInProfile
                        copiedLinkedInProfile = driver
                                .findElement(By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedLinkedInProfile, updatedLinkedinProfile);

                        // Salutation
                        copiedSalutation = driver.findElements(By.className("mat-select-value-text")).get(0).getText();
                        Assert.assertEquals(copiedSalutation, updatedSalutation);

                        // Sub Caste
                        copiedSubCaste = driver.findElement(By.xpath("//input[contains(@placeholder, 'Sub caste')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedSubCaste, updatedSubCaste);

                        // Qualification
                        copiedQualification = driver
                                .findElement(By.xpath("//input[contains(@placeholder, 'Qualification')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedQualification, updatedQualification);

                        // Religion
                        copiedReligion = driver.findElements(By.className("mat-select-value-text")).get(1).getText();
                        Assert.assertEquals(copiedReligion, updatedReligion);

                        // Active Member Id
                        copiedActiveMemberId = driver
                                .findElement(By.xpath("//input[contains(@placeholder, 'Active Member Id')]"))
                                .getAttribute("value");
                        Assert.assertEquals(copiedActiveMemberId, updatedActiveMemberId);

                        // Select Party Zila Id
                        WebElement SelectPartyZilaIdEle = driver
                                .findElement(By.xpath("//div[contains(text(),'Select Party Zila Id')]"));
                        copiedSelectedPartyZilaId = driver
                                .findElement(with(By.className("ng-value-label")).below(SelectPartyZilaIdEle))
                                .getText();
                        Assert.assertEquals(copiedSelectedPartyZilaId, updatedPartyZila);

                        // Select Party Mandal
                        WebElement SelectPartyMandalEle = driver
                                .findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
                        copiedSelectedPartyMandalId = driver
                                .findElement(with(By.className("ng-value-label")).below(SelectPartyMandalEle))
                                .getText();
                        Assert.assertEquals(copiedSelectedPartyMandalId, updatedPartyMandal);

                        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
                        Thread.sleep(2000);

                        // click on cancel button
                        WebElement cancelButtonEle = driver.findElement(By.xpath("//span[contains(.,'Cancel')]"));
                        js.executeScript("arguments[0].click();", cancelButtonEle);

//

                    }
                }

            }
        }
    }

    @And("^user search for data which need to qc$")
    public void user_scroll_to_view_data_table_and_search_for_data_which_need_to_qc() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table")));
        // columns in table
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
                    System.out.println("phoneNumberRow:" + phoneNumberRow);
                    String phoneNumberValue = phoneNumberRows.get(phoneNumberRow).getText();
                    if (phoneNumberValue.contains(updatedPhoneNumber)) {
                        System.out.println("phoneNumberValue>>: " + phoneNumberValue);
                        WebElement actionButtonEle = driver
                                .findElement(By.xpath("//table/tbody/tr[" + (phoneNumberRow + 1) + "]/td["
                                        + (lastColNum) + "]//mat-icon[contains(.,'more_vert')]"));
                        js.executeScript("arguments[0].click();", actionButtonEle);

                        List<WebElement> actionAllEle = driver.findElements(By.xpath("//button//img"));
                        wait.until(ExpectedConditions.visibilityOfAllElements(actionAllEle));
                        WebElement qcStatusButtonEle = driver
                                .findElement(By.xpath("//button//span[text()='QC status']"));
                        js.executeScript("arguments[0].click();", qcStatusButtonEle);
                        WebElement qcPopup = driver.findElement(By.xpath("//app-qc//div"));
                        wait.until(ExpectedConditions.visibilityOf(qcPopup));

                    }
                }

            }
        }

    }

    @And("^user qc all the data in qc pop up$")
    public void user_qc_all_the_data_in_qc_pop_up() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        js = (JavascriptExecutor) driver;
        WebElement qcImageEle = driver.findElement(By.xpath("//app-qc//img"));
        js.executeScript("arguments[0].scrollIntoView(true);", qcImageEle);
        List<WebElement> personalDetailQc = driver
                .findElements(By.xpath("//app-qc//div[@class='personal-detail']/div/span"));
        // name qc value verification
        String nameQcValue = personalDetailQc.get(1).getText();
        System.out.println("nameQcValue: " + nameQcValue);
        Assert.assertEquals(nameQcValue, copiedEnteredName);
        // relation name qc value verfication
        String relationQcValue = personalDetailQc.get(3).getText();
        System.out.println("relationQcValue: " + relationQcValue);
        Assert.assertEquals(relationQcValue, copiedEnteredFather_Husband_Name);
        // age qc value verification
        String ageQcValue = personalDetailQc.get(5).getText();
        System.out.println("ageQcValue: " + ageQcValue);
        Assert.assertEquals(ageQcValue, copiedAge);
        // designation qc value verification
        String designationQcValue = personalDetailQc.get(7).getText();
        System.out.println("designationQcValue: " + designationQcValue);
        Assert.assertEquals(designationQcValue, copiedSelectedDesignation);
        // has smartphone qc value verification
        String smartphoneQcValue = personalDetailQc.get(9).getText();
        System.out.println("smartphoneQcValue: " + smartphoneQcValue);
        Assert.assertEquals(smartphoneQcValue, copiedHasSmartPhone);
        // blood group qc value verification
        String bloodgroupQcValue = personalDetailQc.get(11).getText();
        System.out.println("bloodgroupQcValue: " + bloodgroupQcValue);
        Assert.assertEquals(bloodgroupQcValue, copiedBloodGroup);
        // mobile number qc value verification
        String mobilenumberQcValue = personalDetailQc.get(13).getText();
        System.out.println("mobilenumberQcValue: " + mobilenumberQcValue);
        Assert.assertEquals(mobilenumberQcValue, copiedPhoneNo);
        // primary member qc value verification
        String primarymemberQcValue = personalDetailQc.get(15).getText();
        System.out.println("primarymemberQcValue: " + primarymemberQcValue);
        Assert.assertEquals(primarymemberQcValue, copiedPrimaryMember);

        List<WebElement> personalSocialDetailsQcValue = driver
                .findElements(By.xpath("//div[@class='qc-person-social-detial']/div/div/span[2]"));
        // panna number qc value
        String pannanumberQcValue = personalSocialDetailsQcValue.get(0).getText();
        Assert.assertEquals(pannanumberQcValue, copiedPannaNumber);

        // ration card qc value
        String rationcardQcValue = personalSocialDetailsQcValue.get(1).getText();
        Assert.assertEquals(rationcardQcValue, copiedRationCard);

        // facebook profile qc value
        String facebookQcValue = personalSocialDetailsQcValue.get(2).getText();
        Assert.assertEquals(facebookQcValue, copiedFacebookValue);

        // twitter profile qc value
        String twitterQcValue = personalSocialDetailsQcValue.get(3).getText();
        Assert.assertEquals(twitterQcValue, copiedTwitterProfile);

        // instagram profile qc value
        String instagramQcValue = personalSocialDetailsQcValue.get(4).getText();
        Assert.assertEquals(instagramQcValue, copiedInstagramProfile);

        // Linkedin profile qc value
        String linkedinQcValue = personalSocialDetailsQcValue.get(5).getText();
        Assert.assertEquals(linkedinQcValue, copiedLinkedInProfile);

        // Qc person details
        List<WebElement> personDetailsQcvalue = driver
                .findElements(By.xpath("//div[@class='qc-person-details']/div/div/span[2]"));
        // gender qc value
        String genderQcValue = personDetailsQcvalue.get(0).getText();
        Assert.assertEquals(genderQcValue, "male");
        // whatsApp number qc value
        String whatsAppQcValue = personDetailsQcvalue.get(1).getText();
        Assert.assertEquals(whatsAppQcValue, copiedWhatsAppNumber);
        // Landline number qc value
        String landlineQcValue = personDetailsQcvalue.get(2).getText();
        String landline_stdValue = copiedStdCode + "-" + copiedLandLineNo;
        Assert.assertEquals(landlineQcValue, landline_stdValue);
        // Category qc value
        String categoryQcValue = personDetailsQcvalue.get(3).getText();
        Assert.assertEquals(categoryQcValue, copiedSelectedCategory);

        // Caste qc value
        String casteQcValue = personDetailsQcvalue.get(4).getText();
        Assert.assertEquals(casteQcValue, copiedSelectedCaste);

        // Email qc value
        String emailQcValue = personDetailsQcvalue.get(5).getText();
        Assert.assertEquals(emailQcValue, copiedEmail);

        // Dob qc value
        String dobQcValue = personDetailsQcvalue.get(6).getText();
        Assert.assertEquals(dobQcValue, copiedDob);

        // Address qc value
        String addressQcvalue = personDetailsQcvalue.get(7).getText();
        Assert.assertEquals(addressQcvalue, copiedFullAddress);

        // Village qc value
        String villageQcValue = personDetailsQcvalue.get(8).getText();
        Assert.assertEquals(villageQcValue, copiedVillage);

        // Taluka Tehsil Qc Value
        String talukaQcValue = personDetailsQcvalue.get(9).getText();
        Assert.assertEquals(talukaQcValue, copiedTaluka_Tehsil);

        // Distrcit qc value
        String districtQcValue = personDetailsQcvalue.get(10).getText();
        Assert.assertEquals(districtQcValue, copiedSelectedDistrict);

        // Pincode qc value
        String pincodeQcValue = personDetailsQcvalue.get(11).getText();
        Assert.assertEquals(pincodeQcValue, CopiedpinCode);

        // Education qc value
        String educationQcValue = personDetailsQcvalue.get(12).getText();
        Assert.assertEquals(educationQcValue, copiedSelectedEducation);

        // Profession qc value
        String professionQcValue = personDetailsQcvalue.get(13).getText();
        Assert.assertEquals(professionQcValue, copiedSelectedProfession);

        // Bike qc value
        String bikeQcValue = personDetailsQcvalue.get(14).getText();
        Assert.assertEquals(bikeQcValue, copiedHasBike);

        // Car qc value
        String carQcValue = personDetailsQcvalue.get(15).getText();
        Assert.assertEquals(carQcValue, copiedHasCar);

        // Vidhan Sabha qc value
        String vidhansabhaQcValue = personDetailsQcvalue.get(16).getText();
        Assert.assertEquals(vidhansabhaQcValue, copied_vidhanSabha_where_he_sheVotes);

        // Booth qc value
        String boothQcValue = personDetailsQcvalue.get(17).getText();
        Assert.assertEquals(boothQcValue, copiedBothWhereHeSheVotes);

        // Voter Id qc value
        String voteridQcValue = personDetailsQcvalue.get(18).getText();
        Assert.assertEquals(voteridQcValue, copiedVoterId);

        // Aadhar qc value
        String aadharQcValue = personDetailsQcvalue.get(19).getText();
        Assert.assertEquals(aadharQcValue, copiedAadhaarNumber);

        // Salutation qc value
        String salutationQcValue = personDetailsQcvalue.get(20).getText();
        Assert.assertEquals(salutationQcValue, copiedSalutation);

        // Sub Caste qc value
        String subcasteQcValue = personDetailsQcvalue.get(21).getText();
        Assert.assertEquals(subcasteQcValue, copiedSubCaste);

        // Religion qc value
        String religionQcValue = personDetailsQcvalue.get(22).getText();
        Assert.assertEquals(religionQcValue, copiedReligion);

        // Active Member Id qc value
        String activeMemberIdQcValue = personDetailsQcvalue.get(23).getText();
        Assert.assertEquals(activeMemberIdQcValue, copiedActiveMemberId);

        // Party Zila qc value
        String partyZilaQcValue = personDetailsQcvalue.get(24).getText();
        Assert.assertEquals(partyZilaQcValue, copiedSelectedPartyZilaId);

        // Party Mandal qc value
        String partyMandalQcValue = personDetailsQcvalue.get(25).getText();
        Assert.assertEquals(partyMandalQcValue, copiedSelectedPartyMandalId);

    }

    @And("^user click on qc done button and verify qc status$")
    public void user_click_on_qc_done_button_and_verify_qc_status() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        js = (JavascriptExecutor) driver;
        WebElement qcDoneButtonEle = driver.findElement(By.xpath("//div/button[contains(.,'Done & QCed')]"));
        js.executeScript("arguments[0].click();", qcDoneButtonEle);
        Thread.sleep(3000);

        // verification of qc status
        // columns size
        List<WebElement> colms = driver.findElements(By.xpath("//table/thead/tr/th"));
        int lastColNum = colms.size();
        for (int col = 0; col < lastColNum; col++) {
            String columValue = colms.get(col).getText();
            if (columValue.contains("Phone Number")) {
                List<WebElement> phoneNumberRows = driver
                        .findElements(By.xpath("//table/tbody/tr/td[" + (col + 1) + "]"));
                int phoneNumberRowSize = phoneNumberRows.size();
                System.out.println("phoneNumberRowSize: " + phoneNumberRowSize);
                for (int phoneNumberRow = 0; phoneNumberRow < phoneNumberRowSize; phoneNumberRow++) {
                    System.out.println("phoneNumberRow:" + phoneNumberRow);
                    String phoneNumberValue = phoneNumberRows.get(phoneNumberRow).getText();
                    if (phoneNumberValue.contains(updatedPhoneNumber)) {
                        System.out.println("phoneNumberValue>>: " + phoneNumberValue);
                        String qcedStatusText = driver
                                .findElement(By.xpath(
                                        "//table/tbody/tr[" + (phoneNumberRow + 1) + "]/td[" + (lastColNum - 1) + "]"))
                                .getText();

                        Assert.assertEquals(qcedStatusText, "QCED");

                    }
                }
            }
        }

    }

    @And("^user verify data in qc edit flow$")
    public void user_verify_data_in_qc_edit_flow() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        js = (JavascriptExecutor) driver;
        user_scroll_to_view_data_table_and_search_for_data_which_need_to_qc();
        WebElement qcEditButton = driver.findElement(By.xpath("//button[contains(.,'QC Edit')]"));
        js.executeScript("arguments[0].click();", qcEditButton);
        // wait until edit qc form is visible
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@data-placeholder='Name']"))));

        // click on enter more details to extend form
        user_clicks_on_enter_more_details();
        Thread.sleep(2000);
        // get all the data from the update mode
        // Name
        copiedEnteredName = driver.findElement(By.xpath("//input[@placeholder='Name']")).getAttribute("value");
        Assert.assertEquals(copiedEnteredName.toUpperCase(), updatedName.toUpperCase());

        // Father's/Husband's Name
        copiedEnteredFather_Husband_Name = driver.findElement(By.xpath("//input[contains(@placeholder, 'Father')]"))
                .getAttribute("value");
        Assert.assertEquals(updatedFatherName.toUpperCase(), copiedEnteredFather_Husband_Name.toUpperCase());

        // Designation
        WebElement SelectDesignationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Designation')]"));
        copiedSelectedDesignation = driver.findElement(with(By.className("ng-value-label")).below(SelectDesignationEle))
                .getText();
        Assert.assertEquals(copiedSelectedDesignation, updatedDesignation);

        // Has SmartPhone
        WebElement hasSmartPhoneEle = driver.findElement(By.xpath("//div[contains(text(),'Has Smartphone')]"));
        copiedHasSmartPhone = driver.findElement(with(By.className("ng-value-label")).below(hasSmartPhoneEle))
                .getText();
        Assert.assertEquals(copiedHasSmartPhone, updatedHasSmartPhone);

        // Phone Number
        copiedPhoneNo = driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).getAttribute("value");
        Assert.assertEquals(copiedPhoneNo, updatedPhoneNumber);

        // Primary Member
        copiedPrimaryMember = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"))
                .getAttribute("value");
        Assert.assertEquals(copiedPrimaryMember, updatedPrimaryMemberId);

        // Age
        copiedAge = driver.findElement(By.xpath("//input[@placeholder='Age']")).getAttribute("value");
        Assert.assertEquals(copiedAge, updatedAge);
        int ageInt = Integer.parseInt(updatedAge);
        // Dob
        WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
        String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
        System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
        copiedDob = dobEle.getAttribute("value");
        Assert.assertEquals(day_and_month_updated_dob, copiedDob);

        // Blood Group
        WebElement BloodGroupEle = driver.findElement(By.xpath("//input[@data-placeholder='Blood Group']"));
        copiedBloodGroup = BloodGroupEle.getAttribute("value");
        Assert.assertEquals(copiedBloodGroup, updatedBloodGroup);
        // Gender
        String genderFormating = updatedGender.toLowerCase();
        if (genderFormating.equals("other")) {
            genderFormating = genderFormating + "s";
        }
        System.out.println("genderFormating :" + genderFormating);

        String classOfselectedGender = driver
                .findElement(By.xpath("//mat-radio-button[@value='" + genderFormating + "']")).getAttribute("class");
        System.out.println("classOfselectedGender :" + classOfselectedGender);
        Assert.assertEquals(classOfselectedGender.contains("mat-radio-checked"), true,
                "seems like gender is not selected");

        // WhatsApp
        copiedWhatsAppNumber = driver.findElement(By.xpath("//input[@placeholder='WhatsApp Number']"))
                .getAttribute("value");
        Assert.assertEquals(copiedWhatsAppNumber, updatedWhatsApp);

        // STD Code
        SangathanVariableDeclaration.setCopiedStdCode(FormControlKaryakarta.getEnteredSTDCode());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedStdCode(), SangathanVariableDeclaration.getUpdatedStdCode());

        // Landline Number
        SangathanVariableDeclaration.setCopiedLandlineNumber(FormControlKaryakarta.getEnteredLandlineNumber());
        Assert.assertEquals(SangathanVariableDeclaration.getCopiedLandlineNumber(), SangathanVariableDeclaration.getUpdatedLandlineNumber());

        // Select Category
        WebElement SelectCategoryEle = driver.findElement(By.xpath("//div[contains(text(),'Select Category')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", SelectCategoryEle);
        copiedSelectedCategory = driver
                .findElement(
                        with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectCategoryEle))
                .getText();
        Assert.assertEquals(copiedSelectedCategory, updatedCategory);

        // Caste
        WebElement SelectCasteEle = driver.findElement(By.xpath("//div[contains(text(),'Caste')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", SelectCasteEle);
        copiedSelectedCaste = driver
                .findElement(with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectCasteEle))
                .getText();
        Assert.assertEquals(copiedSelectedCaste, updatedCaste);

        // Email
        copiedEmail = driver.findElement(By.xpath("//input[@placeholder='Email']")).getAttribute("value");
        Assert.assertEquals(copiedEmail, updatedEmail);

        // Full Address
        copiedFullAddress = driver.findElement(By.xpath("//input[@placeholder='Full Address']")).getAttribute("value");
        Assert.assertEquals(copiedFullAddress, updatedFullAddress);

        // Village
        copiedVillage = driver.findElement(By.xpath("//input[@placeholder='Village/Ward']")).getAttribute("value");
        Assert.assertEquals(copiedVillage, updatedVillage);

        // Taluka/Tehsil
        copiedTaluka_Tehsil = driver.findElement(By.xpath("//input[contains(@placeholder, 'Taluka')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedTaluka_Tehsil, updatedTaluka);

        // select district
        WebElement SelectDistrictEle = driver.findElement(By.xpath("//div[contains(text(),'Select District')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", SelectDistrictEle);
        copiedSelectedDistrict = driver
                .findElement(
                        with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectDistrictEle))
                .getText();
        Assert.assertEquals(copiedSelectedDistrict, updatedDistrict);

        // Pin Code
        CopiedpinCode = driver.findElement(By.xpath("//input[@placeholder='Pin Code']")).getAttribute("value");
        Assert.assertEquals(CopiedpinCode, updatedPinCode);

        // Select Education
        WebElement SelectEducationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Education')]"));
        copiedSelectedEducation = driver
                .findElement(
                        with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectEducationEle))
                .getText();
        Assert.assertEquals(copiedSelectedEducation, updatedEducation);

        // Select Profession
        WebElement SelectProfessionEle = driver.findElement(By.xpath("//div[contains(text(),'Select Profession')]"));
        copiedSelectedProfession = driver
                .findElement(
                        with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectProfessionEle))
                .getText();
        Assert.assertEquals(copiedSelectedProfession, updatedProfession);

        // hasBike
        WebElement HasBikeEle = driver.findElement(By.xpath("//div[contains(text(),'Bike')]"));
        copiedHasBike = driver
                .findElement(with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(HasBikeEle))
                .getText();
        Assert.assertEquals(copiedHasBike, updatedBike);

        // hasCar
        WebElement HasCarEle = driver.findElement(By.xpath("//div[contains(text(),'Car')]"));
        copiedHasCar = driver
                .findElement(with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(HasCarEle))
                .getText();
        Assert.assertEquals(copiedHasCar, updatedCar);

        // vidhanSabha where he/she votes
        WebElement vidhanSabha_where_he_sheVotesEle = driver
                .findElement(By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]"));
        copied_vidhanSabha_where_he_sheVotes = driver
                .findElement(with(By.xpath("//span[@class='ng-value-label ng-star-inserted']"))
                        .below(vidhanSabha_where_he_sheVotesEle))
                .getText();

        // separating number and "-" from copied_vidhanSabha_where_he_sheVotes
        String[] vidhansabhaNameArr = copied_vidhanSabha_where_he_sheVotes.split("-");
        Assert.assertEquals(vidhansabhaNameArr[1].trim(), updatedVidhanSabhaWhereHeSheVotes);

        // Booth where He/She Votes
        copiedBothWhereHeSheVotes = driver
                .findElement(By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedBothWhereHeSheVotes, updatedBoothWhereHeSheVotes);

        // Voter Id
        copiedVoterId = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedVoterId, updatedVoterId);

        // Aadhaar Number
        copiedAadhaarNumber = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedAadhaarNumber, updatedAadharNumber);

        // Panna Number
        copiedPannaNumber = driver.findElement(By.xpath("//input[contains(@placeholder, 'Panna Number')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedPannaNumber, updatedPannaNumber);

        // Ration Card
        copiedRationCard = driver.findElement(By.xpath("//input[contains(@placeholder, 'Ration Card Number')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedRationCard, updatedRationCardNumber);

        // Facebook
        copiedFacebookValue = driver.findElement(By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedFacebookValue, updatedFacebookProfile);

        // TwitterProfile
        copiedTwitterProfile = driver
                .findElement(By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedTwitterProfile, updatedTwitterProfile);

        // InstagramProfile
        copiedInstagramProfile = driver
                .findElement(By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedInstagramProfile, updatedInstagramProfile);

        // LinkedInProfile
        copiedLinkedInProfile = driver
                .findElement(By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedLinkedInProfile, updatedLinkedinProfile);

        // Salutation
        copiedSalutation = driver.findElements(By.xpath("//mat-select")).get(1).getText();
        Assert.assertEquals(copiedSalutation, updatedSalutation);

        // Sub Caste
        copiedSubCaste = driver.findElement(By.xpath("//input[contains(@placeholder, 'Sub caste')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedSubCaste, updatedSubCaste);

        // Qualification
        copiedQualification = driver.findElement(By.xpath("//input[contains(@placeholder, 'Qualification')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedQualification, updatedQualification);

        // Religion
        copiedReligion = driver.findElements(By.xpath("//mat-select")).get(2).getText();
        Assert.assertEquals(copiedReligion, updatedReligion);

        // Active Member Id
        copiedActiveMemberId = driver.findElement(By.xpath("//input[contains(@placeholder, 'Active Member Id')]"))
                .getAttribute("value");
        Assert.assertEquals(copiedActiveMemberId, updatedActiveMemberId);

        // Select Party Zila Id
        WebElement SelectPartyZilaIdEle = driver
                .findElement(By.xpath("//div[contains(text(),'Select Party Zila Id')]"));
        copiedSelectedPartyZilaId = driver
                .findElement(
                        with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectPartyZilaIdEle))
                .getText();
        Assert.assertEquals(copiedSelectedPartyZilaId, updatedPartyZila);

        // Select Party Mandal
        WebElement SelectPartyMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
        copiedSelectedPartyMandalId = driver
                .findElement(
                        with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectPartyMandalEle))
                .getText();
        Assert.assertEquals(copiedSelectedPartyMandalId, updatedPartyMandal);

        ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
        Thread.sleep(2000);

        // click on update and mark qc button
        WebElement updateQCButtonEle = driver.findElement(By.xpath("//span[contains(.,'Update & Mark Qced')]"));
        js.executeScript("arguments[0].click();", updateQCButtonEle);

    }

    @And("^user edit all the data in qc edit flow$")
    public void user_edit_all_the_data_in_qc_edit_flow() {

    }

    // @And("^apply validation in phone number$")
    public void apply_validation_in_phone_number() throws InterruptedException {
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

    // @And("^apply validation in whatsApp number$")
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

    // @And("^apply validation in category and caste$")
    public void apply_validation_in_category_and_caste() throws InterruptedException {
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

    // @And("^apply validation in email$")
    public void  apply_validation_in_email() throws InterruptedException {
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

    // @And("^apply validation in aadhar number$")
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

    // @And("^apply validation in panna number$")
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

    public String dob_calculation_based_on_age_input(int age) {

        Calendar calendar = Calendar.getInstance(); // get calender or instance of current date and time
        calendar.add(Calendar.YEAR, -age); // decrease calender year by given age
        calendar.set(Calendar.DATE, 1); // set calender date by 1
        calendar.set(Calendar.MONTH, 0); // set calender month by 1 means january
        // below code for getting date in proper format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDOB = dateFormat.format(calendar.getTime());
        System.out.println(formattedDOB);
        return formattedDOB;

    }

    public String set_day_and_month_in_dob(int age) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -age);
        calendar.set(Calendar.DATE, 29);
        calendar.set(Calendar.MONTH, 4);
        // below code for getting date in proper format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String  setDOB = dateFormat.format(calendar.getTime());
        System.out.println(setDOB);
        return setDOB;

    }

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
                       // js.executeScript("arguments[0].scrollIntoView(true);", actionAllEle);
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

    public void verify_added_entry_in_karyakarta_dynamic_table(String phoneNumber) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        js = (JavascriptExecutor) driver;
        Thread.sleep(3000);

        // table column list
        List<WebElement> columnHeaderNames = driver.findElements(By.xpath("//table//thead/tr/th"));
        // table first row list
        List<WebElement> firstRowValueList = driver.findElements(By.xpath("//table//tbody/tr[1]/td"));
        for (int c = 1; c < columnHeaderNames.size(); c++) {
            String columnHeaderNamesText = columnHeaderNames.get(c).getText();
            System.out.println("columnHeaderNamesText: " + columnHeaderNamesText);
            if (columnHeaderNamesText.contains("Name")) {
                String nameTableValue = firstRowValueList.get(c).getText();
                System.out.println("nameTableValue: " + nameTableValue);
                Assert.assertEquals(nameTableValue, SangathanVariableDeclaration.getNameVariable());
            }
            if (columnHeaderNamesText.contains("Father's/Husband's Name")) {
                String relationTableValue = firstRowValueList.get(c).getText();
                System.out.println("nameTableValue: " + relationTableValue);
                Assert.assertEquals(relationTableValue, SangathanVariableDeclaration.getFatherNameVariable());
            }
            if (columnHeaderNamesText.contains("Designation")) {
                String designationTableValue = firstRowValueList.get(c).getText();
                System.out.println("nameTableValue: " + designationTableValue);
                Assert.assertEquals(designationTableValue, SangathanVariableDeclaration.getDesignationVariable());
            }
        }

    }

}
