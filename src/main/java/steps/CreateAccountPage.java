package steps;

import core.DriverManager;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {


    public static void fillFirstname(String firstname) {
        DriverManager.findElementByName("firstname").sendKeys(firstname);
    }

    public static void fillLastname(String lastname) {
        DriverManager.findElementByName("lastname").sendKeys(lastname);
    }

    public static void fillAddress(String address) {
        DriverManager.findElementByName("address1").sendKeys(address);
    }

    public static void fillPostcode(String postcode) {
        DriverManager.findElementByName("postcode").sendKeys(postcode);
    }

    public static void fillCity(String city) {
        DriverManager.findElementByName("city").sendKeys(city);
    }

    public static void fillCountry(String country) {
        Select select = new Select(DriverManager.findElementByName("country_code"));
        select.selectByVisibleText(country);
    }

    public static void fillState(String country) {
        DriverManager.waiting(10);
        Select select = new Select(DriverManager.findElementByXPath("//select[@name='zone_code']"));
        select.selectByVisibleText(country);
    }

    public static void fillEmail(String email) {
        DriverManager.findElementByName("email").sendKeys(email);
    }

    public static void fillPhone(String phone) {
        DriverManager.findElementByName("phone").sendKeys(phone);
    }

    public static void fillDesiredPassword(String password) {
        DriverManager.findElementByName("password").sendKeys(password);
    }

    public static void fillConfirmPassword(String password) {
        DriverManager.findElementByName("confirmed_password").sendKeys(password);
    }

    public static void createAccountClick() {
        DriverManager.findElementByName("create_account").click();
    }
}
