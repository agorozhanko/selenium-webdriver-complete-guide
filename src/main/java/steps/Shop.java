package steps;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class Shop {
    private static final List<WebElement> products = DriverManager.getInstance().findElements(By.xpath("//li[contains(@class, 'product')]"));
    private static final String sticker = ".//div[contains(@class, 'sticker')]";

    public static boolean checkStickers() {
        for (WebElement product : products) {
            List<WebElement> stickers = product.findElements(By.xpath(sticker));
            int size = stickers.size();
            if (size == 0) {
                throw new NoSuchElementException("Product doesn't have a sticker!");
            } else {
                if (size != 1) {
                    throw new IllegalStateException("Product has more than one sticker!");
                }
            }
        }
        return true;
    }
}