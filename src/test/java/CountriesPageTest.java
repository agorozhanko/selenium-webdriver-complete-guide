import core.DriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.AddNewCountryPage;
import steps.CountriesPage;
import steps.LoginPage;

public class CountriesPageTest extends BaseTest {

    @BeforeClass
    void setUp() {
        DriverManager.open();
        LoginPage.login();
        DriverManager.open("http://localhost/litecart/admin/?app=countries&doc=countries");
    }

    @Test(description = "Задание 8. Проверить сортировку стран и геозон на странице стран."
            + "проверяет, что страны расположены в алфавитном порядке")
    public void verifyCountriesNamesSortingTest() {
        assertTrue(CountriesPage.verifyCountriesNamesSorting());
    }

    @Test(description = "Задание 8. Проверить сортировку стран и геозон на странице стран."
            + "проверяет, что для тех стран, у которых количество зон отлично от нуля " +
            "-- открывает страницу этой страны и там проверяет, что геозоны расположены в алфавитном порядке")
    public void verifyZonesSortingTest() {
        assertTrue(CountriesPage.verifyZonesSorting());
    }

    @Test(description = "Задание 14. Проверьте, что ссылки открываются в новом окне")
    public void linksOpenInNewWindowTest() {
        CountriesPage.clickAddNewCountry();
        AddNewCountryPage.openExternalLinks();
    }

}
