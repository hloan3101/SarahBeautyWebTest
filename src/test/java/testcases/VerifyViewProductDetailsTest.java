package testcases;

import commons.BaseSetup;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.ViewProductDetailsPage;
import ultilities.Log;
import ultilities.TestListener;

@Listeners(TestListener.class)
public class VerifyViewProductDetailsTest extends BaseSetup {

    private ProductPage productPage;
    private ViewProductDetailsPage viewProductDetailsPage;
    private String productName;

    @Test(description = "Verify that the view product details")
    public void verifyViewProductDetails () throws InterruptedException {
        productPage = new ProductPage();
        productName = productPage.selectProduct();
        Log.info("Product name: " + productName);
        viewProductDetailsPage = new ViewProductDetailsPage();
        viewProductDetailsPage.viewProductDetails();
    }

}
