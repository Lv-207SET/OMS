package pages;

import enums.ConditionFilterDropdownList;
import enums.FieldFilterDropdownList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

/**
 * Class represents "Administration" page
 */
public class AdministrationPage extends BasePage {

    public static final String GO_TO_CREATE_NEW_USER_PAGE = "//div[@id='list']/a[1]";
    public static final String SELECT_FIELD_FILTER_DROPDOWN_LIST = "//select[@id='field']";
    public static final String SELECT_CONDITION_FILTER_DROPDOWN_LIST = "//select[@id='condition']";
    public static final String SEACH_INPUT = "seachField";
    public static final String SEARCH_BUTTON = "input[value='Search']";
    public static final String DELETE = "Delete";

    public AdministrationPage(final WebDriver driver) {
        super(driver);
    }

//  User as role an "Administrator" goes from tab "Administration" to
//  "Create New User" page by using this method
    public CreateNewUserPage gToCreateNewUserPage(){
        driver.findElement(By.xpath(GO_TO_CREATE_NEW_USER_PAGE)).click();
        return new CreateNewUserPage(this.driver);
    }

//  Administrator select all fields in "Field Filter" dropdown list
//  in "Search by" block on "Administration" tab
    public AdministrationPage selectFieldFilterDropdownList(final FieldFilterDropdownList fieldFilterDropdownList){
        WebElement selectFieldFilterElement = driver.findElement(By.xpath(SELECT_FIELD_FILTER_DROPDOWN_LIST));
        final Select selectDropdownList = new Select(selectFieldFilterElement);
        selectDropdownList.selectByVisibleText(fieldFilterDropdownList.getFieldName());
        return this;
    }

//  Administrator select all fields in "Condition Filter" dropdown list
//  in "Search by" block on "Administration" tab
    public AdministrationPage selectConditionFilterDropdownList(final ConditionFilterDropdownList conditionFilter){
        WebElement selectConditionFilterElement = driver.findElement(By.xpath(SELECT_CONDITION_FILTER_DROPDOWN_LIST));
        final Select selectConditionFilter = new Select(selectConditionFilterElement);
        selectConditionFilter.selectByVisibleText(conditionFilter.getNameOfConditionFilterField());
        return this;
    }

//  Input text into text field for searching in "Search by" block
    public AdministrationPage inputIntoSearchField(String searchedString){
        driver.findElement(By.id(SEACH_INPUT)).click();
        driver.findElement(By.id(SEACH_INPUT)).sendKeys(searchedString);
        return this;
    }

// Clean search text field in "Search by" block
    public AdministrationPage clearSearchTextBox(){
        driver.findElement(By.id(SEACH_INPUT)).click();
        driver.findElement(By.id(SEACH_INPUT)).clear();
        return this;
    }

//  Click "Search" button in "Serch by" field
    public AdministrationPage clickSearchButton(){
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
        return this;
    }

// Delete user by login. Administrator set Fields filter on User Name,
// set condition filter on equals input login of desired user who should be deleted into
// search text field and click search button
    public AdministrationPage deleteUserByLogin(final String login, boolean deleteUserOrNot){
        this.selectFieldFilterDropdownList(FieldFilterDropdownList.LOGIN)
                .selectConditionFilterDropdownList(ConditionFilterDropdownList.EQUALS)
                .inputIntoSearchField(login)
                .clickSearchButton();

        try {
            driver.findElement(By.linkText(DELETE)).click();
            if (deleteUserOrNot) {
                driver.switchTo().alert().accept();
            } else {
                driver.switchTo().alert().dismiss();
            }
        } catch (NoSuchElementException e) {
            System.out.println("No user with such login found");
        }
        return this;
    }

//    Find user by login and return as java object in purpose to compare it with
//    data in database


}
