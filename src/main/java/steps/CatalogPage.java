package steps;

import core.DriverManager;

import static utilities.Utilities.getObjectsNamesFromText;

public class CatalogPage {

    public static void openCatalog() {
        DriverManager.open("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
    }

    public static boolean checkBrowserLogsInProductPage() {
        String[] productNames = getProductNames();
        for (String productName : productNames) {
            DriverManager.findElementByXPath(getProductXPathByName(productName)).click();
            if (!DriverManager.browserLogsEmpty()) {
                return false;
            }
            DriverManager.back();
        }
        return true;
    }

    public static String[] getProductNames() {
        return getObjectsNamesFromText("//a[contains(@href,'product_id') and not(@title='Edit')]");
    }

    public static String getProductXPathByName(String name) {
        return String.format("//a[text()='%s']", name);
    }

}
