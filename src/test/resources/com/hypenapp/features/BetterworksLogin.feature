Feature: Testing the signin feature of the BetterWorks Engage application

Scenario Outline: Login to the Betterworks Engage application with valid credentials
	Given I am on the gethypen login page application
	Then I should see the email text box and verification code button
	And I enter the work email address <emailaddress>
	And I click on the send me the verification code Button
	Then I should see the verification code Text box 
	And I enter the verification code <verificationcode>
	And I click on the Login Button
	Then I am seeing the acme home page
	
	Examples:
	| emailaddress				| verificationcode	|
	|hyphen_admin@acmetest.com	|34067				|
