package Helper;

import Drivermanager.Drivermanager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Services {
    private static Services service;
    private Services()
    {

    }
    public static Services getInstance()
    {
        if (service==null)
        {
            service=new Services();
            return service;
        }
        else {
            return service;
        }
    }
    public int randomNumberGenerator()
    {
        Random random=new Random();
       return 17 * random.nextInt(10000);
    }
    public  String getBusinessName()
    {
        return "Jack"+LocalDateTime.now().getMonth().toString()+" "+randomNumberGenerator();
    }
    public  String getBookName()
    {
        return "Hotel"+LocalDateTime.now().getMonth().toString()+" "+randomNumberGenerator();
    }
    public void loader()
    {
       WebDriverWait wait=new WebDriverWait(Drivermanager.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//android.view.View[@content-desc='Loading...']")
        ));
    }
    public WebDriverWait waiter()
    {
        WebDriverWait wait=new WebDriverWait(Drivermanager.getInstance().getDriver(), Duration.ofSeconds(30));
        return wait;
    }
}
