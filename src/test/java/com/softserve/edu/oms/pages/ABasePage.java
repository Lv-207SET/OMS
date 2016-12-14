package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ABasePage {

    private static final String LOGOUT_BUTTON_CSS = ".spec a";
    private static final String OMS_LABEL_CSS = "#logo h1";
    private static final String SIMPLE_SLIM_GENIUS_LABEL_CSS = "#logo h2";
    private static final String INSPIRED_BY_GOOGLE_LINK_CSS = "#footer a";
    private static final String USER_INFO_TAB_CSS = "*[href=\"/OMS/userInfo.htm\"]";

    protected WebDriver driver;


    ABasePage(WebDriver driver) {
        this.driver = driver;
    }

    // get Data

    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector(LOGOUT_BUTTON_CSS));
    }

    public WebElement getOmsLabel() {
        return driver.findElement(By.cssSelector(OMS_LABEL_CSS));
    }

    public WebElement getSimpleSlimGeniusLabel() {
        return driver.findElement(By.cssSelector(SIMPLE_SLIM_GENIUS_LABEL_CSS));
    }

    public WebElement getInspiredByGoogleLink() {
        return driver.findElement(By.cssSelector(INSPIRED_BY_GOOGLE_LINK_CSS));
    }

    public WebElement getUserInfoTab() {
        return driver.findElement(By.cssSelector(USER_INFO_TAB_CSS));
    }


    // Functional

    public String getOmsLabelText() {
        return getOmsLabel().getText().trim();
    }

    public String getSimpleSlimGeniusLabelText() {
        return getSimpleSlimGeniusLabel().getText().trim();
    }

    public String getInspiredByGoogleLinkText() {
        return getInspiredByGoogleLink().getText().trim();
    }

    public String getUserInfoTabText() {
        return getUserInfoTab().getText().trim();
    }


    // set Data

    public void clickLogoutButton() {
        driver.findElement(By.cssSelector(LOGOUT_BUTTON_CSS))
                .click();
    }

    public void clickInspiredByGoogleLink() {
        driver.findElement(By.cssSelector(INSPIRED_BY_GOOGLE_LINK_CSS))
                .click();
    }

    public void clickUserInfoTab() {
        driver.findElement(By.cssSelector(USER_INFO_TAB_CSS))
                .click();
    }

    // Business Logic

    public HomePage gotoUserInfoTab() {
        clickUserInfoTab();
        return new HomePage(driver);
    }

    public LoginPage logout() {
        clickLogoutButton();
        return new LoginPage(driver);
    }

    public ABasePage waitForLoad() {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10)
                .ignoring(StaleElementReferenceException.class);
        wait.until((ExpectedCondition<Boolean>) webDriver -> {
            WebElement element = webDriver.findElement(By.cssSelector(INSPIRED_BY_GOOGLE_LINK_CSS));
            return element != null && element.isDisplayed();
        });
        return this;
    }
}