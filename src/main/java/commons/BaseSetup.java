package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseSetup {

    private WebDriver driver;
    private String webURL = "http://sarahbeauty.com/";

    @BeforeClass
    public void initChromeDriver () throws InterruptedException {
        System.out.println("Launching Chrome browser...");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(webURL);
        driver.manage().window().maximize();

        Thread.sleep(2000);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
