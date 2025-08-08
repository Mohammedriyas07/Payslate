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


    @When("the user click the existing business")
    public void theUserClickTheExistingBusiness() {
        BusinessListScreen.getInstance().clickExistingBusiness();
    }

    @When("the user the click the three dots in existing business")
    public void theUserTheClickTheThreeDotsInExistingBusiness() {
        BusinessListScreen.getInstance().clickThreeDotsForExistingBusiness();
    }

    @And("the user click the edit business")
    public void theUserClickTheEditBusiness() {
    BusinessListScreen.getInstance().clickEditBusiness();
    }

    @And("the user update the business name")
    public void theUserUpdateTheBusinessName() {
        BusinessListScreen.getInstance().updateBusinessName();
    }

    @Then("the user verify updated business name is reflecting in business list screen")
    public void theUserVerifyUpdatedBusinessNameIsReflectingInBusinessListScreen() {
        BusinessListScreen.getInstance().verifyUpdatedBusinessNameInList();
    }

    @And("the user click the business settings")
    public void theUserClickTheBusinessSettings() {
        BusinessListScreen.getInstance().clickBusinessSettings();
    }

    @And("the user click the delete business")
    public void theUserClickTheDeleteBusiness() {
        BusinessListScreen.getInstance().clickDeleteBusiness();
        BusinessListScreen.getInstance().clickDoneBtn();
    }

    @Then("verify business name deleted in business list screen")
    public void verifyBusinessNameDeletedInBusinessListScreen() {
        BusinessListScreen.getInstance().verifyBusinessNameDeletedSuccessfully();
    }

    @And("the user click business name dropdown")
    public void theUserClickBusinessNameDropdown() {
        BusinessListScreen.getInstance().clickBusinessNameDropDownInBookListScreen();
    }

    @Then("verify the user landed in business list screen")
    public void verifyTheUserLandedInBusinessListScreen() {
     BusinessListScreen.getInstance().verifyItIsBusinessListScreen();
    }

    @When("the user enters a character exceed limit in the Business Name text box")
    public void theUserEntersACharacterExceedLimitInTheBusinessNameTextBox() {
        BusinessListScreen.getInstance().enterBusinessNameExceedLimit();
    }
}
