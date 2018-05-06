package interfaces;

import org.openqa.selenium.Keys;

public interface Input {

    void setText(String text);
    void sendKeys(Keys keys);

    void clear();
}
