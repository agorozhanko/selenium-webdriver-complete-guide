import core.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Assert {

    @BeforeClass(alwaysRun = true)
    public void setUpBeforeEveryMethod() {
        DriverManager.getInstance();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownAfterEveryMethod() {
        DriverManager.stop();
    }
}
