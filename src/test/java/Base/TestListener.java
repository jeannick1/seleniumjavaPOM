package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import test.MainTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestListener extends BaseTest implements ITestListener {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(MainTest.class.getName());
    ExtentReports extent =ExtentReport.Reporting();
    ExtentTest test;

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onTestStart(ITestResult iTestResult) {
        test = extent.createTest(iTestResult.getMethod().getMethodName());
        test.createNode("home page title");
        //test.createNode("home page title");
    }


    public void onTestSuccess(ITestResult result) {
          if(result.getStatus()==ITestResult.SUCCESS){
            test.log(Status.PASS,"TEST CASE PASSED IS "+result.getMethod().getMethodName());
              LOGGER.info("\"***** success " + result.getName() + " test has passed *****\"");
        }

    }


    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error " + result.getThrowable() + " test has failed *****");
        LOGGER.info("***** Error " + result.getThrowable() + " test has failed *****");
        test.fail("***** Error " + result.getThrowable() + " test has failed *****");
        String methodName = result.getName().toString().trim();
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        takeScreenShot(methodName, driver);
        if(result.getStatus()==ITestResult.FAILURE){
            test.log(Status.FAIL,"TEST CASE FAILED IS "+result.getName());
            test.log(Status.FAIL,"TEST CASE FAILED IS" + result.getThrowable());
            String ScreenshotPath = takeScreenShot(methodName, driver);

            try {
                test.addScreenCaptureFromPath(ScreenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void onTestSkipped(ITestResult result) {
         if(result.getStatus()==ITestResult.SKIP){
            test.log(Status.SKIP,"TEST CASE SKIPPED IS "+result.getName());
             LOGGER.info("***** Warning " + result.getName() + " test skipped *****");

        }
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public void onStart(ITestContext iTestContext) {

    }


    public void onFinish(ITestContext iTestContext) {
        extent.flush();

    }

     static String takeScreenShot(String methodName, WebDriver driver) {
        String timeStamp,destination;
        File screenShotName;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        destination ="src\\test\\Results\\Screenshots" + methodName + timeStamp + "fail.png";
        screenShotName = new File(destination);
        try {
            FileUtils.copyFile(scrFile, screenShotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}