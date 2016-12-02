package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.enums.FieldFilterSupervisor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class ItemManagementPage extends BasePage{

    public ItemManagementPage(WebDriver driver) {
        super(driver);
    }

    private boolean showFiveItems = true;   // true - showing 5 items, false - showing 10 items in table

    //UI Mapping
    private final static String USER_INFO_TAB_CSS = "#nav li:nth-child(2) a";
    private final static String PAGE_IS_APPOINTED_LABEL_CSS = "#list h2";
    private final static String ADD_PRODUCT_LINK_CSS = "#list>a";
    private final static String PRODUCTS_FOUND_LABEL_CSS = "#list h4:first-of-type";
    private final static String PRODUCTS_COUNT_LABEL_ID = "recordsFound";
    private final static String SEARCH_BY_LABEL_TAG_NAME = "legend";
    private final static String FIELD_FILTER_LABEL_CSS = "#searchForm label";
    private final static String FIELD_FILTER_SELECT_ID = "field";
    private final static String SEARCH_FIELD_ID = "searchField";
    private final static String SEARCH_BUTTON_CSS = "input[value='Search']";
    private final static String SHOW_ITEMS_LINK_CSS = "#list p a";
    private final static String TABLE_NAME_LINK_CSS ="th:nth-child(1) a";
    private final static String TABLE_DESCRIPTION_LINK_CSS ="th:nth-child(2) a";
    private final static String TABLE_PRICE_LINK_CSS ="th:nth-child(3) a";
    private final static String TABLE_EDIT_LABEL_CSS ="th:nth-last-of-type(2)";
    private final static String TABLE_DELETE_LABEL_CSS ="th:nth-last-of-type(1)";
    private final static String FIRST_BUTTON_ID ="first";
    private final static String BACKWARD__BUTTON_ID ="previous";
    private final static String FORWARD__BUTTON_ID ="next";
    private final static String LAST__BUTTON_ID ="last";
    private final static String PAGE_LABEL_CSS = "#list h4:last-of-type";
    private final static String PAGE_NUMBER_LABEL_ID = "pageNumber";
    private final static String PAGE_COUNT_LABEL_ID = "pageCount";
    private final static String CREATE_REPORT_LINK_CSS = "#list h4:last-of-type + a";

    //get Elements
    public WebElement getUserInfoTab() {
        return driver.findElement(By.cssSelector(USER_INFO_TAB_CSS));
    }

    public WebElement getPageIsAppointedLabel() {
        return driver.findElement(By.cssSelector(PAGE_IS_APPOINTED_LABEL_CSS));
    }

    public WebElement getAddProductLink() {
        return driver.findElement(By.cssSelector(ADD_PRODUCT_LINK_CSS));
    }

    public WebElement getProductsFoundLabel() {
        return driver.findElement(By.cssSelector(PRODUCTS_FOUND_LABEL_CSS));
    }

    public WebElement getProductsCountLabel() {
        return driver.findElement(By.id(PRODUCTS_COUNT_LABEL_ID));
    }

    public WebElement getSearchByLabel() {
        return driver.findElement(By.tagName(SEARCH_BY_LABEL_TAG_NAME));
    }

    public WebElement getFieldFilterLabel() {
        return driver.findElement(By.cssSelector(FIELD_FILTER_LABEL_CSS));
    }

    public WebElement getFieldFilterSelect() {
        return driver.findElement(By.id(FIELD_FILTER_SELECT_ID));
    }

    public WebElement getSearchField() {
        return driver.findElement(By.id(SEARCH_FIELD_ID));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.cssSelector(SEARCH_BUTTON_CSS));
    }

    public WebElement getShowItemsLink() {
        return driver.findElement(By.cssSelector(SHOW_ITEMS_LINK_CSS));
    }

    public WebElement getTableNameLink() {
        return driver.findElement(By.cssSelector(TABLE_NAME_LINK_CSS));
    }

    public WebElement getTableDescriptionLink() {
        return driver.findElement(By.cssSelector(TABLE_DESCRIPTION_LINK_CSS));
    }

    public WebElement getTablePriceLink() {
        return driver.findElement(By.cssSelector(TABLE_PRICE_LINK_CSS));
    }

    public WebElement getTableEditLabel() {
        return driver.findElement(By.cssSelector(TABLE_EDIT_LABEL_CSS));
    }

    public WebElement getTableDeleteLabel() {
        return driver.findElement(By.cssSelector(TABLE_DELETE_LABEL_CSS));
    }

    public WebElement getFirstButton() {
        return driver.findElement(By.id(FIRST_BUTTON_ID));
    }

    public WebElement getBackwardButton() {
        return driver.findElement(By.id(BACKWARD__BUTTON_ID));
    }

    public WebElement getForwardButton() {
        return driver.findElement(By.id(FORWARD__BUTTON_ID));
    }

    public WebElement getLastButton() {
        return driver.findElement(By.id(LAST__BUTTON_ID));
    }

    public WebElement getPageLabel() {
        return driver.findElement(By.cssSelector(PAGE_LABEL_CSS));
    }

    public WebElement getPageNumberLabel() {
        return driver.findElement(By.id(PAGE_NUMBER_LABEL_ID));
    }

    public WebElement getPageCountLabel() {
        return driver.findElement(By.id(PAGE_COUNT_LABEL_ID));
    }

    public WebElement getCreateReportLink() {
        return driver.findElement(By.cssSelector(CREATE_REPORT_LINK_CSS));
    }

    public Select getChangeFieldFilter() {
        return new Select(getFieldFilterSelect());
    }

    public String getChangeFieldFilterSelectedText() {
        return getChangeFieldFilter().getFirstSelectedOption().getText();
    }

    //get List WebElements from table
    //need to redo tr td:nth-child(1)
    public List<WebElement> getListName(){
        List<WebElement> listName = new ArrayList<>();
        if (showFiveItems){
            for(int i=0; i<=4; i++){
                listName.add(i,
                        driver.findElement(By.xpath(".//*[@id='table']/tbody/tr[" + i +"]/td[1]")));
            }
        } else
            for(int i=0; i<=9; i++){
                listName.add(i,
                        driver.findElement(By.xpath(".//*[@id='table']/tbody/tr[" + i +"]/td[1]")));
            }
        return listName;
    }
    //need to redo tr td:nth-child(2)
    public List<WebElement> getListDescription(){
        List<WebElement> listDescription = new ArrayList<>();
        if (showFiveItems){
            for(int i=0; i<=4; i++){
                listDescription.add(i,
                        driver.findElement(By.xpath(".//*[@id='table']/tbody/tr[" + i +"]/td[2]")));
            }
        } else
            for(int i=0; i<=9; i++){
                listDescription.add(i,
                        driver.findElement(By.xpath(".//*[@id='table']/tbody/tr[" + i +"]/td[2]")));
            }
        return listDescription;
    }
    //need to redo tr td:nth-child(3)
    public List<WebElement> getListPrice(){
        List<WebElement> listPrice = new ArrayList<>();
        if (showFiveItems){
            for(int i=0; i<=4; i++){
                listPrice.add(i,
                        driver.findElement(By.xpath(".//*[@id='table']/tbody/tr[" + i +"]/td[3]")));
            }
        } else
            for(int i=0; i<=9; i++){
                listPrice.add(i,
                        driver.findElement(By.xpath(".//*[@id='table']/tbody/tr[" + i +"]/td[3]")));
            }
        return listPrice;
    }
    //need to redo tr td:nth-child(4)
    public List<WebElement> getListEditLinks(){
        List<WebElement> getListEditLinks = new ArrayList<>();
        if (showFiveItems){
            for(int i=0; i<=4; i++){
                getListEditLinks.add(i,
                        driver.findElement(By.xpath(".//*[@id='table']/tbody/tr[" + i +"]/td[4]/a")));
            }
        } else
            for(int i=0; i<=9; i++){
                getListEditLinks.add(i,
                        driver.findElement(By.xpath(".//*[@id='table']/tbody/tr[" + i +"]/td[4]/a")));
            }
        return getListEditLinks;
    }
    //need to redo tr td:nth-child(5)
    public List<WebElement> getListDeleteLinks(){
        List<WebElement> getListDeleteLinks = new ArrayList<>();
        if (showFiveItems){
            for(int i=0; i<=4; i++){
                getListDeleteLinks.add(i,
                        driver.findElement(By.xpath(".//*[@id='table']/tbody/tr[" + i +"]/td[5]/a")));
            }
        } else
            for(int i=0; i<=9; i++){
                getListDeleteLinks.add(i,
                        driver.findElement(By.xpath(".//*[@id='table']/tbody/tr[" + i +"]/td[5]/a")));
            }
        return getListDeleteLinks;
    }


    //Set Elements

    public void setChangeFieldFilter(FieldFilterSupervisor fieldFilter) {
        getChangeFieldFilter().selectByVisibleText(fieldFilter.toString());
    }

    public void clickFirstButton(){
         getFirstButton().click();
    }

    public void clickBackwardButton(){
         getBackwardButton().click();
    }

    public void clickForwardButton(){
        getForwardButton().click();
    }

    public void clickLastButton(){
        getLastButton().click();
    }

    // go to another pages

    public AddProductPage gotoAddProductPage(){
         getAddProductLink().click();
        return new AddProductPage(driver);
    }

    public CreateReportPage gotoCreateReportPage(){
         getCreateReportLink().click();
        return new CreateReportPage(driver);
    }

    public EditProductPage gotoEditProductPage(int index){
        getListEditLinks().get(index).click();
        return new EditProductPage(driver);
    }


    // functional

    public void clickShowItemsLink(){
        getShowItemsLink().click();
        showFiveItems = !showFiveItems;
    }

    public void searchByName(String name){
        setChangeFieldFilter(FieldFilterSupervisor.NAME);
        getFieldFilterSelect().click();
        getFieldFilterSelect().clear();
        getFieldFilterSelect().sendKeys(name);
        getSearchButton().click();
    }

    public void searchByDescription(String description){
        setChangeFieldFilter(FieldFilterSupervisor.DESCRIPTION);
        getFieldFilterSelect().click();
        getFieldFilterSelect().clear();
        getFieldFilterSelect().sendKeys(description);
        getSearchButton().click();
    }

    public void deleteProduct(int index){
        getListDeleteLinks().get(index).click();
    }

}
