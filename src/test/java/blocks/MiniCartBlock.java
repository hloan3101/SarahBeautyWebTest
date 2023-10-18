package blocks;

import commons.BaseSetup;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import ultilites.Log;

public class MiniCartBlock extends BaseSetup {
    private ValidateHelper validateHelper;

    private By proceedToCheckoutBtn = By.xpath("//*[@id=\"top-cart-btn-checkout\"]");
    private By increaseBtn = By.xpath("//*[@id=\"mini-cart\"]/li/div/div/div[2]/div[2]/button[2]");
    private By reduceBtn = By.xpath("//*[@id=\"mini-cart\"]/li/div/div/div[2]/div[2]/button[1]");
    private By quantityInput = By.xpath("//*[@id=\"cart-item-25-qty\"]");
    private By deleteBtn = By.xpath("//*[@id=\"mini-cart\"]/li/div/div/div[3]/div[2]/a");
    private By updateBtn = By.xpath("//*[@id=\"update-cart-item-25\"]");
    private By titleCheckoutPage = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
    public MiniCartBlock() {
        validateHelper = new ValidateHelper(driver);
    }

    public boolean increaseQuantityProduct () throws InterruptedException {
        String tmp = getQuantity()+ 1;
        Thread.sleep(1000);
        validateHelper.clickElement(increaseBtn);
        Thread.sleep(1000);
        validateHelper.clickElement(updateBtn);
        Log.info("Quantity: " +getQuantity());
        return getQuantity() == tmp;
    }

    public boolean reduceQuantityProduct () throws InterruptedException {
        String tmp = getQuantity()- 1;
        Thread.sleep(1000);
        validateHelper.clickElement(reduceBtn);
        Thread.sleep(1000);
        validateHelper.clickElement(updateBtn);
        Log.info("Quantity: " + getQuantity());
        return getQuantity() == tmp;
    }

    public Boolean deleteProduct () throws InterruptedException {
        Thread.sleep(1000);
        validateHelper.clickElement(deleteBtn);
        return true;
    }

    public Boolean checkoutCart (){
        validateHelper.clickElement(proceedToCheckoutBtn);
        return validateHelper.getText(titleCheckoutPage).equals("Checkout");
    }

    public String getQuantity (){
        return driver.findElement(quantityInput).getAttribute("data-item-qty");
    }
}
