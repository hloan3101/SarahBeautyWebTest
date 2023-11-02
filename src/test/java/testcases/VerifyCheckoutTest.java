package testcases;

import commons.BaseSetup;
import commons.MessageHelper;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.PayPalPage;
import ultilites.TestListener;

@Listeners(TestListener.class)
public class VerifyCheckoutTest extends BaseSetup {

    private CheckoutPage checkoutPage;

    private void setUp (){
        checkoutPage = new CheckoutPage();
    }
    @Test(priority = 1, description = "Verify that the apply discount code is successful")
    public void verifyApplyDiscountCode () throws InterruptedException {
        setUp();
        Assert.assertTrue(checkoutPage.applyDiscountCode("SarahNumber1"));
    }

    @Test(priority = 2, description = "Verify that the select cash on delivery payment")
    public void verifySelectCashOnDeliveryPayment () throws InterruptedException {
        setUp();
        Assert.assertTrue(checkoutPage.selectCashOnDeliveryPayment());
    }

    @Test(priority = 3, description = "Verify that the select paypal payment")
    public void verifySelectPaypalPayment () throws InterruptedException {
        setUp();
        Assert.assertTrue(checkoutPage.selectPaypalPayment());
    }

    @Test(priority = 4, description = "Verify that the order by cash delivery method")
    public void verifyOderByCashDeliveryMethod () throws InterruptedException {
        Assert.assertTrue(checkoutPage.orderByCashOnDeliveryPayment());
    }

    @Test(priority = 5, description = "Verify that the order by paypal method")
    public void verifyOderByPaypalMethod () throws InterruptedException {
        Assert.assertTrue(checkoutPage.orderByPaypal());

        PayPalPage payPalPage = new PayPalPage();
        payPalPage.loginPayPalAccount(MessageHelper.emailPayPalAccount, MessageHelper.passwordPayPalAccount);

        Assert.assertTrue(payPalPage.verifyLoginPayPayAccount());
        Assert.assertTrue(payPalPage.completePurchase());

    }
}
