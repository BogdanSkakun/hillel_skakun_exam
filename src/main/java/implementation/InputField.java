package implementation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import interfaces.Input;

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
    public void clear() {
    getWebElement().clear();
    }
}
