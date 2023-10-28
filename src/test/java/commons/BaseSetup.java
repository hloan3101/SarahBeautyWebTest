package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ultilites.Log;

public class BaseSetup {

    public static WebDriver driver;
    private final String webUrl = "http://sarahbeauty.com/";
    public String orderTotal;


    public void initChromeDriver () throws InterruptedException {
        Log.info(MessageHelper.setUpChromeBrowserMessage);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(webUrl);

        driver.manage().window().maximize();
        Log.info(MessageHelper.setUpHomePagerMessage);
        Thread.sleep(2000);

        orderTotal = " ";
    }

    public WebDriver getDriver() {
        return driver;
    }

//    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }
}
