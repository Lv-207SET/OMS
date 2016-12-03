package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AAdminReportPage extends ABasePage {
    private static final String ADMINISTRATION_LINK_CSS = "#nav .cur a";
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
        return driver.findElement(By.cssSelector(SHOW_ITEMS_LINK_CSS)).getText();
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

    public String getBackwardButtonValue() {
        return driver.findElement(By.id(BACKWARD_BUTTON_ID)).getAttribute("value");
    }

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
        return driver.findElement(By.id(PAGE_COUNT_SPAN_ID)).getText();
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



    public void selectField(String fieldOption){
        getSelectField().selectByVisibleText(fieldOption);
    }

    public void selectCondition(String conditionOption){
        getSelectCondition().selectByVisibleText(conditionOption);
    }

    public void search(String searchTerm){
        WebElement inputSearchField = getSearchFieldInput();
        inputSearchField.clear();
        inputSearchField.sendKeys(searchTerm);
        getSearchButton().click();
    }

    public AAdminReportPage filterAndSearch(String fieldOption, String conditionOption, String searchTerm) {
        selectField(fieldOption);
        selectCondition(conditionOption);
        search(searchTerm);
        return this;
    }

    public AAdminReportPage sortByFirstNameASC(){
        clickRegionLink();
        clickFirstNameLink();
        return this;
    }

    public AAdminReportPage sortByFirstNameDESC(){
        clickRegionLink();
        clickFirstNameLink();
        clickFirstNameLink();
        return this;
    }

    public AAdminReportPage sortByLastNameASC(){
        clickRegionLink();
        clickLastNameLink();
        return this;
    }

    public AAdminReportPage sortByLastNameDESC(){
        clickRegionLink();
        clickLastNameLink();
        clickLastNameLink();
        return this;
    }


    public AAdminReportPage sortByLoginASC(){
        clickRegionLink();
        clickLoginLink();
        return this;
    }

    public AAdminReportPage sortByLoginDESC(){
        clickRegionLink();
        clickLoginLink();
        clickLoginLink();
        return this;
    }

    public AAdminReportPage sortByRoleASC(){
        clickRegionLink();
        clickRoleLink();
        return this;
    }

    public AAdminReportPage sortByRoleDESC(){
        clickRegionLink();
        clickRoleLink();
        clickRoleLink();
        return this;
    }

    public AAdminReportPage sortByRegionASC(){
        clickFirstNameLink();
        clickRegionLink();
        return this;
    }

    public AAdminReportPage sortByRegionDESC(){
        clickFirstNameLink();
        clickRegionLink();
        clickRegionLink();
        return this;
    }

    public void compareto(){
        List<WebElement> logins = driver.findElements(By.xpath(LOGINS_XPATH));
        int size = logins.size();
        String []textofLogins = new String[size];



    }


    AdministrationPage goToAdministrationPage(){
        driver.findElement(By.cssSelector(ADMINISTRATION_LINK_CSS)).click();
        return new AdministrationPage(driver);

    }


}

