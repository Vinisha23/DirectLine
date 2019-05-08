
Feature: Verifying Non-Existing Vehicle

  In order to Verify Vehicle does not exists
  As a User
  I want to enter Invalid registration number and see

Scenario Outline: Verify vehicle Registration number does not exists

Given I goto dealer portal website
When I enter <Invalid> registration number
And I click on search button
Then I should be able to see <Expected message>

  Examples:
  |   Invalid     |Expected message                     |
  |   abcde       |Sorry record not found               |
  |   12345       |Sorry record not found               |
  |   0V12UYY     |Sorry record not found               |
