Feature: feature to verify splash screen
  Background:
    Given the user open PaySlate Application
    When the user tap 3 times
    And the user click get started button
  @regression @login1
  Scenario: to verify error message when user click continue button without entering mobile number
    And the user click the continue button
    Then the user verify the warning popup message for without entering mobile number
  @regression @login2
  Scenario: to verify login functionality with invalid mobile number
    And the user enter the invalid mobile number
    And the user click the continue button
    Then the user verify the warning popup message
  @regression @login3
  Scenario: to verify login functionality with invalid OTP number
    And the user enter the mobile number
    And the user click the continue button
    And the user enter the invalid OTP number
    And the user click the continue button
    Then the user verify the warning popup message for ending invalid OTP

  @regression  @login4
  Scenario: to verify login functionality with existing mobile number
    And the user enter the mobile number
    And the user click the continue button
    And the user enter the OTP
    And the user click the continue button

  @regression  @signup1
  Scenario: to verify login functionality with new mobile number
    And the user enter the new mobile number
    And the user click the continue button
    And the user enter the OTP
    And the user click the continue button
    And the user enters a username for the new account
    And the user enters an email for the new account
    And the user enters a password for the new account
    And the user click the createAccount button
  @regression  @signup2
  Scenario: Verify error displayed when clicking Create button without filling any textbox
    And the user enter the new mobile number
    And the user click the continue button
    And the user enter the OTP
    And the user click the continue button
    And the user click the createAccount button
    And the verify the displayed error for text box in signup screen

  @regression  @signup3
  Scenario: Verify error message when name is less than 3 characters
    And the user enter the new mobile number
    And the user click the continue button
    And the user enter the OTP
    And the user click the continue button
    And the user enter less than three characters in textbox
    And the user click the createAccount button
    And the verify the displayed error for username textBox



