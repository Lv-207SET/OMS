package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductPage extends BasePage {

    private WebDriver driver;
    private final static String ADD_PRODUCT_LABEL_CSS = "#edit h3";
    private final static String PRODUCT_NAME_INPUT_ID = "name";
    private final static String PRODUCT_DESCRIPTION_TEXTAREA_ID = "description";
    private final static String PRODUCT_PRICE_ID = "price";
    private final static String OK_BUTTON_CSS = "[value='OK']";
    private final static String CANCEL_BUTTON_CSS= "[value='Cancel']";
    private final static String ITEM_MANAGEMENT_TAB_CSS = "#nav .cur a";
    private final static String PRODUCT_NAME_ERROR_MESSAGE_ID = "productName.errors";
    private final static String PRODUCT_PRICE_ERROR_MESSAGE_ID = "productPrice.errors";

    public AddProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddProductLabel() {
        return driver.findElement(By.cssSelector(ADD_PRODUCT_LABEL_CSS));
    }

    public void enterProductName(String productNameValue) {
        WebElement productNameInput = driver.findElement(By.id(PRODUCT_NAME_INPUT_ID));
        productNameInput.clear();
        productNameInput.sendKeys(productNameValue);
    }

    public void enterProductDescription(String productDescriptionValue) {
        WebElement productDescriptionTextarea = driver.findElement(By.id(PRODUCT_DESCRIPTION_TEXTAREA_ID));
        productDescriptionTextarea.clear();
        productDescriptionTextarea.sendKeys(productDescriptionValue);
    }

    public void enterProductPrice(String productPriceValue) {
        WebElement productPriceInput = driver.findElement(By.id(PRODUCT_PRICE_ID));
        productPriceInput.clear();
        productPriceInput.sendKeys(productPriceValue);
    }

    public String getProductNameErrorMessage() {
        WebElement productNameErrorMessage = driver.findElement(By.id(PRODUCT_NAME_ERROR_MESSAGE_ID));
        return productNameErrorMessage.getText();
    }

    public String getProductPriceErrorMessage() {
        WebElement productPriceErrorMessage = driver.findElement(By.id(PRODUCT_PRICE_ERROR_MESSAGE_ID));
        return productPriceErrorMessage.getText();
    }

    public ItemManagementPage clickOkButton() {
        WebElement okButton = driver.findElement(By.cssSelector(OK_BUTTON_CSS));
        okButton.click();
        return new ItemManagementPage(driver);
    }

    public ItemManagementPage clickCancelButton() {
        WebElement cancelButton = driver.findElement(By.cssSelector(CANCEL_BUTTON_CSS));
        cancelButton.click();
        return new ItemManagementPage(driver);
    }

    public ItemManagementPage clickOnItemManagementTab () {
        driver.findElement(By.cssSelector(ITEM_MANAGEMENT_TAB_CSS)).click();
        return new ItemManagementPage(driver);
    }
}
