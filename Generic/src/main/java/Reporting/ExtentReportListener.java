package Reporting;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    ExtentReports listenerExtent = ExtntRprts.ExtentReportGenerator();
    ExtentTest listenerExtentTestLogger = ExtntRprts.ExtentTestlogger;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        listenerExtentTestLogger = listenerExtent.startTest(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        listenerExtentTestLogger.log(LogStatus.PASS, iTestResult.getMethod().getMethodName()+"has passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        listenerExtent.endTest(listenerExtentTestLogger);
    }
}
