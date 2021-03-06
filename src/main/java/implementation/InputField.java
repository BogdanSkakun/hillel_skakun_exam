package implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import interfaces.Input;

import javax.xml.stream.events.Attribute;

public class InputField extends  ElementBase implements Input {
    public InputField(WebElement element) {
        super(element);
    }

    @Override
    public void setText(String text) {
        getWebElement().sendKeys(text);
    }

    @Override
    public void sendKeys(Keys keys) {

    }

    @Override
    public void setAttribute(WebDriver driver, String attribute, String value) {
        JavascriptExecutor executor = (JavascriptExecutor) driver ;
            executor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", getWebElement(), attribute, value);
        
    }

    @Override
    public void clear() {
    getWebElement().clear();
    }
}
