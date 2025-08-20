package Pages;

import Drivermanager.Drivermanager;
import Helper.Action;
import Helper.Services;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.Provider;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookListScreen {
    private static BookListScreen  bookListScreen;
    private By addBookBtn=By.xpath("//android.widget.ImageView[@content-desc='Add Book']");
    private By bookNameTextBox=By.xpath("//android.widget.EditText");
    private By currencyType=By.xpath("//*[contains(@content-desc, 'Indian Rupee')]");
    private final Map<String,String> transactionType=new HashMap<>();
    private String currentBusinessName;
    private By allBusinessbtn=By.xpath("//android.widget.Button[contains(@content-desc,'All Businesses')]");
    private By bookList=By.xpath("//android.widget.ImageView[contains(@content-desc,'Cash entries') or contains(@content-desc,'Material entries')]/android.widget.ImageView");
    private By bookSettingsBtn=By.xpath("//android.widget.ImageView[contains(@content-desc,'Book Settings')]");
    private By bookSettingsEditIcon=By.xpath("//android.view.View[@content-desc='Book Name']/android.widget.ImageView");
    private By bookSettingsTextBox=By.xpath("//android.view.View[contains(@content-desc,'Book Name')]/android.widget.EditText");
    private By bookSettingsSaveBtn=By.xpath("//android.view.View[contains(@content-desc,'Book Settings Save')]");
    private BookListScreen()
    {
        transactionType.put("all","//android.widget.RadioButton[contains(@content-desc, 'All')]");
        transactionType.put("cash","//android.widget.RadioButton[contains(@content-desc, 'Cash') and not(contains(@content-desc, 'All'))]");
        transactionType.put("material","//android.widget.RadioButton[contains(@content-desc, 'Material') and not(contains(@content-desc, 'All'))] ");
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
    private String bookName;
    public void enterBookname()
    {
        //Drivermanager.getInstance().getDriver().findElement(this.bookNameTextBox).click();
       WebElement txtbox= Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(this.bookNameTextBox));
       txtbox.click();
        this.bookName=Services.getInstance().getBookName();
       // Action.getInstance().type(this.bookName);
        txtbox.sendKeys(this.bookName);
      WebElement e=Drivermanager.getInstance().getDriver().findElement(By.xpath("//android.view.View[@content-desc='Business Book']"));
e.click();
       // ((AndroidDriver) Drivermanager.getInstance().getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));

    }
   public void selectTransactionType(String transactionType)
   {


       for (String key :this.transactionType.keySet())
       {
           if (transactionType.equalsIgnoreCase(key))
           {
             WebElement element=  Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(By.xpath(this.transactionType.get(key))));
             element.click();
             break;
           }
       }
   }
   public void verifyBookName()
   {
       String xpath = "//android.widget.ImageView[contains(@content-desc,'" + this.bookName + "')]";
       WebElement element=Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
      String book= element.getAttribute("content-desc");
      if (book.indexOf(this.bookName)!=-1)
      {
          System.out.println("book successfully added");
      }
      else {
          throw new RuntimeException("book not added in book list screen");
      }

   }

   public void verifyBookCountInBusinessListScreen()
   {
      int bookCount =Drivermanager.getInstance().getDriver().findElements(By.xpath("//android.view.View/android.widget.ImageView[contains(@content-desc,'Updated')]")).size();
      String b_path="//android.view.View[contains(@content-desc,'"+ LocalDateTime.now().getMonth().toString()+"')]";
      this.currentBusinessName=Drivermanager.getInstance().getDriver().findElement(By.xpath(b_path)).getAttribute("content-desc");
       System.out.println("current business name ="+this.currentBusinessName+ " book count ="+bookCount);
       AppiumDriver driver = Drivermanager.getInstance().getDriver();
       if (driver instanceof AndroidDriver) {
           ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
       } else {
           driver.navigate().back();
       }

       String customizedBusinessNamePath="//android.widget.ImageView[contains(@content-desc,'"+this.currentBusinessName+"')]";
           Services.getInstance().loader();

       WebElement element=Services.getInstance().waiter().ignoring(UnsupportedCommandException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customizedBusinessNamePath)));
       String businessDetails=element.getAttribute("content-desc");
       String prefix = "Books";
       int index = businessDetails.lastIndexOf(prefix);
       if (index == -1) {
           throw new RuntimeException("Expected string not found in content-desc");
       }
       String remainder = businessDetails.substring(index+5);
       if (Integer.toString(bookCount).equalsIgnoreCase(remainder.trim())) {
           System.out.println("Book count matched");
       } else {
           System.out.println("count not matched"+" book count= "+bookCount+", reminder = "+remainder);
       }

   }

   public void clickBookName()
   {

       String xpath = "//android.widget.ImageView[contains(@content-desc,'" + this.bookName + "')]";
       WebElement element=Drivermanager.getInstance().getDriver().findElement(By.xpath(xpath));
       element.click();
   }
   public void clickAllBusinessBtn()
   {
    WebElement btn=Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(this.allBusinessbtn));
    btn.click();
   }
   public void clickTheExistingBook()
   {
     List<WebElement> booklist=  Services.getInstance().waiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(bookList));
     if (!booklist.isEmpty())
     {
         for (WebElement book:booklist)
         {
             book.click();
             break;
         }
     }
     else {
         throw new RuntimeException("book list is empty");
     }
   }
   public void clickBookSettingsBtn()
   {
       WebElement bookSettings=Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(this.bookSettingsBtn));
       bookSettings.click();
   }
   public void clickBookSettingsEditIcon()
   {
      WebElement editIcon= Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(this.bookSettingsEditIcon));
      editIcon.click();
   }
   private String updatedBookName;
   public void updateBookName()
   {
       WebElement textBox=Drivermanager.getInstance().getDriver().findElement(this.bookSettingsTextBox);
       textBox.clear();
       this.updatedBookName=Services.getInstance().getBookName();
       textBox.sendKeys(this.updatedBookName);
   }
   public void clickBookSettingsSaveBtn()
   {
    WebElement saveBtn=Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(this.bookSettingsSaveBtn));
    saveBtn.click();
   }
   public void verifyUpdatedBookNameInBookListScreen()
   {
       String path="//android.widget.ImageView[contains(@content-desc,'"+this.updatedBookName+"')]";
       try
       {
           Services.getInstance().waiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
       }
       catch (Exception e)
       {
           throw new RuntimeException(e.getMessage() +" : path =  "+path);
       }
   }
}
