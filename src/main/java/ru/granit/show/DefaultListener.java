package ru.granit.show;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DefaultListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {
        if (iTestResult.getThrowable() != null)
            TestLogger.get().getLogger().error("There is error in test:", iTestResult.getThrowable());
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
