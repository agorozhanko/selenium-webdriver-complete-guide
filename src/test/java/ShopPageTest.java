import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.ShopPage;
import pages.ShoppingCartPage;

public class ShopPageTest extends BaseTest {

    private ShopPage shopPage = new ShopPage();
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    void setUp() {
        shopPage.open();
    }

    // TODO: 08.03.2023 падает т.к. не у всех товаров есть стикеры 
    @Test(description = "Задание 7. Сценарий, проверяющий наличие стикеров у всех товаров")
    public void checkStickersTest() {
        assertTrue(shopPage.checkStickers());
    }

    @Test(description = "Задание 10. Проверить, что открывается правильная страница товара")
    public void verifyProductTest() {
        String shopName = shopPage.getName();
        String shopRegularPrice = shopPage.getRegularPrice();
        String shopCampaignPrice = shopPage.getCampaignPrice();

        assertTrue(shopPage.verifyRegularPrice());
        assertTrue(shopPage.verifyCampaignPrice());
        assertTrue(shopPage.campaignPriceMoreThanRegularPrice());

        productPage = shopPage.openFirstCampaignProduct();

        String productName = productPage.getName();
        String productRegularPrice = productPage.getRegularPrice();
        String productCampaignPrice = productPage.getCampaignPrice();

        assertTrue(productPage.verifyRegularPrice());
        assertTrue(productPage.verifyCampaignPrice());
        assertTrue(productPage.campaignPriceMoreThanRegularPrice());

        assertEquals(shopName, productName);
        assertEquals(shopRegularPrice, productRegularPrice);
        assertEquals(shopCampaignPrice, productCampaignPrice);
    }

    @Test(description = "Задание 13. Сделайте сценарий работы с корзиной")
    public void cartTest() {
        shopPage.addThreeProducts();
        shoppingCartPage = shopPage.checkout();
        shoppingCartPage.removeAllCartItems();
        assertTrue(shoppingCartPage.isEmpty());

    }
}
