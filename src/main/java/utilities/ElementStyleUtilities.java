package utilities;

import org.openqa.selenium.WebElement;

public class ElementStyleUtilities {
    public static String[] getRGB(String color) {
        return color.substring(4).replace(")", "").replace(" ", "").split(",");
    }

    private static boolean decorationLineThrough(String decoration) {
        return decoration.contains("line-through");
    }

    private static boolean boldText(String decoration) {
        return Integer.parseInt(decoration) >= 700;
    }

    public static boolean verifyRegularPrice(WebElement regularPrice) {
        String color = regularPrice.getCssValue("Color");
        String decoration = regularPrice.getCssValue("text-decoration");

        return colorGray(getRGB(color)) && decorationLineThrough(decoration);
    }

    public static boolean verifyCampaignPrice(WebElement campaignPrice) {
        String color = campaignPrice.getCssValue("Color");
        String decoration = campaignPrice.getCssValue("font-weight");
        return colorRed(getRGB(color)) && boldText(decoration);
    }

    private static boolean colorRed(String[] rgb) {
        return rgb[1].equals("0") && rgb[2].equals("0");
    }

    private static boolean colorGray(String[] rgb) {
        String first = rgb[0];
        for (String rgbs : rgb) {
            if (!rgbs.equals(first)) {
                return false;
            }
        }
        return true;
    }

    public static boolean campaignPriceMoreThanRegularPrice(WebElement regularPrice, WebElement campaignPrice) {
        String regularPriceSize = regularPrice.getCssValue("font-size").replace("px", "");
        String campaignPriceSize = campaignPrice.getCssValue("font-size").replace("px", "");

        return Double.parseDouble(campaignPriceSize) > Double.parseDouble(regularPriceSize);
    }
}
