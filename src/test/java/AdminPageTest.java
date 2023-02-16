import core.DriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.AdminPage;
import steps.LoginPage;

public class AdminPageTest extends BaseTest {

    @BeforeClass
    void setUp() {
        DriverManager.open();
        LoginPage.login();
    }

    @Test(description = "Задание 6. Сценарий, проходящий по всем разделам админки")
    public void checkHeaderTest() {
        assertTrue(AdminPage.checkHeaders());
    }
}
