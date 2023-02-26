package steps;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ElementStyleUtilities;

import java.util.List;
import java.util.NoSuchElementException;

public class ShopPage extends CartBlock {
    private static final List<WebElement> products = DriverManager.findElementsByXPath(("//li[contains(@class, 'product')]"));
    private static final String sticker = ".//div[contains(@class, 'sticker')]";
    private static final WebElement campaignProduct = DriverManager.findElementByXPath("//div[@id='box-campaigns']//li[contains(@class,'product')]");
    private static final WebElement name = campaignProduct.findElement(By.xpath(".//div[@class='name']"));
    private static final WebElement regularPrice = campaignProduct.findElement(By.xpath(".//*[@class='regular-price']"));
    private static final WebElement campaignPrice = campaignProduct.findElement(By.xpath(".//strong[@class='campaign-price']"));

    public static void openShopPage() {
        DriverManager.open("http://localhost/litecart/");
    }

    public static void newCustomerClick() {
        DriverManager.findElementByXPath("//a[text()='New customers click here']").click();
    }

    public static boolean accountIsCreated() {
        String noticeSuccess = "//div[@class='notice success' and text()=' Your customer account has been created.']";
        return DriverManager.findElementByXPath(noticeSuccess).isDisplayed();
    }

    public static boolean login(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        loginClick();
        return loginSuccess();
    }

    private static boolean loginSuccess() {
        String noticeSuccess = "//div[@class='notice success' and contains(text(),' You are now logged in as')]";
        return DriverManager.findElementByXPath(noticeSuccess).isDisplayed();
    }

    private static void fillEmail(String email) {
        DriverManager.findElementByName("email").sendKeys(email);
    }

    private static void fillPassword(String password) {
        DriverManager.findElementByName("password").sendKeys(password);
    }

    private static void loginClick() {
        DriverManager.findElementByName("login").click();
    }

    public static boolean logout() {
        DriverManager.findElementByXPath("//div[@id='box-account']//a[text()='Logout']").click();
        return logoutSuccess();
    }

    private static boolean logoutSuccess() {
        String noticeSuccess = "//div[@class='notice success' and text()=' You are now logged out.']";
        return DriverManager.findElementByXPath(noticeSuccess).isDisplayed();
    }

    public static boolean checkStickers() {
        for (WebElement product : products) {
            List<WebElement> stickers = product.findElements(By.xpath(sticker));
            int size = stickers.size();
            if (size == 0) {
                throw new NoSuchElementException("Product doesn't have a sticker!");
            } else {
                if (size != 1) {
                    throw new IllegalStateException("Product has more than one sticker!");
                }
            }
        }
        return true;
    }

    public static String getName() {
        return name.getText();
    }

    public static String getRegularPrice() {
        return regularPrice.getText();
    }

    public static String getCampaignPrice() {
        return campaignPrice.getText();
    }

    public static boolean verifyRegularPrice() {
        return ElementStyleUtilities.verifyRegularPrice(regularPrice);
    }

    public static boolean verifyCampaignPrice() {
        return ElementStyleUtilities.verifyCampaignPrice(campaignPrice);
    }

    public static boolean campaignPriceMoreThanRegularPrice() {
        return ElementStyleUtilities.campaignPriceMoreThanRegularPrice(regularPrice, campaignPrice);
    }

    public static void addThreeProducts() {
        for (int i = 1; i < 4; i++) {
            openFirstProduct();
            ProductPage.addCartProduct(i);
            openShopPage();
        }
    }

    public static void openFirstProduct() {
        String productXpath = "//li[contains(@class,'product')]";
        List<WebElement> campaignProducts = DriverManager.findElementsByXPath(productXpath);
        campaignProducts.get(0).click();
    }

    public static void openFirstCampaignProduct() {
        openProduct(campaignProduct);
    }

    public static void openProduct(WebElement product) {
        product.click();
        DriverManager.waiting(100);
    }
}