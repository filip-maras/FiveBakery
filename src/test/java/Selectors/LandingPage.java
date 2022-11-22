package Selectors;

import org.openqa.selenium.By;

public class LandingPage {

    public static By registerButton = By.cssSelector("#menu > div > div.remaining > div.items > div.visible > a:nth-child(2)");
    public static By loginButton = By.cssSelector("#menu > div > div.remaining > div > div.visible > a:nth-child(1)");
    public static By forgotPasswordButton = By.cssSelector("#app > main > div.container > section > form > div > a");
    public static By emailForgotPassworField = By.name("email");
    public static By sendEmailForgotPassworButton = By.cssSelector("#app > main > div.container > section > form > div.button-footer > button");
    public static By emailSentMessage = By.cssSelector("#app > main > div.container > section > header > ul > li");
    public static By searchButton = By.cssSelector("#headersection > div > div.buttons-products-wrapper > div.filter-buttons");
    public static By searchField = By.cssSelector("#headersection > div > div.buttons-products-wrapper > div.filter-buttons > div > input");
    public static By productsBox = By.cssSelector("#productssection > div > div:nth-child(2) > div");
}
