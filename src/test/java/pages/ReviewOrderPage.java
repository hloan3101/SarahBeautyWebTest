package pages;

import commons.BaseSetup;
import commons.MessageHelper;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import ultilities.Log;

public class ReviewOrderPage extends BaseSetup {

    private  ValidateHelper validateHelper;
    private By orderNumberText = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a/strong");
    private By titleOrders = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span");

    public ReviewOrderPage() {
        validateHelper = new ValidateHelper(driver);
    }

    public boolean reviewOder () throws InterruptedException {
        Thread.sleep(2000);
        String tmpOrderNumber = validateHelper.getText(orderNumberText);

        Log.info("Order Number: " + tmpOrderNumber);
        validateHelper.clickElement(orderNumberText);
        validateHelper.waitForPageLoaded();

        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,700)");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,1000)");



        if (validateHelper.getText(titleOrders).contains(tmpOrderNumber)){
            return true;
        }

        Log.error(MessageHelper.errReviewOrderMessage);
        return false;
    }
}
