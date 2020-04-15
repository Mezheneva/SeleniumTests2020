
Feature: A description
    
Scenario: Open main page c
    Given Open browser
    When Open main page
    When Closing browser

Scenario: Open Sign In page scenario
    Given Open browser
    When Open Sign In page
    When Closing browser

Scenario: Open Sign Up page scenario
    Given Open browser
    When Open Sign Up page
    When Closing browser

Scenario: Click Sign In button in main page scenario
    Given Open browser
    When Open main page
    When Click Sign In button
    When Closing browser

Scenario: Click Sign Up button in main page scenario
    Given Open browser
    When Open main page
    When Click Sign Up button
    When Closing browser

Scenario: Sign In with invalid creds scenario
    Given Open browser
    When Open Sign In page
    When Sign In with invalid creds
    Then get error message
    When Closing browser


Scenario: Click Create acc callout in Sign In page scenario
    Given Open browser
    When Open Sign In page
    When Click Create acc callout
    When Closing browser


Scenario: Sign Up with invalid creds scenario
    Given Open browser
    When Open Sign Up page
    When enters "testemail" as email
    And enters "testusername" as name
    Then get error email message
    And get error name message
    When Closing browser




