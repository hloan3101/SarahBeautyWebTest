package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ultilites.Log;

import java.time.Duration;

public class ValidateHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public ValidateHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //    Sending a value for a element
    public void setText (By element, String value){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }


    public String getText (By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return driver.findElement(element).getText();
    }

    public String getValue (By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return driver.findElement(element).getAttribute("value");
    }

    public void pressEnterKey(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        clickElement(element);
        driver.findElement(element).sendKeys(Keys.ENTER);
    }

    //    Click a element
    public void clickElement (By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public void selectOptionByText (By element, String text){
       Select select = new Select(driver.findElement(element));
       select.selectByVisibleText(text);
    }

    public boolean verifyElementText (By element, String textValue){
        return driver.findElement(element).getText().equals(textValue);
    }

    public boolean checkSelected (By element){
        return driver.findElement(element).isSelected();
    }

    public boolean checkFindElement (By element){
        try {
            WebElement webElement = driver.findElement(element);
        }catch (NoSuchElementException ex){
            return false;
        }
        return true;
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                                .toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            Log.error(MessageHelper.errTimeOutMessage);
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
