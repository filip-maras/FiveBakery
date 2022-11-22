package Tests;

import DriverConfigurations.ElementActions;
import StaticData.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static Methods.AccountActionsMethods.registerNewUser;
import static Methods.AccountActionsMethods.searchProduct;
import static Methods.DateTimeMethods.*;
import static Methods.GeneralMethods.*;
import static Selectors.HomePage.*;
import static Selectors.LandingPage.productsBox;
import static StaticData.StaticText.your_order_is_placed_text;

public class OrderTest extends ElementActions {

    @Test(description = "Logged user can order one or more products, and select Payment at pickup as a Payment method")
    public static void orderOneProduct() {
        registerNewUser();
        searchProduct(Data.product);
        elementLocate(productsBox, 10);
        scrollPageDown(getChromeDriver());
        List<WebElement> breadElements = getChromeDriver().findElement(productsBox).findElements(By.tagName("article"));
        threadSleepSec(1);
        breadElements.get(0).findElements(By.tagName("button")).get(3).click();
        elementClick(orderSaveButton);
        elementClick(orderSaveCommentButton);
        verifyText(cartButton, "1");
        elementClick(cartButton);
        elementClick(orderFromCartButton);
        elementClick(continueOrderButton);
        elementLocate(datePicker);
        elementClick(datePicker);
        getFirstAvailableDay().click();
        getFirstAvailableHour().click();
        getFirstAvailableMinute().click();
        scrollPageDown(getChromeDriver());
        elementClick(continueToVerifyOrder);
        elementClick(paymentAtPickup);
        elementClick(placeOrderButton);
        elementLocate(orderPlacedMessage);
        verifyText(orderPlacedMessage, your_order_is_placed_text);
        assertion.get().assertAll();
    }

    @Test(description = "- Logged user can order one or more products, and select Payment at pickup as a Payment method")
    public static void orderMultipleProducts() {
        registerNewUser();
        searchProduct(Data.product);
        elementLocate(productsBox, 10);
        scrollPageDown(getChromeDriver());
        List<WebElement> breadElements = getChromeDriver().findElement(productsBox).findElements(By.tagName("article"));
        threadSleepSec(1);
        breadElements.get(0).findElements(By.tagName("button")).get(1).click();
        breadElements.get(0).findElements(By.tagName("button")).get(3).click();
        elementClick(orderSaveButton);
        elementClick(orderSaveCommentButton);
        verifyText(cartButton, "2");
        elementClick(cartButton);
        elementClick(orderFromCartButton);
        elementClick(continueOrderButton);
        elementLocate(datePicker, 10);
        elementClick(datePicker);
        getFirstAvailableDay().click();
        getFirstAvailableHour().click();
        getFirstAvailableMinute().click();
        scrollPageDown(getChromeDriver());
        elementClick(continueToVerifyOrder);
        elementClick(paymentAtPickup);
        elementClick(placeOrderButton);
        elementLocate(orderPlacedMessage);
        verifyText(orderPlacedMessage, your_order_is_placed_text);
        assertion.get().assertAll();
    }
}
