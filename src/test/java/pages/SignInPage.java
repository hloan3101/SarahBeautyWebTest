package pages;

import commons.BaseSetup;
import commons.MessageHelper;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import ultilities.Log;

public class SignInPage extends BaseSetup {


    private ValidateHelper validateHelper;
    private By emailInput = By.id("email");
    private By passwordInput = By.id("pass");
    private By showPasswordCheckBox = By.id("show-password");
    private By signInBtn = By.xpath("//*[@id=\"send2\"]");

    private By errMessageSignInText = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
    private By incorrectCaptcharText = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div");

    private By errEmail = By.id("email-error");
    private By errPassword = By.id("pass-error");
    private By errMessage = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");

    public SignInPage() {
        validateHelper = new ValidateHelper(driver);
    }

    public void signIn (String emailValue, String passwordValue) throws InterruptedException {
        validateHelper.waitForPageLoaded();

        validateHelper.setText(emailInput, emailValue);
        Thread.sleep(1000);
        validateHelper.setText(passwordInput, passwordValue);
        Thread.sleep(1000);
        validateHelper.clickElement(showPasswordCheckBox);
        validateHelper.clickElement(signInBtn);
    }

    public boolean verifySignIn (){
//        Assert.assertTrue(!validateHelper.checkDisplayElement(errorMessageSignInText), errMessageSignIn);
//        Assert.assertTrue(!validateHelper.checkDisplayElement(incorrectCaptcharText), errMessageSignIn);
        if (validateHelper.checkFindElement(signInBtn)){
            Log.error(MessageHelper.errMessageSignIn);
            if (validateHelper.checkFindElement(errMessage)){
                Log.error(validateHelper.getText(errMessage));
            }
            if (validateHelper.checkFindElement(errEmail)){
                Log.error(validateHelper.getText(errEmail));
            }
            if (validateHelper.checkFindElement(errPassword)){
                Log.error(validateHelper.getText(errPassword));
            }
            return false;
        }

        return true;
    }
}
