package constants;

public interface General_Constants {
    String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
    String CHROME_DRIVER_PATH= "src/test/resources/drivers/chromedriver";

    String FIREFOX_DRIVER_NAME = "webdriver.gecko.driver";
    String FIREFOX_DRIVER_PATH= "src\\test\\resources\\drivers\\geckodriver.exe";

    String IE_DRIVER_NAME = "webdriver.ie.driver";
    String IE_DRIVER_PATH= "src\\test\\resources\\drivers\\IEDriverServer.exe";

    String validEmail = "automationAssessment@iLABQuality.com";
    String validname = "jeannick" ;
    String ValidText = "There are errors in your form." ;
    String URL_ILAB = "https://www.ilabquality.com";
    String ProjectPath = System.getProperty("user.dir");
    String ExcelPath = ProjectPath + "/src/test/resources/TestData/TestData1.xlsx";
    String SheetName ="TestData01";
}
