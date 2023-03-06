package pages;

import config.ConfigurationProperties;
import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "username")
    private WebElement usernameInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "login")
    private WebElement loginBtn;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getInstance(), this);
    }

    public void open() {
        DriverManager.open();
    }


    public AdminPage login() {
        enterUsername(ConfigurationProperties.getInstance().getUsername());
        enterPassword(ConfigurationProperties.getInstance().getPassword());
        clickLogin();
        return new AdminPage();
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginBtn.click();
    }

}
