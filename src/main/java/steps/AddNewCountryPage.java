package steps;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class AddNewCountryPage {

    public static boolean openExternalLinks() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance(), Duration.ofSeconds(3));
        List<WebElement> links = DriverManager.findElementsByXPath(("//i[contains(@class,'external-link')]"));
        String originalWindow = DriverManager.getInstance().getWindowHandle();
        Set<String> oldWindows = DriverManager.getInstance().getWindowHandles();
        for (WebElement link : links) {
            link.click();
            String newWindow = wait.until(DriverManager.anyWindowOtherThan(oldWindows));
            if (newWindow == null) {
                return false;
            }
            DriverManager.getInstance().switchTo().window(newWindow).close();
            DriverManager.getInstance().switchTo().window(originalWindow);
        }
        return true;
    }

}
