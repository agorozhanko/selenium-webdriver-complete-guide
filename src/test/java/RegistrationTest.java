import core.DriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.CreateAccountPage;
import steps.Shop;
import utilities.Utilities;

public class RegistrationTest extends BaseTest {

    private static final String NAME = Utilities.getName();
    private static final String EMAIL = NAME + "@gmail.com";
    private static final String PHONE = Utilities.getPhone();

    @BeforeClass
    void setUp() {
        DriverManager.open("http://localhost/litecart/");
    }

    @Test(description = "11. Сделайте сценарий регистрации пользователя")
    public void registrationTest() {
        Shop.newCustomerClick();
        CreateAccountPage.fillFirstname(NAME);
        CreateAccountPage.fillLastname(NAME);
        CreateAccountPage.fillAddress("834 CENTURY ST");
        CreateAccountPage.fillPostcode("93455");
        CreateAccountPage.fillCity("SANTA MARIA CA");
        CreateAccountPage.fillCountry("United States");
        CreateAccountPage.fillState("California");
        CreateAccountPage.fillEmail(EMAIL);
        CreateAccountPage.fillPhone(PHONE);
        CreateAccountPage.fillDesiredPassword(NAME);
        CreateAccountPage.fillConfirmPassword(NAME);
        CreateAccountPage.createAccountClick();

        assertTrue(Shop.accountIsCreated());
        assertTrue(Shop.logout());

        assertTrue(Shop.login(EMAIL, NAME));
        assertTrue(Shop.logout());
    }
}
