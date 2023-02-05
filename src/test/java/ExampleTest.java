import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    @BeforeClass
    void goToUrl() {
        driver.get("http://localhost/litecart/admin/");
    }

    @Test(description = "логина в панель администрирования учебного приложения http://localhost/litecart/admin/")
    public void login() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");
        WebElement login = driver.findElement(By.name("login"));
        login.click();
        WebElement logo = driver.findElement(By.xpath("//img[@title='My Store']"));
        assertTrue(logo.isDisplayed());
    }
}
