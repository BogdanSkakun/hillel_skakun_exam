package pages;

import interfaces.Getter;
import loggers.ConsoleLogger;
import loggers.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageBase implements Getter{

    protected WebDriver driver;
    private String url = "http://rabota.ua";
    protected Logger logger = new ConsoleLogger();
    protected  String getUrl(){
        return url;
    }

    public PageBase(WebDriver driver){
        this.driver=driver;
    }


    @Override
    public List<WebElement> getElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    @Override
    public WebElement getElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }


    protected void log(String textToLog) {
        logger.log(textToLog);
    }
}
