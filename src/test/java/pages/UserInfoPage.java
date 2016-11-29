package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserInfoPage extends BasePage{
    private final String ENGLISH_LANGUAGE_LINK_ID = "en_US";
    private final String UKRAINIAN_LANGUAGE_LINK_ID = "uk_UA";
    private final String FIRST_NAME_LABEL_XPATH = "//tr[td = \"First name\"]/td[2]";
    private final String LAST_NAME_LABEL_XPATH = "//tr[td = \"Last name\"]/td[2]";
    private final String ROLE_LABEL_XPATH = "//tr[td = \"Role\"]/td[2]";
    private final String ADMINISTRATION_TAB_XPATH = "//*[@id=\"nav\"]/li[1]/a";
    private final String ORDERING_TAB_XPATH = "//*[@id=\"nav\"]/li[1]/a";
    private final String ITEM_MANAGEMENT_TAB_XPATH = "//*[@id=\"nav\"]/li[1]/a";




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
        driver.findElement(By.xpath(ADMINISTRATION_TAB_XPATH))
                .click();
        return new AdministrationPage(driver);
    }

    public ItemManagementPage clickOnItemManagementTab () {
        driver.findElement(By.xpath(ITEM_MANAGEMENT_TAB_XPATH))
                .click();
        return new ItemManagementPage(driver);
    }

    public OrderingPage clickOnOrderingTab () {
        driver.findElement(By.xpath(ORDERING_TAB_XPATH))
                .click();
        return new OrderingPage();
    }




}
