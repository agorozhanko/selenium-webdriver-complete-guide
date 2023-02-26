package steps;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartBlock {
    static final String quantityXpath = "//span[@class='quantity' and text()=%s]";

    public static WebElement quantityIsExist(int quantityProduct) {
        return DriverManager.findElementByXPath(String.format(quantityXpath, quantityProduct));
    }

    // TODO: 26.02.2023 метод не работает, по какой-то причине элемент, отображающий количество таваров видим
    public static void quantityIsDisappear(WebElement quantity) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.stalenessOf(quantity));
    }

    public static void checkout() {
        DriverManager.findElementByXPath("//a[text()='Checkout »']").click();
    }


}
