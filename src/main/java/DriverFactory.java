import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.Objects;

public class DriverFactory {

    static WebDriver createBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", getDriverFile("driver/chromedriver.exe"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--lang=ru");
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", getDriverFile("driver/geckodriver.exe"));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                return new FirefoxDriver(firefoxOptions);
            case FIREFOX_NIGHTLY:
                System.setProperty("webdriver.gecko.driver", getDriverFile("driver/geckodriver.exe"));
                FirefoxOptions firefoxNightlyOptions = new FirefoxOptions();
                firefoxNightlyOptions.setBinary("C:\\Program Files\\Firefox Nightly\\firefox.exe");
                return new FirefoxDriver(firefoxNightlyOptions);
            case EDGE:
                System.setProperty("webdriver.edge.driver", getDriverFile("driver/msedgedriver.exe"));
                return new EdgeDriver();
            default:
                throw new IllegalStateException("Unsupported browser type");
        }
    }

    private static String getDriverFile(String filePath) {
        ClassLoader classLoader = DriverFactory.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(filePath)).getFile());
        return file.getAbsolutePath();
    }
}
