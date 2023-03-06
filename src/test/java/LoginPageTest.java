import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private AdminPage adminPage;

    @BeforeClass
    void goToUrl() {
        loginPage.open();
    }

    @Test(description = "Задание 3. Сценарий логина")
    public void loginTest() {
        adminPage = loginPage.login();
        assertTrue(adminPage.logoIsDisplayed());
    }

}
