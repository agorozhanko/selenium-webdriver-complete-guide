package core;

import config.ConfigurationProperties;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class BrowserTypeFactory {

    /**
     * Creates local web driver
     *
     * @param browserType browser name (chrome, firefox, firefox nightly, edge)
     * @return WebDriver instance
     */
    static WebDriver createBrowser(BrowserType browserType) {
        ConfigurationProperties configProperties = ConfigurationProperties.getInstance();
        String chromeDriverPath = configProperties.getChromeDriverPath();
        String firefoxDriverPath = configProperties.getFirefoxDriverPath();
        String msEdgeDriverPath = configProperties.getMsEdgeDriverPath();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", buildPathToDriver(chromeDriverPath));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--lang=" + configProperties.getLocale());
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", buildPathToDriver(firefoxDriverPath));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(configProperties.getFirefoxPath());
                capabilities.setCapability(ChromeOptions.CAPABILITY, firefoxOptions);
                return new FirefoxDriver(firefoxOptions);
            case FIREFOX_NIGHTLY:
                System.setProperty("webdriver.gecko.driver", buildPathToDriver(firefoxDriverPath));
                FirefoxOptions firefoxNightlyOptions = new FirefoxOptions();
                firefoxNightlyOptions.setBinary(configProperties.getFirefoxNightlyPath());
                capabilities.setCapability(ChromeOptions.CAPABILITY, firefoxNightlyOptions);
                return new FirefoxDriver(firefoxNightlyOptions);
            case EDGE:
                System.setProperty("webdriver.edge.driver", buildPathToDriver(msEdgeDriverPath));
                return new EdgeDriver();
            default:
                throw new IllegalStateException("Unsupported browser type");
        }
    }

    private static String buildPathToDriver(String driverRelativePath) {
        try {
            return FilenameUtils.separatorsToSystem(new File("./").getCanonicalPath() + File.separator + driverRelativePath);
        } catch (IOException ioException) {
            throw new RuntimeException("Could not parse absolute path to WebDriver. Relative path is " + driverRelativePath);
        }
    }
}
