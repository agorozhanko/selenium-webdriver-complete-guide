package core;


import config.ConfigurationProperties;
import org.openqa.selenium.WebDriver;

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

    public void clearAllCookies() {
        getInstance().manage().deleteAllCookies();
    }

    public static void stop() {
        getInstance().quit();
        driverExtension = null;
    }


}
