package steps;

import core.DriverManager;
import org.apache.commons.lang3.ArrayUtils;

import static utilities.Utilities.getObjectsNamesFromText;

public class GeoZones {
    public static boolean verifySorting() {
        String[] countries = getObjectsNamesFromText("//td[3]/a");
        for (String country : countries) {
            DriverManager.findElementByXPath(getCountryNameXpath(country)).click();
            String[] zones = getObjectsNamesFromText("//select[contains(@name,'zone_code')]/option[@selected]");
            if (!ArrayUtils.isSorted(zones)) {
                return false;
            }
            DriverManager.back();
        }
        return true;
    }

    public static String getCountryNameXpath(String name) {
        return String.format("//td[3]/a[text()='%s']", name);
    }
}
