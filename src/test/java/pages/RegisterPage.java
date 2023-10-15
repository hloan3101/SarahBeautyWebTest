package pages;

import commons.BaseSetup;
import commons.MessageHelper;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPage extends BaseSetup {

    private ValidateHelper validateHelper;
    private By firstNameInput = By.id("firstname");
    private By lastNameInput = By.id("lastname");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By confirmationPasswordInput = By.id("password_confirmation");
    private By signUpForNewsletterCheckBox = By.id("is_subscribed");
    private By remoteShoppingAssistanceCheckBox = By.id("assistance_allowed_checkbox");
    private By showPasswordCheckBox = By.id("show-password");
    private By createAnAccountBtn = By.id("send2");

    public RegisterPage() {
        validateHelper = new ValidateHelper(driver);
    }

    public void RegisterAccount (String firstName, String lastName, String email, String password,
                                 String confirmPassword) throws InterruptedException {
        validateHelper.waitForPageLoaded();

        validateHelper.setText(firstNameInput, firstName);
        Thread.sleep(1000);
        validateHelper.setText(lastNameInput, lastName);
        Thread.sleep(1000);
        validateHelper.setText(emailInput, email);
        Thread.sleep(1000);
        validateHelper.setText(passwordInput, password);
        Thread.sleep(1000);
        validateHelper.setText(confirmationPasswordInput, confirmPassword);
        Thread.sleep(1000);
        validateHelper.clickElement(createAnAccountBtn);
    }

    public void verifyRegisterAccount (){
        Assert.assertTrue(!validateHelper.checkFindElement(createAnAccountBtn), MessageHelper.errRegisterMessage);
    }
}
