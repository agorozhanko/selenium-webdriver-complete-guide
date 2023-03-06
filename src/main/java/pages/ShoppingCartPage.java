package pages;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCartPage {

    @FindBy(xpath = "//em[text()='There are no items in your cart.']")
    private WebElement isEmpty;

    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getInstance(), this);
    }

    public void removeAllCartItems() {
        List<WebElement> removeBtnList = DriverManager.findElementsByName("remove_cart_item");
        for (WebElement removeBtn : removeBtnList) {
            WebElement datatable = dataTableIsExist();
            removeBtn = DriverManager.findElementByName("remove_cart_item");
            removeBtn.click();
            dataTableIsDisappear(datatable);
        }
    }

    public WebElement dataTableIsExist() {
        return DriverManager.findElementByXPath("//table[contains(@class,'dataTable')]");
    }

    public void dataTableIsDisappear(WebElement dataTable) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.stalenessOf(dataTable));
    }

    public boolean isEmpty() {
        return isEmpty.isDisplayed();
    }

}
