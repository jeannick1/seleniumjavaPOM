package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends BaseTest {

      public static ExtentReports extent;
   // public ExtentTest test;
    public static ExtentReports Reporting(){
        ExtentSparkReporter htmlReporter;
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/src/test/Results/Screenshots/html/Report.html");
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Ilab Test");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Hostname","LocalHost");
        extent.setSystemInfo("OS","Windows 7");
        extent.setSystemInfo("Tester Name", "Jeannick kabangu");
        extent.setSystemInfo("browser",BrowserName);
        return extent;

    }




}
