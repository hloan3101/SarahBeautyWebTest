package ultilites;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static final ExtentReports extendReports = new ExtentReports();

    public synchronized static ExtentReports getExtendReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/ExtentReport.html");

        reporter.config().setReportName("Sarah Beauty Web Test Extent Report");
        extendReports.attachReporter(reporter);
        extendReports.setSystemInfo("Framework Name", "Selenium Java Framework");
        extendReports.setSystemInfo("Author", "Sarah");

        return extendReports;
    }
}
