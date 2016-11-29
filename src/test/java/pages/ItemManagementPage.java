package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ItemManagementPage extends BasePage{

    public static enum ChangeFieldFilter {
        NAME("Name"), DESCRIPTION("Description");

        //
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
        this.driver = driver;
    }

    private WebDriver driver;

    private final String USER_INFO_TAB_XPATH = ".//*[@id='nav']/li[2]/a";
    private final String PAGE_IS_APPOINTED_LABEL_XPATH = ".//*[@id='list']/h2";
    private final String ADD_PRODUCT_LINK_XPATH = ".//*[@id='list']/a[1]";
    private final String PRODUCTS_COUNT_LABEL_ID = "recordsFound";
    private final String  SEARCH_BY_LABEL_XPATH = ".//*[@id='list']/fieldset/legend";
    private final String  FIELD_FILTER_LABEL_XPATH = ".//*[@id='searchForm']/label";
    private final String  FIELD_FILTER_SELECT_ID = "field";
    private final String  SEARCH_FIELD_ID = "searchField";



    //get Elements

    public WebElement getFieldFilterSelect(){
        return driver.findElement(By.id(FIELD_FILTER_SELECT_ID));
    }

    public Select getChangeFieldFilter() {
        return new Select(getFieldFilterSelect());
    }

    public String getChangeFieldFilterSelectedText() {
        return getChangeFieldFilter().getFirstSelectedOption().getText();
    }

    //Set Elements

    public void setChangeFieldFilter(ChangeFieldFilter fieldFilter) {
        getChangeFieldFilter().selectByVisibleText(fieldFilter.toString());
    }













}
