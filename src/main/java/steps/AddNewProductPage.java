package steps;

import core.DriverManager;
import model.Product;
import org.openqa.selenium.support.ui.Select;

public class AddNewProductPage {

    public static void addNewProduct(Product product) {
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

    private static void setStatusEnabled() {
        DriverManager.findElementByXPath("//input[@name='status' and @value='1']").click();
    }

    private static void fillName(String name) {
        DriverManager.findElementByName("name[en]").sendKeys(name);
    }

    private static void fillCode(String code) {
        DriverManager.findElementByName("code").sendKeys(code);
    }

    private static void goToInformationTab() {
        DriverManager.waiting(100);
        DriverManager.findElementByXPath("//a[text()='Information']").click();
    }

    private static void selectManufacturer(String manufacturer) {
        Select select = new Select(DriverManager.findElementByName("manufacturer_id"));
        select.selectByVisibleText(manufacturer);
    }

//    private static void selectSupplier(String supplier) {
//        Select select = new Select(DriverManager.findElementByName("supplier_id"));
//        select.selectByVisibleText(supplier);
//    }

    private static void fillKeywords(String keywords) {
        DriverManager.findElementByName("keywords").sendKeys(keywords);
    }

    private static void fillShortDescription(String shortDescription) {
        DriverManager.findElementByName("short_description[en]").sendKeys(shortDescription);
    }

    private static void fillDescription(String description) {
        DriverManager.findElementByName("description[en]").sendKeys(description);
    }

    private static void fillHeadTitle(String headTitle) {
        DriverManager.findElementByName("head_title[en]").sendKeys(headTitle);
    }

    private static void fillMetaDescription(String metaDescription) {
        DriverManager.findElementByName("meta_description[en]").sendKeys(metaDescription);
    }

    private static void uploadFile(String path) {
        DriverManager.findElementByName("new_images[]").sendKeys(path);
    }

    private static void goToPricesTab() {
        DriverManager.waiting(100);
        DriverManager.findElementByXPath("//a[text()='Prices']").click();
    }

    private static void fillPurchasePrice(String purchasePrice) {
        DriverManager.findElementByName("purchase_price").clear();
        DriverManager.findElementByName("purchase_price").sendKeys(purchasePrice);
    }

    private static void selectPurchasePriceCurrency(String purchasePriceCurrency) {
        Select select = new Select(DriverManager.findElementByName("purchase_price_currency_code"));
        select.selectByVisibleText(purchasePriceCurrency);
    }

    private static void fillPricesUSD(String prices) {
        DriverManager.findElementByName("prices[USD]").sendKeys(prices);
    }

    private static void save() {
        DriverManager.findElementByName("save").click();
    }

    public static boolean newProductAdded() {
        String noticeSuccess = "//div[@class='notice success' and text()=' Changes were successfully saved.']";
        return DriverManager.findElementByXPath(noticeSuccess).isDisplayed();
    }

    public static boolean newProductIsDisplayed(String name) {
        String nameXpath = String.format("//a[text()='%s']", name);
        return DriverManager.findElementByXPath(nameXpath).isDisplayed();
    }
}
