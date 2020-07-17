package Base;

import constants.General_Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class BaseTest implements General_Constants {
    public WebDriver driver;
    public static String BrowserName;
    public WebDriver getDriver(){return driver;}
    @BeforeMethod
    @Parameters("browser")
    public void setup(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            this.BrowserName = browserName;
            System.setProperty(CHROME_DRIVER_NAME,CHROME_DRIVER_PATH);
            driver =new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty(FIREFOX_DRIVER_NAME,FIREFOX_DRIVER_PATH);
            driver =new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty(IE_DRIVER_NAME,IE_DRIVER_PATH);
            driver =new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();
        driver.navigate().to(URL_ILAB);
    }


    @AfterMethod
    public void tearDown(ITestResult result ){

        driver.quit();
    }

}
