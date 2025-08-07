package Retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int limit=1;
    int count =0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count<limit && !iTestResult.isSuccess())
        {
            count ++;
            return true;
        }
        return false;
    }
}
