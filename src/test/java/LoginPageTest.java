import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.LoginPage;

public class LoginPageTest extends BaseTest {

    @BeforeClass
    void goToUrl() {
        DriverManager.open();
    }

    @Test(description = "Задание 3. Сценарий логина")
    public void loginTest() {
        LoginPage.login();
        WebElement logo = DriverManager.findElementByXPath(("//img[@title='My Store']"));
        assertTrue(logo.isDisplayed());
    }

}
