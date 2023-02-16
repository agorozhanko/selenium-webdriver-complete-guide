package steps;

import config.ConfigurationProperties;
import core.DriverManager;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static final WebElement username_input = DriverManager.findElementByName(("username"));
    private static final WebElement password_input = DriverManager.findElementByName(("password"));
    private static final WebElement login_btn = DriverManager.findElementByName(("login"));


    public static void login() {
        enterUsername(ConfigurationProperties.getInstance().getUsername());
        enterPassword(ConfigurationProperties.getInstance().getPassword());
        clickLogin();
    }

    public static void enterUsername(String username) {
        username_input.sendKeys(username);
    }

    public static void enterPassword(String password) {
        password_input.sendKeys(password);
    }

    public static void clickLogin() {
        login_btn.click();
    }

}
