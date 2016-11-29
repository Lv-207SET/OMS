package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProductPage extends BasePage {

    private WebDriver driver;
    final static private String ADD_PRODUCT_LABEL_XPATH = "//*[@id='edit']/h3";
    final static private String PRODUCT_NAME_INPUT_ID = "name";
    final static private String PRODUCT_DESCRIPTION_TEXTAREA_ID = "description";
    final static private String PRODUCT_PRICE_ID = "price";
    final static private String OK_BUTTON_XPATH = "//*[@value='OK']";
    final static private String CANCEL_BUTTON_XPATH = "//*[@value='Cancel']";

    public EditProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
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

}
