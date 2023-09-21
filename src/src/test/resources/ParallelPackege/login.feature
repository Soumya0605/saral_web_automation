Feature: Login Page Feature

Scenario: Login With Mobile number

Given User is on login page 
When  User enters mobile Number
#|Mobile_number |
#|5112909111 		|

|Moble|6920001453|

And User click on OTP nbutton
And User enters otp
|Otp_String									|otp			 | 
|//input[@type='password']	|010203    |
And User click on login button

Scenario: Login With Email ID
Given User is on login page 
When  User enters EmailID and Password
|EmailID						|Password		|
|statemager12@gmail.com|Test@123|
#And user enters Pasword
#| Password | Password1*|
And User click on OTP nbutton
And User enters otp
|Otp_String									|otp			 | 
|//input[@type='password']	|010203    |
And User click on login button


