package pages;

import database.UserEntity;
import enums.ConditionFilterDropdownList;
import enums.FieldFilterDropdownList;
import enums.Region;
import enums.Role;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
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
    public static final String GET_USER_BY_LOGIN = "//tr[1]/td[1]";
    public static final String TABLE_BODY = "tbody";
    public static final String TR = "tr";
    public static final String TD = "td";

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
    public UserEntity getUserByLoginAndTransferToJavaObject(String login){
        this.selectFieldFilterDropdownList(FieldFilterDropdownList.LOGIN)
                .selectConditionFilterDropdownList(ConditionFilterDropdownList.EQUALS)
                .inputIntoSearchField(login)
                .clickSearchButton();

        UserEntity user = null;
            user = new UserEntity.Builder()
                    .setFirstName(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText())
                    .setLastName(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText())
                    .setPassword(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText())
                    .setLogin(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText())
                    .setEmail(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText())
                    .setRegion(Region.valueOf(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText()))
                    .setRole(Role.valueOf(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText()))
                    .build();
        return user;
    }

//    Find list of users on current page
    public List<UserEntity> getUsersFormCurrentPage(){
        final List<UserEntity> userEntityListFormCurrentPage = new ArrayList<>();
        final WebElement table = driver.findElement(By.tagName(TABLE_BODY));
        final List<WebElement> webElements = table.findElements(By.tagName(TR));
        for (WebElement rows : webElements){
            final List<WebElement> tableCells = rows.findElements(By.tagName(TD));
            UserEntity user = null;
            user = new UserEntity.Builder()
                    .setFirstName(tableCells.get(0).getText())
                    .setLastName(tableCells.get(1).getText())
                    .setLogin(tableCells.get(2).getText())
                    .setRole(Role.valueOf(tableCells.get(3).getText()))
                    .setRegion(Region.valueOf(tableCells.get(4).getText()))
                    .build();
            userEntityListFormCurrentPage.add(user);
        }
        return userEntityListFormCurrentPage;
    }

    
}
