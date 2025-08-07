package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class AllureTestListener implements ITestListener {
    public static boolean r;
    @Override
    public void onTestFailure(ITestResult result) {
       r=result.isSuccess();
    }
}
