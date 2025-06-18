Feature: Feature to automate the book list screen
  Background:
    Given the user open PaySlate Application
    When the user tap 3 times
    And the user click get started button
    And the user enter the mobile number
    And the user click the continue button
    And the user enter the OTP
    And the user click the continue button
    And the user click the Add business button
   @bookList1
  Scenario: create new book under new business
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




#    Examples:
#      | transactionType |
#      |cash           |
#      |all            |
#      |material       |
