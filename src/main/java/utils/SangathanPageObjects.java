
package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SangathanPageObjects {

    WebDriver driver;

//    public WardPageObject(WebDriver driver) {
//        driver = this.driver;
//    }

    By SangathanDataEntryEle = By.className("data-entry-card-titles");

    By karyakartaDataLevelText = By.xpath("//mat-card-content//div/h5");

    By searchButton = By.xpath("//button[@color='primary']/child::span[contains(text(),'Search')]");

    By extraDetails = By.xpath("//mat-panel-title");

    By nameEle = By.xpath("//input[@placeholder='Name']");

    By designationClick = By.xpath("//div[contains(text(),'Select Designation')]");

    By designaionClearClickEle = By.xpath("//ng-select[@dropdownposition='bottom']//span[@title='Clear all']");

    By selectedDropdownListEle = By.className("ng-value-label");

    By hasSmartPhoneClick = By.xpath("//div[contains(text(),'Has Smartphone')]");

    By ageEle = By.xpath("//input[@placeholder='Age']");

    By dobEle = By.xpath("//input[@data-placeholder='Dob']");

    By bloodGroupEle = By.xpath("//input[@data-placeholder='Blood Group']");
    By fatherNameEle = By.xpath("//input[contains(@placeholder, 'Father')]");

    By phoneEle = By.xpath("//input[@placeholder='Phone Number']");

    By primaryMemberIdEle = By.xpath("//input[@placeholder='Primary Member Id']");

    By stdCodeEle = By.xpath("//input[@placeholder='STD Code']");


    By whatsAppEle = By.xpath("//input[@placeholder='WhatsApp Number']");

    By landlineNumberEle = By.xpath("//input[@placeholder='Landline Number']");

    By selectCategoryEle = By.xpath("//div[contains(text(),'Select Category')]");

    By clearDropdownEle = By.xpath("//span[@title='Clear all']");

    By selectCasteEle = By.xpath("//div[contains(text(),'Caste')]");

    By casteToolTilEle = By.xpath("//*[@class='mat-tooltip mat-tooltip-show']");

    By emailEle = By.xpath("//input[@placeholder='Email']");

    By fullAddressEle = By.xpath("//input[@placeholder='Full Address']");

    By villageEle = By.xpath("//input[@placeholder='Village/Ward']");

    By talukaEle = By.xpath("//input[contains(@placeholder, 'Taluka')]");
    By selectDistrictEle = By.xpath("//div[contains(text(),'Select District')]");

    By inputDropdownEle = By.tagName("input");

    By pincodeEle = By.xpath("//input[@placeholder='Pin Code']");

    By selectEducationEle = By.xpath("//div[contains(text(),'Select Education')]");

    By selectProfessionEle = By.xpath("//div[contains(text(),'Select Profession')]");
    By selectBikeEle = By.xpath("//div[contains(text(),'Bike')]");

    By dropdownOptionsEle = By.className("ng-option-label");

    By selectCarEle = By.xpath("//div[contains(text(),'Car')]");

    By selectVidhanSabhaWhereHeSheVotes = By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]");

    By boothWhereHeSheVotes = By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]");

    By voterIDEle = By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]");

    By aadharNumberEle = By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]");

    By pannaNumberEle = By.xpath("//input[contains(@placeholder, 'Panna Number')]");

    By rationCardNumberEle = By.xpath("//input[contains(@placeholder, 'Ration Card Number')]");

    By facebookProfileEle = By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]");

    By twitterProfileEle = By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]");

    By instagramProfileEle = By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]");

    By linkedinProfileEle = By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]");

    By photoEle = By.xpath("//input[@type='file']");

    By salutationEle = By.xpath("//mat-select");

    By subCasteEle = By.xpath("//input[contains(@placeholder, 'Sub caste')]");

    By qualificationEle = By.xpath("//input[contains(@placeholder, 'Qualification')]");

    By religionEle = By.xpath("//mat-select");

    By activeMemberIDEle = By.xpath("//input[contains(@placeholder, 'Active Member Id')]");

    By selectPartyZilaEle = By.xpath("//div[contains(text(),'Select Party Zila')]");

    By selectOptionsValueEle = By .className("ng-value-label");

    By selectPartyMandalEle = By.xpath("//div[contains(text(),'Select Party Mandal')]");
    By pop_upEle = By.className("mat-simple-snack-bar-content");
    By data_entry_dialogue_ele = By.xpath("//mat-dialog-container");

    By textInDialogueEle = By.xpath("//mat-dialog-container//div[@class='mat-dialog-title']");

    By cancelDialogButtonEle = By.xpath("//span[contains(.,'Cancel')]");

    By data_entryDynamicTableEle = By.xpath("//table");

    By addButtonEle = By.xpath("//button[@type='submit']");

    By cancelButtonEle = By.xpath("//span[contains(.,'Cancel')]");

    public SangathanPageObjects(WebDriver driver) {

        this.driver = driver;

    }

    public List<WebElement> getSangathanDataEntryEle() {
        return driver.findElements(SangathanDataEntryEle);
    }

    public List<WebElement> getKaryakartaDataLevelText() {
        return driver.findElements(karyakartaDataLevelText);
    }

    public WebElement getSearchButtonEle() {
        return driver.findElement(searchButton);
    }

    public WebElement getExtraDetailsEle() {
        return driver.findElement(extraDetails);
    }

    public WebElement getNameEle() {
        return driver.findElement(nameEle);
    }

    public WebElement getFatherNameEle() {
        return driver.findElement(fatherNameEle);
    }

    public WebElement getDesignationClickEle() {
        return driver.findElement(designationClick);
    }

    public WebElement getDesignationValueEle(String designationName) {
        return driver.findElement(By.xpath("//div//span[contains(text(),'" + designationName + "')]"));
    }
    public WebElement getSelectedDesignationEle(){
        return driver.findElement(with(selectedDropdownListEle).below(designationClick));
    }

    public WebElement getHasSmartPhoneClickEle() {
        return driver.findElement(hasSmartPhoneClick);
    }

    public WebElement getHasSmartPhoneValueEle(String hasSmartPhoneValue) {
        return driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted' and text() = '" + hasSmartPhoneValue + "']"));
    }

    public WebElement getSelectedHasSmartPhoneEle(){
        return driver.findElement(with(selectedDropdownListEle).below(hasSmartPhoneClick));
    }

    public WebElement getAgeEle() {
        return driver.findElement(ageEle);
    }

    public WebElement getDOBEle() {
        return driver.findElement(dobEle);
    }

    public WebElement getbloodGroupEle() {
        return driver.findElement(bloodGroupEle);
    }

    public WebElement getPhoneEle() {
        return driver.findElement(phoneEle);
    }

    public WebElement getPrimaryMemberIdEle(){
        return driver.findElement(primaryMemberIdEle);
    }

    public WebElement getWhatsAppNumber() {
        return driver.findElement(whatsAppEle);
    }

    public WebElement getSTDCodeEle() {
        return driver.findElement(stdCodeEle);
    }

    public WebElement getLandlineEle() {
        return driver.findElement(landlineNumberEle);
    }

    public WebElement getSelectedGenderValueEle(String selectedGenderValue){
        return driver.findElement(By.xpath("//mat-radio-button[@value='" + selectedGenderValue + "']"));
    }

    public WebElement getSelectCategoryEle() {
        return driver.findElement(selectCategoryEle);
    }

    public WebElement getClearCategoryEle(){
        return driver.findElement(with(clearDropdownEle).toRightOf(selectCategoryEle));
    }

    public WebElement getClearDesignationEle(){

        //return driver.findElement(with(clearDropdownEle).toRightOf(designationClick));
        return driver.findElement(designaionClearClickEle);
    }

    public WebElement getSelectCasteEle() {
        return driver.findElement(selectCasteEle);
    }

    public WebElement getCasteToolTipTextEle() {
        return driver.findElement(casteToolTilEle);
    }

    public WebElement getCategoryValueEle(String categoryName) {
        return driver.findElement(By.xpath("//div//span[contains(text(),'" + categoryName + "')]"));
    }

    public WebElement getCasteValueEle(String casteName) {
        return driver.findElement(By.xpath("//div//span[contains(text(),'" + casteName + "')]"));
    }

    public WebElement getEmailEle() {
        return driver.findElement(emailEle);
    }

    public WebElement getFullAddressEle() {
        return driver.findElement(fullAddressEle);
    }

    public WebElement getVillageEle() {
        return driver.findElement(villageEle);
    }

    public WebElement getTaluka_Tehsil_Ele() {
        return driver.findElement(talukaEle);
    }

    public WebElement getSelectDistrictEle() {
        return driver.findElement(selectDistrictEle);
    }

    public WebElement getDistrictValueEle(String districtName) {
        return driver.findElement(By.xpath("//div//span[contains(text(),'" + districtName + "')]"));
    }
    public WebElement getClearDistrictEle(){
        return driver.findElement(with(clearDropdownEle).toRightOf(selectDistrictEle));
    }
    public WebElement enterTextInDistrict(){
       return driver.findElement(with(inputDropdownEle).below(selectDistrictEle));
    }

    public WebElement getPincodeEle() {
        return driver.findElement(pincodeEle);
    }

    public WebElement getSelectEducationEle() {
        return driver.findElement(selectEducationEle);
    }
    public WebElement getEducationValueEle(String educationName) {
        return driver.findElement(By.xpath("//div//span[contains(text(),'" + educationName + "')]"));
    }
    public WebElement getClearEducationEle(){
        return driver.findElement(with(clearDropdownEle).toRightOf(selectEducationEle));
    }


    public WebElement getFacebookProfileEle() {
        return driver.findElement(facebookProfileEle);
    }

    public WebElement getTwitterProfileEle() {
        return driver.findElement(twitterProfileEle);
    }

    public WebElement getInstagramProfileEle() {
        return driver.findElement(instagramProfileEle);
    }



    public WebElement getSelectProfessionEle() {
        return driver.findElement(selectProfessionEle);
    }

    public WebElement getProfessionValueEle(String professionName) {
        return driver.findElement(By.xpath("//div//span[contains(text(),'" + professionName + "')]"));
    }
    public WebElement getClearProfessionEle(){

        return driver.findElement(with(clearDropdownEle).toRightOf(selectProfessionEle));
    }

    public WebElement getSelectBikeEle() {
        return driver.findElement(selectBikeEle);
    }
    public WebElement getClearBikeEle(){
        return driver.findElement(with(clearDropdownEle).toRightOf(selectBikeEle));
    }

    public WebElement getDropdownOptionsEle() {
        return driver.findElement(dropdownOptionsEle);
    }

    public WebElement getSelectCarEle() {
        return driver.findElement(selectCarEle);

    }
    public WebElement getClearCarEle(){
        return driver.findElement(with(clearDropdownEle).toRightOf(selectCarEle));
    }

    public WebElement getSelectVidhanSabhaWhereHeSheVotesEle() {
        return driver.findElement(selectVidhanSabhaWhereHeSheVotes);
    }

    public WebElement getVidhanSabhaWhereHeSheVotesValueEle(String vidhanSabhaWhereHeSheVotesName) {
        return driver.findElement(By.xpath("//div//span[contains(text(),'" + vidhanSabhaWhereHeSheVotesName + "')]"));
    }
    public WebElement getClearVidhanSabhaWhereHeSheVotesEle(){
        return driver.findElement(with(clearDropdownEle).toRightOf(selectVidhanSabhaWhereHeSheVotes));
    }

    public WebElement getBoothWhereHeSheVotesEle() {
        return driver.findElement(boothWhereHeSheVotes);
    }

    public WebElement getVoterIDEle() {
        return driver.findElement(voterIDEle);
    }

    public WebElement getAadharNumberEle() {
        return driver.findElement(aadharNumberEle);
    }

    public WebElement getPannaNumberEle() {
        return driver.findElement(pannaNumberEle);
    }

    public WebElement getRationCardNumber() {
        return driver.findElement(rationCardNumberEle);
    }

    public List<WebElement> getSelectSalutationEle() {
        return driver.findElements(salutationEle);

    }

    public WebElement getSalutationValueEle(String salutationValue) {
        return driver.findElement(By.xpath("//mat-option//span[contains(text(),'" + salutationValue + "')]"));
    }

    public WebElement getSubCasteEle() {
        return driver.findElement(subCasteEle);
    }

    public WebElement getQualificationEle() {
        return driver.findElement(qualificationEle);
    }

    public List<WebElement> getReligionEle() {
        return driver.findElements(religionEle);
    }

    public WebElement getReligionValueEle(String religionName) {
        return driver.findElement(By.xpath("//mat-option//span[contains(text(),'" + religionName + "')]"));
    }

    public WebElement getActiveMemberIDEle() {
        return driver.findElement(activeMemberIDEle);
    }

    public WebElement getSelectPartyZilaEle() {
        return driver.findElement(selectPartyZilaEle);
    }

    public WebElement getPartyZilaValueEle(String partyZilaName) {
        return driver.findElement(By.xpath("//div//span[contains(text(),'" + partyZilaName + "')]"));
    }
    public WebElement getClearPartyZilaEle(){
        return driver.findElement(with(clearDropdownEle).toRightOf(selectPartyZilaEle));
    }

    public WebElement getSelectedPartyZilaValueEle(){
        return driver.findElement(with(selectOptionsValueEle).below(selectPartyZilaEle));
    }

    public WebElement getSelectPartyMandalEle() {
        return driver.findElement(selectPartyMandalEle);
    }

    public WebElement getSelectPartyMandalValueEle(String partyMandalName){
        return driver.findElement(By.xpath("//div//span[contains(text(),'" + partyMandalName + "')]"));
    }
    public WebElement getClearPartyMandalEle(){
        return driver.findElement(with(clearDropdownEle).toRightOf(selectPartyMandalEle));
    }
    public WebElement getSelectedPartyMandalValueEle(){
        return driver.findElement(with(selectOptionsValueEle).below(selectPartyMandalEle));
    }

    public WebElement getPop_UPEle() {
        return driver.findElement(pop_upEle);
    }

    public WebElement getData_EntryDynamicTableEle(){
        return driver.findElement(data_entryDynamicTableEle);
    }

    public WebElement getLinkedinProfileEle(){
       return driver.findElement(linkedinProfileEle);
    }

    public WebElement getPhotoEle(){
        return driver.findElement(photoEle);
    }

    public WebElement getAddButtonEle(){
        return driver.findElement(addButtonEle);
    }

    public WebElement get_data_entry_dialogue_ele(){
        return driver.findElement(data_entry_dialogue_ele);
    }

    public WebElement getTextInDialogueEle(){
        return driver.findElement(textInDialogueEle);
    }

    public WebElement getCancelDialogButtonEle(){
        return driver.findElement(cancelDialogButtonEle);
    }
    public WebElement getCancelButtonEle(){
        return driver.findElement(cancelButtonEle);
    }


}
