package Pages;

import Drivermanager.Drivermanager;
import Helper.Action;
import Helper.Services;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Provider;
import java.util.HashMap;
import java.util.Map;

public class BookListScreen {
    private static BookListScreen  bookListScreen;
    private By addBookBtn=By.xpath("//android.widget.ImageView[@content-desc='Add Book']");
    private By bookNameTextBox=By.xpath("//android.widget.EditText");
    private By currencyType=By.xpath("//*[contains(@content-desc, 'Indian Rupee')]");
    private final Map<String,String> transactionType=new HashMap<>();
    private BookListScreen()
    {
        transactionType.put("all","//android.widget.RadioButton[contains(@content-desc, 'All')]");
        transactionType.put("cash","//android.widget.RadioButton[contains(@content-desc, 'Cash') and not(contains(@content-desc, 'All'))]");
        transactionType.put("material","//android.widget.RadioButton[contains(@content-desc, 'Material')]");
    }
    public static  BookListScreen getInstance()
    {
        if (bookListScreen==null)
        {
            bookListScreen=new BookListScreen();
            return  bookListScreen;
        }
        else
        {
            return bookListScreen;
        }
    }
    public void clickAddBookButton()
    {
      Services.getInstance().loader();
       WebElement btn= Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(addBookBtn));
       btn.click();
    }
    public void enterBookname()
    {
        Drivermanager.getInstance().getDriver().findElement(this.bookNameTextBox).click();
        Action.getInstance().type(Services.getInstance().getBookName());
        ((AndroidDriver) Drivermanager.getInstance().getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));


    }
   public void selectTransactionType(String transactionType)
   {
       for (String key :this.transactionType.keySet())
       {
           if (transactionType.equalsIgnoreCase(key))
           {
               Drivermanager.getInstance().getDriver().findElement(By.xpath(this.transactionType.get(key)));
           }
       }
   }
}
