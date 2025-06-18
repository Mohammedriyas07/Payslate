    package Pages;

    import Drivermanager.Drivermanager;
    import Helper.Action;
    import Helper.Assertion;
    import Helper.Datas;
    import Helper.Services;
    import Util.Util;
    import io.appium.java_client.AppiumDriver;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class Login_screen {
        private static Login_screen loginScreen;

        private By textBox = By.xpath("//android.widget.EditText");
        private By continueBtn = By.xpath("//android.widget.Button[@content-desc='Continue']");
        private By otp = By.xpath("//android.view.View[contains(@content-desc,'Your OTP number is')]");
        private By warningPopup = By.xpath("//android.view.View[@content-desc='Please enter a valid phone number']");
        private By warningPopup_without_entering_mobileNumber = By.xpath("//android.view.View[@content-desc='Please enter your phone number']");
        private By waringPopup_invalidOtp = By.xpath("//android.view.View[@content-desc='The OTP you have entered is incorrect. Please try again.']");
        private By name_textBox_userCreation = By.xpath("(//android.widget.EditText)[1]");
        private By email_textBox_userCreation = By.xpath("(//android.widget.EditText)[2]");
        private By password_textBox_userCreation = By.xpath("(//android.widget.EditText)[3]");
        private By createAccount_btn_userCreation = By.xpath("//android.widget.Button[@content-desc='Create account']");
        private By warningPopup_username1 = By.xpath("//android.view.View[contains(@content-desc, 'Enter your Name')]");
        private By warningPopup_email = By.xpath("//android.view.View[@content-desc='Invalid email']");
        private By warningPopup_password = By.xpath("//android.view.View[@content-desc='Password must be at least 8 characters long']");
        private By WarningPopup_username2 = By.xpath("//android.view.View[@content-desc='Name must be between 3 and 30 characters']");
        private String username = "";
        private String email = "";
        private String password = "";
        private String mobileNumber = "";
        private WebDriverWait wait;

        private Login_screen() {

        }

        public static Login_screen getInstance() {
            if (loginScreen == null) {
                loginScreen = new Login_screen();

            }
            return loginScreen;
        }

        public void enterMobileNumber() {
            Drivermanager.getInstance().getDriver().findElement(textBox).click();
            Action.getInstance().type(String.valueOf(Datas.MobileNumber.valid_num1.getNumber()));
        }

        public void enterInvalidMobileNumber() {
            Drivermanager.getInstance().getDriver().findElement(textBox).click();
            Action.getInstance().type(String.valueOf(Datas.MobileNumber.invalid_num1.getNumber()));
        }

        public void clickContinueBtn() {
            Drivermanager.getInstance().getDriver().findElement(continueBtn).click();
        }

        public void enterOtp() {
            AppiumDriver driver = Drivermanager.getInstance().getDriver();
            String v = driver.findElement(otp).getAttribute("content-desc");
            System.out.println(v);
            Pattern p = Pattern.compile("\\d");
            Matcher matcher = p.matcher(v);
            String otp_num = "";
            while (matcher.find()) {
                otp_num = otp_num + matcher.group();
            }
            driver.findElement(textBox).click();
            Action.getInstance().type(otp_num);
        }

        public void verify_warning_popup() {
            String actual = Drivermanager.getInstance().getDriver().findElement(warningPopup).getAttribute("content-desc");
            Assertion.getInstance().verifyText(actual, Datas.MobileNumbervalidationErrorMsg.msg1.getMessage());
        }

        public void verify_warning_popup_without_entering_mobileNumber() {
            String actual = Drivermanager.getInstance().getDriver().findElement(warningPopup_without_entering_mobileNumber).getAttribute("content-desc");
            Assertion.getInstance().verifyText(actual, Datas.MobileNumbervalidationErrorMsg.msg2.getMessage());
        }

        public void enterInvalidOtp() {
            //Drivermanager.getInstance().getDriver().findElement(textBox).click();
            wait=new WebDriverWait(Drivermanager.getInstance().getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.presenceOfElementLocated(textBox)).click();
            Action.getInstance().type("123456");
        }

        public void verifyOtpErrorMsg() {
            String actual = Drivermanager.getInstance().getDriver().findElement(waringPopup_invalidOtp).getAttribute("content-desc");
            Assertion.getInstance().verifyText(actual, Datas.otpValidationErrorMsg.msg1.getErrorMsg());
        }

        public void enterNewMobileNumber() {
            Drivermanager.getInstance().getDriver().findElement(textBox).click();
            this.mobileNumber=Util.getInstance().getNewMobileNumber();
            Action.getInstance().type(mobileNumber);
        }

        public void enterNewUserName() {
            wait = new WebDriverWait(Drivermanager.getInstance().getDriver(), Duration.ofSeconds(30));
            WebElement username_element = wait.until(ExpectedConditions.elementToBeClickable(name_textBox_userCreation));
            username_element.click();
            this.username = "test" + Services.getInstance().randomNumberGenerator();

            Action.getInstance().type(this.username);
        }

        public void enterNewEmailId() {
            wait = new WebDriverWait(Drivermanager.getInstance().getDriver(), Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(email_textBox_userCreation));
            element.click();
            this.email = this.username + "@gmail.com";
            Action.getInstance().type(this.email);
        }

        public void enterPassword() {
            Drivermanager.getInstance().getDriver().findElement(password_textBox_userCreation).click();
            this.password = "SoftSuave" + Services.getInstance().randomNumberGenerator();
            Action.getInstance().type(this.password);
        }

        public void clickCreateAccountbtn() {

            if (!this.username.isEmpty() && !this.mobileNumber.isEmpty() && !this.email.isEmpty() && !this.password.isEmpty()) {
                Util.getInstance().setUserDetails(this.mobileNumber, this.username, this.email, this.password);
                Util.getInstance().insertData();
                System.out.println("inserted");
                Drivermanager.getInstance().getDriver().findElement(createAccount_btn_userCreation).click();
            }
            else
            {
                System.out.println(username+ " "+email+" "+mobileNumber+" "+password);
                System.out.println("nooyyttttt");
            }
        }

        public void verifyAllTextBoxErrorMessageinSignUpScreen() {
            wait = new WebDriverWait(Drivermanager.getInstance().getDriver(), Duration.ofSeconds(30));
            WebElement username_element = wait.until(ExpectedConditions.visibilityOfElementLocated(warningPopup_username1));
            String username_actual = username_element.getAttribute("content-desc");
            Assertion.getInstance().verifyText(username_actual, Datas.signUpScreenValidationErrorMsg.userName1.getErrorMsg());
            String email_actul = Drivermanager.getInstance().getDriver().findElement(warningPopup_email).getAttribute("content-desc");
            Assertion.getInstance().verifyText(email_actul, Datas.signUpScreenValidationErrorMsg.email.getErrorMsg());
            String password_actul = Drivermanager.getInstance().getDriver().findElement(warningPopup_password).getAttribute("content-desc");
            Assertion.getInstance().verifyText(password_actul, Datas.signUpScreenValidationErrorMsg.password.getErrorMsg());
        }

        public void enterLessThanThreeCharinUserTextBox() {
            wait = new WebDriverWait(Drivermanager.getInstance().getDriver(), Duration.ofSeconds(30));
            WebElement username_element = wait.until(ExpectedConditions.visibilityOfElementLocated(name_textBox_userCreation));
            username_element.click();
            Action.getInstance().type("Hi");
        }
        public void verifyErrorMsgForLessThanThreeCharinUserTextBox()
        {
           String username_actual= Drivermanager.getInstance().getDriver().findElement(WarningPopup_username2).getAttribute("content-desc");
            Assertion.getInstance().verifyText(username_actual,Datas.signUpScreenValidationErrorMsg.UserName2.getErrorMsg());
        }
    }