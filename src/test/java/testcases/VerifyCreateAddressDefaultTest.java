package testcases;

import commons.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import ultilities.TestListener;

@Listeners(TestListener.class)
public class VerifyCreateAddressDefaultTest extends BaseSetup {

    HomePage homePage;
    AccountPage accountPage;

    private void setUp () throws InterruptedException {
        homePage = new HomePage();
        Assert.assertTrue(homePage.setUpAccountPage());
        accountPage = new AccountPage();
    }
    @Test (description = "Verify that the create default address with correct data")
    public void verifyCreateAddress () throws InterruptedException {
        accountPage = new AccountPage();
        accountPage.setAddress("0862672122", "Donald Trump", "Alaska", "Anchorage", "99516");
        Assert.assertTrue(accountPage.verifySetAddress());
    }

}
