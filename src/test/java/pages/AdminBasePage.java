package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AdminBasePage extends BasePage{
    private WebDriver driver;
    final private String ADMINISTRATION_TAB_XPATH = "(.//*[@id='nav']//a)[1]";
    final private String USERINFO_TAB_XPATH = "(.//*[@id='nav']//a)[2]";

    public AdministrationPage clickOnAdministrationTab(){
        WebElement administrationTab = driver.findElement(By.xpath(ADMINISTRATION_TAB_XPATH));
        administrationTab.click();
        return new AdministrationPage();
    }

    public UserInfoPage clickOnUserInfoTab(){
        WebElement userInfoTab = driver.findElement(By.xpath(USERINFO_TAB_XPATH));
        userInfoTab.click();
        return new UserInfoPage(driver);
    }


}
