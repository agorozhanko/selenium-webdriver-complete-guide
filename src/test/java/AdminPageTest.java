import model.Product;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddNewProductPage;
import pages.AdminPage;
import pages.CatalogPage;
import pages.LoginPage;
import utilities.Utilities;

public class AdminPageTest extends BaseTest {
    private static final String NAME = Utilities.getName();
    private static final String IMAGE_PATH = "src/main/resources/image/GB_Camera.jpg";
    private static final String PRICE = Utilities.getPrice();

    private LoginPage loginPage = new LoginPage();
    private AdminPage adminPage;
    private AddNewProductPage addNewProductPage;
    private CatalogPage catalogPage = new CatalogPage();

    @BeforeClass
    void setUp() {
        loginPage.open();
        adminPage = loginPage.login();
    }

    @Test(description = "Задание 6. Сценарий, проходящий по всем разделам админки")
    public void checkHeaderTest() {
        assertTrue(adminPage.checkHeaders());
    }


    @Test(description = "Задание 12. Сделайте сценарий добавления товара")
    public void addNewProductTest() {
        Product product = new Product().setName(NAME)
                .setCode(NAME)
                .setImage(IMAGE_PATH)
                .setManufacturer("ACME Corp.")
                .setKeywords(NAME)
                .setShortDescription(NAME)
                .setDescription(NAME)
                .setHeadTitle(NAME)
                .setMetaDescription(NAME)
                .setPurchasePrice(PRICE)
                .setPurchasePriceCurrency("US Dollars")
                .setPrice(PRICE);

        adminPage.openCatalog();
        addNewProductPage = adminPage.addNewProduct();
        addNewProductPage.addNewProduct(product);
        assertTrue(addNewProductPage.newProductAdded());
        assertTrue(addNewProductPage.newProductIsDisplayed(product.getName()));
    }

    @Test(description = "Задание 17. Проверьте отсутствие сообщений в логе браузера")
    public void checkBrowserLogs() {
        catalogPage.open();
        assertTrue(catalogPage.checkBrowserLogsInProductPage());
    }


}
