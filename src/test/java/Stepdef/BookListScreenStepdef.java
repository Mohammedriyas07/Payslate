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
}
