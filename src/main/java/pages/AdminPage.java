package pages;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class AdminPage {
    @FindBy(xpath = "//img[@title='My Store']")
    private WebElement logo;
    @FindBy(xpath = "//h1")
    private WebElement header;
    @FindBy(xpath = "//a[text()=' Add New Product']")
    private WebElement addNewProduct;
    @FindBy(xpath = "//li[@id='app-']//span[text()='Catalog']")
    private WebElement catalog;
    @FindBy(id = "app-")
    private List<WebElement> appsMenu;
    @FindBy(id = "//ul[@class='docs']//span")
    private List<WebElement> subAppsMenu;

    public AdminPage() {
        PageFactory.initElements(DriverManager.getInstance(), this);
    }

    public boolean logoIsDisplayed() {
        return logo.isDisplayed();
    }

    private boolean headerIsNotDisplayed() {
        return !header.isDisplayed();
    }

    public void openCatalog() {
        catalog.click();
    }

    public AddNewProductPage addNewProduct() {
        addNewProduct.click();
        return new AddNewProductPage();
    }

    public boolean checkHeaders() {
        ArrayList<String> appsMenuNames = getAppMenuNames();
        for (String appsMenuName : appsMenuNames) {
            appMenuClick(appsMenuName);
            ArrayList<String> subAppsMenuNames = getSubAppMenuNames();
            if (subAppsMenuNames.size() == 0) {
                if (headerIsNotDisplayed()) return false;
            } else {
                for (String subAppsMenuName : subAppsMenuNames) {
                    DriverManager.findElementByXPath((getSubAppMenuXpath(subAppsMenuName))).click();
                    if (headerIsNotDisplayed()) return false;
                }
            }
        }
        return true;
    }

    private ArrayList<String> getAppMenuNames() {
        ArrayList<String> appMenuNames = new ArrayList<>();
        for (WebElement menu : appsMenu) {
            appMenuNames.add(menu.getText());
        }
        return appMenuNames;
    }

    private ArrayList<String> getSubAppMenuNames() {
        DriverManager.setImplicitlyWait(2);
        ArrayList<String> subAppsMenuNames = new ArrayList<>();
        for (WebElement menu : subAppsMenu) {
            subAppsMenuNames.add(menu.getText());
        }
        DriverManager.setImplicitlyWait();
        return subAppsMenuNames;
    }

    private void appMenuClick(String appsMenuName) {
        WebElement appsMenu = DriverManager.findElementByXPath((getAppMenuXpath(appsMenuName)));
        appsMenu.click();
    }

    private String getAppMenuXpath(String appsMenu) {
        return String.format("//li[@id='app-']//span[text()='%s']", appsMenu);
    }

    private String getSubAppMenuXpath(String appsMenu) {
        return String.format("//ul[@class='docs']//span[text()='%s']", appsMenu);
    }

}
