package pages;

import enums.City;
import implementation.ElementBase;
import implementation.InputField;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by HillelNew5 on 06.05.2018.
 */
public class RabotaUaPage  extends PageBase{


    public RabotaUaPage(WebDriver driver) {
        super(driver);
    }
    public InputField searchField(){
        return new InputField(getElement("//input[@placeholder='Введите ключевые слова (например: бухгалтер, юрист)']"));
    }
    public InputField cityField(){
        return new InputField(getElement("//input[@class='ui-autocomplete-input']"));
    }
    public ElementBase searchButton(){
        return new ElementBase(getElement("//div[@class='fd-text-center ft-f1']"));
    }

    public void searchJob(String jobVacancy, City city){
        log("Clear search field");
        searchField().clear();
        log("Enter vacancy" + jobVacancy);
        searchField().setText(jobVacancy);
        log("Clear city field");
        cityField().clear();
        log("Enter city " + city.getCity());
        cityField().setText(city.getCity());
        log("Press search button");
        searchButton().click();


    }
}
