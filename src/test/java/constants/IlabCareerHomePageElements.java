package constants;

import org.openqa.selenium.By;

public interface IlabCareerHomePageElements extends General_Constants {
    public String txtHomePageTitle = "Home Page | iLAB";
    public String txtCareerPageTitle = "CAREERS | iLAB";
    public String txtSAPageTitle = "SOUTH AFRICA | iLAB";

    public By CareerPage = By.xpath("//li[@id='menu-item-1373']//a[contains(text(),'CAREERS')]");
    public By JobsinSA =By.linkText("South Africa");

}
