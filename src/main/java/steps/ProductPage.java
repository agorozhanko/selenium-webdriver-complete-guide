package steps;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import utilities.ElementStyleUtilities;

public class ProductPage {
    private static final WebElement name = DriverManager.findElementByXPath("//h1[@itemprop='name']");
    private static final WebElement regularPrice = DriverManager.findElementByXPath("//*[@class='regular-price']");
    private static final WebElement campaignPrice = DriverManager.findElementByXPath("//strong[@class='campaign-price']");

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
}
