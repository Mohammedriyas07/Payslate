package Pages;

import Drivermanager.Drivermanager;
import Helper.Action;
import Helper.Assertion;
import Helper.Datas;
import Helper.Services;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BusinessListScreen {
    private By add_businessBtn = By.xpath("//android.widget.ImageView[contains(@content-desc,'Add Business')]");
    private By business_nameTextBox = By.xpath(" //android.widget.EditText[@hint='Business Name']");
    private By saveBtn = By.xpath("//android.widget.Button[@content-desc='Save']");
    private static BusinessListScreen businessListScreen;
    private By warningPopupMsg_emptyBusinessTxtBox = By.xpath("//android.view.View[@content-desc='Please enter your business name.']");
    private By warningPopupMsg_singleChar = By.xpath("//android.view.View[@content-desc='Business name should be between 2 and 30 characters.']");
    private WebDriverWait wait;
    private By business_profilePicture = By.xpath("//android.widget.ImageView");
    private By profilePicture_selectOption = By.xpath("//android.view.View[@content-desc='Choose from gallery']");
    private By image_1 = By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.providers.media.module:id/icon_thumbnail'])[1]");
    private By image_saveBtn = By.xpath("//android.widget.Button[@content-desc='Crop']");

    private String business_name = "";

    private BusinessListScreen() {

    }

    public static BusinessListScreen getInstance() {
        if (businessListScreen == null) {
            businessListScreen = new BusinessListScreen();
            return businessListScreen;
        } else {
            return businessListScreen;
        }
    }

    public void clickAddBusinessBtn() {
        wait = new WebDriverWait(Drivermanager.getInstance().getDriver(), Duration.ofSeconds(10));
        Services.getInstance().loader();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Add Business"))).click();
        //System.out.println(Drivermanager.getInstance().getDriver().getPageSource());
    }

    public void enterBusinessname(boolean singletxt) {
        Drivermanager.getInstance().getDriver().findElement(business_nameTextBox).click();
        if (singletxt) {
            Action.getInstance().type("T");
        } else {
            this.business_name = Services.getInstance().getBusinessName();

            Action.getInstance().type(this.business_name);
        }
    }

    public void clickSaveBtn() {
        wait = new WebDriverWait(Drivermanager.getInstance().getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }

    public void verifyWarningMsgForEmptyBusinessNameTextBox() {
        wait = new WebDriverWait(Drivermanager.getInstance().getDriver(), Duration.ofSeconds(30));
        String actual_errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Please enter your business name."))).getAttribute("content-desc");
        Assertion.getInstance().verifyText(actual_errorMsg, Datas.addBusinessTextBoxErrorMsg.error_msg1.getErrorMsg());
    }

    public void verifyWarningMsgForEnterSingleCharInBusinessNameTextBox() {
        wait = new WebDriverWait(Drivermanager.getInstance().getDriver(), Duration.ofSeconds(30));
        String actual_errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(warningPopupMsg_singleChar)).getAttribute("content-desc");
        Assertion.getInstance().verifyText(actual_errorMsg, Datas.addBusinessTextBoxErrorMsg.error_msg2.getErrorMsg());
    }

    public void clickBusinessnameImageIcon() {
        Drivermanager.getInstance().getDriver().findElement(business_profilePicture).click();
    }

    public void clickImageSelectOption() {
        Drivermanager.getInstance().getDriver().findElement(profilePicture_selectOption).click();
    }

    public void selectImage() {
        Drivermanager.getInstance().getDriver().findElement(image_1).click();
        Drivermanager.getInstance().getDriver().findElement(image_saveBtn).click();
    }

    public void verifyBusinessNameInBusinessListScreen() {
        Services.getInstance().loader();
        String businessName = Drivermanager.getInstance().getDriver()
                .findElement(By.xpath("//android.widget.ImageView[contains(@content-desc, '" + this.business_name + "')]"))
                .getAttribute("content-desc");

        if (businessName.indexOf(this.business_name) != -1) {
            System.out.println("Business name sucessfully added");
        } else {
            System.out.println("not added");
        }
    }

    public void clickNewlyCreatedBusiness() {
        Services.getInstance().loader();
        Drivermanager.getInstance().getDriver()
                .findElement(By.xpath("//android.widget.ImageView[contains(@content-desc, '" + this.business_name + "')]"))
                .click();
    }

    public void clickExistingBusiness() {
        Services.getInstance().loader();
        List<WebElement> list_element = Drivermanager.getInstance().getDriver().findElements(By.xpath("//android.widget.ImageView"));

        for (WebElement w : list_element) {
            String s = w.getAttribute("content-desc");
            if (!s.isEmpty() && !s.equalsIgnoreCase("null")) {
                w.click();
                break;
            }
        }
    }
}
