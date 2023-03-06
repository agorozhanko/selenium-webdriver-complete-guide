package pages;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementStyleUtilities;

public class ProductPage extends CartBlock {

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement name;
    @FindBy(xpath = "//*[@class='regular-price']")
    private WebElement regularPrice;
    @FindBy(xpath = "//strong[@class='campaign-price']")
    private WebElement campaignPrice;
    @FindBy(name = "add_cart_product")
    private WebElement addCartProduct;

    public ProductPage() {
        PageFactory.initElements(DriverManager.getInstance(), this);
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

    public void addCartProduct(int quantityProduct) {
        addCartProduct.click();
        quantityIsExist(quantityProduct);
    }

}
