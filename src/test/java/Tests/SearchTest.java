package Tests;

import DriverConfigurations.ElementActions;
import StaticData.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

import static Methods.AccountActionsMethods.registerNewUser;
import static Methods.AccountActionsMethods.searchProduct;
import static Selectors.LandingPage.*;

public class SearchTest extends ElementActions {

    @Test(description = "Visitor user can search for products")
    public static void visitorUserSearch() {
        int counter = 0;
        searchProduct(Data.product);
        List<WebElement> breadElements = getChromeDriver().findElement(productsBox).findElements(By.tagName("article"));
        for (WebElement e: breadElements) {
            if(e.getText().toLowerCase(Locale.ROOT).contains(Data.product.toLowerCase(Locale.ROOT))) {
                counter++;
            }
        }
        if(counter < 1)
            failTest("There is no " + Data.product + " in this search result!");
    }

    @Test(description = "Logged in user can search for products")
    public static void loggedInUserSearch() {
        registerNewUser();
        int counter = 0;
        searchProduct(Data.product);
        List<WebElement> breadElements = getChromeDriver().findElement(productsBox).findElements(By.tagName("article"));
        for (WebElement e: breadElements) {
            if(e.getText().toLowerCase(Locale.ROOT).contains(Data.product.toLowerCase(Locale.ROOT))) {
                counter++;
            }
        }
        if(counter < 1)
            failTest("There is no " + Data.product + " in this search result!");
    }
}
