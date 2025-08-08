package Pages;

import Drivermanager.Drivermanager;
import Helper.Action;
import Helper.Assertion;
import Helper.Datas;
import Helper.Services;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusinessListScreen {
    private static final Logger log = LoggerFactory.getLogger(BusinessListScreen.class);
    private By addBusinessBtn = By.xpath("//android.widget.ImageView[@content-desc='Add Business']");

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
    private By editBusiness=By.xpath("//android.widget.ImageView[@content-desc='Edit Business']");
    private String business_name = "";
    private By businessSettings=By.xpath("//android.widget.ImageView[@content-desc='Business Settings']");
    private By deleteBusiness=By.xpath("//android.widget.ImageView[contains(@content-desc,'Delete Business')]");
    private By doneBtn=By.xpath("//android.widget.Button[@content-desc='Done']");
    private By yourBusinessTxt=By.xpath("//android.view.View[contains(@content-desc,'Your Businesses')]");
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

        Services.getInstance().loader();

       try {
            Thread.sleep(1000); // Optional buffer

            WebElement btn = Services.getInstance()
                    .waiter()
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//android.widget.ImageView[@content-desc='Add Business']")));

            // Get center of element
            Point location = btn.getLocation();
            Dimension size = btn.getSize();
            int centerX = location.getX() + size.getWidth() / 2;
            int centerY = location.getY() + size.getHeight() / 2;

            // Create touch input using W3C Actions
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence tap = new Sequence(finger, 1);
            tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            // Perform the tap
            ((RemoteWebDriver) Drivermanager.getInstance().getDriver()).perform(Collections.singletonList(tap));

            System.out.println("Tapped Add Business button.");
        } catch (Exception e) {
           Services.getInstance()
                    .waiter()
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//android.widget.ImageView[@content-desc='Add Business']"))).click();
        }
    }



    public void enterBusinessname(boolean singletxt) {
        //Drivermanager.getInstance().getDriver().findElement(business_nameTextBox).click();
      WebElement textbox=  Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(business_nameTextBox));
      textbox.click();
        if (singletxt) {
            //Action.getInstance().type("T");
            textbox.sendKeys("T");
        } else {
            this.business_name = Services.getInstance().getBusinessName();

           // Action.getInstance().type(this.business_name);
            textbox.sendKeys(this.business_name);
        }
    }

    public void clickSaveBtn() {
      WebElement btn= Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(saveBtn));
        btn.click();
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
        //Drivermanager.getInstance().getDriver().findElement(profilePicture_selectOption).click();
       WebElement element= Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(profilePicture_selectOption));
      element.click();
    }

    public void selectImage() {
        //Drivermanager.getInstance().getDriver().findElement(image_1).click();
       WebElement img= Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(image_1));
       img.click();
        //Drivermanager.getInstance().getDriver().findElement(image_saveBtn).click();
       WebElement btn= Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(image_saveBtn));
       btn.click();
    }

    public void verifyBusinessNameInBusinessListScreen() {
        Services.getInstance().loader();
       WebElement element=Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.ImageView[contains(@content-desc, '" + this.business_name + "')]")));

        String businessName = element.getAttribute("content-desc");
        if (businessName.indexOf(this.business_name) != -1) {
            System.out.println("Business name sucessfully added");
        } else {
            System.out.println("not added or deleted");
        }
    }

    public void clickNewlyCreatedBusiness() {
        Services.getInstance().loader();
        Drivermanager.getInstance().getDriver()
                .findElement(By.xpath("//android.widget.ImageView[contains(@content-desc, '" + this.business_name + "')]"))
                .click();
    }
private String contentDesc;
    public void clickExistingBusiness() {
        By businessImage = By.xpath("//android.widget.ImageView[contains(@content-desc,'Created by')]");

        // Retry block for stale element handling
        for (int retry = 0; retry < 3; retry++) {
            try {
                List<WebElement> listElement = Services.getInstance().waiter()
                        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(businessImage));

                for (int i = 0; i < listElement.size(); i++) {
                    // Re-fetch elements fresh each time to avoid stale references
                    List<WebElement> freshElements = Drivermanager.getInstance().getDriver()
                            .findElements(businessImage);

                    if (i >= freshElements.size()) continue;  // Safety check

                    WebElement candidate = freshElements.get(i);

                    this.contentDesc = candidate.getAttribute("content-desc");

                    if (contentDesc != null && !contentDesc.trim().isEmpty() && !contentDesc.equalsIgnoreCase("null")) {
                        // Wait until element is clickable before clicking
                        WebElement clickable = Services.getInstance().waiter()
                                .until(ExpectedConditions.elementToBeClickable(candidate));
                        clickable.click();
                        System.out.println("Clicked on existing business with content-desc: " + contentDesc);
                        return; // Done
                    }
                }

                System.out.println("No valid business found in attempt #" + (retry + 1));
            } catch (StaleElementReferenceException sere) {
                System.out.println("StaleElementReferenceException on retry #" + (retry + 1));
            } catch (Exception e) {
                System.out.println("Unexpected exception on retry #" + (retry + 1) + ": " + e.getMessage());
                break; // Stop retrying on unknown errors
            }
        }
    }
    public void clickThreeDotsForExistingBusiness()
    {
        Services.getInstance().loader();
        By businessImage = By.xpath("//android.widget.ImageView/android.widget.ImageView");
       List<WebElement>webElementList= Services.getInstance().waiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(businessImage));
       for(int i=0;i<3;i++)
       {
           if(webElementList.size()>0)
           {
             webElementList.get(i).click();
             break;
           }

       }
    }
    public void clickEditBusiness()
    {
       WebElement element= Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(this.editBusiness));
       element.click();
    }
    String updatedBusinessName;
    public void updateBusinessName()
    {
        WebElement textbox=  Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(business_nameTextBox));
        String currentName=textbox.getAttribute("text");
        this.updatedBusinessName=currentName+Services.getInstance().randomNumberGenerator();
        textbox.click();
        textbox.clear();
       // Action.getInstance().type(this.updatedBusinessName);
        textbox.sendKeys(this.updatedBusinessName);
    }
public void verifyUpdatedBusinessNameInList()
{
    Services.getInstance().loader();
    WebElement element=Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//android.widget.ImageView[contains(@content-desc, '" + this.updatedBusinessName + "')]")));

    String businessName = element.getAttribute("content-desc");
    if (businessName.indexOf(this.business_name) != -1) {
        System.out.println("Business name sucessfully Updated");
    } else {
        System.out.println("not Updated");
    }
}
public void clickBusinessSettings()
{
    WebElement element=Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(this.businessSettings));
    element.click();
}
public void clickDeleteBusiness()
{
   WebElement element= Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(this.deleteBusiness));
   element.click();
}
public void clickDoneBtn()
{
    WebElement btn=Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(this.doneBtn));
    btn.click();
}
public void  verifyBusinessNameDeletedSuccessfully()
{
    String path="//android.widget.ImageView[contains(@content-desc, '" + this.business_name + "')]";
    Services.getInstance().loader();
Services.getInstance().waiter().until(ExpectedConditions.invisibilityOfElementLocated(
            By.xpath(path)));
    try
    {
        Drivermanager.getInstance().getDriver().findElement(By.xpath(path));
    }
    catch (Exception e)
    {
        System.out.println("Successfully deleted");
    }
}
public void clickBusinessNameDropDownInBookListScreen()
    {
        String businessName=this.contentDesc.substring(0,this.contentDesc.indexOf("Created by")).trim();
        String path= "//android.view.View[contains(@content-desc,'"+businessName+"')]";
       WebElement dropdown= Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        dropdown.click();
    }
public void verifyItIsBusinessListScreen()
{
    try
    {
        Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(this.yourBusinessTxt));
        System.out.println("landed successfully in businessList screen");
    }
    catch (Exception e)
    {
        System.out.println("not landed in in businessList screen");
    }
}
public void enterBusinessNameExceedLimit()
{
    WebElement textbox=  Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(business_nameTextBox));
    textbox.click();
  // Action.getInstance().type(Datas.businessNameTestData.data1.getData());
    textbox.sendKeys(Datas.businessNameTestData.data1.getData());
}
}
