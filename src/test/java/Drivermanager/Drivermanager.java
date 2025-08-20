package Drivermanager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class Drivermanager {
    private static Drivermanager drivermanager;
    private static ThreadLocal<AppiumDriver> appiumDriver = null;

    private Drivermanager() {}

    public static Drivermanager getInstance() {
        if (drivermanager == null) {
            drivermanager = new Drivermanager();
            appiumDriver = new ThreadLocal<>();
        }
        return drivermanager;
    }

    public void setDriver(AppiumDriver driver) {
        System.out.println("Driver initialized: " + driver);
        appiumDriver.set(driver);
    }

    public AppiumDriver getDriver() {
        if (appiumDriver.get() == null || appiumDriver.get().getSessionId() == null) {
            throw new IllegalStateException("Driver session is invalid or has been quit.");
        }
        // Optional: set implicit wait globally
        // appiumDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return appiumDriver.get();
    }

    public void quitDriver() {
        if (appiumDriver.get() != null) {
            appiumDriver.get().quit();
            appiumDriver.remove();
        }
    }
}
