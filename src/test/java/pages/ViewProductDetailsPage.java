package pages;

import commons.BaseSetup;
import commons.MessageHelper;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import ultilites.Log;

public class ViewProductDetailsPage extends BaseSetup {
    ValidateHelper validateHelper;
    private By increaseQuatityProductBtn = By.xpath("//*[@id=\"product_addtocart_form\"]/div[2]/div/div/div[1]/div/span[2]/button");
    private By reduceQuatityProductBtn = By.xpath("//*[@id=\"product_addtocart_form\"]/div[2]/div/div/div[1]/div/span[1]/button");
    private By addToCartButton = By.xpath("//*[@id=\"product-addtocart-button\"]");
    private By swatchOption = By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div/div");
    private By selectOptionAb = By.id("option-label-choose_color-137-item-7");
    private By addToCartMessage = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div");

    private By quantity = By.id("qty");

    private By counterNumberSpan = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[2]/div[1]/a/span[2]/span[1]");

    public ViewProductDetailsPage() {
        validateHelper = new ValidateHelper(driver);
    }

    public void viewProductDetails() throws InterruptedException {
        validateHelper.waitForPageLoaded();
        Log.info(MessageHelper.viewProductDetailPageMessage);
        //scroll down page
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,800)");
        Thread.sleep(1000);
    }

    public void selectSwatchOption () throws InterruptedException {
        if (validateHelper.checkFindElement(swatchOption)){
            validateHelper.clickElement(selectOptionAb);
        }
    }

    public String increaseQualityProduct () throws InterruptedException {
        Thread.sleep(1000);
        validateHelper.clickElement(increaseQuatityProductBtn);
        return getQuantity();
    }

    public String reduceQualityProduct () throws InterruptedException {
        Thread.sleep(2000);
        validateHelper.clickElement(reduceQuatityProductBtn);
        return getQuantity();
    }

    public void addProductToCart () throws InterruptedException {
        Thread.sleep(2000);
        validateHelper.clickElement(addToCartButton);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,-900)");

    }
    public boolean verifyAddProductToCart (String productName){
        if (validateHelper.getText(addToCartMessage).equals("You added " +productName + " to your shopping cart.")){
            Log.info(MessageHelper.addToCartSuccessMassage);
            return true;
        }

        Log.error(MessageHelper.addToCartFailedMassage);
        return false;
    }

    private String getQuantity (){
        Log.info("Quantity: " + validateHelper.getValue(quantity));
        return  validateHelper.getValue(quantity);
    }
}
