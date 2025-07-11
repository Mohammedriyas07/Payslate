Feature: Feature to automate the book list screen
  Background:
    Given the user open PaySlate Application
    When the user tap 3 times
    And the user click get started button
    And the user enter the mobile number
    And the user click the continue button
    And the user enter the OTP
    And the user click the continue button

   @bookList1 @regression @sanity2
  Scenario: create new book under new business
    And the user click the Add business button
    When the user enter the business name
    And the user add the profile picture for the business
    And the user click the save button
    Then verify business name add in business list screen
    When the user click the newly create business
    And the user click the add book button
    And the user enter the book name inside the text box
    #And the user select the currency type as ""
    And the user select the transaction type "all"
    And the user click the save button
    And the user verify the book name in book list screen

  @bookList2 @regression @sanity2
  Scenario: create new book under existing business business
    When the user click the existing business
    And the user click the add book button
    And the user enter the book name inside the text box
    #And the user select the currency type as ""
    And the user select the transaction type "all"
    And the user click the save button
    And the user verify the book name in book list screen
    And the check the book count in business list screen




