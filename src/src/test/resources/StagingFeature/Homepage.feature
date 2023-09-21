 Feature: Homepage Feature 
 
 Background: 
 Given User has already logged into the Saral 
|EmailID				|Password		| |Otp_String									  |otp			 |
|statemager12@gmail.com |Test@123	 | |//input[@type='password']	  |010203    |

Scenario: Profile page section 
Given User is on Homepage
When user click on profile page
Then user gets the user name


#Scenario: User Chooses the Abhiyan data entry
#Given User is on Homepage
#When user click on Abhiyan data entry
##And User lands on dataentry selection
##And User Select the data entry
##Then User goes to abhiyan data entry page and search
#And User enters the data
#
#  Scenario: User Chooses the AbhiyanPradesh data entry
#   Given User is on Homepage
#   When User click on Abhiyanpradesh Data Entry
#   And  User Ennters pradesh Data entry
#
#  Scenario: User Chooses the Loksabha data entry
#   Given User is on Homepage
#   When User click on Loksabha Data Entry
#   And  User Ennters Loksabha Data entry
