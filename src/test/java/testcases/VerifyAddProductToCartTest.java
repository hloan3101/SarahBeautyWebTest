package testcases;

import commons.BaseSetup;
import commons.MessageHelper;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ViewProductDetailsPage;
import ultilities.TestListener;

@Listeners(TestListener.class)
public class VerifyAddProductToCartTest extends BaseSetup {
    private ViewProductDetailsPage viewProductDetailsPage;

    @Test(priority = 1, description = "Verify that the increase quantity product")
    public void verifyIncreaseQuantityProduct () throws InterruptedException {
        viewProductDetailsPage = new ViewProductDetailsPage();
        viewProductDetailsPage.selectSwatchOption();
        Assert.assertTrue(viewProductDetailsPage.increaseQualityProduct().equals("2"));
    }
//
//    @Test(priority = 2, description = "Verify that the reduce quantity product")
//    public void verifyReduceQuantityProduct () throws InterruptedException {
//        Assert.assertTrue(viewProductDetailsPage.reduceQualityProduct().equals("1"));
//    }

    @Test(description = "Verify that the add product to cart")
    public void verifyAddProductToCart () throws InterruptedException {
        viewProductDetailsPage = new ViewProductDetailsPage();
        viewProductDetailsPage.selectSwatchOption();
        viewProductDetailsPage.addProductToCart();
        Assert.assertTrue(viewProductDetailsPage.verifyAddProductToCart(MessageHelper.productName));
    }
    @Test(priority = 2, description = "Verify that the add product to cart")
    public void verifyAddProductToCart2 () throws InterruptedException {
        viewProductDetailsPage.addProductToCart();
        Assert.assertTrue(viewProductDetailsPage.verifyAddProductToCart(MessageHelper.productName));
    }

}
