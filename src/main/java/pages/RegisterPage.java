package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ByIdOrName;

public class RegisterPage {

    private WebDriver driver;

    private By firstNameInput = By.id("firstname");
    private By lastNameInput = By.id("lastname");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By passwordConfirmationInput = By.id("password_confirmation");
    private By signUpForNewsletterCheckBox = By.id("is_subscribed");
    private By remoteShoppingAssistanceCheckBox = By.id("assistance_allowed_checkbox");
    private By showPasswordCheckBox = By.id("show-password");
    private By createAnAccountBtn = By.id("send2");
}
