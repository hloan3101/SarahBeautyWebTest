package ultilities;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public String getTestName (ITestResult result){
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription (ITestResult result){
        return result.getMethod().getDescription() !=null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext context) {
        Log.info("----Test Suite " + context.getName() + " is starting----");
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("----Test Suite " + context.getName() + " is ending----\n\n\n");

        ExtentManager.getExtendReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("----Running Test Method " + result.getMethod().getMethodName() +  "----");

        ExtentTestManager.saveToReport(result.getName(), result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Executed " + result.getMethod().getMethodName() +  " test is passed");

        ExtentTestManager.logMessage(Status.PASS, getTestDescription(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("Executed " + getTestName(result) +  " test failed");

        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + "is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("Test Method " + result.getMethod().getMethodName() +  "is skipped");

        ExtentTestManager.logMessage(Status.SKIP, getTestName(result) + " test is skipped.");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        Log.error("Test failed but it is in defined success ratio " + getTestName(result));

        ExtentTestManager.logMessage("Test failed but it is in defined success ratio " + getTestName(result));
    }
}
