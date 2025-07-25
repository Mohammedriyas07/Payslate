package Stepdef;

import Pages.BookListScreen;
import Pages.EntryListScreen;
import io.cucumber.java.af.En;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CashListScreenStepdef {
    @And("the user click the newly created book")
    public void theUserClickTheNewlyCreatedBook() {
        BookListScreen.getInstance().clickBookName();
    }

    @And("the user click the cash entry")
    public void theUserClickTheCashEntry() {
        EntryListScreen.getInstance().clickCashEntry();
    }

    @And("the user click the cashBook entry button")
    public void theUserClickTheCashBookEntryButton() {
        EntryListScreen.getInstance().clickAddCashEntryBtn();
    }

    @And("the user click the cashIn button")
    public void theUserClickTheCashInButton() {
        EntryListScreen.getInstance().clickCashInBtn();
    }

    @And("the user enter the amount")
    public void theUserEnterTheAmount() {
        EntryListScreen.getInstance().EnterAmount();
    }

    @And("the user enter the remarks")
    public void theUserEnterTheRemarks() {
        EntryListScreen.getInstance().EnterRemark();
    }

    @And("the user select the category")
    public void theUserSelectTheCategory() {
        EntryListScreen.getInstance().clickCategoryDropdown();
        EntryListScreen.getInstance().selectCategoryOption();
    }

    @And("the user attached the documents")
    public void theUserAttachedTheDocuments() {
        EntryListScreen.getInstance().selectAttachments();
    }

    @And("the user selected the payment mode")
    public void theUserSelectedThePaymentMode() {
        EntryListScreen.getInstance().clickShowMoreBtn();
        EntryListScreen.getInstance().clickPaymentMode_AddBtn();
        EntryListScreen.getInstance().enterPaymentModeText();
        EntryListScreen.getInstance().clickpaymentModeCreateBtn();
    }

    @And("the user click the add button to add customer name and phone number")
    public void theUserClickTheAddButtonToAddCustomerNameAndPhoneNumber() {
        
    }

    @And("the user enter the customer name")
    public void theUserEnterTheCustomerName() {
        
    }

    @And("the user enter the customer phone number")
    public void theUserEnterTheCustomerPhoneNumber() {
    }

    @And("the user click the cashOut button")
    public void theUserClickTheCashOutButton() {
        EntryListScreen.getInstance().clickCashOutBtn();
    }

    @Then("the user check the cash count in cash list screen")
    public void theUserCheckTheCashCountInCashListScreen() {
      EntryListScreen.getInstance().checkCashCountInCashListScreen();
    }

    @And("the user click the material entry")
    public void theUserClickTheMaterialEntry() {
        EntryListScreen.getInstance().clickMaterialEntry();
    }

    @And("the user click the materialBook entry button")
    public void theUserClickTheMaterialBookEntryButton() {
        EntryListScreen.getInstance().clickAddMaterialButton();

    }

    @And("the user click the materialBuy button")
    public void theUserClickTheMaterialBuyButton() {
        EntryListScreen.getInstance().clickMaterialBuyButton();
    }

    @And("the user enter the material name")
    public void theUserEnterTheMaterialName() {
        EntryListScreen.getInstance().enterMaterialName();
    }

    @And("the user enter the quantity")
    public void theUserEnterTheQuantity() {
        EntryListScreen.getInstance().enterMaterialQuantity();
    }

    @And("the user enter the pricePerunit")
    public void theUserEnterThePricePerunit() {
        EntryListScreen.getInstance().enterMaterialPricePerUnit();
    }

    @And("the user validate the total amount")
    public void theUserValidateTheTotalAmount() {
        EntryListScreen.getInstance().validateMaterialTotal();
    }

    @And("the user attached the documents for material entry")
    public void theUserAttachedTheDocumentsForMaterialEntry() {
        EntryListScreen.getInstance().selectAttachmentsForMaterialEntry();
    }

    @And("the user click the materialSell button")
    public void theUserClickTheMaterialSellButton() {
        EntryListScreen.getInstance().clickMaterialSellBtn();
    }

    @And("the user select the new category")
    public void theUserSelectTheNewCategory() {
        EntryListScreen.getInstance().clickCategoryDropdown();
        EntryListScreen.getInstance().clickAddCategoryBtn();
        EntryListScreen.getInstance().enterNewCategory();
        EntryListScreen.getInstance().clickNextBtn();
        EntryListScreen.getInstance().selectIconForCategory();
        EntryListScreen.getInstance().clickDoneBtn();
    }
}
