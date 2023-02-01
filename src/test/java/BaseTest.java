import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Assert {

    public static WebDriver driver;

    @BeforeClass
    public void createDriver() {
        driver = DriverFactory.createBrowser(BrowserType.CHROME);
    }

    @AfterClass
    public void stopDriver() {
        driver.quit();
    }
}
