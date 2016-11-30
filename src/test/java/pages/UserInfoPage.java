package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserInfoPage extends BasePage{
    private final static String ENGLISH_LANGUAGE_LINK_ID = "en_US";
    private final static String UKRAINIAN_LANGUAGE_LINK_ID = "uk_UA";
    private final static String FIRST_NAME_LABEL_XPATH = "//tr[td = \"First name\"]/td[2]"; //fieldset tr:nth-child(1) td:last-child
    private final static String LAST_NAME_LABEL_XPATH = "//tr[td = \"Last name\"]/td[2]"; //fieldset tr:nth-child(2) td:last-child
    private final static String ROLE_LABEL_XPATH = "//tr[td = \"Role\"]/td[2]"; //fieldset tr:nth-child(4) td:last-child
    private final static String ADMINISTRATION_TAB_CSS = "#nav .cur a";
    private final static String ORDERING_TAB_CSS = "#nav .cur a";
    private final static String ITEM_MANAGEMENT_TAB_CSS = "#nav .cur a";

   public UserInfoPage (WebDriver driver){
        super(driver);
    }

    public String getFirstNameLabel() {
        return  driver.findElement(By.xpath(FIRST_NAME_LABEL_XPATH)).getText();
    }

    public String getLastNameLabel() {
        return driver.findElement(By.xpath(LAST_NAME_LABEL_XPATH)).getText();
    }

    public WebElement getRoleLabel() {
        return driver.findElement(By.xpath(ROLE_LABEL_XPATH));
    }

    public void changeToUkrainianLanguage () {
        driver.findElement(By.id(UKRAINIAN_LANGUAGE_LINK_ID))
                .click();
    }

    public  void changeToEnglishLanguage () {
        driver.findElement(By.id(ENGLISH_LANGUAGE_LINK_ID))
                .click();
    }

    public AdministrationPage  clickOnAdministrationTab () {
        driver.findElement(By.cssSelector(ADMINISTRATION_TAB_CSS))
                .click();
        return new AdministrationPage(driver);
    }

    public ItemManagementPage clickOnItemManagementTab () {
        driver.findElement(By.cssSelector(ITEM_MANAGEMENT_TAB_CSS))
                .click();
        return new ItemManagementPage(driver);
    }

    public OrderingPage clickOnOrderingTab () {
        driver.findElement(By.cssSelector(ORDERING_TAB_CSS))
                .click();
        return new OrderingPage();
    }
}
