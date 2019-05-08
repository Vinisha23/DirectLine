
Feature: Verifying Input Field

  In order to Verify the Input field
  As a User
  I want to test field validations

Scenario Outline: Verify Registration Number input field

Given I goto dealer portal website
When I enter <Invalid> registration number
And I click on search button
Then I should see the validation error

  Examples:
  |   Invalid     |
  |               |
  |   $%££&(*(    |