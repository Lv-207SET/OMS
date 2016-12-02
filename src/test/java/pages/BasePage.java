package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    final private String LOGOUT_BUTTON_CSS = ".spec a";
    final private String OMS_LABEL_CSS = "#logo h1";
    final private String SIMPLE_SLIM_GENIUS_LABEL_CSS = "#logo h2";
    final private String INSPIRED_BY_GOOGLE_LINK_CSS = "#footer a";
    final private String USER_INFO_LINK_CSS = "[href=\"/OMS/userInfo.htm\"]";

    protected WebDriver driver;
    protected WebElement linkUserInfo;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.linkUserInfo = driver.findElement(By.cssSelector(USER_INFO_LINK_CSS));
    }

    public void clickLogoutButton(){
         driver.findElement(By.cssSelector(LOGOUT_BUTTON_CSS))
                 .click();
    }

    public UserInfoPage clickUserInfo(){
        linkUserInfo.click();
        return new UserInfoPage(driver);
    }

    public WebElement getOmsLabel(){
        return driver.findElement(By.cssSelector(OMS_LABEL_CSS));
    }

    public WebElement getSimpleSlimGeniusLabel(){
        return driver.findElement(By.cssSelector(SIMPLE_SLIM_GENIUS_LABEL_CSS));
    }

    public WebElement getInspiredByGoogleLink(){
        return driver.findElement(By.cssSelector(INSPIRED_BY_GOOGLE_LINK_CSS));
    }

}
