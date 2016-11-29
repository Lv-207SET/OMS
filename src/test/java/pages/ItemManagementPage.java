package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ItemManagementPage extends BasePage{

    // enum for elements in dropdown list

    public static enum ChangeFieldFilter {
        NAME("Name"), DESCRIPTION("Description");

        private String field;

        private ChangeFieldFilter(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }


    public ItemManagementPage(WebDriver driver) {
        super(driver);
    }

    private boolean showFiveItems = true;   // true - showing 5 items, false - showing 10 items in table

    //UI Mapping
    private final String USER_INFO_TAB_XPATH = ".//*[@id='nav']/li[2]/a";
    private final String PAGE_IS_APPOINTED_LABEL_XPATH = ".//*[@id='list']/h2";
    private final String ADD_PRODUCT_LINK_XPATH = ".//*[@id='list']/a[1]";
    private final String PRODUCTS_FOUND_LABEL_XPATH = ".//*[@id='list']/h4[1]";
    private final String PRODUCTS_COUNT_LABEL_ID = "recordsFound";
    private final String  SEARCH_BY_LABEL_XPATH = ".//*[@id='list']/fieldset/legend";
    private final String  FIELD_FILTER_LABEL_XPATH = ".//*[@id='searchForm']/label";
    private final String  FIELD_FILTER_SELECT_ID = "field";
    private final String  SEARCH_FIELD_ID = "searchField";
    private final String  SEARCH_BUTTON_XPATH =  ".//*[@id='searchField']/following-sibling::input";
    private final String SHOW_ITEMS_LINK_XPATH = ".//a[@href='itemManagement/resizeItemList.htm']";
    private final String TABLE_NAME_LINK_XPATH =".//*[@id='table']/thead/tr/th[1]/a";
    private final String TABLE_DESCRIPTION_LINK_XPATH =".//*[@id='table']/thead/tr/th[2]/a";
    private final String TABLE_PRICE_LINK_XPATH =".//*[@id='table']/thead/tr/th[3]/a";
    private final String TABLE_EDIT_LABEL_XPATH =".//*[@id='table']/thead/tr/th[4]";
    private final String TABLE_DELETE_LABEL_XPATH =".//*[@id='table']/thead/tr/th[5]";
    private final String FIRST_BUTTON_ID ="first";
    private final String BACKWARD__BUTTON_ID ="previous";
    private final String FORWARD__BUTTON_ID ="next";
    private final String LAST__BUTTON_ID ="last";
    private final String PAGE_LABEL_XPATH = ".//*[@id='list']/h4[2]";
    private final String PAGE_NUMBER_LABEL_ID = "pageNumber";
    private final String PAGE_COUNT_LABEL_ID = "pageCount";
    private final String CREATE_REPORT_LINK_XPATH = ".//a[@href='reportItems.htm']";


    //get Elements

    public WebElement getUserInfoTab() {
        return driver.findElement(By.xpath(USER_INFO_TAB_XPATH));
    }

    public WebElement getPageIsAppointedLabel() {
        return driver.findElement(By.xpath(PAGE_IS_APPOINTED_LABEL_XPATH));
    }

    public WebElement getAddProductLink() {
        return driver.findElement(By.xpath(ADD_PRODUCT_LINK_XPATH));
    }

    public WebElement getProductsFoundLabel() {
        return driver.findElement(By.xpath(PRODUCTS_FOUND_LABEL_XPATH));
    }

    public WebElement getProductsCountLabel() {
        return driver.findElement(By.id(PRODUCTS_COUNT_LABEL_ID));
    }

    public WebElement getSearchByLabel() {
        return driver.findElement(By.xpath(SEARCH_BY_LABEL_XPATH));
    }

    public WebElement getFieldFilterLabel() {
        return driver.findElement(By.xpath(FIELD_FILTER_LABEL_XPATH));
    }

    public WebElement getFieldFilterSelect() {
        return driver.findElement(By.id(FIELD_FILTER_SELECT_ID));
    }

    public WebElement getSearchField() {
        return driver.findElement(By.id(SEARCH_FIELD_ID));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.xpath(SEARCH_BUTTON_XPATH));
    }

    public WebElement getShowItemsLink() {
        return driver.findElement(By.xpath(SHOW_ITEMS_LINK_XPATH));
    }

    public WebElement getTableNameLink() {
        return driver.findElement(By.xpath(TABLE_NAME_LINK_XPATH));
    }

    public WebElement getTableDescriptionLink() {
        return driver.findElement(By.xpath(TABLE_DESCRIPTION_LINK_XPATH));
    }

    public WebElement getTablePriceLink() {
        return driver.findElement(By.xpath(TABLE_PRICE_LINK_XPATH));
    }

    public WebElement getTableEditLabel() {
        return driver.findElement(By.xpath(TABLE_EDIT_LABEL_XPATH));
    }

    public WebElement getTableDeleteLabel() {
        return driver.findElement(By.xpath(TABLE_DELETE_LABEL_XPATH));
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
        return driver.findElement(By.xpath(PAGE_LABEL_XPATH));
    }

    public WebElement getPageNumberLabel() {
        return driver.findElement(By.id(PAGE_NUMBER_LABEL_ID));
    }

    public WebElement getPageCountLabel() {
        return driver.findElement(By.id(PAGE_COUNT_LABEL_ID));
    }

    public WebElement getCreateReportLink() {
        return driver.findElement(By.xpath(CREATE_REPORT_LINK_XPATH));
    }

    public Select getChangeFieldFilter() {
        return new Select(getFieldFilterSelect());
    }

    public String getChangeFieldFilterSelectedText() {
        return getChangeFieldFilter().getFirstSelectedOption().getText();
    }

    //get List WebElements from table

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

    public void setChangeFieldFilter(ChangeFieldFilter fieldFilter) {
        getChangeFieldFilter().selectByVisibleText(fieldFilter.toString());
    }

    public void clickShowItemsLink(){
        getShowItemsLink().click();
        showFiveItems = !showFiveItems;
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



















}
