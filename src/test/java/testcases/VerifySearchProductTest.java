package testcases;

import commons.BaseSetup;
import commons.ExcelHelper;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import ultilites.TestListener;

@Listeners(TestListener.class)
public class VerifySearchProductTest extends BaseSetup {
    private ExcelHelper excelHelper;

    private void setUp () throws InterruptedException {
        initChromeDriver();
    }

    @Test(description = "Verify that the search product is successful")
    public void verifySearchProductSuccess () throws InterruptedException {
        setUp();
        HomePage homePage = new HomePage();
        homePage.searchProduct("Pond");
        Assert.assertTrue(homePage.verifySearchProduct());
    }

    @Test(description = "Verify that the search product is failed")
    public void verifySearchProductFailed () throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.searchProduct("*****");
        Assert.assertTrue(homePage.verifySearchProduct());
    }
}
