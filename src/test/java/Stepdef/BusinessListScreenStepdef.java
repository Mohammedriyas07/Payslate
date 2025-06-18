package Stepdef;

import Pages.BusinessListScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusinessListScreenStepdef {
    @And("the user click the Add business button")
    public void theUserClickTheAddBusinessButton() {
        BusinessListScreen.getInstance().clickAddBusinessBtn();
    }

    @And("the user click the save button")
    public void theUserClickTheSaveButton() {
     BusinessListScreen.getInstance().clickSaveBtn();
    }

    @Then("the user validate the warning popup message displayed for empty business name text box")
    public void theUserValidateTheWarningPopupMessageDisplayedForEmptyBussinessNameTextBox() {
     BusinessListScreen.getInstance().verifyWarningMsgForEmptyBusinessNameTextBox();
    }

    @When("the user enters a single character in the Business Name text box")
    public void theUserEntersASingleCharacterInTheBusinessNameTextBox() {
     BusinessListScreen.getInstance().enterBusinessname(true);
    }

    @Then("a warning popup message should be displayed indicating that the Business Name is below the required range")
    public void aWarningPopupMessageShouldBeDisplayedIndicatingThatTheBusinessNameIsBelowTheRequiredRange() {
    BusinessListScreen.getInstance().verifyWarningMsgForEnterSingleCharInBusinessNameTextBox();
    }

    @When("the user enter the business name")
    public void theUserEnterTheBusinessName() {
        BusinessListScreen.getInstance().enterBusinessname(false);
    }
    @And("the user add the profile picture for the business")
    public void theUserAddTheProfilePictureForTheBusiness() {
     BusinessListScreen.getInstance().clickBusinessnameImageIcon();
     BusinessListScreen.getInstance().clickImageSelectOption();
     BusinessListScreen.getInstance().selectImage();
    }

    @Then("verify business name add in business list screen")
    public void verifyBusinessNameAddInBusinessListScreen() {
     BusinessListScreen.getInstance().verifyBusinessNameInBusinessListScreen();
    }



}
