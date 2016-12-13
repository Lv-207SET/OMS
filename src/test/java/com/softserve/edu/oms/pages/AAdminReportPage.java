package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.data.DBUtils;
import com.softserve.edu.oms.data.User;
import com.softserve.edu.oms.enums.ConditionFilterDropdownList;
import com.softserve.edu.oms.enums.FieldFilterDropdownList;
import com.softserve.edu.oms.enums.UsersPerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;


public abstract class AAdminReportPage extends ABasePage {

    private static final String SUBHEADER_CSS = "#list h2";
    private static final String USERS_FOUND_SPAN_ID = "usersFound";
    private static final String SEARCH_BY_LABEL_TAG_NAME = "legend";
    private static final String FIELD_FILTER_LABEL_CSS = "#searchForm label";
    private static final String SELECT_FIELD_ID = "field";
    private static final String SELECT_CONDITION_ID = "condition";
    private static final String SEARCH_FIELD_ID = "searchField";
    private static final String SEARCH_BUTTON_NAME = "search";
    private static final String SHOW_ITEMS_LINK_CSS = "#list p a";
    private static final String FIRST_NAME_LINK_CSS = "th:nth-child(1) a";
    private static final String LAST_NAME_LINK_CSS = "th:nth-child(2) a";
    private static final String LOGIN_LINK_CSS= "th:nth-child(3) a";
    private static final String ROLE_LINK_CSS = "th:nth-child(4) a";
    private static final String REGION_LINK_CSS = "th:nth-child(5) a";
    private static final String FIRST_BUTTON_ID = "first";
    private static final String BACKWARD_BUTTON_ID = "previous";
    private static final String FORWARD_BUTTON_ID = "next";
    private static final String LAST_BUTTON_ID = "last";
    private static final String PAGE_NUMBER_SPAN_ID = "pageNumber";
    private static final String PAGE_COUNT_SPAN_ID = "pageCount";
    private static final String TABLE_ROWS_CSS = "#table>tbody>tr";
    private static final String LOGINS_XPATH = ".//td[3]";
    private static final String FIRST_NAMES_XPATH = ".//td[1]";
    private static final String LAST_NAMES_XPATH = ".//td[2]";
    private static final String TABLE_BODY = "tbody";
    private static final String TR = "tr";
    private static final String TD = "td";
    //    TODO make normal selector
    public static final String GET_USER_BY_LOGIN = "//tr[1]/td[1]";



    public AAdminReportPage(WebDriver driver) {
        super(driver);
    }


    // get Data

    public WebElement getSubHeader() {
        return driver.findElement(By.cssSelector(SUBHEADER_CSS));
    }

    public WebElement getUsersFoundSpan() {
        return driver.findElement(By.id(USERS_FOUND_SPAN_ID));
    }

    public WebElement getSearchByLabel() {
        return driver.findElement(By.tagName(SEARCH_BY_LABEL_TAG_NAME));
    }

    public WebElement getFieldFilterLabel() {
        return driver.findElement(By.cssSelector(FIELD_FILTER_LABEL_CSS));
    }

    public Select getSelectField() {
        return new Select(driver.findElement(By.id(SELECT_FIELD_ID)));
    }

    public Select getSelectCondition() {
        return new Select(driver.findElement(By.id(SELECT_CONDITION_ID)));
    }

    public WebElement getSearchFieldInput() {
        return driver.findElement(By.id(SEARCH_FIELD_ID));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.name(SEARCH_BUTTON_NAME));
    }

    public WebElement getShowItemsLink() {
        return driver.findElement(By.cssSelector(SHOW_ITEMS_LINK_CSS));
    }

    public WebElement getFirstNameLink() {
        return driver.findElement(By.cssSelector(FIRST_NAME_LINK_CSS));
    }

    public WebElement getLastNameLink() {
        return driver.findElement(By.cssSelector(LAST_NAME_LINK_CSS));
    }

    public WebElement getLoginLink() {
        return driver.findElement(By.cssSelector(LOGIN_LINK_CSS));
    }

    public WebElement getRoleLink() {
        return driver.findElement(By.cssSelector(ROLE_LINK_CSS));
    }

    public WebElement getRegionLink() {
        return driver.findElement(By.cssSelector(REGION_LINK_CSS));
    }

    public WebElement getFirstButton() {
        return driver.findElement(By.id(FIRST_BUTTON_ID));
    }

    public WebElement getBackwardButton() {
        return driver.findElement(By.id(BACKWARD_BUTTON_ID));
    }

    public WebElement getForwardButton() {
        return driver.findElement(By.id(FORWARD_BUTTON_ID));
    }

    public WebElement getLastButton() {
        return driver.findElement(By.id(LAST_BUTTON_ID));
    }

    public WebElement getPageNumberSpan() {
        return driver.findElement(By.id(PAGE_NUMBER_SPAN_ID));
    }

    public WebElement getPageCountSpan() {
        return driver.findElement(By.id(PAGE_COUNT_SPAN_ID));
    }


    // Functional

    public String getSubHeaderText() {
        return driver.findElement(By.cssSelector(SUBHEADER_CSS)).getText();
    }

    public String getUsersFoundSpanText() {
        return driver.findElement(By.id(USERS_FOUND_SPAN_ID)).getText();
    }

    public String getSearchByLabelText() {
        return driver.findElement(By.tagName(SEARCH_BY_LABEL_TAG_NAME)).getText();
    }

    public String getFieldFilterLabelText() {
        return driver.findElement(By.cssSelector(FIELD_FILTER_LABEL_CSS)).getText();
    }

    public String getSelectFieldDefaultValue() {
        return new Select(driver.findElement(By.id(SELECT_FIELD_ID))).getFirstSelectedOption().getText();
    }

    public String getSelectConditionDefaultValue() {
        return new Select(driver.findElement(By.id(SELECT_CONDITION_ID))).getFirstSelectedOption().getText();
    }

    public String getSearchFieldInputValue() {
        return driver.findElement(By.id(SEARCH_FIELD_ID)).getAttribute("value");
    }

    public String getSearchButtonValue() {
        return driver.findElement(By.name(SEARCH_BUTTON_NAME)).getAttribute("value");
    }

    public String getShowItemsLinkText() {
        //return driver.findElement(By.cssSelector(SHOW_ITEMS_LINK_CSS)).getText();
        return driver.findElement(By.cssSelector(SHOW_ITEMS_LINK_CSS)).getAttribute("innerHTML");
    }

    public String getFirstNameLinkText() {
        return driver.findElement(By.cssSelector(FIRST_NAME_LINK_CSS)).getText();
    }

    public String getLastNameLinkText() {
        return driver.findElement(By.cssSelector(LAST_NAME_LINK_CSS)).getText();
    }

    public String getLoginLinkText() {
        return driver.findElement(By.cssSelector(LOGIN_LINK_CSS)).getText();
    }

    public String getRoleLinkText() {
        return driver.findElement(By.cssSelector(ROLE_LINK_CSS)).getText();
    }
    public String getRegionLinkText() {
        return driver.findElement(By.cssSelector(REGION_LINK_CSS)).getText();
    }

    public String getFirstButtonValue() {
        return driver.findElement(By.id(FIRST_BUTTON_ID)).getAttribute("value");
    }

    public String getBackwardButtonValue() {return driver.findElement(By.id(BACKWARD_BUTTON_ID)).getAttribute("value");}

    public String getForwardButtonValue() {
        return driver.findElement(By.id(FORWARD_BUTTON_ID)).getAttribute("value");
    }

    public String getLastButtonValue() {
        return driver.findElement(By.id(LAST_BUTTON_ID)).getAttribute("value");
    }

    public String getPageNumberSpanText() {
        return driver.findElement(By.id(PAGE_NUMBER_SPAN_ID)).getText();
    }

    public String getPageCountSpanText() {
        //return driver.findElement(By.id(PAGE_COUNT_SPAN_ID)).getText();
        return driver.findElement(By.id(PAGE_COUNT_SPAN_ID)).getAttribute("innerHTML");
    }
    
    public String getUsersFoundText(){
        return getUsersFoundSpan().getAttribute("innerHTML");
    }

 
    public int getFoundUsersNumber() {
       return Integer.parseInt(getUsersFoundText());
    }

    public int getPagesQuantity() {
        return Integer.parseInt(getPageCountSpanText());
    }

    public int  getCurrentPageNumber() {
        return Integer.parseInt(getPageNumberSpanText());
    }

    // Check if navigation buttons is enabled
    public boolean isForwardButtonEnabled() {
        return driver.findElement(By.id(FORWARD_BUTTON_ID)).isEnabled();
    }

    public boolean isLastButtonEnabled() {
        return driver.findElement(By.id(LAST_BUTTON_ID)).isEnabled();
    }

    public boolean isBackwardButtonEnabled() {
        return driver.findElement(By.id(BACKWARD_BUTTON_ID)).isEnabled();
    }

    public boolean isFirstButtonEnabled() {
        return driver.findElement(By.id(FIRST_BUTTON_ID)).isEnabled();
    }


    // set Data

    public void clickFirstNameLink(){
        getFirstNameLink().click();
    }

    public void clickLastNameLink(){
        getLastNameLink().click();
    }

    public void clickLoginLink(){
        getLoginLink().click();
    }

    public void clickRoleLink(){
        getRoleLink().click();
    }

    public void clickRegionLink(){
        getRegionLink().click();
    }

    public void clickFirstButton() { getFirstButton().click(); }

    public void clickBackwardButton() { getBackwardButton().click(); }

    public void clickForwardButton() { getForwardButton().click(); }

    public void clickLastButton() { getLastButton().click(); }

    public void clickShowItemsLink() { getShowItemsLink().click(); }

    //  Click "Search" button in "Search by" field
    public void clickSearchButton() {
        getSearchButton().click();
    }


    public void selectField(FieldFilterDropdownList fieldOption){
        getSelectField().selectByVisibleText(fieldOption.getFieldName());
    }

    public Set<String> getSelectFieldOptions() {
        Select selectFieldFilterElement = getSelectField();
        List<WebElement>listOptions=selectFieldFilterElement.getOptions();
        Set<String> options=new HashSet<>();
        listOptions.forEach(p -> { options.add(p.getText().toLowerCase());});
        return options;
    }
    public void selectCondition(ConditionFilterDropdownList conditionOption){
        getSelectCondition().selectByVisibleText(conditionOption.getNameOfConditionFilterField());
    }

    public Set<String> getSelectConditionOptions() {
        Select selectConditionFilterElement = getSelectCondition();
        List<WebElement>listOptions=selectConditionFilterElement.getOptions();
        Set<String> options=new HashSet<>();
        listOptions.forEach(p -> { options.add(p.getText());});
        return options;
    }

    public AAdminReportPage selectConditionByIndex(final int index) {
        final Select selectConditionFilter = getSelectCondition();
        selectConditionFilter.selectByIndex(index);
        return this;
    }

    public void search(String searchTerm){
        WebElement inputSearchField = getSearchFieldInput();
        inputSearchField.clear();
        inputSearchField.sendKeys(searchTerm);
        clickSearchButton();
    }

    public AAdminReportPage filterAndSearch(FieldFilterDropdownList fieldOption, ConditionFilterDropdownList conditionOption, String searchTerm) {
        selectField(fieldOption);
        selectCondition(conditionOption);
        search(searchTerm);
        return this;
    }

    public AAdminReportPage sortByFirstNameASC(){
        clickRegionLink();
        waitForLoad();
        clickFirstNameLink();
        return this;
    }

    public AAdminReportPage sortByFirstNameDESC(){
        clickRegionLink();
        waitForLoad();
        clickFirstNameLink();
        waitForLoad();
        clickFirstNameLink();
        return this;
    }

    public AAdminReportPage sortByLastNameASC(){
        clickRegionLink();
        waitForLoad();
        clickLastNameLink();
        return this;
    }

    public AAdminReportPage sortByLastNameDESC(){
        clickRegionLink();
        waitForLoad();
        clickLastNameLink();
        waitForLoad();
        clickLastNameLink();
        return this;
    }


    public AAdminReportPage sortByLoginASC(){
        clickRegionLink();
        waitForLoad();
        clickLoginLink();
        return this;
    }

    public AAdminReportPage sortByLoginDESC(){
        clickRegionLink();
        waitForLoad();
        clickLoginLink();
        waitForLoad();
        clickLoginLink();
        return this;
    }

    public AAdminReportPage sortByRoleASC(){
        clickRegionLink();
        waitForLoad();
        clickRoleLink();
        return this;
    }

    public AAdminReportPage sortByRoleDESC(){
        clickRegionLink();
        waitForLoad();
        clickRoleLink();
        waitForLoad();
        clickRoleLink();
        return this;
    }

    public AAdminReportPage sortByRegionASC(){
        clickFirstNameLink();
        waitForLoad();
        clickRegionLink();
        return this;
    }

    public AAdminReportPage sortByRegionDESC(){
        clickFirstNameLink();
        waitForLoad();
        clickRegionLink();
        waitForLoad();
        clickRegionLink();
        return this;
    }

    public AAdminReportPage showTenRows(){
        if(getShowItemsLinkText().equals("Show 5 items"))
            return this;
        clickShowItemsLink();
        return this;
    }

    public AAdminReportPage waitForLoad() {
        WebDriverWait wait = (WebDriverWait)new WebDriverWait(driver,10)
            .ignoring(StaleElementReferenceException.class);
        wait.until((ExpectedCondition<Boolean>) webDriver -> {
            WebElement element = webDriver.findElement(By.id(LAST_BUTTON_ID));
            return element != null && element.isDisplayed();
        });
        return this;

    }

    //    Get list of users from current page
    public List<User> getUsersFormCurrentPage() {
        final List<User> userListFormCurrentPage = new ArrayList<>();
        final WebElement table = driver.findElement(By.tagName(TABLE_BODY));
        final List<WebElement> webElements = table.findElements(By.tagName(TR));
        for (WebElement rows : webElements) {
            final List<WebElement> tableCells = rows.findElements(By.tagName(TD));
            User user = new User ();
            user.setFirstname(tableCells.get(0).getText());
            user.setLastname(tableCells.get(1).getText());
            user.setLoginname(tableCells.get(2).getText());
            user.setRole(tableCells.get(3).getText().toUpperCase(Locale.ENGLISH));
            user.setRegion(tableCells.get(4).getText().toUpperCase(Locale.ENGLISH));
            userListFormCurrentPage.add(user);
        }
        return userListFormCurrentPage;
    }

    // Get all users list from search result
    public List<User> getAllUsers() {
        final List<User> usersOnAllPages = new ArrayList<>();
        List<User> usersFromCurrentPage = this.getUsersFormCurrentPage();
        while (usersFromCurrentPage != null) {
            usersOnAllPages.addAll(usersFromCurrentPage);
            if (driver.findElement(By.id(FORWARD_BUTTON_ID)).isEnabled()) {
                clickForwardButton();
                usersFromCurrentPage = this.getUsersFormCurrentPage();
            } else {
                break;
            }
        }
        return usersOnAllPages;
    }

    //   Find user by login and return as java object in purpose to compare it with
    //   data in database
    public User getUserByLoginAndTransferToJavaObject(String login) {
        selectField(FieldFilterDropdownList.LOGIN);
        selectCondition(ConditionFilterDropdownList.EQUALS);
        search(login);

        User user = new User();
        user.setFirstname(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
        user.setLastname(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
        user.setPassword(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
        user.setLoginname(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
        user.setEmail(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
        user.setRegion(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
        user.setRole(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());

        return user;
    }

    public boolean compareLogins (String SQLQuery){
        List<WebElement> logins = driver.findElements(By.xpath(LOGINS_XPATH));
        List<WebElement> firstNames = driver.findElements(By.xpath(FIRST_NAMES_XPATH));
        List<WebElement> lastNames = driver.findElements(By.xpath(LAST_NAMES_XPATH));

        int size = logins.size();
        String []textofLogins = new String[size];
        String []textofFirstNames = new String[size];
        String []textofLastNames = new String[size];
        for (int i = 0; i<size; i++) {
            textofLogins[i] = logins.get(i).getText().trim();
            textofFirstNames[i] = firstNames.get(i).getText().trim();
            textofLastNames[i] = lastNames.get(i).getText().trim();
        }

        DBUtils dbUtility = new DBUtils();
        List<String> loginsFromDB =  dbUtility.getLogins(SQLQuery);

        boolean isEqual = true;

        System.out.printf("%-20s%-20s%-20s%s\n", "\nLogin/table   ", "First Name/table   ", "Last Name/table  ", "Login/DB");
        for (int i = 0; i<size; i++) {
            System.out.printf("%-20s%-20s%-20s%s\n", textofLogins[i], textofFirstNames[i], textofLastNames[i], loginsFromDB.get(i));
            if(textofLogins[i].equals(loginsFromDB.get(i))) {


                continue;
            }
            else {
                isEqual = false;
                break;
            }
        }

        return isEqual;

    }
}







