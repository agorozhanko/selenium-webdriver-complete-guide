import core.DriverManager;
import model.Account;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.CreateAccountPage;
import steps.ShopPage;
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
        Account account = new Account().setFirstname(NAME)
                .setLastname(NAME)
                .setAddress("834 CENTURY ST")
                .setPostcode("93455")
                .setCity("SANTA MARIA CA")
                .setCountry("United States")
                .setState("California")
                .setEmail(EMAIL)
                .setPhone(PHONE)
                .setPassword(NAME);

        ShopPage.newCustomerClick();
        CreateAccountPage.createAccount(account);
        assertTrue(ShopPage.accountIsCreated());
        assertTrue(ShopPage.logout());

        assertTrue(ShopPage.login(EMAIL, NAME));
        assertTrue(ShopPage.logout());
    }
}
