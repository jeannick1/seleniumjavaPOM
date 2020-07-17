package page;

import Base.BaseTest;
import constants.IlabCareerHomePageElements;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.BasePageUtil;

import java.io.IOException;

public class IlabCareerHomePage extends BasePageUtil implements IlabCareerHomePageElements {
    public IlabCareerHomePage(WebDriver driver) throws IOException {
        super(driver);
    }
    public IlabJobPage callCareerPage() throws IOException {

        Assert.assertTrue(getTitle().equals(txtHomePageTitle));
        click(CareerPage);
        Assert.assertTrue(getTitle().equals(txtCareerPageTitle));
        find(JobsinSA).click();
        Assert.assertTrue(getTitle().equals(txtSAPageTitle));
        return new IlabJobPage(driver);
    }
}
