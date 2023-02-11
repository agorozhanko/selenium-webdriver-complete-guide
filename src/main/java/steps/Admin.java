package steps;

import config.ConfigurationProperties;
import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


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
                    DriverManager.getInstance().findElement(By.xpath(getSubAppMenuXpath(subAppsMenuName))).click();
                    if (headerIsDisplayed()) return false;
                }
            }
        }
        return true;
    }

    private static ArrayList<String> getAppMenuNames() {
        List<WebElement> appsMenu = DriverManager.getInstance().findElements(By.id("app-"));
        ArrayList<String> appMenuNames = new ArrayList<>();
        for (WebElement menu : appsMenu) {
            appMenuNames.add(menu.getText());
        }
        return appMenuNames;
    }

    private static ArrayList<String> getSubAppMenuNames() {
        DriverManager.getInstance().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> subAppsMenu = DriverManager.getInstance().findElements(
                By.xpath("//ul[@class='docs']//span"));
        ArrayList<String> subAppsMenuNames = new ArrayList<>();
        for (WebElement menu : subAppsMenu) {
            subAppsMenuNames.add(menu.getText());
        }
        DriverManager.getInstance().manage().timeouts().implicitlyWait(
                ConfigurationProperties.getInstance().getTimeoutImplicitlyWait(), TimeUnit.SECONDS);
        return subAppsMenuNames;
    }

    private static void appMenuClick(String appsMenuName) {
        WebElement appsMenu = DriverManager.getInstance().findElement(By.xpath(getAppMenuXpath(appsMenuName)));
        appsMenu.click();
    }

    private static boolean headerIsDisplayed() {
        WebElement header = DriverManager.getInstance().findElement(By.xpath("//h1"));
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
