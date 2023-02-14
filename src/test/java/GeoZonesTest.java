import core.DriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.GeoZones;
import steps.Login;

public class GeoZonesTest extends BaseTest {

    @BeforeClass
    void setUp() {
        DriverManager.open();
        Login.login();
        DriverManager.open("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    }

    @Test(description = "Задание 9. Проверить сортировку геозон на странице геозон")
    public void verifyGeoZonesSortingTest() {
        assertTrue(GeoZones.verifySorting());
    }
}
