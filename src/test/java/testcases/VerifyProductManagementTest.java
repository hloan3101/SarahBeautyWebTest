package testcases;

import blocks.MiniCartBlock;
import commons.BaseSetup;
import commons.MessageHelper;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import ultilites.Log;
import ultilites.TestListener;

@Listeners(TestListener.class)
public class VerifyProductManagementTest extends BaseSetup {

    HomePage homePage;
    MiniCartBlock miniCartBlock;

    public void setUp () throws InterruptedException {
        homePage = new HomePage();
        miniCartBlock = homePage.setupMiniCartBlock();
    }

    @Test(priority = 1, description = "Verify that the increase quantity of products")
    public void verifyIncreaseQuantityProduct () throws InterruptedException {
        setUp();
        Assert.assertTrue(miniCartBlock.increaseQuantityProduct());
    }

    @Test(priority = 2, description = "Verify that the reduce quantity of products")
    public void verifyReduceQuantityProduct () throws InterruptedException {
        setUp();
        Assert.assertTrue(miniCartBlock.reduceQuantityProduct());
    }

    @Test(priority = 3, description =  "Verify that the delete product")
    public void verifyDeleteProduct () throws InterruptedException {
        setUp();
        Assert.assertTrue(miniCartBlock.deleteProduct());
    }

    @Test(priority = 4, description = "Verify that the check out cart")
    public void verifyCheckOutCart () throws InterruptedException {
        Assert.assertTrue(miniCartBlock.checkoutCart());
        Log.info(MessageHelper.checkoutPageMessage);
    }

}
