package utilities;

import core.DriverManager;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
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

    public static String getName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String getPhone() {
        return RandomStringUtils.randomNumeric(9);
    }

    public static String getPrice() {
        return RandomStringUtils.randomNumeric(3);
    }

    public static String buildPathToFile(String fileRelativePath) {
        try {
            return FilenameUtils.separatorsToSystem(new File("./").getCanonicalPath() + File.separator + fileRelativePath);
        } catch (IOException ioException) {
            throw new RuntimeException("Could not parse absolute path to WebDriver. Relative path is " + fileRelativePath);
        }
    }
}
