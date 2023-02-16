package steps;

import core.DriverManager;
import model.Account;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {

    public static void createAccount(Account account) {
        fillFirstname(account.getFirstname());
        fillLastname(account.getLastname());
        fillAddress(account.getAddress());
        fillPostcode(account.getPostcode());
        fillCity(account.getCity());
        fillCountry(account.getCountry());
        fillState(account.getState());
        fillEmail(account.getEmail());
        fillPhone(account.getPhone());
        fillDesiredPassword(account.getPassword());
        fillConfirmPassword(account.getPassword());
        createAccountClick();
    }

    private static void fillFirstname(String firstname) {
        DriverManager.findElementByName("firstname").sendKeys(firstname);
    }

    private static void fillLastname(String lastname) {
        DriverManager.findElementByName("lastname").sendKeys(lastname);
    }

    private static void fillAddress(String address) {
        DriverManager.findElementByName("address1").sendKeys(address);
    }

    private static void fillPostcode(String postcode) {
        DriverManager.findElementByName("postcode").sendKeys(postcode);
    }

    private static void fillCity(String city) {
        DriverManager.findElementByName("city").sendKeys(city);
    }

    private static void fillCountry(String country) {
        Select select = new Select(DriverManager.findElementByName("country_code"));
        select.selectByVisibleText(country);
    }

    private static void fillState(String country) {
        DriverManager.waiting(10);
        Select select = new Select(DriverManager.findElementByXPath("//select[@name='zone_code']"));
        select.selectByVisibleText(country);
    }

    private static void fillEmail(String email) {
        DriverManager.findElementByName("email").sendKeys(email);
    }

    private static void fillPhone(String phone) {
        DriverManager.findElementByName("phone").sendKeys(phone);
    }

    private static void fillDesiredPassword(String password) {
        DriverManager.findElementByName("password").sendKeys(password);
    }

    private static void fillConfirmPassword(String password) {
        DriverManager.findElementByName("confirmed_password").sendKeys(password);
    }

    private static void createAccountClick() {
        DriverManager.findElementByName("create_account").click();
    }
}
