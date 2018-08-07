#StyoryType=WEB
#Owner=ejagruti
#CreationDate=24-07-2018 Tuesday
@Login
Feature: Login Feature

  Background: user successfully openned the chrome browser
  When user opens the "ch64" browser
  And user enter the url "http://localhost:90/finsys"

  @SmokeTest @EndToEnd
  Scenario: Login Functionality for valid username and password
    Given user is on the application login page
    When user enters "dummyfm" as username
    And user enters "passw0rd" as password
    And user clicks on login button
    Then user is on the application home page
    And user gets the message starting with "Welcome" on the top

