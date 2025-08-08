Feature: Feature to automate the cash and material entries
  Background:
    Given the user open PaySlate Application
    When the user tap 3 times
    And the user click get started button
    And the user enter the mobile number
    And the user click the continue button
    And the user enter the OTP
    And the user click the continue button
    When the user click the existing business
    And the user click the add book button
    And the user enter the book name inside the text box
    #And the user select the currency type as ""

@cash @entryListSanity @regression
  Scenario: to create an cashIn entry with attachments
    And the user select the transaction type "cash"
    And the user click the save button
    And the user verify the book name in book list screen
    And the user click the newly created book
    And the user click the cash entry
    And the user click the cashBook entry button
    And the user click the cashIn button
    And the user enter the amount
    And the user enter the remarks
    And the user select the category
    And the user attached the documents
#    And the user selected the payment mode
#    And the user click the add button to add customer name and phone number
#    And the user enter the customer name
#    And the user enter the customer phone number
#    And the user click the save button
    And the user click the save button
   Then the user check the cash count in cash list screen
@cash1 @entryListSanity @regression
  Scenario: to create an cashIn entry without attachments
    And the user select the transaction type "cash"
    And the user click the save button
    And the user verify the book name in book list screen
    And the user click the newly created book
    And the user click the cash entry
    And the user click the cashBook entry button
    And the user click the cashIn button
    And the user enter the amount
    And the user enter the remarks
    And the user select the category
#    And the user selected the payment mode
#    And the user click the add button to add customer name and phone number
#    And the user enter the customer name
#    And the user enter the customer phone number
#    And the user click the save button
    And the user click the save button
 Then the user check the cash count in cash list screen
  @cash2 @entryListSanity @regression
  Scenario: to create an cashOut entry with attachments
    And the user select the transaction type "cash"
    And the user click the save button
    And the user verify the book name in book list screen
    And the user click the newly created book
    And the user click the cash entry
    And the user click the cashBook entry button
    And the user click the cashOut button
    And the user enter the amount
    And the user enter the remarks
    And the user select the category
    And the user selected the payment mode
    And the user attached the documents
#    And the user click the add button to add customer name and phone number
#    And the user enter the customer name
#    And the user enter the customer phone number
#    And the user click the save button
    And the user click the save button
    Then the user check the cash count in cash list screen

  @cash3 @entryListSanity @regression
  Scenario: to create an cashIn entry without attachments and new Category
    And the user select the transaction type "cash"
    And the user click the save button
    And the user verify the book name in book list screen
    And the user click the newly created book
    And the user click the cash entry
    And the user click the cashBook entry button
    And the user click the cashIn button
    And the user enter the amount
    And the user enter the remarks
    And the user select the new category
    And the user selected the payment mode
    #And the user click the add button to add customer name and phone number
#    And the user enter the customer name
#    And the user enter the customer phone number
#    And the user click the save button
    And the user click the save button
    Then the user check the cash count in cash list screen
  @material @entryListSanity @regression
  Scenario: to create an materialIn entry with attachments
    And the user select the transaction type "material"
    And the user click the save button
    And the user verify the book name in book list screen
    And the user click the newly created book
    And the user click the material entry
    And the user click the materialBook entry button
    And the user click the materialBuy button
    And the user enter the material name
    And the user enter the quantity
    And the user enter the pricePerunit
  #  And the user validate the total amount
    And the user attached the documents for material entry
  #    And the user click the add button to add customer name and phone number
#    And the user enter the customer name
#    And the user enter the customer phone number
#    And the user click the save button
    And the user click the save button
    Then the user check the material count in material list screen

  @material1 @entryListSanity @regression
  Scenario: to create an materialOut entry with attachments
    And the user select the transaction type "material"
    And the user click the save button
    And the user verify the book name in book list screen
    And the user click the newly created book
    And the user click the material entry
    And the user click the materialBook entry button
    And the user click the materialSell button
    And the user enter the material name
    And the user enter the quantity
    And the user enter the pricePerunit
  #  And the user validate the total amount
    And the user attached the documents for material entry
  #    And the user click the add button to add customer name and phone number
#    And the user enter the customer name
#    And the user enter the customer phone number
#    And the user click the save button
    And the user click the save button
    Then the user check the material count in material list screen

  @material2 @entryListSanity @regression
  Scenario: to create an materialOut entry without attachments
    And the user select the transaction type "material"
    And the user click the save button
    And the user verify the book name in book list screen
    And the user click the newly created book
    And the user click the material entry
    And the user click the materialBook entry button
    And the user click the materialSell button
    And the user enter the material name
    And the user enter the quantity
    And the user enter the pricePerunit
  #  And the user validate the total amount
  #    And the user click the add button to add customer name and phone number
#    And the user enter the customer name
#    And the user enter the customer phone number
#    And the user click the save button
    And the user click the save button
    Then the user check the material count in material list screen