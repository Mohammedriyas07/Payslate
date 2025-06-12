package Stepdef;

import Pages.Login_screen;
import Pages.Splash_screen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginScreenStepdef {
    @Given("the user open PaySlate Application")
    public void the_user_open_pay_slate_application() {
        System.out.println("user opened payslate app");
    }
    @And("the user tap {int} times")
    public void the_user_tap_times(Integer int1) {
        Splash_screen.getInstance().tap();
    }
    @And("the user click get started button")
    public void the_user_click_get_started_button() {
      Splash_screen.getInstance().click_getStartedBtn();
    }
    @And("the user enter the mobile number")
    public void the_user_enter_the_mobile_number() {
        Login_screen.getInstance().enterMobileNumber();
    }
    @When("the user click the continue button")
    public void the_user_click_the_continue_button() {
       Login_screen.getInstance().clickContinueBtn();
    }
    @When("the user enter the OTP")
    public void the_user_enter_the_otp() {
        Login_screen.getInstance().enterOtp();
    }

    @And("the user enter the invalid mobile number")
    public void theUserEnterTheInvalidMobileNumber() {
        Login_screen.getInstance().enterInvalidMobileNumber();
    }

    @Then("the user verify the warning popup message")
    public void theUserVerifyTheWarningPopupMessage() {
     Login_screen.getInstance().verify_warning_popup();
    }

    @Then("the user verify the warning popup message for without entering mobile number")
    public void theUserVerifyTheWarningPopupMessageForWithoutEnteringMobileNumber() {
      Login_screen.getInstance().verify_warning_popup_without_entering_mobileNumber();
    }

    @And("the user enter the invalid OTP number")
    public void theUserEnterTheInvalidOTPNumber() {
    Login_screen.getInstance().enterInvalidOtp();

    }

    @Then("the user verify the warning popup message for ending invalid OTP")
    public void theUserVerifyTheWarningPopupMessageForEndingInvalidOTP() {
        Login_screen.getInstance().verifyOtpErrorMsg();
    }

    @And("the user enter the new mobile number")
    public void theUserEnterTheNewMobileNumber() {
    Login_screen.getInstance().enterNewMobileNumber();
    }

    @And("the user enters a username for the new account")
    public void theUserEntersAUsernameForTheNewAccount() {
        Login_screen.getInstance().enterNewUserName();
    }

    @And("the user enters an email for the new account")
    public void theUserEntersAnEmailForTheNewAccount() {
    Login_screen.getInstance().enterNewEmailId();
    }

    @And("the user enters a password for the new account")
    public void theUserEntersAPasswordForTheNewAccount() {
        Login_screen.getInstance().enterPassword();
    }

    @And("the user click the createAccount button")
    public void theUserClickTheCreateAccountButton() {
        Login_screen.getInstance().clickCreateAccountbtn();
    }

    @And("the verify the displayed error for text box in signup screen")
    public void theVerifyTheDisplayedErrorForTextBoxInSignupScreen() {
        Login_screen.getInstance().verifyAllTextBoxErrorMessageinSignUpScreen();
    }

    @And("the user enter less than three characters in textbox")
    public void theUserEnterLessThanThreeCharactersInTextbox() {
        Login_screen.getInstance().enterLessThanThreeCharinUserTextBox();
    }

    @And("the verify the displayed error for username textBox")
    public void theVerifyTheDisplayedErrorForUsernameTextBox() {
        Login_screen.getInstance().verifyErrorMsgForLessThanThreeCharinUserTextBox();
    }


}
