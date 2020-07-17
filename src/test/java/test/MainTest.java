package test;

import Base.BaseTest;
import Base.TestListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.IlabCareerHomePage;
import util.ExcelDataProvider;
import util.ExcelUtils;
import java.io.IOException;


@Listeners({TestListener.class})
public class MainTest extends BaseTest {

    @Test(dataProvider = "testData",dataProviderClass = ExcelDataProvider.class)
    public void MainTest(String Name,String Email) throws IOException {
        new IlabCareerHomePage(driver)
                .callCareerPage()
                .IlabJobPage( Name, Email);

    }
}
