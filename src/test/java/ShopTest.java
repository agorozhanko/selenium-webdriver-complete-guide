import core.DriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.Shop;

public class ShopTest extends BaseTest {

    @BeforeClass
    void setUp() {
        DriverManager.open("http://localhost/litecart/");
    }

    @Test(description = "Задание 7. Сценарий, проверяющий наличие стикеров у всех товаров")
    public void checkStickersTest() {
        assertTrue(Shop.checkStickers());
    }
}
