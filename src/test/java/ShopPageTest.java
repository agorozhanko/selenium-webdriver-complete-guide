import core.DriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.ProductPage;
import steps.ShopPage;
import steps.ShoppingCartPage;

public class ShopPageTest extends BaseTest {

    @BeforeClass
    void setUp() {
        DriverManager.open("http://localhost/litecart/");
    }

    @Test(description = "Задание 7. Сценарий, проверяющий наличие стикеров у всех товаров")
    public void checkStickersTest() {
        assertTrue(ShopPage.checkStickers());
    }

    @Test(description = "Задание 10. Проверить, что открывается правильная страница товара")
    public void verifyProductTest() {
        String shopName = ShopPage.getName();
        String shopRegularPrice = ShopPage.getRegularPrice();
        String shopCampaignPrice = ShopPage.getCampaignPrice();

        assertTrue(ShopPage.verifyRegularPrice());
        assertTrue(ShopPage.verifyCampaignPrice());
        assertTrue(ShopPage.campaignPriceMoreThanRegularPrice());

        ShopPage.openFirstCampaignProduct();

        String productName = ProductPage.getName();
        String productRegularPrice = ProductPage.getRegularPrice();
        String productCampaignPrice = ProductPage.getCampaignPrice();

        assertTrue(ProductPage.verifyRegularPrice());
        assertTrue(ProductPage.verifyCampaignPrice());
        assertTrue(ProductPage.campaignPriceMoreThanRegularPrice());

        assertEquals(shopName, productName);
        assertEquals(shopRegularPrice, productRegularPrice);
        assertEquals(shopCampaignPrice, productCampaignPrice);
    }

    @Test(description = "Задание 13. Сделайте сценарий работы с корзиной")
    public void cartTest() {
        ShopPage.addThreeProducts();
        ShopPage.checkout();
        ShoppingCartPage.removeAllCartItems();
        assertTrue(ShoppingCartPage.isEmpty());

    }
}
