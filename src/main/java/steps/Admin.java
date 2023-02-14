package steps;

import core.DriverManager;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class Admin {
    public static boolean checkHeaders() {
        ArrayList<String> appsMenuNames = getAppMenuNames();
        for (String appsMenuName : appsMenuNames) {
            appMenuClick(appsMenuName);
            ArrayList<String> subAppsMenuNames = getSubAppMenuNames();
            if (subAppsMenuNames.size() == 0) {
                if (headerIsDisplayed()) return false;
            } else {
                for (String subAppsMenuName : subAppsMenuNames) {
                    DriverManager.findElementByXPath((getSubAppMenuXpath(subAppsMenuName))).click();
                    if (headerIsDisplayed()) return false;
                }
            }
        }
        return true;
    }

    private static ArrayList<String> getAppMenuNames() {
        List<WebElement> appsMenu = DriverManager.findElementsByID(("app-"));
        ArrayList<String> appMenuNames = new ArrayList<>();
        for (WebElement menu : appsMenu) {
            appMenuNames.add(menu.getText());
        }
        return appMenuNames;
    }

    private static ArrayList<String> getSubAppMenuNames() {
        DriverManager.setImplicitlyWait(2);
        List<WebElement> subAppsMenu = DriverManager.findElementsByXPath(("//ul[@class='docs']//span"));
        ArrayList<String> subAppsMenuNames = new ArrayList<>();
        for (WebElement menu : subAppsMenu) {
            subAppsMenuNames.add(menu.getText());
        }
        DriverManager.setImplicitlyWait();
        return subAppsMenuNames;
    }

    private static void appMenuClick(String appsMenuName) {
        WebElement appsMenu = DriverManager.findElementByXPath((getAppMenuXpath(appsMenuName)));
        appsMenu.click();
    }

    private static boolean headerIsDisplayed() {
        WebElement header = DriverManager.findElementByXPath(("//h1"));
        if (!header.isDisplayed()) {
            return true;
        }
        return false;
    }

    private static String getAppMenuXpath(String appsMenu) {
        return String.format("//li[@id='app-']//span[text()='%s']", appsMenu);
    }

    private static String getSubAppMenuXpath(String appsMenu) {
        return String.format("//ul[@class='docs']//span[text()='%s']", appsMenu);
    }
}
