package pages;

import blocks.MiniCartBlock;
import commons.BaseSetup;
import commons.MessageHelper;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import ultilites.Log;

public class HomePage extends BaseSetup {

    ValidateHelper validateHelper;
    private By miniCartIcon = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[2]/div[1]");
    private By signInLinkText = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[2]");
    private By creatAnAccountLinkText = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[3]");
    private By customerMenuBtn = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private By signOutLink = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]");
    private By searchInput = By.xpath("//*[@id=\"search\"]");
    private By searchInputMessage = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]");
    private By toolbarAmount = By.className("toolbar-number");
    private By items = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]");

    public HomePage() {
        validateHelper = new ValidateHelper(driver);
    }

    public SignInPage setupSignInPage(){
        validateHelper.clickElement(signInLinkText);
        Log.info(MessageHelper.signInPageMessage);
        return new SignInPage();
    }

    public RegisterPage setupRegisterAccountPage(){
        validateHelper.clickElement(creatAnAccountLinkText);
        Log.info(MessageHelper.setupRegisterAccountPageMessage);
        return new RegisterPage();
    }

    public MiniCartBlock setupMiniCartBlock(){
        validateHelper.clickElement(miniCartIcon);
        Log.info(MessageHelper.miniCartBlockMessage);
        return new MiniCartBlock();
    }

    public boolean signOutAccount() throws InterruptedException {

        Thread.sleep(2000);
        Log.info(MessageHelper.signOutAccountMessage);

        if (!validateHelper.checkFindElement(customerMenuBtn)){
            Log.error(MessageHelper.errCustomerMenuMessage);
            return false;
        }

        if (!validateHelper.checkFindElement(signOutLink)){
            Log.error(MessageHelper.errSignOutLinkMessage);
            return false;
        }

        Thread.sleep(2000);
        validateHelper.clickElement(customerMenuBtn);

        Thread.sleep(3000);
        validateHelper.clickElement(signOutLink);
        Thread.sleep(8000);

        if (!validateHelper.checkFindElement(signInLinkText)){
            Log.error("MessageHelper.errSignOutMessage");
            return false;
        }

        return true;
    }

    public void searchProduct(String nameProduct) throws InterruptedException {
        validateHelper.waitForPageLoaded();

        validateHelper.setText(searchInput, nameProduct);
        Thread.sleep(1000);
        validateHelper.pressEnterKey(searchInput);
        Log.info(MessageHelper.productPageMessage);
    }

    public boolean verifySearchProduct (){
        if (validateHelper.getText(searchInputMessage).equals("Your search returned no results.")){
            Log.error(validateHelper.getText(searchInputMessage));
            return false;
        }

        Log.info("Search result: " + validateHelper.getText(toolbarAmount) + " Items");

        return true;
    }
}
