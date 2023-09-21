#Feature: AbhiyanDataEntry Feature
#
#  Background:
#    Given User has already logged into the Saral
#      |EmailID						|Password		| |Otp_String									  |otp			 |
#      |statemager12@gmail.com |Test@123	 | |//input[@type='password']	  |010203    |
#  Scenario: Profile page section
#    Given User is on Homepage
#    When user click on profile page
#    Then user gets the user name
#
#
#  Scenario: User Chooses the Abhiyan data entry
#    Given User is on Homepage
#    When user click on Abhiyan data entry
##And User lands on dataentry selection
##And User Select the data entry
##Then User goes to abhiyan data entry page and search
#    And User enters the data
#      |Name | FatherName | Age | phoneNumber| primaryNumber |
#      |Raja |Rajjes			 |23|98912324|3352522353|