package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class BasePage {

    final private String LOGOUT_BUTTON_XPATH = ".//*[@id='logout']/img";
    final private String OMS_LABEL_XPATH = ".//*[@id='logo']/h1";
    final private String SIMPLE_SLIM_GENIUS_LABEL_XPATH = ".//*[@id='logo']/h2";
    final private String INSPIRED_BY_GOOGLE_LINK_XPATH = ".//*[@id='footer']/a";
    final private String LAST_UPDATE_LABEL_XPATH = ".//*[@id='footer']/p";
    final private String USER_INFO_LINK_XPATH = ".//a[@href='userInfo.htm']";

    protected WebDriver driver;
    private WebElement linkUserInfo;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.linkUserInfo = driver.findElement(By.xpath(USER_INFO_LINK_XPATH));
    }





    public void clickLogoutButton(){
         driver.findElement(By.xpath(LOGOUT_BUTTON_XPATH))
                 .click();
    }

    public UserInfoPage clickUserInfo(){
        linkUserInfo.click();
        return new UserInfoPage(driver);
    }

    public WebElement getOmsLabel(){
        return driver.findElement(By.xpath(OMS_LABEL_XPATH));
    }

    public WebElement getSimpleSlimGeniusLabel(){
        return driver.findElement(By.xpath(SIMPLE_SLIM_GENIUS_LABEL_XPATH));
    }

    public WebElement getInspiredByGoogleLink(){
        return driver.findElement(By.xpath(INSPIRED_BY_GOOGLE_LINK_XPATH));
    }

    public WebElement getLastUpdateLabel(){
        return driver.findElement(By.xpath(LAST_UPDATE_LABEL_XPATH));
    }
}
