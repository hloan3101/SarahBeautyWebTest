package pages;

import commons.BaseSetup;
import commons.MessageHelper;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import ultilites.Log;

public class RegisterPage extends BaseSetup {

    private ValidateHelper validateHelper;
    private By firstNameInput = By.id("firstname");
    private By lastNameInput = By.id("lastname");
    private By emailInput = By.id("email_address");
    private By passwordInput = By.id("password");
    private By confirmationPasswordInput = By.id("password-confirmation");
    private By signUpForNewsletterCheckBox = By.id("is_subscribed");
    private By remoteShoppingAssistanceCheckBox = By.id("assistance_allowed_checkbox");
    private By showPasswordCheckBox = By.id("show-password");
    private By createAnAccountBtn = By.id("send2");
    private By errFirstName = By.id("firstname-error");
    private By errLastName = By.id("lastname-error");
    private By errEmailAddress = By.id("email_address-error");
    private By errPassword = By.id("password-error");
    private By errConfirmPassword = By.id("password-confirmation-error");
    private By errRegisterMessage= By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div");
    private By checkRegister = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");

    public RegisterPage() {
        validateHelper = new ValidateHelper(driver);
    }

    public void registerAccount (String firstName, String lastName, String email, String password,
                                 String confirmPassword) throws InterruptedException {
        validateHelper.waitForPageLoaded();

        validateHelper.setText(firstNameInput, firstName);
        Thread.sleep(1000);
        validateHelper.setText(lastNameInput, lastName);
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");

        Thread.sleep(3000);
        validateHelper.setText(emailInput, email);
        Thread.sleep(1000);
        validateHelper.setText(passwordInput, password);
        Thread.sleep(1000);
        validateHelper.setText(confirmationPasswordInput, confirmPassword);
        Thread.sleep(1000);
        validateHelper.clickElement(showPasswordCheckBox);
        Thread.sleep(1000);
        validateHelper.clickElement(createAnAccountBtn);

        Thread.sleep(5000);
    }

    public boolean verifyRegisterAccount (){

        if (!validateHelper.checkFindElement(checkRegister)){
            Log.error(MessageHelper.errRegisterMessage);
            Log.error(validateHelper.getText(errRegisterMessage));
            Log.error(validateHelper.getText(errFirstName));
            Log.error(validateHelper.getText(errLastName));
            ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
            Log.error(validateHelper.getText(errEmailAddress));
            Log.error(validateHelper.getText(errPassword));
            Log.error(validateHelper.getText(errConfirmPassword));
            ((JavascriptExecutor) driver).executeScript("scroll(0,-500)");
            return false;
        }
        Log.info(validateHelper.getText(checkRegister));
        return true;
    }
}
