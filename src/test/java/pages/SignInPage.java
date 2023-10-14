package pages;

import commons.BaseSetup;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SignInPage extends BaseSetup {

    private final String checkLoadedSignInPage = "Sign In";
    private final String errMessageSignIn = "Sign In failed";
    private ValidateHelper validateHelper;
    private By emailInput = By.id("email");
    private By passwordInput = By.id("pass");
    private By showPasswordCheckBox = By.id("show-password");
    private By signInBtn = By.xpath("//*[@id=\"send2\"]");

    private By errorMessageSignInText = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
    private By incorrectCaptcharText = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div");

    public SignInPage() {
        validateHelper = new ValidateHelper(driver);
    }

    public void   signIn (String emailValue, String passwordValue) throws InterruptedException {
        validateHelper.waitForPageLoaded();

        validateHelper.setText(emailInput, emailValue);
        Thread.sleep(1000);
        validateHelper.setText(passwordInput, passwordValue);
        Thread.sleep(1000);
        validateHelper.clickElement(showPasswordCheckBox);
        validateHelper.clickElement(signInBtn);
    }

    public void verifySignIn (){
//        Assert.assertTrue(!validateHelper.checkDisplayElement(errorMessageSignInText), errMessageSignIn);
//        Assert.assertTrue(!validateHelper.checkDisplayElement(incorrectCaptcharText), errMessageSignIn);
            Assert.assertTrue(!validateHelper.checkFindElement(signInBtn),errMessageSignIn );
    }
}
