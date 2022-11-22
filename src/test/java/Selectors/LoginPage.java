package Selectors;

import org.openqa.selenium.By;

public class LoginPage {

    public static By emailField = By.name("username");
    public static By passwordField = By.name("password");
    public static By loginButton = By.cssSelector("#app > main > div.container > section > form > div > button");
    public static By emailForgotPasswordField = By.name("forgotPasswordButton");
}
