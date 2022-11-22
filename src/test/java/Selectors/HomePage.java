package Selectors;

import org.openqa.selenium.By;

public class HomePage {

    public static By accountButton = By.cssSelector("#menu > div > div.remaining > div.items > div.visible > button");
    public static By logoutButton = By.cssSelector("#app > div:nth-child(6) > div > div > div > a:nth-child(3)");
    public static By orderSaveButton = By.cssSelector("#app > div:nth-child(4) > div > div > div > div > div > footer > button");
    public static By orderSaveCommentButton = By.cssSelector("#app > div:nth-child(4) > div > div > div > div > div > footer > button");
    public static By cartButton = By.cssSelector("#menu > div > div.remaining > div.items > div.visible > div");
    public static By orderFromCartButton = By.cssSelector("#app > div.side-view > div > div > footer > a");
    public static By continueOrderButton = By.cssSelector("#app > main > div.container > div.columns > div:nth-child(1) > div.form-style.box-header > footer > button");
    public static By datePicker = By.id("test-calendar-date");
    public static By daysDatePicker = By.cssSelector("#app > main > div.container > section > div:nth-child(2) > div:nth-child(1) > div > div.split-input.calendar-input-anchor > div:nth-child(1) > div.calendar-input-container > div > div > div.days");
    public static By hourPicker = By.cssSelector("#app > main > div.container > section > div:nth-child(2) > div:nth-child(1) > div > div.split-input.calendar-input-anchor > div.calendar-input-anchor > div.calendar-input-container > div > div > div.hours > div.test-hours");
    public static By minutePicker = By.cssSelector("#app > main > div.container > section > div:nth-child(2) > div:nth-child(1) > div > div.split-input.calendar-input-anchor > div.calendar-input-anchor > div.calendar-input-container > div > div > div.hours > div.test-minutes");
    public static By continueToVerifyOrder = By.id("test-next");
    public static By paymentAtPickup = By.id("test-payment-method-0");
    public static By placeOrderButton = By.id("test-pay-submit");
    public static By orderPlacedMessage = By.cssSelector("#test-success-header > h1");
}
