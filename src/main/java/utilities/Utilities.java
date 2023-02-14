package utilities;

import core.DriverManager;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
    public static String[] getObjectsNamesFromText(String xpath) {
        List<WebElement> objectsNames = DriverManager.findElementsByXPath(xpath);
        List<String> countriesNamesText = new ArrayList<>();
        for (WebElement objectNames : objectsNames) {
            countriesNamesText.add(objectNames.getText());
        }
        return countriesNamesText.toArray(new String[0]);
    }
}
