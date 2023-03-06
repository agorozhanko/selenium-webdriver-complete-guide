package pages;

import core.DriverManager;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class CountriesPage {

    public static boolean verifyCountriesNamesSorting() {
        return ArrayUtils.isSorted(Utilities.getObjectsNamesFromText("//td[5]"));
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
        List<WebElement> countriesZonesCount = DriverManager.findElementsByXPath(("//td[6]"));
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

    public static void clickAddNewCountry() {
        DriverManager.findElementByXPath("//a[text()=' Add New Country']").click();
    }
}
