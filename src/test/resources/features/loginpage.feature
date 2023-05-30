Feature: login functionality for orangeHrm  website

  As a employee of orangeHrm website
  I want to be able to login with my account
  so that i can access my account related features

  Background:
    Given  I am on the orangeHrm login page

    Scenario: Successful login with valid credential
      Given  I have entered valid username and password
      When  I click on login button
      Then  I should be logged in successfully

    Scenario Outline: Unsuccessful login with invalid credential
      Given I have entered invalid "<username>" and invalid "<password>"
      When I click on login button
      Then I should see and error message indicating "<error_message>"

      Examples:
        | username        | password | error_message
        | test1@test1.com | abcd     | Warning: Invalid credentials
        | test2.com       | 1234     | Warning: Invalid credentials

  Scenario: Navigating to forget password link
    When I click on forget password
        Then I should be redirect to password reset page