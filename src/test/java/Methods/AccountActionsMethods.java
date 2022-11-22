package Methods;

import DriverConfigurations.ElementActions;
import Selectors.LoginPage;
import StaticData.Data;
import org.apache.commons.logging.Log;

import static Methods.GeneralMethods.generateRandomEmail;
import static Selectors.HomePage.accountButton;
import static Selectors.HomePage.logoutButton;
import static Selectors.LandingPage.*;
import static Selectors.LandingPage.loginButton;
import static Selectors.LoginPage.*;
import static Selectors.RegistrationPage.*;
import static StaticData.Data.*;
import static StaticData.Data.userPhoneNumber;
import static StaticData.StaticText.tos_button_text;

public class AccountActionsMethods extends ElementActions {

    public static String registerNewUser() {
        String randomEmail = generateRandomEmail();
        elementLocate(registerButton, 10);
        elementClick(registerButton);
        sendKeys(emailAddressTextField, randomEmail);
        sendKeys(passwordTextField, password);
        sendKeys(repeatPasswordTextField, password);
        sendKeys(firstNameTextField, userFirstName);
        sendKeys(lastNameTextField, userLastName);
        sendKeys(phoneNumberTextField, userPhoneNumber);
        elementClick(createAccountButton);
        elementClick(acceptToSButton);
        elementClick(acceptPrivacyPolicyButton);
        if(!elementPresent(accountButton, 5))
            failTest("User is not registered!!");
        return randomEmail;
    }

    public static void loginUser(String email, String password) {
        elementClick(loginButton);
        elementLocate(LoginPage.emailField);
        sendKeys(emailField, email);
        sendKeys(passwordField, password);
        elementClick(LoginPage.loginButton);
        if(!elementPresent(accountButton, 5)) {
            failTest("User is not logged in!!");
        }
    }

    public static void logoutUser() {
        elementClick(accountButton);
        elementClick(logoutButton);
        if(!elementPresent(loginButton, 5)) {
            failTest("User is not logged in!!");
        }
    }

    public static void searchProduct(String product) {
        elementClick(searchButton);
        elementLocate(searchField);
        sendKeys(searchField, product);
        elementLocate(productsBox);
    }
}
