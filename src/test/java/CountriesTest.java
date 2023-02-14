import core.DriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.Countries;
import steps.Login;

public class CountriesTest extends BaseTest {

    @BeforeClass
    void setUp() {
        DriverManager.open();
        Login.login();
        DriverManager.open("http://localhost/litecart/admin/?app=countries&doc=countries");
    }

    @Test(description = "Задание 8. Проверить сортировку стран и геозон на странице стран."
            + "проверяет, что страны расположены в алфавитном порядке")
    public void verifyCountriesNamesSortingTest() {
        assertTrue(Countries.verifyCountriesNamesSorting());
    }

    @Test(description = "Задание 8. Проверить сортировку стран и геозон на странице стран."
            + "проверяет, что для тех стран, у которых количество зон отлично от нуля " +
            "-- открывает страницу этой страны и там проверяет, что геозоны расположены в алфавитном порядке")
    public void verifyZonesSortingTest() {
        assertTrue(Countries.verifyZonesSorting());
    }

}
