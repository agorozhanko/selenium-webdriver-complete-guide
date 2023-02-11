import core.DriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.Admin;
import steps.Login;

public class AdminTest extends BaseTest {

    @BeforeClass
    void setUp() {
        DriverManager.open();
        Login.login();
    }

    @Test(description = "Задание 6. Сценарий, проходящий по всем разделам админки")
    public void checkHeaderTest() {
        assertTrue(Admin.checkHeaders());
    }
}
