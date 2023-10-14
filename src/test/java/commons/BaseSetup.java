package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSetup {

    public static WebDriver driver;
    private String webURL = "http://sarahbeauty.com/";


    public void initChromeDriver () throws InterruptedException {
        System.out.println("Launching Chrome browser...");
        System.out.println("Launching Main Page...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(webURL);
        driver.manage().window().maximize();
        System.out.println("Main Page opened...");
        Thread.sleep(2000);
    }

    public WebDriver getDriver() {
        return driver;
    }

//    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
