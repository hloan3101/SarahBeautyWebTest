package pages;

import commons.BaseSetup;
import commons.MessageHelper;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import ultilites.Log;

public class PayPalPage extends BaseSetup {

    private ValidateHelper validateHelper;

    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By showPaswordBtn = By.id("Show password");
    private By logInBtn = By.id("btnLogin");
    private By errEmptyEmail = By.xpath("//*[@id=\"emailErrorMessage\"]/p[1]");
    private By errEmail = By.xpath("//*[@id=\"emailErrorMessage\"]/p[2]");
    private By errEmptyPassword = By.xpath("//*[@id=\"passwordErrorMessage\"]/p");
    private By errLogInMessage = By.xpath("//*[@id=\"content\"]/div[1]/p");
    private By completePurchaseBtn = By.xpath("//*[@id=\"hermione-container\"]/div/main/div[3]/div[2]");
    private By checkoutMessage = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
    private By nextBtn = By.id("btnNext");
    private By errMessage = By.xpath("//*[@id=\"content\"]/div[1]/p");
    public PayPalPage() {
        validateHelper = new ValidateHelper(driver);
    }

    public void loginPayPalAccount (String email, String password) throws InterruptedException {
        Thread.sleep(1000);
        validateHelper.setText(emailInput, email);
        Thread.sleep(1000);
        validateHelper.clickElement(nextBtn);
        Thread.sleep(1000);
        validateHelper.setText(passwordInput, password);
        Thread.sleep(1000);
        validateHelper.clickElement(logInBtn);
        Thread.sleep(1000);

    }

    public boolean verifyLoginPayPayAccount (){
        if (validateHelper.checkFindElement(errLogInMessage)){
            Log.error(validateHelper.getText(errLogInMessage));
            return false;
        }

        if (validateHelper.checkFindElement(errEmptyEmail)){
            Log.error(validateHelper.getText(errEmptyEmail));
            return false;
        }

        if (validateHelper.checkFindElement(errEmail)){
            Log.error(validateHelper.getText(errEmail));
            return false;
        }

        if (validateHelper.checkFindElement(errEmptyPassword)){
            Log.error(validateHelper.getText(errEmptyPassword));
            return false;
        }

        return true;
    }

    public boolean completePurchase () throws InterruptedException {
        Thread.sleep(5000);
        validateHelper.clickElement(completePurchaseBtn);
        Thread.sleep(5000);

        return  validateHelper.getText(checkoutMessage).equals(MessageHelper.checkoutSuccessMessage);
    }
}
