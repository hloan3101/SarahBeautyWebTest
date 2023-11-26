package testcases;

import commons.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import ultilities.TestListener;

@Listeners(TestListener.class)
public class VerifySearchProductTest extends BaseSetup {

    @Test(description = "Verify that the search product 1 is successful")
    public void verifySearchProductSuccess () throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.searchProduct("Maybelline");
        Assert.assertTrue(homePage.verifySearchProduct());
    }

    @Test(description = "Verify that the search product is failed")
    public void verifySearchProductFailed () throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.searchProduct("*****");
        Assert.assertTrue(homePage.verifySearchProduct());
    }
}
