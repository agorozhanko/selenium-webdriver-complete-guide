import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeClass
    void goToUrl() {
        DriverManager.open();
    }

    @Test(description = "логин в панель администрирования учебного приложения")
    public void login() {
        WebElement username = DriverManager.getInstance().findElement(By.name("username"));
        username.sendKeys("admin");
        WebElement password = DriverManager.getInstance().findElement(By.name("password"));
        password.sendKeys("admin");
        WebElement login = DriverManager.getInstance().findElement(By.name("login"));
        login.click();
        WebElement logo = DriverManager.getInstance().findElement(By.xpath("//img[@title='My Store']"));
        assertTrue(logo.isDisplayed());
    }
}
