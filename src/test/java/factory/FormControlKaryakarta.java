package factory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;
import utils.SangathanPageObjects;
import utils.RandomStringGenerationUtils;
import utils.SangathanVariableDeclaration;

public class FormControlKaryakarta {

    static WebDriver driver;
    static JavascriptExecutor js;
    static WebDriverWait wait, wait2;
    static NgWebDriver ngDriver;
    static ElementUtils elementUtils;
    static WaitUtils load_wait;

    static SangathanPageObjects sangathanPageObjects;

    public static void main(String[] args) throws InterruptedException {


    }

    public FormControlKaryakarta(WebDriver driver) {

        elementUtils = new ElementUtils(driver);
    }

    public static void enterName(String name) {

        driver = DriverFactory.getInstance().getDriver();

        // creating object for loading web page.
        load_wait = new WaitUtils();

        sangathanPageObjects = new SangathanPageObjects(driver);
        // Name WebElement....
        WebElement nameEle = sangathanPageObjects.getNameEle();
        nameEle.sendKeys(name);
    }

    public static void clearName() {
       WebElement nameEle = sangathanPageObjects.getNameEle();
       nameEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
    }

    public static String getEnteredName() {

        return sangathanPageObjects.getNameEle().getAttribute("value");

    }


    public static void enterRelationName(String relationName) {

        // Relation Name WebElement....
        WebElement relationNameEle = sangathanPageObjects.getFatherNameEle();
        relationNameEle.clear();
        relationNameEle.sendKeys(relationName);


    }

    public static String getEnteredRelationName() {

        return sangathanPageObjects.getFatherNameEle().getAttribute("value");

    }

    public static void clearRelationName() {
       WebElement fatherNameEle = sangathanPageObjects.getFatherNameEle();
       fatherNameEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
    }

    public static void clickOnDesignation() {

        // designation WebElement....
        WebElement designationEle = sangathanPageObjects.getDesignationClickEle();
        js = (JavascriptExecutor) driver;

        ExceptionHandler.clickElementWithRetry(designationEle);

        load_wait.waitForPageLoad();
        //elementUtils.clickOnElement(designationEle, 10);

    }

    public static void selectDesignation(String designation) {

        // designation value WebElement....
        WebElement selectDesignationNameEle = sangathanPageObjects.getDesignationValueEle(designation);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectDesignationNameEle);

    }

    public static void clearDesignation() {

        WebElement clearDesignationEle = sangathanPageObjects.getClearDesignationEle();
        ExceptionHandler.clickElementWithRetry(clearDesignationEle);
    }

    public static String getSelectedDesignation() {

        return sangathanPageObjects.getSelectedDesignationEle().getText();

    }

    public static void clickOnHasSmartPhone() {

        // has smart phone WebElement....
        WebElement hasSmartPhone = sangathanPageObjects.getHasSmartPhoneClickEle();
        js = (JavascriptExecutor) driver;
        ExceptionHandler.clickElementWithRetry(hasSmartPhone);
        load_wait.waitForPageLoad();

    }

    public static void selectHasSmartPhone(String hasSmartPhone) {

        // has smart phone value WebElement....
        WebElement HasSmartPhoneValueEle = sangathanPageObjects.getHasSmartPhoneValueEle(hasSmartPhone);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", HasSmartPhoneValueEle);

    }

    public static String getSelectedHasSmartPhone() {

        return sangathanPageObjects.getSelectedHasSmartPhoneEle().getText();

    }

    public static void enterPrimaryMemberId(String primaryMemberId) {
        // primary member id webElement...
        WebElement PrimaryMemberIdEle = sangathanPageObjects.getPrimaryMemberIdEle();
        PrimaryMemberIdEle.sendKeys(primaryMemberId);

    }

    public static void clearPrimaryMemberId() {
        WebElement clearPrimaryMemberId = sangathanPageObjects.getPrimaryMemberIdEle();
        clearPrimaryMemberId.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
    }

    public static String getEnteredPrimaryMemberId() {

        return sangathanPageObjects.getPrimaryMemberIdEle().getAttribute("value");

    }

    public static void enterAge(String age) {

        // age WebElement....
        WebElement AgeEle = sangathanPageObjects.getAgeEle();
        AgeEle.sendKeys(age);
    }

    public static void clearAge() {
        WebElement clearAge = sangathanPageObjects.getAgeEle();
        clearAge.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
    }

    public static String getEnteredAge() {

        return sangathanPageObjects.getAgeEle().getAttribute("value");

    }


    public static void enterDob(String dob) {

        // dob WebElement....
        WebElement dobEle = sangathanPageObjects.getDOBEle();
        dobEle.sendKeys(dob);

    }

    public static String getEnteredDob() {

        // get karyakarta dob......
        return sangathanPageObjects.getDOBEle().getAttribute("value");


    }

    public static void enterBloodGroup(String bloodGroup) {

        // blood group WebElement....
        WebElement BloodGroupEle = sangathanPageObjects.getbloodGroupEle();
        BloodGroupEle.sendKeys(bloodGroup);

    }

    public static void clearBloodGroup() {
        WebElement clearBloodGroup = sangathanPageObjects.getbloodGroupEle();
        clearBloodGroup.clear();
    }

    public static String getEnteredBloodGroup() {


        return sangathanPageObjects.getbloodGroupEle().getAttribute("value");

    }

    public static void enterPhoneNumber(String phoneNumber) {

        // phone number WebElement....
        // Phone Number
        WebElement PhoneNumberEle = sangathanPageObjects.getPhoneEle();
        if (phoneNumber == null) {
            SangathanVariableDeclaration.setPhoneNumberVariableValue(RandomStringGenerationUtils.generatePhoneNumber());
            PhoneNumberEle.sendKeys(SangathanVariableDeclaration.getPhoneNumberVariable());
        } else {
            PhoneNumberEle.sendKeys(phoneNumber);
        }


    }

    public static String getEnteredPhoneNumber() {

        return sangathanPageObjects.getPhoneEle().getAttribute("value");

    }
    public static void clearPhoneNumber(){
        WebElement phoneEle = sangathanPageObjects.getPhoneEle();
        phoneEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
    }

    public static void clickOnEnterMoreDetailsButton() {

        WebElement extraDetailsClickEle = sangathanPageObjects.getExtraDetailsEle();
        ExceptionHandler.clickElementWithRetry(extraDetailsClickEle);

    }

    public static void enterEmail(String email) {

        WebElement emailEle = sangathanPageObjects.getEmailEle();
        emailEle.sendKeys(email);

    }

    public static void clearEmail() {
        WebElement clearEmail = sangathanPageObjects.getEmailEle();
        clearEmail.clear();
    }

    public static String getEnteredEmail() {

        return sangathanPageObjects.getEmailEle().getAttribute("value");

    }

    public static void selectGender(String gender) throws InterruptedException {

        String selectGender;
        if (gender.equals("Male") || gender.equals("Female")) {
            selectGender = gender.toLowerCase();
        } else {
            // make Other to others
            selectGender = gender.toLowerCase() + "s";
        }
        WebElement genderEle = driver.findElement(By.xpath("//input[@value='" + selectGender + "']"));
        WebElement genderLevelTxt = driver.findElement(By.xpath("//label[contains(text(),'Gender')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", genderLevelTxt);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", genderEle);


    }

    public static String getSelectedGender(String fetchedGenderValue) {
        fetchedGenderValue = SangathanVariableDeclaration.getGenderVariable().toLowerCase();
        if (fetchedGenderValue.equals("other")) {
            fetchedGenderValue = fetchedGenderValue + "s";
        }

        return sangathanPageObjects.getSelectedGenderValueEle(fetchedGenderValue).getAttribute("class");

    }

    public static void enterWhatsAppNumber(String whatsAppNumber) {

        WebElement whatsAppNumberEle = sangathanPageObjects.getWhatsAppNumber();
        whatsAppNumberEle.sendKeys(whatsAppNumber);
    }

    public static void clearWhatsAppNumber() {
        WebElement clearWhatsAppNumberEle = sangathanPageObjects.getWhatsAppNumber();
        clearWhatsAppNumberEle.clear();
    }

    public static String getEnteredWhatsAppNumber() {

        return sangathanPageObjects.getWhatsAppNumber().getAttribute("value");

    }

    public static void enterKaryakartaDOB() {
        WebElement dobEle = sangathanPageObjects.getDOBEle();
        dobEle.sendKeys();

    }


    public static void enterSTDCode(String stdCode) {
        WebElement stdCodeEle = sangathanPageObjects.getSTDCodeEle();
        stdCodeEle.sendKeys(stdCode);

    }

    public static void clearSTDCode() {
        WebElement clearSTDCodeEle = sangathanPageObjects.getSTDCodeEle();
        clearSTDCodeEle.clear();
    }

    public static void scrollToViewSTDCode() {

        js.executeScript("arguments[0].scrollIntoView(true);", sangathanPageObjects.getSTDCodeEle());
    }

    public static String getEnteredSTDCode() {
        return sangathanPageObjects.getSTDCodeEle().getAttribute("value");
    }

    public static void enterLandlineNumber(String landlineNumber) {
        WebElement landlineEle = sangathanPageObjects.getLandlineEle();
        landlineEle.sendKeys(landlineNumber);

    }

    public static void clearLandlineNumber() {
        WebElement clearLandlineNumber = sangathanPageObjects.getLandlineEle();
        clearLandlineNumber.clear();
    }

    public static String getEnteredLandlineNumber() {
        return sangathanPageObjects.getLandlineEle().getAttribute("value");
    }

    public static void clickOnCategory() {
        WebElement selectCategoryEle = sangathanPageObjects.getSelectCategoryEle();
        ExceptionHandler.clickElementWithRetry(selectCategoryEle);
        load_wait.waitForPageLoad();
    }

    public static void selectCategory(String category) {

        WebElement selectCategoryNameEle = sangathanPageObjects.getCategoryValueEle(category);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectCategoryNameEle);


    }

    public static void clearCategory() {
        WebElement clearCategoryEle = sangathanPageObjects.getClearCategoryEle();
        clearCategoryEle.click();
    }

    public static void getSelectedCategory() {

    }

    public static void clickOnCaste() {

        WebElement selectCasteEle = sangathanPageObjects.getSelectCasteEle();
        ExceptionHandler.clickElementWithRetry(selectCasteEle);
        load_wait.waitForPageLoad();


    }

    public static void selectCaste(String caste) {

        WebElement selectCasteValueEle = sangathanPageObjects.getCasteValueEle(caste);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectCasteValueEle);

    }

    public static void getSelectedCaste() {


    }


    public static void enterFullAddress(String fullAddress) {
        WebElement fullAddressEle = sangathanPageObjects.getFullAddressEle();
        fullAddressEle.clear();
        fullAddressEle.sendKeys(fullAddress);
    }

    public static void clearFullAddress() {
        WebElement clearFullAddressEle = sangathanPageObjects.getFullAddressEle();
        clearFullAddressEle.click();

    }

    public static String getEnteredFullAddress() {
        return sangathanPageObjects.getFullAddressEle().getAttribute("value");
    }

    public static void enterVillage(String village) {
        WebElement villageEle = sangathanPageObjects.getVillageEle();
        villageEle.sendKeys(village);

    }

    public static void clearVillage() {
        WebElement clearVillageEle = sangathanPageObjects.getVillageEle();
        clearVillageEle.clear();
    }

    public static String getEnteredVillage() {
        return sangathanPageObjects.getVillageEle().getAttribute("value");
    }

    public static void enterTaluka(String taluka) {
        WebElement talukaEle = sangathanPageObjects.getTaluka_Tehsil_Ele();
        talukaEle.sendKeys(taluka);
    }

    public static void clearTaluka() {
        WebElement clearTalukaEle = sangathanPageObjects.getTaluka_Tehsil_Ele();
        clearTalukaEle.clear();

    }

    public static String getEnteredTaluka() {
        return sangathanPageObjects.getTaluka_Tehsil_Ele().getAttribute("value");
    }

    public static void clickOnDistrict() {
        WebElement clickDistrictEle = sangathanPageObjects.getSelectDistrictEle();
        ExceptionHandler.clickElementWithRetry(clickDistrictEle);
        load_wait.waitForPageLoad();
    }

    public static void selectDistrict(String district) {
        sangathanPageObjects.enterTextInDistrict().sendKeys(district);
        WebElement selectDistrictEle = sangathanPageObjects.getDistrictValueEle(district);
        ExceptionHandler.clickElementWithRetry(selectDistrictEle);
    }

    public static void clearDistrict() {
        WebElement clearDistrictEle = sangathanPageObjects.getClearDistrictEle();
        clearDistrictEle.click();

    }

    public static void getSelectedDistrict() {

    }

    public static void enterPinCode(String pinCode) {

        WebElement pincodeEle = sangathanPageObjects.getPincodeEle();
        pincodeEle.sendKeys(pinCode);
    }

    public static void clearPinCode() {
        WebElement clearPinCodeEle = sangathanPageObjects.getPincodeEle();
        clearPinCodeEle.clear();
    }

    public static String getEnteredPinCode() {
        return sangathanPageObjects.getPincodeEle().getAttribute("value");
    }

    public static void clickOnEducation() {

        WebElement selectEducationEle = sangathanPageObjects.getSelectEducationEle();
        ExceptionHandler.clickElementWithRetry(selectEducationEle);
        load_wait.waitForPageLoad();

    }

    public static void selectEducation(String education) {

        WebElement EducationValueEle = sangathanPageObjects.getEducationValueEle(education);
        js.executeScript("arguments[0].click();", EducationValueEle);
        load_wait.waitForPageLoad();


    }

    public static void clearEducation() {
        WebElement clearEducationEle = sangathanPageObjects.getClearEducationEle();
        clearEducationEle.click();

    }

    public static void getSelectedEducation() {

    }

    public static void clickOnProfession() {

        WebElement selectProfessionEle = sangathanPageObjects.getSelectProfessionEle();
        ExceptionHandler.clickElementWithRetry(selectProfessionEle);
        load_wait.waitForPageLoad();

    }

    public static void selectProfession(String profession) {

        WebElement ProfessionValueEle = sangathanPageObjects.getProfessionValueEle(profession);
        js.executeScript("arguments[0].click();", ProfessionValueEle);
        load_wait.waitForPageLoad();

    }

    public static void clearProfession() {
        WebElement clearProfessionEle = sangathanPageObjects.getClearProfessionEle();
        clearProfessionEle.click();
    }

    public static void getSelectedProfession() {

    }

    public static void clickOnHasBike() {

        WebElement BikeEle = sangathanPageObjects.getSelectBikeEle();
        BikeEle.click();

    }

    public static void selectHasBike(String bike) {


        WebElement bikeValueEle = null;
        // Select yes or no for bike
        if (bike.equals("Yes")) {
            bikeValueEle = driver.findElements(By.className("ng-option-label")).get(0);
        } else {
            bikeValueEle = driver.findElements(By.className("ng-option-label")).get(1);
        }
        js.executeScript("arguments[0].click();", bikeValueEle);
        load_wait.waitForPageLoad();

    }

    public static void clearBike() {
        WebElement clearBikeEle = sangathanPageObjects.getClearBikeEle();
        clearBikeEle.click();
    }

    public static void getSelectedBike() {

    }

    public static void clickOnHasCar() {

        WebElement CarEle = sangathanPageObjects.getSelectCarEle();
        CarEle.click();

    }

    public static void selectHasCar(String car) {

        WebElement carValueEle = null;
        if (car.equals("Yes")) {
            carValueEle = driver.findElements(By.className("ng-option-label")).get(0);
        } else {
            carValueEle = driver.findElements(By.className("ng-option-label")).get(1);
        }
        js.executeScript("arguments[0].click();", carValueEle);
        load_wait.waitForPageLoad();

    }

    public static void clearHasCar() {
        WebElement clearHasCarEle = sangathanPageObjects.getClearCarEle();
        clearHasCarEle.click();
    }

    public static void getSelectedCar() {

    }

    public static void clickOnVidhanSabhaHeSheVotes() {

        WebElement VidhanSabhawhereHe_SheVotesEle = sangathanPageObjects.getSelectVidhanSabhaWhereHeSheVotesEle();
        ExceptionHandler.clickElementWithRetry(VidhanSabhawhereHe_SheVotesEle);
        load_wait.waitForPageLoad();

    }

    public static void selectVidhanSabhaHeSheVotes(String vidhanSabha) {

        WebElement VidhanSabhawhereHe_SheVotesValueEle = sangathanPageObjects.getVidhanSabhaWhereHeSheVotesValueEle(vidhanSabha);
        js.executeScript("arguments[0].click();", VidhanSabhawhereHe_SheVotesValueEle);
        load_wait.waitForPageLoad();

    }

    public static void clearVidhanSabhaWhereHeSheVotes() {
        WebElement clearVidhanSabhaWhereHeSheVotesEle = sangathanPageObjects.getClearVidhanSabhaWhereHeSheVotesEle();
        clearVidhanSabhaWhereHeSheVotesEle.click();
    }

    public static void selectedVidhanSabhaWhereHeSheVotes() {


    }

    public static void enterBoothWhereHeSheVotes(String boothWhereHeSheVotes) {

        WebElement BoothwhereHe_SheVotesValueEle = sangathanPageObjects.getBoothWhereHeSheVotesEle();
        BoothwhereHe_SheVotesValueEle.clear();
        BoothwhereHe_SheVotesValueEle.sendKeys(boothWhereHeSheVotes);

    }

    public static void clearBoothWhereHeSheVotes() {
        WebElement clearBoothWhereHe_SheVotesEle = sangathanPageObjects.getBoothWhereHeSheVotesEle();
        clearBoothWhereHe_SheVotesEle.clear();
    }

    public static String getEnteredBoothWhereHeSheVotes() {
        return sangathanPageObjects.getBoothWhereHeSheVotesEle().getAttribute("value");
    }

    public static void enterVoterId(String voterId) {

        WebElement voterIdValueEle = sangathanPageObjects.getVoterIDEle();
        voterIdValueEle.sendKeys(voterId);

    }

    public static void clearVoterId() {
        WebElement clearVoterIdEle = sangathanPageObjects.getVoterIDEle();
        clearVoterIdEle.clear();
    }

    public static String getEnteredVoterId() {
        return sangathanPageObjects.getVoterIDEle().getAttribute("value");
    }

    public static void enterAadharNumber(String aadharNumber) {

        //Aadhar Number WebElement..
        WebElement AadhaarNumberEle = sangathanPageObjects.getAadharNumberEle();
        AadhaarNumberEle.clear();
        AadhaarNumberEle.sendKeys(aadharNumber);

    }

    public static void clearAadharNumber() {
        WebElement clearAadhaarNumberEle = sangathanPageObjects.getAadharNumberEle();
        clearAadhaarNumberEle.clear();
    }

    public static String getEnteredAadharNumber() {
        return sangathanPageObjects.getAadharNumberEle().getAttribute("value");
    }

    public static void enterPannaNumber(String pannaNumber) {

        WebElement PannaNumberEle = sangathanPageObjects.getPannaNumberEle();
        PannaNumberEle.clear();
        PannaNumberEle.sendKeys(pannaNumber);


    }

    public static void clearPannaNumber() {
        WebElement clearPannaNumberEle = sangathanPageObjects.getPannaNumberEle();
        clearPannaNumberEle.clear();
    }

    public static String getEnteredPannaNumber() {
        return sangathanPageObjects.getPannaNumberEle().getAttribute("value");
    }

    public static void enterRationCardNumber(String rationCardNumber) {

        WebElement RationCardNumberEle = sangathanPageObjects.getRationCardNumber();
        RationCardNumberEle.sendKeys(rationCardNumber);

    }

    public static void clearRationCardNumber() {
        WebElement clearRationCardNumberEle = sangathanPageObjects.getRationCardNumber();
        clearRationCardNumberEle.clear();
    }

    public static String getEnteredRationCardNumber() {
        return sangathanPageObjects.getRationCardNumber().getAttribute("value");
    }

    public static void enterFacebookProfile(String facebookProfile) {

        WebElement FacebookProfileEle = sangathanPageObjects.getFacebookProfileEle();
        FacebookProfileEle.sendKeys(facebookProfile);
    }

    public static void clearFacebookProfile() {
        WebElement clearFacebookProfileEle = sangathanPageObjects.getFacebookProfileEle();
        clearFacebookProfileEle.clear();
    }

    public static String getEnteredFacebookProfile() {

        return sangathanPageObjects.getFacebookProfileEle().getAttribute("value");
    }

    public static void enterTwitterProfile(String twitterProfile) {

        WebElement TwitterProfileEle = sangathanPageObjects.getTwitterProfileEle();
        TwitterProfileEle.sendKeys(twitterProfile);

    }

    public static void clearTwitterProfile() {
        WebElement clearTwitterProfileEle = sangathanPageObjects.getTwitterProfileEle();
        clearTwitterProfileEle.clear();
    }

    public static String getEnteredTwitterProfile() {
        return sangathanPageObjects.getTwitterProfileEle().getAttribute("value");
    }

    public static void enterInstagramProfile(String instagramProfile) {

        WebElement InstagramProfileEle = sangathanPageObjects.getInstagramProfileEle();
        InstagramProfileEle.sendKeys(instagramProfile);

    }

    public static void clearInstagramProfile() {
        WebElement clearInstagramProfileEle = sangathanPageObjects.getInstagramProfileEle();
        clearInstagramProfileEle.clear();
    }

    public static String getEnteredInstagramProfile() {
        return sangathanPageObjects.getInstagramProfileEle().getAttribute("value");
    }

    public static void enterLinkedinProfile(String linkedinProfile) {

        WebElement LinkedInProfileEle = sangathanPageObjects.getLinkedinProfileEle();
        LinkedInProfileEle.sendKeys(linkedinProfile);

    }

    public static void clearLinkedinProfile() {
        WebElement clearLinkedInProfileEle = sangathanPageObjects.getLinkedinProfileEle();
        clearLinkedInProfileEle.clear();
    }

    public static String getEnteredLinkedinProfile() {
        return sangathanPageObjects.getLinkedinProfileEle().getAttribute("value");
    }

    public static void uploadImage(String image) {

        WebElement photoEle = sangathanPageObjects.getPhotoEle();
        photoEle.sendKeys(image);


    }

    public static void clickOnSalutation() {

        WebElement SalutationEle = sangathanPageObjects.getSelectSalutationEle().get(1);
        ExceptionHandler.clickElementWithRetry(SalutationEle);
        load_wait.waitForPageLoad();

    }

    public static void selectSalutation(String salutation) {

        WebElement salutationValueEle = sangathanPageObjects.getSalutationValueEle(salutation);
        js.executeScript("arguments[0].click();", salutationValueEle);

    }

    public static void getSelectedSalutation() {

    }

    public static void enterSubCaste(String subCaste) {

        WebElement SubCasteEle = sangathanPageObjects.getSubCasteEle();
        SubCasteEle.sendKeys(subCaste);

    }

    public static void clearSubCaste() {
        WebElement clearSubCaste = sangathanPageObjects.getSubCasteEle();
        clearSubCaste.clear();
    }

    public static String getEnteredSubCaste() {
        return sangathanPageObjects.getSubCasteEle().getAttribute("value");
    }

    public static void enterQualification(String qualification) {

        WebElement QualificationEle = sangathanPageObjects.getQualificationEle();
        QualificationEle.sendKeys(qualification);

    }

    public static void clearQualification() {
        WebElement clearQualificationEle = sangathanPageObjects.getQualificationEle();
        clearQualificationEle.clear();
    }

    public static String getEnteredQualification() {
        return sangathanPageObjects.getQualificationEle().getAttribute("value");
    }

    public static void clickOnReligion() {

        WebElement ReligionEle = sangathanPageObjects.getReligionEle().get(2);
        ExceptionHandler.clickElementWithRetry(ReligionEle);
        load_wait.waitForPageLoad();


    }

    public static void selectReligion(String religion) {

        WebElement ReligionEleValueEle = sangathanPageObjects.getReligionValueEle(religion);
        js.executeScript("arguments[0].click();", ReligionEleValueEle);

    }

    public static String getSelectedReligion() {
        return sangathanPageObjects.getReligionEle().get(2).getAttribute("value");
    }

    public static void enterActiveMemberId(String activeMemberId) {

        WebElement ActiveMemberIdValueEle = sangathanPageObjects.getActiveMemberIDEle();
        ActiveMemberIdValueEle.sendKeys(activeMemberId);

    }

    public static void clearActiveMemberId() {
        WebElement clearActiveMemberEle = sangathanPageObjects.getActiveMemberIDEle();
        clearActiveMemberEle.clear();
    }

    public static String getEnteredActiveMemberId() {

        return sangathanPageObjects.getActiveMemberIDEle().getAttribute("value");
    }

    public static void clickOnPartyZila() {

        WebElement selectPartyZilaEle = sangathanPageObjects.getSelectPartyZilaEle();
        ExceptionHandler.clickElementWithRetry(selectPartyZilaEle);
        load_wait.waitForPageLoad();


    }

    public static void selectPartyZila(String partyZila) {
        WebElement selectPartyZilaValueEle = sangathanPageObjects.getPartyZilaValueEle(partyZila);
        js.executeScript("arguments[0].click();", selectPartyZilaValueEle);
    }

    public static void clearPartyZila() {
        WebElement clearPartyZilaEle = sangathanPageObjects.getClearPartyZilaEle();
        clearPartyZilaEle.click();

    }

    public static String getSelectedPartyZila() {

        return sangathanPageObjects.getSelectedPartyZilaValueEle().getText();

    }

    public static void clickOnPartyMandal() {
        WebElement selectPartyMandalEle = sangathanPageObjects.getSelectPartyMandalEle();
        ExceptionHandler.clickElementWithRetry(selectPartyMandalEle);
        load_wait.waitForPageLoad();

    }

    public static void selectPartyMandal(String partyMandal) {
        WebElement selectPartyMandalValueEle = sangathanPageObjects.getSelectPartyMandalValueEle(partyMandal);
        js.executeScript("arguments[0].click();", selectPartyMandalValueEle);

    }

    public static void clearPartyMandal() {
        WebElement clearPartyMandalEle = sangathanPageObjects.getClearPartyMandalEle();
        clearPartyMandalEle.click();

    }

    public static String getSelectedPartyMandal() {

        return sangathanPageObjects.getSelectedPartyMandalValueEle().getText();

    }

    public static void clickOnAddEntryButton() {
        WebElement addButtonEle = sangathanPageObjects.getAddButtonEle();
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButtonEle);
    }

    public static String getTextFromDataEntryDialogue() {
        return sangathanPageObjects.getTextInDialogueEle().getText();
    }

    public static void clickOnCancelButtonInDataEntryDialogue() {

        js.executeScript("arguments[0].click();", sangathanPageObjects.getCancelDialogButtonEle());

    }
    public static void clickOnCancelButtonEle(){
        js.executeScript("arguments[0].click();", sangathanPageObjects.getCancelButtonEle());
    }

    public static void  scrollToViewDynamicTable(){
        js.executeScript("arguments[0].scrollIntoView(true);", sangathanPageObjects.getData_EntryDynamicTableEle());
    }


}
