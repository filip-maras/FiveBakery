package Selectors;

import org.openqa.selenium.By;

public class RegistrationPage {

    /*public static By emailAddressTextField = By.cssSelector("#app > main > div.container > section > div > div > div:nth-child(1) > input[type=email]:nth-child(2)");
    public static By passwordTextField = By.cssSelector("#app > main > div.container > section > div > div > div:nth-child(1) > input[type=password]:nth-child(4)");
    public static By repeatPpasswordTextField = By.cssSelector("#app > main > div.container > section > div > div > div:nth-child(1) > input[type=password]:nth-child(6)");
    public static By firstNameTextField = By.cssSelector("#app > main > div.container > section > div > div > div:nth-child(2) > input[type=text]:nth-child(2)");
    public static By lastNameTextField = By.cssSelector("#app > main > div.container > section > div > div > div:nth-child(2) > input[type=text]:nth-child(4)");
    public static By phoneNumberTextField = By.cssSelector("#app > main > div.container > section > div > div > div:nth-child(2) > input[type=tel]:nth-child(6)");*/
    public static By emailAddressTextField = By.name("email");
    public static By passwordTextField = By.name("password");
    public static By repeatPasswordTextField = By.name("password-repeat");
    public static By firstNameTextField = By.name("firstname");
    public static By lastNameTextField = By.name("lastname");
    public static By phoneNumberTextField = By.name("telephone");
    public static By createAccountButton = By.cssSelector("#app > main > div.container > section > div > footer > button");
    public static By acceptToSButton = By.cssSelector("#app > main > div.overlay-container > div > div > div.footer > button");
    public static By acceptPrivacyPolicyButton = By.cssSelector("#app > main > div.overlay-container > div > div > div.footer > button");
    public static By errorHolder = By.className("error");
}
