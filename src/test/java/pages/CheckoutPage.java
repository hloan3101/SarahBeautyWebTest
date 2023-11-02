package pages;

import commons.BaseSetup;
import commons.MessageHelper;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import ultilities.Log;

public class CheckoutPage extends BaseSetup {
    private ValidateHelper validateHelper;
    private By cashOnDeliveryRadio = By.id("cashondelivery");
    private By paypalExpressCheckoutRadio = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[1]/label");
    private By applyDiscountCodeLink = By.id("block-discount-heading");
    private By placeOderBtn = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]" +
            "/div[2]/div[4]/div/button");
    private By discountCodeInput = By.id("discount-code");
    private By applyDiscountButton = By.xpath("//*[@id=\"discount-form\"]/div[2]/div/button");
    private By continueToPaypalBtn = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]" +
            "/div[2]/div[4]/div/button");
    private By errDiscountCodeMessage = By.id("checkout-cart-validationmessages-message-error");
    private By errDiscounMessage = By.id("discount-code-error");
    private By checkoutMessage = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
    private By errPayPalPaymentMessage = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[3]/div/div");

    private By orderTotal = By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[3]/td/strong/span");
    public CheckoutPage() {
        validateHelper = new ValidateHelper(driver);
    }

    public boolean selectCashOnDeliveryPayment () throws InterruptedException {
        Thread.sleep(5000);
        validateHelper.clickElement(cashOnDeliveryRadio);
        Thread.sleep(1000);

        return validateHelper.checkSelected(cashOnDeliveryRadio);
    }

    public boolean selectPaypalPayment () throws InterruptedException {
        Thread.sleep(5000);
        validateHelper.clickElement(paypalExpressCheckoutRadio);
        Thread.sleep(1000);

        return validateHelper.checkFindElement(continueToPaypalBtn);
    }

    public boolean orderByCashOnDeliveryPayment () throws InterruptedException {
        Thread.sleep(5000);
        validateHelper.clickElement(placeOderBtn);
        Thread.sleep(5000);
        return  validateHelper.getText(checkoutMessage).equals(MessageHelper.checkoutSuccessMessage);
    }

    public boolean orderByPaypal () throws InterruptedException {
        Thread.sleep(5000);
        validateHelper.clickElement(continueToPaypalBtn);
        Thread.sleep(5000);
        if (validateHelper.checkFindElement(errPayPalPaymentMessage)){
            Log.error(validateHelper.getText(errPayPalPaymentMessage));
            return false;
        }

        return true;
    }

    public boolean applyDiscountCode (String discountCode) throws InterruptedException {
        Thread.sleep(1000);
        validateHelper.clickElement(applyDiscountCodeLink);
        Thread.sleep(1000);
        validateHelper.setText(discountCodeInput, discountCode);
        Thread.sleep(1000);
        validateHelper.clickElement(applyDiscountButton);

        if (validateHelper.checkFindElement(errDiscountCodeMessage)){
            Log.error(validateHelper.getText(errDiscountCodeMessage));
            return false;
        }

        if (validateHelper.checkFindElement(errDiscounMessage)){
            Log.error(validateHelper.getText(errDiscounMessage));
            return false;
        }

        setOrderTotal(validateHelper.getText(orderTotal));

        return true;
    }
}
