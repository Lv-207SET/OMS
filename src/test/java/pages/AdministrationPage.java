package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Class represents "Administration" page
 */
public class AdministrationPage extends BasePage {

    public static final String GO_TO_CREATE_NEW_USER_PAGE = "//div[@id='list']/a[1]";

    public AdministrationPage(final WebDriver driver) {
        super(driver);
    }

    //  User as role an "Administrator" goes from tab "Administration" to
    //  "Create New User" page by using this method
    public CreateNewUserPage gToCreateNewUserPage(){
        driver.findElement(By.xpath(GO_TO_CREATE_NEW_USER_PAGE)).click();
        return new CreateNewUserPage(this.driver);
    }

    public AdministrationPage selectFieldFilterDropdownList(){
        WebElement selectDropdownListElement = driver.findElement(By.xpath("//select[@id='field']"));
        final Select selectDropdownList = new Select(selectDropdownListElement);
        selectDropdownList.selectByVisibleText("");
        return this;
    }
}
