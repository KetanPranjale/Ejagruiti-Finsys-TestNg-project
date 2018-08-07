#Author: pranjale.ks@gmail.com
#Keywords Summary : Home page feature files
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@SmokeTest @EndToEnd
Feature: Home page feature

	Background: User is successfully logged in
	When user enters "dummycfo" as username
	And user enters "passw0rd" as password
	And user clicks on login button

  @SmokeTest @EndToEnd
  Scenario: Title of home page
    Given User is on home page
    When user checks title of home page
    Then users sees the title "Welcome dummy[***]" on top

  @SmokeTest @EndToEnd
  Scenario: open Manage Company page
    Given user is on home page
    When user clicks on "Financial Analysis" on left pane
    Then "Financial Analysis' pane expands
		And user clicks on "Company" node
		Then "Company" node expands
		And user clicks on "Manage Company" link on home page 
    Then "Manage Company" page opens
  
  @SmokeTest @EndToEnd
  Scenario: Open Leasehold Improvement page
  	Given user is on home page
  	When user clicks on "Financial Analysis" on left pane
  	When user clicks on "Financial Analysis" on left pane
    Then "Financial Analysis' pane expands
		And user clicks on "Company" node
		Then "Company" node expands
		And user clicks on "Leasehold Improvemnet"
    


