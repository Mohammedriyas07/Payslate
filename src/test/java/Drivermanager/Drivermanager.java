package Drivermanager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


import java.time.Duration;

public class Drivermanager {
    private static Drivermanager drivermanager;
    private static ThreadLocal<AndroidDriver> appiumDriver = null;

    private Drivermanager() {}

    public static Drivermanager getInstance() {
        if (drivermanager == null) {
            drivermanager = new Drivermanager();
            appiumDriver=new ThreadLocal<>();
        }
        return drivermanager;
    }

    public void setDriver(AndroidDriver androidDriver) {

        System.out.println(androidDriver+ " ---------");


        appiumDriver.set(androidDriver);
    }

    public AppiumDriver getDriver() {
        if (appiumDriver.get() == null || appiumDriver.get().getSessionId() == null) {
            throw new IllegalStateException("Driver session is invalid or has been quit.");
        }
        appiumDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return appiumDriver.get();
    }


    public void quitDriver() {
        if (appiumDriver.get() != null) {
            appiumDriver.get().quit();
            appiumDriver.remove();
        }
    }
}
