package pages;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartBlock {

    @FindBy(xpath = "//a[text()='Checkout »']")
    private WebElement checkout;

    public CartBlock() {
        PageFactory.initElements(DriverManager.getInstance(), this);
    }

    public WebElement quantityIsExist(int quantityProduct) {
        String quantityXpath = "//span[@class='quantity' and text()=%s]";
        return DriverManager.findElementByXPath(String.format(quantityXpath, quantityProduct));
    }

    public ShoppingCartPage checkout() {
        checkout.click();
        return new ShoppingCartPage();
    }


}
