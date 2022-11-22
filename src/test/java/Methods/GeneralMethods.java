package Methods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

import static StaticData.Data.userFirstName;
import static StaticData.Data.userLastName;

public class GeneralMethods {

    public static String generateRandomEmail(){
        Random rand = new Random();
        String userEmail = userFirstName + userLastName + Integer.toString(rand.nextInt(10000)) + "@example.com";
        return userEmail;
    }

    public static void scrollToTopOfThePage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }

    public static void scrollToBottomOfThePage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void scrollPageDown(WebDriver driver) {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public static void scrollToElement(WebDriver driver, By el) {
        WebElement element = driver.findElement(el);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }
}
