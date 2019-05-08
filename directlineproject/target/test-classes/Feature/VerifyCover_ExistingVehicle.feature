
Feature: Verify Vehicle exists

  In order to Verify Vehicle exists
  As a User
  I want to enter Valid registration number and see

Scenario Outline: Test that user registration number of vehicle exists

Given I goto dealer portal website
When I enter <Valid> registration number
And I click on search button
Then I should see vehicle details

  Examples:
  |Valid   |
  |OV12UYY |
  |ov12uyy |
  |Ov12UyY |
  |OV12 UYY|

