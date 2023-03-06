package pages;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utilities.Utilities.getObjectsNamesFromText;

public class CatalogPage {

    @FindBy(xpath = "//a[contains(@href,'product_id') and not(@title='Edit')]")
    private List<WebElement> productNames;

    public CatalogPage() {
        PageFactory.initElements(DriverManager.getInstance(), this);
    }

    public void open() {
        DriverManager.open("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
    }

    public boolean checkBrowserLogsInProductPage() {
        String[] productNames = getProductNames();
        for (String productName : productNames) {
            DriverManager.findElementByXPath(getProductXPathByName(productName)).click();
            if (!DriverManager.browserLogsEmpty()) {
                return false;
            }
            DriverManager.back();
        }
        return true;
    }

    private String[] getProductNames() {
        return getObjectsNamesFromText(productNames);
    }

    private String getProductXPathByName(String name) {
        return String.format("//a[text()='%s']", name);
    }

}
