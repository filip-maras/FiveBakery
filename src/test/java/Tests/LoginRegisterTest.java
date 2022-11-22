package Tests;

import DriverConfigurations.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static Methods.AccountActionsMethods.*;
import static Methods.GeneralMethods.generateRandomEmail;
import static Methods.GeneralMethods.*;
import static Selectors.HomePage.accountButton;
import static Selectors.LandingPage.*;
import static Selectors.RegistrationPage.*;
import static StaticData.StaticText.*;
import static StaticData.Data.*;

public class LoginRegisterTest extends ElementActions {

    @Test(description = "Visitor user can create an account")
    public static void registerUserTest() {
        List<WebElement> errorMessages = new ArrayList<>();
        String randomEmail = generateRandomEmail();
        elementLocate(registerButton);
        elementClick(registerButton);
        elementLocate(emailAddressTextField);
        elementClick(createAccountButton);
        elementLocate(acceptToSButton);
        verifyText(acceptToSButton, tos_button_text);
        elementClick(acceptToSButton);
        elementLocate(acceptPrivacyPolicyButton);
        verifyText(acceptPrivacyPolicyButton, privacy_policy_button_text);
        elementClick(acceptPrivacyPolicyButton);
        errorMessages = getChromeDriver().findElement(errorHolder).findElements(By.xpath(".//*"));
        verifyWDElementText(errorMessages.get(0), empty_first_name_error_text);
        verifyWDElementText(errorMessages.get(1), empty_last_name_error_text);
        verifyWDElementText(errorMessages.get(2), empty_email_error_text);
        verifyWDElementText(errorMessages.get(3), empty_password_error_text);
        verifyWDElementText(errorMessages.get(4), empty_phone_number_error_text);
        verifyWDElementText(errorMessages.get(5), invalid_belgium_phone_number_error_text);
        sendKeys(emailAddressTextField, ".");
        sendKeys(passwordTextField, ".");
        sendKeys(repeatPasswordTextField, ".");
        sendKeys(firstNameTextField, ".");
        sendKeys(lastNameTextField, ".");
        sendKeys(phoneNumberTextField, ".");
        elementClick(createAccountButton);
        scrollToTopOfThePage(getChromeDriver());
        threadSleepSec(3);
        errorMessages = getChromeDriver().findElement(errorHolder).findElements(By.xpath(".//*"));
        verifyWDElementText(errorMessages.get(0), invalid_first_name_error_text);
        verifyWDElementText(errorMessages.get(1), invalid_last_name_error_text);
        verifyWDElementText(errorMessages.get(2), invalid_email_error_text);
        verifyWDElementText(errorMessages.get(3), invalid_email_must_be_valid_error_text);
        verifyWDElementText(errorMessages.get(4), invalid_password_error_text);
        verifyWDElementText(errorMessages.get(5), invalid_phone_number_must_be_valid_error_text);
        verifyWDElementText(errorMessages.get(6), invalid_phone_number_error_text);
        verifyWDElementText(errorMessages.get(7), invalid_belgium_phone_number_error_text);
        scrollPageDown(getChromeDriver());
        threadSleepSec(1);
        clearElement(emailAddressTextField);
        clearElement(passwordTextField);
        clearElement(repeatPasswordTextField);
        clearElement(firstNameTextField);
        clearElement(lastNameTextField);
        clearElement(phoneNumberTextField);
        sendKeys(emailAddressTextField, randomEmail);
        sendKeys(passwordTextField, password);
        sendKeys(repeatPasswordTextField, password);
        sendKeys(firstNameTextField, userFirstName);
        sendKeys(lastNameTextField, userLastName);
        sendKeys(phoneNumberTextField, userPhoneNumber);
        elementClick(createAccountButton);
        if(!elementPresent(accountButton, 5))
            failTest("User is not registered!!");
        assertion.get().assertAll();
    }

    @Test(description = "Registered user can login")
    public static void loginUserTest() {
        String email = registerNewUser();
        logoutUser();
        loginUser(email, password);
    }

    @Test(description = "Logged in user can log out")
    public static void logoutUserTest() {
        registerNewUser();
        logoutUser();
    }

    @Test(description = "Registered user as a Visitor user can reset the password and use it to log in")
    public static void resetPasswordTest() {
        String email = registerNewUser();
        logoutUser();
        elementClick(loginButton);
        elementClick(forgotPasswordButton);
        elementLocate(emailForgotPassworField);
        sendKeys(emailForgotPassworField, email);
        elementClick(sendEmailForgotPassworButton);
        elementLocate(emailSentMessage);
        verifyText(emailSentMessage, forgot_password_email_sent_text+email);
        assertion.get().assertAll();
        /*
        To fully test this test case it is required to use real email.
        If I would use gmail, it will require creating email, enabling API in Google Cloud Console and setting up API inside this project.
        One gmail account can be used (no need for repetitive creation od gmail accounts), to reuse same account many times all that I
        need to do here is when I register user with that email, I would just need to use this template:
        some_gmail_email+some_random_string@gmail.com
        All messages sent to all those accounts will be visible in some_gmail_email@gmail.com inbox
        * */
    }
}
