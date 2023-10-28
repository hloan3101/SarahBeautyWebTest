package ultilites;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extendTestMap = new HashMap<>();
    static ExtentReports extendReports = ExtentManager.getExtendReports();

    public static ExtentTest getTest (){
        return extendTestMap.get((int) Thread.currentThread().getId());
    }

    public static  synchronized  ExtentTest saveToReport (String testName, String desc){
        ExtentTest test = extendReports.createTest(testName, desc);
        extendTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }

    public static void logMessage (String message){
        getTest().log(Status.INFO, message);
    }

    public static void logMessage (Status status, String message){
        getTest().log(status, message);
    }
}
