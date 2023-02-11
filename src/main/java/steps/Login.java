package steps;

import config.ConfigurationProperties;
import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login {
    private static final WebElement username_input = DriverManager.getInstance().findElement(By.name("username"));
    private static final WebElement password_input = DriverManager.getInstance().findElement(By.name("password"));
    private static final WebElement login_btn = DriverManager.getInstance().findElement(By.name("login"));


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
