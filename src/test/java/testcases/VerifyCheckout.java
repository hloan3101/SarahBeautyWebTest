package testcases;

import commons.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class VerifyCheckout extends BaseSetup {

    private CheckoutPage checkoutPage;

    private void setUp (){
        checkoutPage = new CheckoutPage();
    }
    @Test(priority = 1)
    public void verifyApplyDiscountCode () throws InterruptedException {
        setUp();
        Assert.assertTrue(checkoutPage.applyDiscountCode("SarahNumber1"));
    }

    @Test(priority = 2)
    public void verifySelectCashOnDeliveryPayment () throws InterruptedException {
        setUp();
        Assert.assertTrue(checkoutPage.selectCashOnDeliveryPayment());
    }

    @Test(priority = 3)
    public void verifySelectPaypalPayment () throws InterruptedException {
        setUp();
        Assert.assertTrue(checkoutPage.selectPaypalPayment());
    }

    @Test(priority = 4)
    public void verifyOderByCashDeliveryMethod () throws InterruptedException {
        Assert.assertTrue(checkoutPage.orderByCashOnDeliveryPayment());
    }

    @Test(priority = 5)
    public void verifyOderByPaypalMethod () throws InterruptedException {
        checkoutPage.orderByPaypal();
    }


}
