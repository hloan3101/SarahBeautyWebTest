package pages;

import commons.BaseSetup;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ProductPage extends BaseSetup {

    ValidateHelper validateHelper;
    private By nameProduct = By.linkText("POND'S Vitamin Micellar Water Brightening Rose with 5 Vitamins," +
            " French Roses for a Bright Glow 100ml");

    private By title = By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1/span");

    public ProductPage() {
        validateHelper = new ValidateHelper(driver);

    }

    public String selectProduct () throws InterruptedException {
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,600)");
        Thread.sleep(3000);
        validateHelper.clickElement(nameProduct);
        return validateHelper.getText(title);
    }
}
