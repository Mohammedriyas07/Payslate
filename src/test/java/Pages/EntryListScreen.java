package Pages;

import Drivermanager.Drivermanager;
import Helper.Action;
import Helper.Datas;
import Helper.Services;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.ja.但し;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class EntryListScreen {
    private static EntryListScreen entryListScreen;
    private By cashEntry = By.xpath("//android.widget.ImageView[contains(@content-desc, 'Cash In') and contains(@content-desc, 'Cash Out')]");
    private By addCashEntryBtn = By.xpath("//android.widget.ImageView[@content-desc='Add Cash Book Entry']");
    private By cashInBtn = By.xpath("//android.widget.Button[@content-desc='+ CASH IN']");
    private By enterAmount_textBox = By.xpath("//android.widget.EditText[contains(@hint,'Enter Amount')]");
    private By remark_textBox = By.xpath("//android.view.View[@text='No Category']/parent::android.view.View/android.widget.ImageView[2]");
    private By catergoryDropDown = By.xpath("//android.view.View[@text='No Category']");
    private By categoryOption = By.xpath("//android.view.View[@content-desc='Profit']");
    private By attachmentBtn = By.xpath("//android.view.View[@content-desc='Attach Image or PDF']");
    private By imageLocation = By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]");
    private By cashOutBtn = By.xpath("//android.widget.Button[@content-desc='- CASH OUT']");
    private By paymentMode_showmore = By.xpath("//android.widget.ImageView[@content-desc='Show More']");
    private By paymentMode_AddBtn = By.xpath("//android.widget.ImageView[@content-desc='Add Payment Mode']");
    private By paymentMode_enterText = By.xpath("//android.widget.EditText[@hint='Enter your payment mode']");
    private By paymentMode_createBtn = By.xpath("//android.widget.Button[@content-desc='Create']");
    private By materialEntry = By.xpath("//android.widget.ImageView[contains(@content-desc, 'Material In') and contains(@content-desc, 'Material Out')]");
    private By cashEntryCount = By.xpath("//android.view.View[contains(@content-desc, 'Cash In') or contains(@content-desc, 'Cash Out')]");
    private By addMaterialBookEntryBtn = By.xpath("//android.widget.ImageView[contains(@content-desc,'Add Material Book Entry')]");
    private By materailBuybtn = By.xpath("//android.widget.Button[@content-desc='Buy']");
    private By materialNameTextField = By.xpath("//android.widget.ImageView[contains(@hint,'Material Name')]");
    private By materialQuantityTextField = By.xpath("//android.widget.ImageView[contains(@hint,'Quantity')]");
    private By materialPricePerUnitTextField = By.xpath("//android.widget.ImageView[contains(@hint,'Price Per Unit')]");
    private By materiaTotalPrice = By.xpath("//android.widget.ImageView[@hint='Total' and @focusable='true']");
    private By materialSellBtn = By.xpath("//android.widget.Button[@content-desc='Sell']");
    private By addCategoryBtn = By.xpath("//android.widget.ImageView[@content-desc='Add Category']");
    private By newCategoryTextBox = By.xpath("//android.widget.EditText[@hint='Item Name']");
    private By nextBtn = By.xpath("//android.widget.Button[@content-desc='Next']");
    private By doneBtn=By.xpath("//android.widget.Button[@content-desc='Done']");
    
    private EntryListScreen() {

    }

    public static EntryListScreen getInstance() {
        if (entryListScreen == null) {
            entryListScreen = new EntryListScreen();
            return entryListScreen;
        } else {
            return entryListScreen;
        }
    }

    public void clickCashEntry() {
        WebElement element = Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(cashEntry));
        element.click();
    }

    public void clickAddCashEntryBtn() {
        WebElement btn = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(addCashEntryBtn));
        btn.click();
    }

    public void clickCashInBtn() {
        WebElement btn = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(cashInBtn));
        btn.click();
    }

    public void clickCashOutBtn() {
        WebElement btn = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(cashOutBtn));
        btn.click();
    }

    public void EnterAmount() {
        WebElement textBox = Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(enterAmount_textBox));
        textBox.click();
        Action.getInstance().type(String.valueOf(Services.getInstance().randomNumberGenerator()));
    }

    public void EnterRemark() {
        WebElement textBox = Drivermanager.getInstance().getDriver().findElement(remark_textBox);
        textBox.click();
        Action.getInstance().type(Datas.remarks.cashRemark.getRemark() + " " + Services.getInstance().randomNumberGenerator());
    }

    public void clickCategoryDropdown() {
        Drivermanager.getInstance().getDriver().findElement(catergoryDropDown).click();
    }

    public void selectCategoryOption() {
        WebElement option = Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(categoryOption));
        option.click();
    }

    public void selectAttachments() {
        By attachmentBtnPlus = By.xpath("//android.view.View[contains(@content-desc, 'File supported')]/preceding-sibling::android.view.View[@clickable='true' and not(@text='Profit')][last()]");
        //Drivermanager.getInstance().getDriver().findElement(attachmentBtn).click();
        WebElement attachment = Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(attachmentBtn));
        attachment.click();
        WebElement img = Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(imageLocation));
        img.click();
        for (int i = 0; i < 2; i++) {
            // System.out.println(Drivermanager.getInstance().getDriver().getPageSource());
            WebElement attachmentPlus = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(attachmentBtnPlus));
            attachmentPlus.click();
            WebElement img2 = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(imageLocation));
            img2.click();
        }
    }

    public void selectAttachmentsForMaterialEntry() {
        By attachmentBtnPlus = By.xpath("(//android.view.View[contains(@content-desc,'File supported')]/preceding-sibling::android.view.View)[last()]");
        //Drivermanager.getInstance().getDriver().findElement(attachmentBtn).click();
        WebElement attachment = Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(attachmentBtn));
        attachment.click();
        WebElement img = Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(imageLocation));
        img.click();
        for (int i = 0; i < 2; i++) {
            System.out.println(Drivermanager.getInstance().getDriver().getPageSource());
            WebElement attachmentPlus = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(attachmentBtnPlus));
            attachmentPlus.click();
            WebElement img2 = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(imageLocation));
            img2.click();
        }
    }

    public void clickShowMoreBtn() {
        WebElement showMoreBtn = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(paymentMode_showmore));
        showMoreBtn.click();
    }

    public void clickPaymentMode_AddBtn() {
        WebElement btn = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(paymentMode_AddBtn));
        btn.click();
    }

    public void enterPaymentModeText() {
        WebElement element = Drivermanager.getInstance().getDriver().findElement(paymentMode_enterText);
        element.click();
        Action.getInstance().type("paypal " + Services.getInstance().randomNumberGenerator());
    }

    public void clickpaymentModeCreateBtn() {
        WebElement btn = Drivermanager.getInstance().getDriver().findElement(paymentMode_createBtn);
        btn.click();
    }

    public void clickMaterialEntry() {
        WebElement btn = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(this.materialEntry));
        btn.click();
    }

    public void checkCashCountInCashListScreen() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<WebElement> list = Services.getInstance().waiter().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cashEntryCount));
        int listCount = list.size();
        AppiumDriver driver = Drivermanager.getInstance().getDriver();
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        } else {
            driver.navigate().back();
        }

        WebElement element = Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(cashEntry));
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String text = element.getAttribute("content-desc");
        String cashCount = text.substring(text.lastIndexOf("Total entries:") + "Total entries:".length());

        Assert.assertEquals(listCount, Integer.parseInt(cashCount.trim()));
    }

    public void clickAddMaterialButton() {
        WebElement btn = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(this.addMaterialBookEntryBtn));
        btn.click();
    }

    public void clickMaterialBuyButton() {
        WebElement btn = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(this.materailBuybtn));
        btn.click();
    }

    public void enterMaterialName() {
        WebElement element = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(this.materialNameTextField));
        element.click();
        Action.getInstance().type("steel " + Services.getInstance().randomNumberGenerator());
    }

    private String quantity;
    private String pricePerUnit;

    public void enterMaterialQuantity() {
        WebElement element = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(this.materialQuantityTextField));
        element.click();
        this.quantity = Integer.toString(Services.getInstance().randomNumberGenerator() / 2);
        Action.getInstance().type(this.quantity);
    }

    public void enterMaterialPricePerUnit() {
        WebElement element = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(this.materialPricePerUnitTextField));
        element.click();
        this.pricePerUnit = Integer.toString(Services.getInstance().randomNumberGenerator() / 2);
        ;
        Action.getInstance().type(this.pricePerUnit);
    }

    public void validateMaterialTotal() {
        long t = Integer.parseInt(this.quantity) * Integer.parseInt(this.pricePerUnit);
        WebElement element = Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(this.materiaTotalPrice));
        String v = element.getAttribute("text");
        Assert.assertEquals(v.replaceAll(",", ""), Long.toString(t));
    }

    public void clickMaterialSellBtn() {
        WebElement btn = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(this.materialSellBtn));
        btn.click();
    }

    public void clickAddCategoryBtn() {
        WebElement btn = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(this.addCategoryBtn));
        btn.click();
    }

    public void enterNewCategory() {
        WebElement textbox = Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(this.newCategoryTextBox));
        textbox.click();
        Action.getInstance().type(Datas.category.category1.getCategory());
//        AppiumDriver driver = Drivermanager.getInstance().getDriver();
//        if (driver instanceof AndroidDriver) {
//            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
//        } else {
//            driver.navigate().back();
//        }

    }

    public void clickNextBtn() {
        WebElement btn = Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(this.nextBtn));
        btn.click();
    }
    public void selectIconForCategory()
    {
        Random ran=new Random();
        int i= ran.nextInt(10);
        String xpath="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ImageView["+i+"]";
       WebElement element= Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
       element.click();

    }
    public void clickDoneBtn()
    {
        Drivermanager.getInstance().getDriver().findElement(this.doneBtn).click();
    }
}
