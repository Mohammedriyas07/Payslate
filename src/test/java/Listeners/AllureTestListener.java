package Listeners;

import Drivermanager.Drivermanager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;


public class AllureTestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) Drivermanager.getInstance().getDriver();
            byte[] bytes = screenshot.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
