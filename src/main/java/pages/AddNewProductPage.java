package pages;

import core.DriverManager;
import model.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewProductPage {

    @FindBy(xpath = "//input[@name='status' and @value='1']")
    private WebElement status;
    @FindBy(name = "name[en]")
    private WebElement name;
    @FindBy(name = "code")
    private WebElement code;
    @FindBy(xpath = "//a[text()='Information']")
    private WebElement informationTab;
    @FindBy(name = "manufacturer_id")
    private WebElement manufacturerId;
    @FindBy(name = "keywords")
    private WebElement keywords;
    @FindBy(name = "short_description[en]")
    private WebElement shortDescription;
    @FindBy(name = "description[en]")
    private WebElement description;
    @FindBy(name = "head_title[en]")
    private WebElement headTitle;
    @FindBy(name = "meta_description[en]")
    private WebElement metaDescription;
    @FindBy(name = "new_images[]")
    private WebElement newImages;
    @FindBy(xpath = "//a[text()='Prices']")
    private WebElement pricesTab;
    @FindBy(name = "purchase_price")
    private WebElement purchasePrice;
    @FindBy(name = "purchase_price_currency_code")
    private WebElement purchasePriceCurrencyCode;
    @FindBy(name = "prices[USD]")
    private WebElement prices;
    @FindBy(name = "save")
    private WebElement save;
    @FindBy(xpath = "//div[@class='notice success' and text()=' Changes were successfully saved.']")
    private WebElement noticeSuccess;

    public AddNewProductPage() {
        PageFactory.initElements(DriverManager.getInstance(), this);
    }

    public void addNewProduct(Product product) {
        DriverManager.waiting(100);
        setStatusEnabled();
        fillName(product.getName());
        fillCode(product.getCode());

        goToInformationTab();
        selectManufacturer(product.getManufacturer());
        fillKeywords(product.getKeywords());
        fillShortDescription(product.getShortDescription());
        fillDescription(product.getDescription());
        fillHeadTitle(product.getHeadTitle());
        fillMetaDescription(product.getMetaDescription());
        uploadFile(product.getImage());

        goToPricesTab();
        fillPurchasePrice(product.getPurchasePrice());
        selectPurchasePriceCurrency(product.getPurchasePriceCurrency());
        fillPricesUSD(product.getPrice());
        save();
    }

    private void setStatusEnabled() {
        status.click();
    }

    private void fillName(String productName) {
        name.sendKeys(productName);
    }

    private void fillCode(String productCode) {
        code.sendKeys(productCode);
    }

    private void goToInformationTab() {
        DriverManager.waiting(100);
        informationTab.click();
    }

    private void selectManufacturer(String manufacturer) {
        Select select = new Select(manufacturerId);
        select.selectByVisibleText(manufacturer);
    }

    private void fillKeywords(String productKeywords) {
        keywords.sendKeys(productKeywords);
    }

    private void fillShortDescription(String productShortDescription) {
        shortDescription.sendKeys(productShortDescription);
    }

    private void fillDescription(String productDescription) {
        description.sendKeys(productDescription);
    }

    private void fillHeadTitle(String productHeadTitle) {
        headTitle.sendKeys(productHeadTitle);
    }

    private void fillMetaDescription(String productMetaDescription) {
        metaDescription.sendKeys(productMetaDescription);
    }

    private void uploadFile(String productPath) {
        newImages.sendKeys(productPath);
    }

    private void goToPricesTab() {
        DriverManager.waiting(100);
        pricesTab.click();
    }

    private void fillPurchasePrice(String productPurchasePrice) {
        purchasePrice.clear();
        purchasePrice.sendKeys(productPurchasePrice);
    }

    private void selectPurchasePriceCurrency(String productPurchasePriceCurrency) {
        Select select = new Select(purchasePriceCurrencyCode);
        select.selectByVisibleText(productPurchasePriceCurrency);
    }

    private void fillPricesUSD(String productPrices) {
        prices.sendKeys(productPrices);
    }

    private void save() {
        save.click();
    }

    public boolean newProductAdded() {
        return noticeSuccess.isDisplayed();
    }

    public boolean newProductIsDisplayed(String name) {
        String nameXpath = String.format("//a[text()='%s']", name);
        return DriverManager.findElementByXPath(nameXpath).isDisplayed();
    }
}
