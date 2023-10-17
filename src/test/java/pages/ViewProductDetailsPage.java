package pages;

import commons.BaseSetup;
import commons.MessageHelper;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import ultilites.Log;

public class ViewProductDetailsPage extends BaseSetup {
    ValidateHelper validateHelper;
    private By increaseQuatityProductBtn = By.xpath("//*[@id=\"product_addtocart_form\"]" +
            "/div/div/div[1]/div/span[2]/button");
    private By reduceQuatityProductBtn = By.xpath("//*[@id=\"product_addtocart_form\"]/" +
            "div/div/div[1]/div/span[1]/button");
    private By addToCartButton = By.id("product-addtocart-button");
    private By addToCartMessage = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div");

    private By quantity = By.id("qty");

    private By counterNumberSpan = By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[2]/div[1]/a/span[2]/span[1]");

    public ViewProductDetailsPage() {
        validateHelper = new ValidateHelper(driver);
    }

    public void viewProductDetails() throws InterruptedException {
        validateHelper.waitForPageLoaded();
        //scroll down page
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,800)");
        Thread.sleep(1000);
    }

    public String increaseQualityProduct () throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("scroll(0,-900)");
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
