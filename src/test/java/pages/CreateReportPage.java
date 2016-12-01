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

        private WebElement linkAdministrationPage;
        private WebElement subHeader;
        private WebElement linkSaveReport;
        private WebElement spanUsersFound;
        private WebElement labelSearchBy;
        private WebElement labelFieldFilter;
        private Select selectField;
        private Select selectCondition;
        private WebElement inputSearchField ;
        private WebElement buttonSearch;
        private WebElement linkShowItems;
        private WebElement linkFirstName;
        private WebElement linkLastName;
        private WebElement linkLogin;
        private WebElement linkRole;
        private WebElement linkRegion;
        private WebElement buttonFirst;
        private WebElement buttonBackward;
        private WebElement buttonForward;
        private WebElement buttonLast;
        private WebElement spanPageNumber;
        private WebElement spanPageCount;

        public CreateReportPage(WebDriver driver) {
            super(driver);
            this.linkAdministrationPage =driver.findElement(By.cssSelector(ADMINISTRATION_LINK_CSS));
            this.subHeader = driver.findElement(By.cssSelector(SUBHEADER_CSS));
            this.linkSaveReport = driver.findElement(By.cssSelector(SAVE_REPORT_LINK_CSS));
            this.spanUsersFound = driver.findElement(By.id(USERS_FOUND_SPAN_ID));
            this.labelSearchBy = driver.findElement(By.tagName(SEARCH_BY_LABEL_TAG_NAME));
            this.labelFieldFilter = driver.findElement(By.cssSelector(FIELD_FILTER_LABEL_CSS));
            this.selectField  = new Select(driver.findElement(By.id(SELECT_FIELD_ID)));
            this.selectCondition  = new Select(driver.findElement(By.id(SELECT_CONDITION_ID)));
            this.inputSearchField = driver.findElement(By.id(SEARCH_FIELD_ID));
            this.buttonSearch = driver.findElement(By.name(SEARCH_BUTTON_NAME));
            this.linkShowItems = driver.findElement(By.cssSelector(SHOW_ITEMS_LINK_CSS));
            this.linkFirstName = driver.findElement(By.cssSelector(FIRST_NAME_LINK_CSS));
            this.linkLastName = driver.findElement(By.cssSelector(LAST_NAME_LINK_CSS));
            this.linkLogin = driver.findElement(By.cssSelector(LOGIN_LINK_CSS));
            this.linkRole = driver.findElement(By.cssSelector(ROLE_LINK_CSS));
            this.linkRegion = driver.findElement(By.cssSelector(REGION_LINK_CSS));
            this.buttonFirst = driver.findElement(By.id(FIRST_BUTTON_ID));
            this.buttonBackward = driver.findElement(By.id(BACKWARD_BUTTON_ID));
            this.buttonForward = driver.findElement(By.id(FORWARD_BUTTON_ID));
            this.buttonLast = driver.findElement(By.id(LAST_BUTTON_ID));
            this.spanPageNumber = driver.findElement(By.id(PAGE_NUMBER_SPAN_ID));
            this.spanPageCount = driver.findElement(By.id(PAGE_COUNT_SPAN_ID));
        }

        AdministrationPage goToAdministrationPage(){
            linkAdministrationPage.click();
            return new AdministrationPage(driver);
        }

        //These methods could be chained
        public CreateReportPage selectField(String fieldOption){
            selectField.selectByVisibleText(fieldOption);
            return this;
        }

        public CreateReportPage selectCondition(String conditionOption){
            selectCondition.selectByVisibleText(conditionOption);
            return this;
        }

        public CreateReportPage search(String searchTerm){
            inputSearchField.clear();
            inputSearchField.sendKeys(searchTerm);
            buttonSearch.click();
            return this;
        }

        public WebElement getSubHeader() {
            return subHeader;
        }

        public WebElement getLinkSaveReport() {
            return linkSaveReport;
        }

        public WebElement getSpanUsersFound() {
            return spanUsersFound;
        }

        public WebElement getLabelSearchBy() {
            return labelSearchBy;
        }

        public WebElement getLabelFieldFilter() {
            return labelFieldFilter;
        }

        public Select getSelectField() {
            return selectField;
        }

        public Select getSelectCondition() {
            return selectCondition;
        }

        public WebElement getInputSearchField() {
            return inputSearchField;
        }

        public WebElement getButtonSearch() {
            return buttonSearch;
        }

        public WebElement getLinkShowItems() {
            return linkShowItems;
        }

        public WebElement getLinkFirstName() {
            return linkFirstName;
        }

        public WebElement getLinkLastName() {
            return linkLastName;
        }

        public WebElement getLinkLogin() {
            return linkLogin;
        }

        public WebElement getLinkRole() {
            return linkRole;
        }

        public WebElement getLinkRegion() {
            return linkRegion;
        }

        public WebElement getButtonFirst() {
            return buttonFirst;
        }

        public WebElement getButtonBackward() {
            return buttonBackward;
        }

        public WebElement getButtonForward() {
            return buttonForward;
        }

        public WebElement getButtonLast() {
            return buttonLast;
        }

        public WebElement getSpanPageNumber() {
            return spanPageNumber;
        }

        public WebElement getSpanPageCount() {
            return spanPageCount;
        }
    }
