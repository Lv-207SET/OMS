package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInfoPage extends BasePage{

    private final static String ENGLISH_LANGUAGE_LINK_ID = "en_US";//xpath
    private final static String UKRAINIAN_LANGUAGE_LINK_ID = "uk_UA";//xpath
    private final static String FIRST_NAME_LABEL_CSS = "fieldset tr:nth-child(1) td:last-child";
    private final static String LAST_NAME_LABEL_CSS = "fieldset tr:nth-child(2) td:last-child";
    private final static String CUSTOMER_TYPE_LABEL_CSS = "fieldset tr:nth-child(3) td:last-child"; //getter needed
    private final static String ROLE_LABEL_CSS = "fieldset tr:nth-child(4) td:last-child";
    private final static String ADMINISTRATION_TAB_CSS = "[href=\"/OMS/users.htm\"]";
    private final static String ORDERING_TAB_CSS = "[href=\"/OMS/order.htm\"]";
    private final static String ITEM_MANAGEMENT_TAB_CSS = "[href=\"/OMS/itemManagement.htm\"]";


   public UserInfoPage (WebDriver driver){
        super(driver);
    }

    public String getFirstNameLabel() {
        return  driver.findElement(By.cssSelector(FIRST_NAME_LABEL_CSS)).getText();
    }

    public String getLastNameLabel() {
        return driver.findElement(By.cssSelector(LAST_NAME_LABEL_CSS)).getText();
    }

    public String getRoleLabel() {
        return driver.findElement(By.cssSelector(ROLE_LABEL_CSS)).getText();
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
