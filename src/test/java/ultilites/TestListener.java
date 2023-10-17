package ultilites;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        Log.info("----Test Suite " + context.getName() + " started----");
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("----Test Suite " + context.getName() + " ending----\n\n\n");
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("----Running Test Method " + result.getMethod().getMethodName() +  "----");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Executed " + result.getMethod().getMethodName() +  " test successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("Executed " + result.getMethod().getMethodName() +  " test failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("Test Method " + result.getMethod().getMethodName() +  " skipped");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        Log.info("Executed " + result.getMethod().getMethodName() +  " test failed (time out)");
    }



}
