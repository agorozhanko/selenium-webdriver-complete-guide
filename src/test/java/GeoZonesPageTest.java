import core.DriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GeoZonesPage;
import pages.LoginPage;

public class GeoZonesPageTest extends BaseTest {

    private LoginPage loginPage = new LoginPage();

    @BeforeClass
    void setUp() {
        loginPage.open();
        loginPage.login();
        DriverManager.open("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    }

    @Test(description = "Задание 9. Проверить сортировку геозон на странице геозон")
    public void verifyGeoZonesSortingTest() {
        assertTrue(GeoZonesPage.verifySorting());
    }
}
