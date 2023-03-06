import core.DriverManager;
import model.Product;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.AddNewProductPage;
import steps.AdminPage;
import steps.CatalogPage;
import steps.LoginPage;
import utilities.Utilities;

public class AdminPageTest extends BaseTest {
    private static final String NAME = Utilities.getName();
    private static final String IMAGE_PATH = "src/main/resources/image/GB_Camera.jpg";
    private static final String PRICE = Utilities.getPrice();

    @BeforeClass
    void setUp() {
        DriverManager.open();
        LoginPage.login();
    }

    @Test(description = "Задание 6. Сценарий, проходящий по всем разделам админки")
    public void checkHeaderTest() {
        assertTrue(AdminPage.checkHeaders());
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

        AdminPage.openCatalog();
        AdminPage.addNewProduct();
        AddNewProductPage.addNewProduct(product);
        assertTrue(AddNewProductPage.newProductAdded());
        assertTrue(AddNewProductPage.newProductIsDisplayed(product.getName()));
    }

    @Test(description = "Задание 17. Проверьте отсутствие сообщений в логе браузера")
    public void checkBrowserLogs() {
        CatalogPage.openCatalog();
        assertTrue(CatalogPage.checkBrowserLogsInProductPage());
    }


}
