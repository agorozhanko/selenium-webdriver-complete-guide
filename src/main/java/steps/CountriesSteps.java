package steps;

import core.DriverManager;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CountriesSteps {
    private static final List<WebElement> countriesNames = DriverManager.findElementsByXPath(("//td[5]"));
    private static final List<WebElement> countriesZonesCount = DriverManager.findElementsByXPath(("//td[6]"));

    public static boolean verifyCountriesNamesSorting() {
        return ArrayUtils.isSorted(getCountriesNames());
    }

    private static String[] getCountriesNames() {
        List<String> countriesNamesText = new ArrayList<>();
        for (WebElement countryName : countriesNames) {
            countriesNamesText.add(countryName.getText());
        }
        return countriesNamesText.toArray(new String[0]);
    }

    public static boolean verifyZonesSorting() {
        List<String> countriesNamesWithZone = getCountriesNamesWithZones();
        for (String countryNamesWithZone : countriesNamesWithZone) {
            DriverManager.findElementByXPath(getCountryNameXpath(countryNamesWithZone)).click();
            String[] zonesNames = getZonesNames();
            if (!ArrayUtils.isSorted(zonesNames)) {
                return false;
            }
            DriverManager.back();
        }
        return true;
    }

    private static String[] getZonesNames() {
        List<WebElement> zones = DriverManager.findElementsByXPath("//td[3]/input[contains(@name,'zones')]");
        List<String> zonesNames = new ArrayList<>();
        for (WebElement zone : zones) {
            zonesNames.add(zone.getAttribute("value"));
        }
        return zonesNames.toArray(new String[0]);
    }

    public static List<String> getCountriesNamesWithZones() {
        List<String> countriesNames = new ArrayList<>();
        for (WebElement countryZonesCount : countriesZonesCount) {
            if (!countryZonesCount.getText().equals("0")) {
                String countriesName = countryZonesCount.findElement(By.xpath("./../td[5]")).getText();
                countriesNames.add(countriesName);
            }
        }
        return countriesNames;
    }

    public static String getCountryNameXpath(String name) {
        return String.format("//td/a[text()='%s']", name);
    }
}
