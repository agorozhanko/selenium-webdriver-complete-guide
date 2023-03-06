package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementStyleUtilities;

import java.util.List;
import java.util.NoSuchElementException;

public class ShopPage extends CartBlock {

    @FindBy(xpath = "//li[contains(@class, 'product')]")
    List<WebElement> products;
    @FindBy(xpath = "//div[@id='box-campaigns']//li[contains(@class,'product')]")
    WebElement campaignProduct;
    @FindBy(xpath = "//div[@id='box-campaigns']//li[contains(@class,'product')]//div[@class='name']")
    WebElement name;
    @FindBy(xpath = "//div[@id='box-campaigns']//li[contains(@class,'product')]//*[@class='regular-price']")
    WebElement regularPrice;
    @FindBy(xpath = "//div[@id='box-campaigns']//li[contains(@class,'product')]//strong[@class='campaign-price']")
    WebElement campaignPrice;
    @FindBy(xpath = "//a[text()='New customers click here']")
    WebElement newCustomer;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(name = "login")
    WebElement login;
    @FindBy(xpath = "//div[@id='box-account']//a[text()='Logout']")
    WebElement logout;
    @FindBy(xpath = "//div[@class='notice success' and text()=' Your customer account has been created.']")
    WebElement accountIsCreated;
    @FindBy(xpath = "//div[@class='notice success' and contains(text(),' You are now logged in as')]")
    WebElement loginSuccess;
    @FindBy(xpath = "//div[@class='notice success' and text()=' You are now logged out.']")
    WebElement logoutSuccess;

    public ShopPage() {
        PageFactory.initElements(DriverManager.getInstance(), this);
    }

    public void open() {
        DriverManager.open("http://localhost/litecart/");
    }

    public CreateAccountPage newCustomerClick() {
        newCustomer.click();
        return new CreateAccountPage();
    }

    public boolean accountIsCreated() {
        return accountIsCreated.isDisplayed();
    }

    public boolean login(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        loginClick();
        return loginSuccess();
    }

    private boolean loginSuccess() {
        return loginSuccess.isDisplayed();
    }

    private void fillEmail(String userEmail) {
        email.sendKeys(userEmail);
    }

    private void fillPassword(String userPassword) {
        password.sendKeys(userPassword);
    }

    private void loginClick() {
        login.click();
    }

    public boolean logout() {
        logout.click();
        return logoutSuccess();
    }

    private boolean logoutSuccess() {
        return logoutSuccess.isDisplayed();
    }

    public boolean checkStickers() {
        String sticker = ".//div[contains(@class, 'sticker')]";
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

    public String getName() {
        return name.getText();
    }

    public String getRegularPrice() {
        return regularPrice.getText();
    }

    public String getCampaignPrice() {
        return campaignPrice.getText();
    }

    public boolean verifyRegularPrice() {
        return ElementStyleUtilities.verifyRegularPrice(regularPrice);
    }

    public boolean verifyCampaignPrice() {
        return ElementStyleUtilities.verifyCampaignPrice(campaignPrice);
    }

    public boolean campaignPriceMoreThanRegularPrice() {
        return ElementStyleUtilities.campaignPriceMoreThanRegularPrice(regularPrice, campaignPrice);
    }

    public void addThreeProducts() {
        for (int i = 1; i < 4; i++) {
            ProductPage productpage = openFirstProduct();
            productpage.addCartProduct(i);
            open();
        }
    }

    public ProductPage openFirstProduct() {
        return openProduct(products.get(0));
    }

    public ProductPage openFirstCampaignProduct() {
        return openProduct(campaignProduct);
    }

    public ProductPage openProduct(WebElement product) {
        product.click();
        DriverManager.waiting(100);
        return new ProductPage();
    }
}