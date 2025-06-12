package Pages;

import Drivermanager.Drivermanager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class Splash_screen {
    private static Splash_screen splashScreen;
    private By getStartedBtn = By.xpath("//android.widget.Button[@content-desc='Get Started']");

    private Splash_screen() {}

    public static Splash_screen getInstance() {
        if (splashScreen == null) {
            splashScreen = new Splash_screen();
        }
        return splashScreen;
    }

    public void tap() {
        AppiumDriver driver = Drivermanager.getInstance().getDriver();

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        int x = (int) (width * 0.9);  // right side
        int y = height / 2;           // center vertically

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        for (int i = 0; i < 3; i++) {
            final String beforePageSource = driver.getPageSource();

            driver.perform(Collections.singletonList(tap));

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(d -> !d.getPageSource().equals(beforePageSource));

            System.out.println("Tap #" + (i + 1) + " completed.");
        }
    }

    public void click_getStartedBtn() {
        Drivermanager.getInstance().getDriver().findElement(getStartedBtn).click();
    }
}
