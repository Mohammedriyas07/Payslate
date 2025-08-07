package Hooks;

import Drivermanager.Drivermanager;
import Listeners.AllureTestListener;
import Util.Util;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    @Before
    public void setup()
    {
        System.out.println(Util.getInstance().getApp_location());
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Util.getInstance().getPlatform_name());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Util.getInstance().getPlatform_version());
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Util.getInstance().getDevice_name());
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, Util.getInstance().getAutomation_name());
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, Util.getInstance().getApp_location());
        desiredCapabilities.setCapability("appPackage", Util.getInstance().getApp_package());
        desiredCapabilities.setCapability("appActivity", Util.getInstance().getApp_activity());
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("appWaitForLaunch", true);
        desiredCapabilities.setCapability("appWaitActivity", "*");

        try {
            Drivermanager.getInstance().setDriver(new AndroidDriver(new URL(Util.getInstance().getHost_url()), desiredCapabilities));
            System.out.println("Driver started with session ID: " + Drivermanager.getInstance().getDriver().getSessionId());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    @After
    public void tearDown()
    {
        if (!AllureTestListener.r)
        {
            TakesScreenshot screenshot = (TakesScreenshot) Drivermanager.getInstance().getDriver();
            byte[] bytes = screenshot.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(bytes));
            AllureTestListener.r=true;
        }
        Drivermanager.getInstance().quitDriver();
    }
}
