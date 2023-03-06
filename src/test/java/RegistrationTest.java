import model.Account;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.ShopPage;
import utilities.Utilities;

public class RegistrationTest extends BaseTest {

    private static final String NAME = Utilities.getName();
    private static final String EMAIL = NAME + "@gmail.com";
    private static final String PHONE = Utilities.getPhone();

    private ShopPage shopPage = new ShopPage();
    private CreateAccountPage createAccountPage;

    @BeforeClass
    void setUp() {
        shopPage.open();
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

        createAccountPage = shopPage.newCustomerClick();
        createAccountPage.createAccount(account);
        assertTrue(shopPage.accountIsCreated());
        assertTrue(shopPage.logout());

        assertTrue(shopPage.login(EMAIL, NAME));
        assertTrue(shopPage.logout());
    }
}
