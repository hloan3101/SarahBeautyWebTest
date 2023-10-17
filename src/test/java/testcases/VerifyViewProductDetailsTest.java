package testcases;

import commons.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.ViewProductDetailsPage;
import ultilites.Log;
import ultilites.TestListener;

@Listeners(TestListener.class)
public class VerifyViewProductDetailsTest extends BaseSetup {

    private ProductPage productPage;
    private ViewProductDetailsPage viewProductDetailsPage;
    private String productName;

    @Test(priority = 1, description = "Verify that the view product details")
    public void verifyViewProductDetails () throws InterruptedException {
        productPage = new ProductPage();
        productName = productPage.selectProduct();
        Log.info("Product name: " + productName);
        viewProductDetailsPage = new ViewProductDetailsPage();
        viewProductDetailsPage.viewProductDetails();
    }

    @Test(priority = 2, description = "Verify that the increase quantity product")
    public void verifyIncreaseQuantityProduct () throws InterruptedException {
        Assert.assertTrue(viewProductDetailsPage.increaseQualityProduct().equals("2"));
    }

    @Test(priority = 3, description = "Verify that the reduce quantity product")
    public void verifyReduceQuantityProduct () throws InterruptedException {
        Assert.assertTrue(viewProductDetailsPage.reduceQualityProduct().equals("1"));
    }

    @Test(priority = 4, description = "Verify that the add product to cart")
    public void verifyAddProductToCart () throws InterruptedException {
            viewProductDetailsPage.addProductToCart();
            Assert.assertTrue(viewProductDetailsPage.verifyAddProductToCart(productName));
    }
}
