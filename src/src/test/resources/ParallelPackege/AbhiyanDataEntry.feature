Feature: Abhiyan Data Entry Page

  Background:
    Given User has already logged into the Saral
      |EmailID				|Password		| |Otp_String									  |otp			 |
      |statemager12@gmail.com |Test@123	 | |//input[@type='password']	  |010203    |


Scenario: User Chooses the Abhiyan Vibhag data entry
Given User is on Homepage
When user click on Abhiyan Vibhag data entry
#And User lands on dataentry selection
#And User Select the data entry
#Then User goes to abhiyan data entry page and search
And User enters the data

Scenario: User Chooses the Abhiyan Pradesh data entry
Given User is on Homepage
When User click on Abhiyan Pradesh Data Entry
And  User Enters Abhiyan Pradesh Data entry

Scenario: User Chooses the Abhiyan Loksabha data entry
Given User is on Homepage
When User click on Abhiyan Loksabha Data Entry
And  User Enters Abhiyan Loksabha Data entry