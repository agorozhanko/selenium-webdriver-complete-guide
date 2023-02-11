import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.Login;

public class LoginTest extends BaseTest {

    @BeforeClass
    void goToUrl() {
        DriverManager.open();
    }

    @Test(description = "Задание 3. Сценарий логина")
    public void loginTest() {
        Login.login();
        WebElement logo = DriverManager.getInstance().findElement(By.xpath("//img[@title='My Store']"));
        assertTrue(logo.isDisplayed());
    }

}
