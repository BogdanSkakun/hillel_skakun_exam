package pages;

import enums.City;
import implementation.ElementBase;
import implementation.InputField;
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
        return new InputField(getElement("//input[@id='content_vacSearch_CityPickerWork_inpCity']"));
    }
    public ElementBase searchButton(){
        return new ElementBase(getElement("//a[@id='content_vacSearch_lnkSearch']"));
    }

    public void searchJob(String jobVacancy, City city){
        log("Clear search field");
        searchField().clear();
        log("Enter vacancy");
        searchField().setText(jobVacancy);
        log("Clear city field");
        cityField().clear();
        log("Enter city");
       /* Select cityDropDown = new Select(getElement("//input[@id='content_vacSearch_CityPickerWork_inpCity']"));
        cityDropDown.selectByVisibleText(city.getCity());*/
        cityField().setText(city.getCity());

        log("Press search button");
        searchButton().click();


    }
}
