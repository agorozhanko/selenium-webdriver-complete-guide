package core;


import config.ConfigurationProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static ConfigurationProperties configProperties = ConfigurationProperties.getInstance();

    private static WebDriver driverExtension;

    public static WebDriver getInstance() {
        if (driverExtension == null) {
            driverExtension = BrowserTypeFactory.createBrowser(configProperties.getBrowserType());
            driverExtension.manage().timeouts().pageLoadTimeout(configProperties.getTimeoutPageLoad(), TimeUnit.SECONDS);
            driverExtension.manage().timeouts().implicitlyWait(configProperties.getTimeoutImplicitlyWait(), TimeUnit.SECONDS);
        }
        return driverExtension;
    }

    public static void open() {
        getInstance().get(configProperties.getEndpoint());
    }

    public static void open(String url) {
        getInstance().get(url);
    }

    public static void setImplicitlyWait() {
        getInstance().manage().timeouts().implicitlyWait(
                ConfigurationProperties.getInstance().getTimeoutImplicitlyWait(), TimeUnit.SECONDS);
    }

    public static void setImplicitlyWait(long timeout) {
        getInstance().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public static void waiting(long waitPeriod) {
        try {
            TimeUnit.MILLISECONDS.sleep(waitPeriod);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public static ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }

    public static List<LogEntry> getAllBrowserLogs() {
        return getInstance().manage().logs().get("browser").getAll();
    }

    public static boolean browserLogsEmpty() {
        return getAllBrowserLogs().size() == 0;
    }

    public static void clearAllCookies() {
        getInstance().manage().deleteAllCookies();
    }

    public static void back() {
        getInstance().navigate().back();
    }

    public static void stop() {
        getInstance().quit();
        driverExtension = null;
    }

    public static WebElement findElementByXPath(String xpath) {
        return getInstance().findElement(By.xpath(xpath));
    }

    public static WebElement findElementByID(String id) {
        return getInstance().findElement(By.id(id));
    }

    public static WebElement findElementByName(String name) {
        return getInstance().findElement(By.name(name));
    }

    public static List<WebElement> findElementsByXPath(String xpath) {
        return getInstance().findElements(By.xpath(xpath));
    }

    public static List<WebElement> findElementsByID(String id) {
        return getInstance().findElements(By.id(id));
    }

    public static List<WebElement> findElementsByName(String name) {
        return getInstance().findElements(By.name(name));
    }


}
