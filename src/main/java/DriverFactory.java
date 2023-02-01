import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
                return new FirefoxDriver(firefoxOptions);
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
