package testcases;

import commons.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import ultilites.TestListener;

@Listeners(TestListener.class)
public class VerifySignOutTest extends BaseSetup {

    @Test ( description = "Verify that the sign out account")
    public void SignOut () throws InterruptedException {
        HomePage mainPage = new HomePage();
        Assert.assertTrue(mainPage.signOutAccount());
    }
}
