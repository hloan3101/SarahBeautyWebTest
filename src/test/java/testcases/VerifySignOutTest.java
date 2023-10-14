package testcases;

import commons.BaseSetup;
import org.testng.annotations.Test;
import pages.MainPage;

public class VerifySignOutTest extends BaseSetup {

    @Test
    public void SignOut () throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.SignOutAccount();
    }
}
