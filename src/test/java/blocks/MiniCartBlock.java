package blocks;

import commons.BaseSetup;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import ultilites.Log;

public class MiniCartBlock extends BaseSetup {
    private ValidateHelper validateHelper;

    private By proceedToCheckoutBtn = By.id("top-cart-btn-checkout");
    private By increaseBtn = By.name("increment");
    private By reduceBtn = By.name("decrement");
    private By quantityInput = By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[4]/ol/li/div/div/div[2]/div[2]/input");
    private By deleteBtn = By.className("secondary");
    private By updateBtn = By.className("update-cart-item");
    private By titleCheckoutPage = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
    public MiniCartBlock() {
        validateHelper = new ValidateHelper(driver);
    }

    public boolean increaseQuantityProduct () throws InterruptedException {
        Thread.sleep(2000);
        int tmp = Integer.valueOf(getQuantity())+ 1;
        validateHelper.clickElement(increaseBtn);
        Thread.sleep(3000);
        validateHelper.clickElement(updateBtn);
        Thread.sleep(2000);
        Log.info("Tmp: " +tmp);
        Log.info("Quantity: " +getQuantity());
        return Integer.valueOf(getQuantity()) == tmp;
    }

    public boolean reduceQuantityProduct () throws InterruptedException {
        int tmp = Integer.valueOf(getQuantity())- 1;
        Thread.sleep(2000);
        validateHelper.clickElement(reduceBtn);
        Thread.sleep(2000);
        validateHelper.clickElement(updateBtn);
        Log.info("Quantity: " + getQuantity());
        return Integer.valueOf(getQuantity()) == tmp;
    }

    public Boolean deleteProduct () throws InterruptedException {
        Thread.sleep(2000);
        validateHelper.clickElement(deleteBtn);
        return true;
    }

    public Boolean checkoutCart () throws InterruptedException {
        Thread.sleep(2000);
        validateHelper.clickElement(proceedToCheckoutBtn);
        return validateHelper.getText(titleCheckoutPage).equals("Checkout");
    }

    public String getQuantity (){
        return driver.findElement(quantityInput).getAttribute("data-item-qty");
    }
}
