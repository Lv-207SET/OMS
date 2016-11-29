package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductPage extends BasePage {

    private WebDriver driver;
    private final String ADD_PRODUCT_LABEL_XPATH = "//*[@id='edit']/h3";
    private final String PRODUCT_NAME_INPUT_ID = "name";
    private final String PRODUCT_DESCRIPTION_TEXTAREA_ID = "description";
    private final String PRODUCT_PRICE_ID = "price";
    private final String OK_BUTTON_XPATH = "//*[@value='OK']";
    private final String CANCEL_BUTTON_XPATH = "//*[@value='Cancel']";
    private final String ITEM_MANAGEMENT_TAB_XPATH = "//a[@href='itemManagement.htm']";
    private final String PRODUCT_NAME_ERROR_MESSAGE_ID = "productName.errors";
    private final String PRODUCT_PRICE_ERROR_MESSAGE_ID = "productPrice.errors";

    public AddProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddProductLabel() {
        return driver.findElement(By.xpath(ADD_PRODUCT_LABEL_XPATH));
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
        WebElement okButton = driver.findElement(By.xpath(OK_BUTTON_XPATH));
        okButton.click();
        return new ItemManagementPage(driver);
    }

    public ItemManagementPage clickCancelButton() {
        WebElement cancelButton = driver.findElement(By.xpath(CANCEL_BUTTON_XPATH));
        cancelButton.click();
        return new ItemManagementPage(driver);
    }

    public ItemManagementPage clickOnItemManagementTab () {
        driver.findElement(By.xpath(ITEM_MANAGEMENT_TAB_XPATH)).click();
        return new ItemManagementPage(driver);
    }
}
