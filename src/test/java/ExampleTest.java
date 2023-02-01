import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    @Test(description = "Проверка заголовка сайта 'stackoverflow.com'")
    public void verifyTitle() {
        driver.get("https://stackoverflow.com/");
        WebElement logo = driver.findElement(By.xpath("//a[contains(@class,'s-topbar--logo')]//span"));
        assertEquals(logo.getText(), "Stack Overflow");
    }
}
