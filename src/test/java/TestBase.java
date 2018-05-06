
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by HillelNew5 on 01.04.2018.
 */

import urlbuilder.*;
import loggers.*;
public abstract class TestBase {
    protected Logger logger;
    protected WebDriver driver;
    protected WebDriverWait wait;


    @Before
    public void setUp() {
        logger = new ConsoleLogger();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        log("Setting window size");
        driver.manage().window().maximize();

        log("Navigating to Comments website");
        String url = new Url.UrlBuilder("rabota.ua/украина")
                .withHttps(true)
                .build()
                .getUrl();
        driver.get(url);
        beforeTest();

    }

    @After
    public void tearDown() {
        afterTest();
        driver.quit();
    }
    protected void log(String textToLog) {
        logger.log(textToLog);
    }

    protected  void beforeTest(){

    }
    protected  void afterTest(){

    }
}
