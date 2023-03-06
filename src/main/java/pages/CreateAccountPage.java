package pages;

import core.DriverManager;
import model.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {

    @FindBy(name = "firstname")
    WebElement accFirstname;
    @FindBy(name = "lastname")
    WebElement accLastname;
    @FindBy(name = "address1")
    WebElement accAddress;
    @FindBy(name = "postcode")
    WebElement accPostcode;
    @FindBy(name = "city")
    WebElement accCity;
    @FindBy(name = "email")
    WebElement accEmail;
    @FindBy(name = "phone")
    WebElement accPhone;
    @FindBy(name = "password")
    WebElement accPassword;
    @FindBy(name = "confirmed_password")
    WebElement accConfirmedPassword;
    @FindBy(name = "create_account")
    WebElement accCreateAccount;

    public CreateAccountPage() {
        PageFactory.initElements(DriverManager.getInstance(), this);
    }

    public void createAccount(Account account) {
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

    private void fillFirstname(String firstname) {
        accFirstname.sendKeys(firstname);
    }

    private void fillLastname(String lastname) {
        accLastname.sendKeys(lastname);
    }

    private void fillAddress(String address) {
        accAddress.sendKeys(address);
    }

    private void fillPostcode(String postcode) {
        accPostcode.sendKeys(postcode);
    }

    private void fillCity(String city) {
        accCity.sendKeys(city);
    }

    private void fillCountry(String country) {
        DriverManager.findElementByXPath("//span[@class='select2-selection__arrow']").click();
        DriverManager.findElementByXPath(String.format("//li[text()='%s']", country)).click();
    }

    private void fillState(String country) {
        DriverManager.waiting(10);
        Select select = new Select(DriverManager.findElementByXPath("//select[@name='zone_code']"));
        select.selectByVisibleText(country);
    }

    private void fillEmail(String email) {
        accEmail.sendKeys(email);
    }

    private void fillPhone(String phone) {
        accPhone.sendKeys(phone);
    }

    private void fillDesiredPassword(String password) {
        accPassword.sendKeys(password);
    }

    private void fillConfirmPassword(String password) {
        accConfirmedPassword.sendKeys(password);
    }

    private void createAccountClick() {
        accCreateAccount.click();
    }
}
