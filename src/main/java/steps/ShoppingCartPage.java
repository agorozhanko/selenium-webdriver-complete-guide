package steps;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCartPage {
    public static final String DATA_TABLE_XPATH = "//table[contains(@class,'dataTable')]";

    public static void removeAllCartItems() {
        List<WebElement> removeBtnList = DriverManager.findElementsByName("remove_cart_item");
        for (WebElement removeBtn : removeBtnList) {
            WebElement datatable = dataTableIsExist();
            removeBtn = DriverManager.findElementByName("remove_cart_item");
            removeBtn.click();
            dataTableIsDisappear(datatable);
        }
    }

    public static WebElement dataTableIsExist() {
        return DriverManager.findElementByXPath(DATA_TABLE_XPATH);
    }

    public static void dataTableIsDisappear(WebElement dataTable) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.stalenessOf(dataTable));
    }

    public static boolean isEmpty() {
        return DriverManager.findElementByXPath("//em[text()='There are no items in your cart.']").isDisplayed();
    }

}
