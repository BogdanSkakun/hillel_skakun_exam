package interfaces;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import javax.xml.stream.events.Attribute;

public interface Input {

    void setText(String text);
    void sendKeys(Keys keys);
    void setAttribute(WebDriver driver, String attribute, String value);

    void clear();
}
