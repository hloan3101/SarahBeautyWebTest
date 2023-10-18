package testcases;

import blocks.MiniCartBlock;
import commons.BaseSetup;
import commons.MessageHelper;
import org.testng.Assert;
import pages.HomePage;
import ultilites.Log;

public class VerifyProductManagement extends BaseSetup {

    HomePage homePage;
    MiniCartBlock miniCartBlock;
    public void setUp (){
        homePage = new HomePage();
        miniCartBlock = homePage.setupMiniCartBlock();
    }
    public void verifyIncreaseQuantityProduct () throws InterruptedException {
        Assert.assertTrue(miniCartBlock.increaseQuantityProduct());
    }
    public void verifyReduceQuantityProduct () throws InterruptedException {
        Assert.assertTrue(miniCartBlock.reduceQuantityProduct());
    }
    public void verifyDeleteProduct () throws InterruptedException {
        Assert.assertTrue(miniCartBlock.deleteProduct());
    }

    public void verifyCheckOut (){
        Assert.assertTrue(miniCartBlock.checkoutCart());
        Log.info(MessageHelper.checkoutPageMessage);
    }

}
