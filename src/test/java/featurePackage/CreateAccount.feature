
Feature: Create an account in magento SoftwareTestingBoard
  I want to create an account in magento SoftwareTesting Board
  
  Background:
    Given User launch the browser
    And User navigate into Magento Software Testing Board Home Page

  
  Scenario: Create an New Customer Account
    And User navigate into Create New Customer Account Page
    When User enters the first name 
    And User enters the last name 
    And User enters the email 
    And User enters the password  and confirms with ConfirmPassword
    And User clicks the CreateAccount button
    Then The account should be created successfully
    And User close the application
    
    Scenario: Sign In with New Customer Account
    And User navigate into Customer login Page
    When User enters the UserEmail
    And User enters the password
    And User clicks the sighIn button
    Then User account login successfully
    And User close the application
