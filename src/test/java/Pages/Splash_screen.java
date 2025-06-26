package Pages;

import Drivermanager.Drivermanager;
import Helper.Services;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class Splash_screen {
    private static Splash_screen splashScreen;
    private By getStartedBtn = By.xpath("//android.widget.Button[@content-desc='Get Started']");
    private By splashScreen1=By.xpath("//android.view.View[contains(@content-desc,'Payslate: Your Financial Chalkboard')]");

    private Splash_screen() {}

    public static Splash_screen getInstance() {
        if (splashScreen == null) {
            splashScreen = new Splash_screen();
        }
        return splashScreen;
    }

    public void tap() {
        AppiumDriver driver = Drivermanager.getInstance().getDriver();

        // Optional safe wait, or remove if not reliable
        try {
            Services.getInstance().waiter()
                    .until(ExpectedConditions.presenceOfElementLocated(splashScreen1));
        } catch (Exception e) {
            System.out.println("Skipping wait for splash screen.");
        }

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        int x = (int) (width * 0.9);
        int y = height / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        for (int i = 0; i < 2; i++) {
            String beforePageSource = driver.getPageSource();
            driver.perform(Collections.singletonList(tap));

            try {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(d -> !d.getPageSource().equals(beforePageSource));
            } catch (TimeoutException e) {
                System.out.println("No UI change after tap #" + (i + 1) + ", may be expected.");
            }

            System.out.println("Tap #" + (i + 1) + " completed.");
        }

    }


    public void click_getStartedBtn() {
        //Drivermanager.getInstance().getDriver().findElement(getStartedBtn).click();
        WebElement btn=Services.getInstance().waiter().until(ExpectedConditions.elementToBeClickable(getStartedBtn));
        btn.click();
    }
}
