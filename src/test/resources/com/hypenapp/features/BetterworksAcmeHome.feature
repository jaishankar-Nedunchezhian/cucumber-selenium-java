Feature: To test the create post feature from the Acme Home Page

Background: 
	Given user has already logged in to the Acme application
	|emailaddress				|verificationcode	|
	|hyphen_admin@acmetest.com	|34067				|

# radio button options - you can choose - Anonymous , Official, Named.
# Post type - you can choose - Open , MULTIPLE CHOICE
# Co-worker groups -{Women in Business ,SF Bay Area,R&D team,
# Arnaud , Forum (All Merged),Chat with Meagan,CEO Ask Me Anything,Pulse Survey - For Forum
# Ask anything to your CEO at anytime,Any Suggestion,Ask CHRO Anything,Ask HR anything,}

Scenario: verify the create a new post functionality with Open type
	Given user is on the Acme Home page
	Then I should see the AcmeTest home page
	And I should see the create a new post Button
	When I click on create new Post Button
	Then I should see the create new post -Select type modal box
	And I choose the radio button - Anonymous-Official-Named category "Named"
	When I choose the post type - Open or Multiple Choice "Open"
	When I choose the co-worker groups from the drop down "Forum (All Merged)"
	And I click on select button 
	Then I should see the Create new post -Write post modal box 
	And I type the question-opinion-feedback on the post "This is for testing Purpose - Automation Script" 
	And I click on publish Post 