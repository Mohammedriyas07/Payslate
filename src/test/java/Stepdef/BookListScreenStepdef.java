package Stepdef;

import Pages.BookListScreen;
import Pages.BusinessListScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookListScreenStepdef {
    @When("the user click the newly create business")
    public void theUserClickTheNewlyCreateBusiness() {
        BusinessListScreen.getInstance().clickNewlyCreatedBusiness();
    }

    @And("the user click the add book button")
    public void theUserClickTheAddBookButton() {
        BookListScreen.getInstance().clickAddBookButton();
    }

    @And("the user enter the book name inside the text box")
    public void theUserEnterTheBookNameInsideTheTextBox() {
        BookListScreen.getInstance().enterBookname();
    }

    /*@And("the user select the currency type as {string}")
    public void theUserSelectTheCurrencyTypeAs(String arg0) {
        
    }*/

    @And("the user select the transaction type {string}")
    public void theUserSelectTheTransactionType(String type) {
        BookListScreen.getInstance().selectTransactionType(type);
    }


    @And("the user verify the book name in book list screen")
    public void theUserVerifyTheBookNameInBookListScreen() {
        BookListScreen.getInstance().verifyBookName();
    }

    @And("the check the book count in business list screen")
    public void theCheckTheBookCountInBusinessListScreen() {
        BookListScreen.getInstance().verifyBookCountInBusinessListScreen();
    }


    @And("the user click all business button")
    public void theUserClickAllBusinessButton() {
        BookListScreen.getInstance().clickAllBusinessBtn();
    }

    @And("the user click the three dots for existing book")
    public void theUserClickTheThreeDotsForExistingBook() {
        BookListScreen.getInstance().clickTheExistingBook();
    }

    @And("the user click the book settings option")
    public void theUserClickTheBookSettingsOption() {
        BookListScreen.getInstance().clickBookSettingsBtn();
    }

    @And("the user click edit icon to update book name")
    public void theUserClickEditIconToUpdateBookName() {
        BookListScreen.getInstance().clickBookSettingsEditIcon();
    }

    @And("the user update the book name")
    public void theUserUpdateTheBookName() {
    BookListScreen.getInstance().updateBookName();
    }

    @And("the user click the book settings save button")
    public void theUserClickTheBookSettingsSaveButton() {
        BookListScreen.getInstance().clickBookSettingsSaveBtn();
    }

    @Then("verify book name updated in book list screen")
    public void verifyBookNameUpdatedInBookListScreen() {
        BookListScreen.getInstance().verifyUpdatedBookNameInBookListScreen();
    }
}
