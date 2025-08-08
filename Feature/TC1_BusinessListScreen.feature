Feature: Feature to automate the business list screen

  Background:
    Given the user open PaySlate Application
    When the user tap 3 times
    And the user click get started button
    And the user enter the mobile number
    And the user click the continue button
    And the user enter the OTP
    And the user click the continue button

  @regression @sanity @business1 @sanity1
  Scenario: without filling text in business name text box click save button
    And the user click the Add business button
    And  the user click the save button
    Then the user validate the warning popup message displayed for empty business name text box
  @regression @sanity @business2 @sanity1
  Scenario: Verify error message when business name is less than 1 character
    And the user click the Add business button
    When the user enters a single character in the Business Name text box
    And the user click the save button
    Then a warning popup message should be displayed indicating that the Business Name is below the required range

  @regression @sanity @business3 @sanity1
  Scenario: Verify error message when business name is more than 30 character
    And the user click the Add business button
    When the user enters a character exceed limit in the Business Name text box
    And the user click the save button
    Then a warning popup message should be displayed indicating that the Business Name is below the required range
  @regression @sanity @business4 @sanity1
    Scenario: scenario to create a new business
    And the user click the Add business button
      When the user enter the business name
      #And the user add the profile picture for the business
      And the user click the save button
      Then verify business name add in business list screen
  @regression @sanity @business5 @sanity1
    Scenario: scenario to update the business name
      When the user the click the three dots in existing business
      And the user click the edit business
      And the user update the business name
      And the user click the save button
      Then the user verify updated business name is reflecting in business list screen

  @regression @sanity @business6 @sanity1
  Scenario: scenario to create a new business
    And the user click the Add business button
    When the user enter the business name
      #And the user add the profile picture for the business
    And the user click the save button
    Then verify business name add in business list screen
    When the user the click the three dots in existing business
    And the user click the business settings
    And the user click the delete business
    Then verify business name deleted in business list screen










