package pages;

import commons.BaseSetup;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MainPage extends BaseSetup {

    ValidateHelper validateHelper;
    private By searchInput = By.id("search");
    private By miniCartIcon = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[2]/div[1]");
    private By signInLinkText = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[2]");
    private By creatAnAccountLinkText = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[3]");
    private By customerMenuBtn = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private By signOutLink = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]");
    private By signOutText = By.xpath("");
    public MainPage() {
        validateHelper = new ValidateHelper(driver);
    }

    public SignInPage LaunchingSignInPage(){

        System.out.println("Launching Sign In Page...");
        validateHelper.clickElement(signInLinkText);
        System.out.println("Sign In Page opened");
        return new SignInPage();
    }

    public void SignOutAccount () throws InterruptedException {

        Thread.sleep(2000);
        System.out.println("Sign Out Account...");

        Assert.assertTrue(validateHelper.checkFindElement(customerMenuBtn), "Customer menu button is not displayed");
        Assert.assertTrue(validateHelper.checkFindElement(signOutLink), "Customer menu is not display");

        Thread.sleep(2000);
        validateHelper.clickElement(customerMenuBtn);

        Thread.sleep(3000);
        validateHelper.clickElement(signOutLink);
        Thread.sleep(8000);
        Assert.assertTrue(validateHelper.checkFindElement(signInLinkText), "Sign out failed");
    }
}
