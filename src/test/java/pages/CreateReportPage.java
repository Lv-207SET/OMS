package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateReportPage extends BasePage{

        public static final String ADMINISTRATION_LINK_CSS = "#nav .cur a";
        public static final String SUBHEADER_CSS = "#list h2";
        public static final String SAVE_REPORT_LINK_CSS = "#list>a";
        public static final String USERS_FOUND_SPAN_ID = "usersFound";
        public static final String SEARCH_BY_LABEL_TAG_NAME = "legend";
        public static final String FIELD_FILTER_LABEL_CSS = "#searchForm label";
        public static final String SELECT_FIELD_ID = "field";
        public static final String SELECT_CONDITION_ID = "condition";
        public static final String SEARCH_FIELD_ID = "searchField";
        public static final String SEARCH_BUTTON_NAME = "search";
        public static final String SHOW_ITEMS_LINK_CSS = "#list p a";
        public static final String FIRST_NAME_LINK_CSS = "th:nth-child(1) a";
        public static final String LAST_NAME_LINK_CSS = "th:nth-child(2) a";
        public static final String LOGIN_LINK_CSS= "th:nth-child(3) a";
        public static final String ROLE_LINK_CSS = "th:nth-child(4) a";
        public static final String REGION_LINK_CSS = "th:nth-child(5) a";
        public static final String FIRST_BUTTON_ID = "first";
        public static final String BACKWARD_BUTTON_ID = "previous";
        public static final String FORWARD_BUTTON_ID = "next";
        public static final String LAST_BUTTON_ID = "last";
        public static final String PAGE_NUMBER_SPAN_ID = "pageNumber";
        public static final String PAGE_COUNT_SPAN_ID = "pageCount";

       
        public CreateReportPage(WebDriver driver) {
            super(driver);
        }

        AdministrationPage goToAdministrationPage(){
            driver.findElement(By.cssSelector(ADMINISTRATION_LINK_CSS)).click();
            return new AdministrationPage(driver);
        }

        //These methods could be chained
        public CreateReportPage selectField(String fieldOption){
            getSelectField().selectByVisibleText(fieldOption);
            return this;
        }

        public CreateReportPage selectCondition(String conditionOption){
            getSelectCondition.selectByVisibleText(conditionOption);
            return this;
        }

        public CreateReportPage search(String searchTerm){
            WebElement inputSearchField = getInputSearchField();     
            inputSearchField.clear();
            inputSearchField.sendKeys(searchTerm); 
            getButtonSearch.click();
            return this;
        }

        public WebElement getSubHeader() {
            return driver.findElement(By.cssSelector(SUBHEADER_CSS));
        }

        public WebElement getLinkSaveReport() {
            return driver.findElement(By.cssSelector(SAVE_REPORT_LINK_CSS));
        }

        public WebElement getSpanUsersFound() {
            return driver.findElement(By.id(USERS_FOUND_SPAN_ID));
        }

        public WebElement getLabelSearchBy() {
            return driver.findElement(By.tagName(SEARCH_BY_LABEL_TAG_NAME));
        }

        public WebElement getLabelFieldFilter() {
            return driver.findElement(By.cssSelector(FIELD_FILTER_LABEL_CSS));
        }

        public Select getSelectField() {
            return driver.findElement(By.id(SELECT_FIELD_ID));
        }

        public Select getSelectCondition() {
            return driver.findElement(By.id(SELECT_CONDITION_ID));
        }

        public WebElement getInputSearchField() {
            return driver.findElement(By.id(SEARCH_FIELD_ID));
        }

        public WebElement getButtonSearch() {
            return driver.findElement(By.name(SEARCH_BUTTON_NAME));
        }

        public WebElement getLinkShowItems() {
            return driver.findElement(By.cssSelector(SHOW_ITEMS_LINK_CSS));
        }

        public WebElement getLinkFirstName() {
            return driver.findElement(By.cssSelector(FIRST_NAME_LINK_CSS));
        }

        public WebElement getLinkLastName() {
            return driver.findElement(By.cssSelector(FIRST_NAME_LINK_CSS));
        }

        public WebElement getLinkLogin() {
            return driver.findElement(By.cssSelector(LOGIN_LINK_CSS));
        }

        public WebElement getLinkRole() {
            return driver.findElement(By.cssSelector(ROLE_LINK_CSS));
        }

        public WebElement getLinkRegion() {
            return driver.findElement(By.cssSelector(REGION_LINK_CSS));
        }

        public WebElement getButtonFirst() {
            return driver.findElement(By.id(FIRST_BUTTON_ID));
        }

        public WebElement getButtonBackward() {
            return driver.findElement(By.id(BACKWARD_BUTTON_ID));
        }

        public WebElement getButtonForward() {
            return driver.findElement(By.id(FORWARD_BUTTON_ID));
        }

        public WebElement getButtonLast() {
            return driver.findElement(By.id(LAST_BUTTON_ID));
        }

        public WebElement getSpanPageNumber() {
            return driver.findElement(By.id(PAGE_NUMBER_SPAN_ID));
        }

        public WebElement getSpanPageCount() {
            return driver.findElement(By.id(PAGE_COUNT_SPAN_ID));
        }
    }
